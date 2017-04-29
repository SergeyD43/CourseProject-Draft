package main.java.controllers.chat;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;

@ServerEndpoint(value = "/chat/{room}")
public class ChatEndpoint {
    private Room room1 = Room.getRoom();
    private Room2 room2 = Room2.getRoom2();

    @OnOpen
    public void onOpen(final Session session, @PathParam("room") final String room) {
        session.getUserProperties().put("room", room);
    }

    @OnMessage
    public void onMessage(final Session session, final String messageJson) {
        ObjectMapper mapper = new ObjectMapper();
        ChatMessage chatMessage = null;
        try {
            chatMessage = mapper.readValue(messageJson, ChatMessage.class);
        } catch (IOException e) {
            String message = "Badly formatted message";
            try {
                session.close(new CloseReason(CloseReason.CloseCodes.CANNOT_ACCEPT, message));
            } catch (IOException ex) {
//                log.severe(ex.getMessage());
            }
        } ;

        Map<String, Object> properties = session.getUserProperties();
        if (chatMessage.getMessageType() == MessageType.LOGIN) {
            if(chatMessage.getRoom()==1){
                String name = chatMessage.getMessage();
                properties.put("name", name);
                room1.join(session);
                room1.sendMessage(name + " - Joined the chat room");
            } else {
                String name = chatMessage.getMessage();
                properties.put("name", name);
                room2.join(session);
                room2.sendMessage(name + " - Joined the chat room");
            }
        }
        else {
            if(chatMessage.getRoom()==1){
                String name = (String)properties.get("name");
                room1.sendMessage(name + " - " + chatMessage.getMessage());
            } else {
                String name = (String)properties.get("name");
                room2.sendMessage(name + " - " + chatMessage.getMessage());
            }
        }
    }

    @OnClose
    public void OnClose(Session session, CloseReason reason) {
        String roomP = (String) session.getUserProperties().get("room");
        int room = Integer.parseInt(roomP);
        System.out.println(room);
        if(room ==1){
            room1.leave(session);
            room1.sendMessage((String)session.getUserProperties().get("name") + " - Left the room " + room);
        }
        if(room ==2){
            room2.leave(session);
            room2.sendMessage((String)session.getUserProperties().get("name") + " - Left the room " + room);
        }
    }

    @OnError
    public void onError(Session session, Throwable ex) {
//        log.info("Error: " + ex.getMessage());
    }
}
