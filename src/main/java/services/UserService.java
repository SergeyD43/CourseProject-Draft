package main.java.services;


import main.java.services.dto.UserDTO;

import java.util.List;

public interface UserService {

    void signUp(String login, String password, String name, String surname) throws Exception;

    List<UserDTO> getAllUsers();

    UserDTO getUserByLogin(String login);
}
