package main.java.model.dao;

import main.java.model.SingletonDBConnection;
import main.java.model.pojo.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Override
    public User findUserByLoginAndPassword(String login, String password) {
        User user = null;

        Connection connection = SingletonDBConnection.getInstance().connect();
        PreparedStatement statement = null;
        try {
            statement = connection
                    .prepareStatement( "SELECT * FROM users WHERE login = ? AND password = ?");
            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = createEntity(resultSet);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(user);

        return user;
    }

    private User createEntity(ResultSet resultSet) throws SQLException {

        String isBlocked = resultSet.getString("isBlocked");
        boolean block;
        if(isBlocked.equals("Y")){
            block = true;
        } else {
            block = false;
        }

        String isAdmin = resultSet.getString("isAdmin");
        boolean admin;
        if(isAdmin.equals("Y")){
            admin = true;
        } else {
            admin = false;
        }

        return new User(resultSet.getInt("id_user"),
                resultSet.getString("login"),
                resultSet.getString("password"),
                block,
                admin,
                resultSet.getString("name"),
                resultSet.getString("surname"),
                resultSet.getInt("id_room")
                );
    }

    @Override
    public void insertUser(String login, String password, String name, String surname) throws Exception {
        User user = null;
        Connection connection = SingletonDBConnection.getInstance().connect();

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into users(login, password, " +
                            "isBlocked, isAdmin, name, surname, id_room) " +
                            "values (?,?,?,?,?,?,?) ");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, "N");
            preparedStatement.setString(4, "N");
            preparedStatement.setString(5, name);
            preparedStatement.setString(6, surname);
            preparedStatement.setInt(7, 0);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new Exception();
        }
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        Connection connection = SingletonDBConnection.getInstance().connect();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()){
                users.add(createEntity(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
