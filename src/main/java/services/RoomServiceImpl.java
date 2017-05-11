package main.java.services;

import main.java.model.dao.RoomDAO;
import main.java.model.pojo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {


    private RoomDAO roomDAO;

    @Autowired
    public void setRoomDAO(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    @Override
    public List<Room> getAllRooms() {
        List<Room> rooms = roomDAO.selectAllRooms();
        return rooms;
    }

}
