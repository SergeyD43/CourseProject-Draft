package entity;

import javax.persistence.*;

@Entity
@Table(name = "rooms", schema = "school2", catalog = "")
public class RoomsEntity {
    private int idRoom;
    private String textroom;

    @Id
    @Column(name = "id_room")
    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    @Basic
    @Column(name = "textroom")
    public String getTextroom() {
        return textroom;
    }

    public void setTextroom(String textroom) {
        this.textroom = textroom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomsEntity that = (RoomsEntity) o;

        if (idRoom != that.idRoom) return false;
        if (textroom != null ? !textroom.equals(that.textroom) : that.textroom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRoom;
        result = 31 * result + (textroom != null ? textroom.hashCode() : 0);
        return result;
    }
}
