package model.dao;

import model.pojo.User;

/**
 * Created by Admin on 23.04.2017.
 */
public interface UserDAO {
    User findUserByLoginAndPassword(String login, String password);
}
