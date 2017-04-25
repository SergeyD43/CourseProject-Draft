package services;

import model.pojo.User;

public interface UserService {
    User auth(String login, String password);
}
