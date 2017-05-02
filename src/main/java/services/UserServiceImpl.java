package main.java.services;

import main.java.model.dao.UserDAO;
import main.java.model.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User auth(String login, String password) {
        User user = userDAO.findUserByLoginAndPassword(login, password);
//        logger.debug("user: " + user);

//        if (user != null && user.isBlocked()) {
//            return null;
//        }
//        logger.debug("user not blocked");

        return user;
    }

    @Override
    public void signUp(String login, String password, String name, String surname) throws Exception {
        userDAO.insertUser(login, password, name, surname);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userDAO.selectAllUsers();
        return users;
    }

    @Override
    public User getUserById(int id) {
        User user = userDAO.selectUserById(id);
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        User user = userDAO.selectUserByLogin(login);
        return user;
    }

    public void setUserDAO(String userDAO) {
    }
}
