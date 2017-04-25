package services;

import model.dao.UserDAO;
import model.dao.UserDAOImpl;
import model.pojo.User;

import java.util.List;

public class UserServiceImpl implements UserService {


    private static UserDAO userDAO = new UserDAOImpl();

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
//        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userDAO.selectAllUsers();
        return users;
    }

    public void setUserDAO(String userDAO) {
    }
}
