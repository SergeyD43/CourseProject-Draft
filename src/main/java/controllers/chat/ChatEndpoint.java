package main.java.controllers.chat;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ServerEndpoint(value = "/chat/{room}")
public class ChatEndpoint {

    private static List<ChatRoom> chatRoomList = new ArrayList<>();

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
            int idRoom = chatMessage.getRoom();
            String name = chatMessage.getMessage();
            properties.put("name", name);
            boolean b = true;

            for (ChatRoom chatRoom:chatRoomList) {
                if(chatRoom.getId()==idRoom){
                    b=false;
                    chatRoom.join(session);
                    chatRoom.sendMessage(name + " - Joined the chatroom №" + idRoom);
                    break;
                }
            }

            if(b) {
                ChatRoom chatRoom = new ChatRoom(idRoom);
                chatRoomList.add(chatRoom);
                chatRoom.join(session);
                chatRoom.sendMessage(name + " - Joined the chatroom №" + idRoom);
            }
        }
        else {
            int idRoom = chatMessage.getRoom();
            String name = (String)properties.get("name");

            for (ChatRoom chatRoom:chatRoomList) {
                if(chatRoom.getId()==idRoom){
                    chatRoom.sendMessage(name + " - " + chatMessage.getMessage());
                    break;
                }
            }
        }
    }

    @OnClose
    public void OnClose(Session session, CloseReason reason) {
        String roomP = (String) session.getUserProperties().get("room");
        int room = Integer.parseInt(roomP);

        for (ChatRoom chatRoom:chatRoomList) {
            if(chatRoom.getId()==room){
                chatRoom.leave(session);
                chatRoom.sendMessage((String)session.getUserProperties().get("name") + " - Left the chatroom №" + room);
                break;
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable ex) {
//        log.info("Error: " + ex.getMessage());
    }
}
