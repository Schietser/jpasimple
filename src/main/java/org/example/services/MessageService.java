package org.example.services;

import org.example.models.Message;
import org.example.models.User;

import java.util.List;
import java.util.Optional;

public class MessageService {

    private MessageRepository messageRepository = new MessageRepository();
    private UserRepository userRepository = new UserRepository();

    public void createMessage(Message message){

        Optional<User> optionalUser = userRepository.readUserByPhoneNumber(message.getSender().getPhoneNumber());

        if (optionalUser.isEmpty()){
            userRepository.createUser(message.getSender());
            System.out.println(message.getSender());
        }

        List<User> receivers = message.getReceivers();

        for (User receiver : receivers) {

            Optional<User> optionalReceiver = userRepository.readUserByPhoneNumber(message.getSender().getPhoneNumber());

            if (optionalReceiver.isEmpty()){
                userRepository.createUser(receiver);
            }
        }
        messageRepository.createMessage(message);

    }

    public Optional<Message> readMessage(Integer id){
        Optional<Message> optionalMessage = messageRepository.readMessage(id);
        return optionalMessage;
    }

    public List<Message> readAllMessages(){

        return messageRepository.readAllMessages();
    }

    public void deleteMessage(Integer id){
        Optional<Message> optionalMessage = messageRepository.readMessage(id);

        if (optionalMessage.isPresent()){
            messageRepository.deleteMessage(optionalMessage.get());
        }
    }

    public void updateMessage(Message message){
        messageRepository.updateMessage(message);
    }


}
