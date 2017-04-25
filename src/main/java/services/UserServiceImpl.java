package services;

import model.dao.UserDAO;
import model.dao.UserDAOImpl;
import model.pojo.User;

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
}
