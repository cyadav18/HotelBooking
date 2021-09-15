package domain;

import java.util.Objects;

public class Room {
    private String roomNumber;
    private Boolean available;

    public Room(String roomNumber) {
        this.roomNumber = roomNumber;
        this.available = true;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public Boolean isAvailable() {
        return available;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room;
        room = (Room) o;
        return getRoomNumber().equals(room.getRoomNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoomNumber());
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", available=" + available +
                '}';
    }
}
