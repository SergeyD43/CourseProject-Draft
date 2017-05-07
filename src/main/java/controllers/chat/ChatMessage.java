package main.java.controllers.chat;

public class ChatMessage {
    private MessageType messageType;
    private String message;
    private int room;

    public void setMessageType(MessageType v) { this.messageType = v; }
    public MessageType getMessageType() { return messageType; }
    public void setMessage(String v) { this.message = v; }
    public String getMessage() { return this.message; }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
}
