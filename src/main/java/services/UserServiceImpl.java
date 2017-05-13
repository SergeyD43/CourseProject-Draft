package main.java.services;

import entity.UsersEntity;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import main.java.model.dao.UserDAO;
import main.java.model.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void signUp(String login, String password, String name, String surname) throws Exception {
        userDAO.insertUser(login, password, name, surname);
    }

    @Override
    public List<User> getAllUsers() {
        List<UsersEntity> users = userDAO.selectAllUsers();

        List<User> usersDTO = new ArrayList<>();

        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        BoundMapperFacade<UsersEntity, User>
                boundMapper = mapperFactory.getMapperFacade(UsersEntity.class, User.class);

        for(UsersEntity usersEntity:users){
            usersDTO.add(boundMapper.map(usersEntity));
        }

        return usersDTO;
    }

    @Override
    public User getUserByLogin(String login) {
        UsersEntity user = userDAO.selectUserByLogin(login);

        User userDTO;

        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        BoundMapperFacade<UsersEntity, User>
                boundMapper = mapperFactory.getMapperFacade(UsersEntity.class, User.class);

        userDTO = boundMapper.map(user);

        return userDTO;
    }

}
