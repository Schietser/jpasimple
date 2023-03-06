package org.example.services;

import jakarta.persistence.EntityManager;
import org.example.connection.EntityManagerProvider;
import org.example.models.Message;

import java.util.List;
import java.util.Optional;

public class MessageService {

    private MessageRepository mr = new MessageRepository();

    public void createMessage(Message message){

        mr.createMessage(message);
    }

    public Optional<Message> readMessage(Integer id){
        Optional<Message> optionalMessage = mr.readMessage(id);
        return optionalMessage;
    }

    public List<Message> readAllMessages(){

        return mr.readAllMessages();
    }

    public void deleteMessage(Integer id){
        Optional<Message> optionalMessage = mr.readMessage(id);

        if (optionalMessage.isPresent()){
            mr.deleteMessage(optionalMessage.get());
        }
    }

    public void updateMessage(Message message){
        mr.updateMessage(message);
    }


}
