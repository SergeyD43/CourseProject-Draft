package main.java.controllers.chat;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;

@ServerEndpoint(value = "/chat")
public class ChatEndpoint {
    private Room room = Room.getRoom();

    @OnOpen
    public void onOpen(final Session session, EndpointConfig config) {}

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
            String name = chatMessage.getMessage();
            properties.put("name", name);
            room.join(session);
            room.sendMessage(name + " - Joined the chat room");
        }
        else {
            String name = (String)properties.get("name");
            room.sendMessage(name + " - " + chatMessage.getMessage());
        }
    }

    @OnClose
    public void OnClose(Session session, CloseReason reason) {
        room.leave(session);
        room.sendMessage((String)session.getUserProperties().get("name") + " - Left the room");
    }

    @OnError
    public void onError(Session session, Throwable ex) {
//        log.info("Error: " + ex.getMessage());
    }
}
