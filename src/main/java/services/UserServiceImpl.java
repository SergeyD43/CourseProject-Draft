package main.java.services;

import main.java.model.entity.UsersEntity;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import main.java.model.dao.UserDAO;
import main.java.services.dto.UserDTO;
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
    public List<UserDTO> getAllUsers() {
        List<UsersEntity> users = userDAO.selectAllUsers();

        List<UserDTO> usersDTO = new ArrayList<>();

        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        BoundMapperFacade<UsersEntity, UserDTO>
                boundMapper = mapperFactory.getMapperFacade(UsersEntity.class, UserDTO.class);

        for(UsersEntity usersEntity:users){
            usersDTO.add(boundMapper.map(usersEntity));
        }

        return usersDTO;
    }

    @Override
    public UserDTO getUserByLogin(String login) {
        UsersEntity user = userDAO.selectUserByLogin(login);

        UserDTO userDTO;

        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        BoundMapperFacade<UsersEntity, UserDTO>
                boundMapper = mapperFactory.getMapperFacade(UsersEntity.class, UserDTO.class);

        userDTO = boundMapper.map(user);

        return userDTO;
    }

}
