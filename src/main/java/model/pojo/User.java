package main.java.model.pojo;

public class User {
    private int idUser;
    private String login;
    private String password;
    private boolean isBlocked;
    private boolean isAdmin;
    private String name;
    private String surname;
    private int idStudentFriend;
    private String conversation;

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public User(int idUser, String login, String password,
                boolean isBlocked, boolean isAdmin, String name,
                String surname, int idStudentFriend, String conversation) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.isBlocked = isBlocked;
        this.isAdmin = isAdmin;
        this.name = name;
        this.surname = surname;
        this.idStudentFriend = idStudentFriend;
        this.conversation = conversation;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", isBlocked=" + isBlocked +
                ", isAdmin=" + isAdmin +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", idStudentFriend=" + idStudentFriend +
                ", conversation='" + conversation + '\'' +
                '}';
    }

}
