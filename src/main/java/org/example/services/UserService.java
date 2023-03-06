package org.example.services;

import org.example.models.Message;
import org.example.models.User;

import java.util.List;
import java.util.Optional;

public class UserService {

    private UserRepository ur = new UserRepository();

    public void createUser(User user) {

        ur.createUser(user);
    }

    public Optional<User> readUser(Integer id) {
        Optional<User> optionalUser = ur.readUser(id);
        return optionalUser;
    }

    public List<User> readAllUsers() {

        return ur.readAllUsers();
    }

    public void deleteUser(Integer id) {
        Optional<User> optionalUser = ur.readUser(id);

        if (optionalUser.isPresent()) {
            ur.deleteUser(optionalUser.get());
        }
    }

    public void updateUser(User user) {
        ur.updateUser(user);
    }


}
