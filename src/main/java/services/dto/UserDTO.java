package main.java.services.dto;

public class UserDTO {
    private int idUser;
    private String login;
    private String password;
    private String role;
    private String name;
    private String surname;
    private int idRoom;

    public UserDTO(int idUser, String login, String password, String role, String name, String surname, int idRoom) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.idRoom = idRoom;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
