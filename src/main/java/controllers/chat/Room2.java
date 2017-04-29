package main.java.controllers.chat;

import javax.websocket.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Room2 {
    private static Room2 instance = null;
    private List<Session> sessions = new ArrayList<Session>();

    public synchronized void join(Session session) { sessions.add(session); }
    public synchronized void leave(Session session) { sessions.remove(session); }
    public synchronized void sendMessage(String message) {
        for (Session session: sessions) {
            if (session.isOpen()) {
                try { session.getBasicRemote().sendText(message); }
                catch (IOException e) { e.printStackTrace(); }
            }
        }
    }

    public synchronized static Room2 getRoom2() {
        if (instance == null) { instance = new Room2(); }
        return instance;
    }
}
