package services;

import model.pojo.User;

import java.util.List;

public interface UserService {
    User auth(String login, String password);
    void signUp(String login, String password, String name, String surname) throws Exception;
    List<User> getAllUsers();
}
