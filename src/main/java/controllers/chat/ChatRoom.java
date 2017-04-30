package main.java.controllers.chat;

import javax.websocket.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private List<Session> sessions = new ArrayList<Session>();
    private int id;

    public ChatRoom(int id) {
        this.id = id;
    }

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

    public int getId() {
        return id;
    }

}
