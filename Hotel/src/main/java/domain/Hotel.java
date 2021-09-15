package domain;

import service.HandleCheckInCheckOut;

import java.util.ArrayList;
import java.util.Objects;

public class Hotel {
    private String name;
    private ArrayList<ArrayList<Room>> rooms;


    private Boolean topDown;
    private Integer numberOfFloors;
    private Integer numberOfRoomsPerFloor;

    private Integer lastAvailableRowFromTop;
    private Integer lastAvailableRowFromBottom;


    private Integer totalAvailableRooms;

    public Hotel(String name, int numberOfFloors, int numBErOfRoomsPerFloor) {
        this.name = name;
        this.numberOfFloors = numberOfFloors;
        this.numberOfRoomsPerFloor = numBErOfRoomsPerFloor;
        int totalCountOfRooms = 0;
        ArrayList<ArrayList<Room>> outer = new ArrayList<>();
        for (int i = 0; i < numberOfFloors; i++) {
            ArrayList<Room> inner = new ArrayList<>();
            for (int j = 0; j < numBErOfRoomsPerFloor; j++) {
                inner.add(new Room("" + i + j));
                totalCountOfRooms++;
            }
            outer.add(inner);
        }
        this.totalAvailableRooms = totalCountOfRooms;
        this.lastAvailableRowFromTop = 0;
        this.lastAvailableRowFromBottom = outer.size() - 1;
        this.rooms = outer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTopDown(Boolean topDown) {
        this.topDown = topDown;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<ArrayList<Room>> getRooms() {
        return rooms;
    }

    public Boolean getTopDown() {
        return topDown;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public Integer getNumberOfRoomsPerFloor() {
        return numberOfRoomsPerFloor;
    }


    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public void setNumberOfRoomsPerFloor(Integer numberOfRoomsPerFloor) {
        this.numberOfRoomsPerFloor = numberOfRoomsPerFloor;
    }

    public void setLastAvailableRowFromTop(Integer lastAvailableRowFromTop) {
        this.lastAvailableRowFromTop = lastAvailableRowFromTop;
    }

    public void setLastAvailableRowFromBottom(Integer lastAvailableRowFromBottom) {
        this.lastAvailableRowFromBottom = lastAvailableRowFromBottom;
    }

    public Integer getLastAvailableRowFromTop() {
        return lastAvailableRowFromTop;
    }

    public Integer getLastAvailableRowFromBottom() {
        return lastAvailableRowFromBottom;
    }

    public void setTotalAvailableRooms(Integer totalAvailableRooms) {
        this.totalAvailableRooms = totalAvailableRooms;
    }

    public Integer getTotalAvailableRooms() {
        return totalAvailableRooms;
    }

    public void cleanAllRooms() {
        for (int i = 0; i < rooms.size(); i++) {
            for (int j = 0; j < rooms.get(i).size(); j++) {
                Room room = rooms.get(i).get(j);
                room.setAvailable(true);
            }
        }
    }

    public void resetLastAvailable() {
        this.lastAvailableRowFromTop = 0;
        this.lastAvailableRowFromBottom = rooms.size()-1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hotel)) return false;
        Hotel hotel = (Hotel) o;
        return name.equals(hotel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hotel Name ").append(this.name).append(" rooms :[");
        for (ArrayList<Room> rooms : this.getRooms()) {
            for (Room room : rooms) {
                if (room.isAvailable()) {
                    sb.append(room.getRoomNumber()).append(" ");
                }
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public ArrayList<String> checkIn(int numberOfRooms) {
        if (this.topDown) {
            return HandleCheckInCheckOut.checkInToDown(this, numberOfRooms);
        } else {
            return HandleCheckInCheckOut.checkInBottomUp(this, numberOfRooms);
        }
    }
}
