package main.java.model.dao;


import main.java.model.SingletonDBConnection;
import main.java.model.pojo.Room;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomDAOImpl implements RoomDAO {

    @Override
    public void insertRoom(int idRoom, String textroom) throws Exception {

    }

    @Override
    public List<Room> selectAllRooms() {
        List<Room> rooms = new ArrayList<>();
        Connection connection = SingletonDBConnection.getInstance().connect();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM rooms");

            while (resultSet.next()){
                rooms.add(createEntity(resultSet));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    private Room createEntity(ResultSet resultSet) throws SQLException {

        return new Room(resultSet.getInt("id_room"),
                resultSet.getString("textroom")
        );
    }
}
