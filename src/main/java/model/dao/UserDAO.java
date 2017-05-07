package main.java.model.dao;

import main.java.model.pojo.User;

import java.util.List;


public interface UserDAO {
    int getUserIdByLogin(String login);
    User findUserByLoginAndPassword(String login, String password);
    void insertUser(String login, String password, String name, String surname) throws Exception;
    List<User> selectAllUsers();

    User selectUserById(int id);

    User selectUserByLogin(String login);
}
