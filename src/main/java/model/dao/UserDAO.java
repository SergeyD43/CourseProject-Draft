package main.java.model.dao;

import entity.UsersEntity;
import main.java.model.pojo.User;

import java.util.List;


public interface UserDAO {

    void insertUser(String login, String password, String name, String surname) throws Exception;

    List<UsersEntity> selectAllUsers();

    UsersEntity selectUserByLogin(String login);
}
