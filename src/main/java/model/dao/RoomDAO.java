package main.java.model.dao;

import main.java.model.pojo.Room;
import java.util.List;

public interface RoomDAO {
    void insertRoom(int idRoom, String textroom) throws Exception;
    List<Room> selectAllRooms();
}
