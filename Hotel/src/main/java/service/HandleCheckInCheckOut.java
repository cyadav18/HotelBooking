package service;

import domain.Hotel;
import domain.Room;

import java.util.ArrayList;

public class HandleCheckInCheckOut {

    public static ArrayList<String> checkInToDown(Hotel hotel, int numberOfRooms) {
        ArrayList<String> bookedRooms = new ArrayList<>();
        if (hotel.getTotalAvailableRooms() < numberOfRooms) {
            throw new IllegalArgumentException("Available rooms " + hotel.getTotalAvailableRooms() +
                    " given rooms " + numberOfRooms);
        }
        ArrayList<ArrayList<Room>> rooms = hotel.getRooms();
        int totalAllocations = 0;
        for (int i = hotel.getLastAvailableRowFromTop(); i < rooms.size(); i++) {
            hotel.setLastAvailableRowFromTop(i);
            totalAllocations = allocateRoomInFloor(bookedRooms, hotel, i, totalAllocations, numberOfRooms);
            if (totalAllocations == numberOfRooms) {
                break;
            }
        }
        return bookedRooms;
    }

    public static ArrayList<String> checkInBottomUp(Hotel hotel, int numberOfRooms) {
        if (hotel.getTotalAvailableRooms() < numberOfRooms) {
            throw new IllegalArgumentException("Available rooms " + hotel.getTotalAvailableRooms() +
                    " given rooms " + numberOfRooms);
        }
        ArrayList<String> bookedRooms = new ArrayList<>();
        ArrayList<ArrayList<Room>> rooms = hotel.getRooms();
        int totalAllocations = 0;
        for (int i = hotel.getLastAvailableRowFromBottom(); i >= 0; i--) {
            hotel.setLastAvailableRowFromBottom(i);
            totalAllocations = allocateRoomInFloor(bookedRooms, hotel, i, totalAllocations, numberOfRooms);
            if (totalAllocations == numberOfRooms) {
                break;
            }
        }
        return bookedRooms;
    }

    public static boolean checkOut(Hotel hotel, String roomNumber) {
        int row;
        int column;
        for (int i = 1; i <= roomNumber.length() - 1; i++) {
            row = Integer.parseInt(roomNumber.substring(0, i));
            column = Integer.parseInt(roomNumber.substring(i));
            ArrayList<ArrayList<Room>> rooms = hotel.getRooms();
            if (row < rooms.size() && column < rooms.get(row).size()) {
                Room room = rooms.get(row).get(column);
                if (room.getRoomNumber().equals(roomNumber) && !room.isAvailable()) {
                    room.setAvailable(true);
                    hotel.setTotalAvailableRooms(hotel.getTotalAvailableRooms() + 1);
                    hotel.resetLastAvailable();
                    return true;
                }
            }
        }
        System.out.println("room has to be checked in before check out");
        return false;
    }

//    public static boolean checkOut(String roomNumber,hotel)

    private static int allocateRoomInFloor(ArrayList<String> bookedRooms, Hotel hotel,
                                           int floor, int totalAllocations, int numberOfRooms) {
        ArrayList<ArrayList<Room>> rooms = hotel.getRooms();
        for (int j = 0; j < rooms.get(floor).size(); j++) {
            Room room = rooms.get(floor).get(j);
            if (room.isAvailable()) {
                room.setAvailable(false);
                bookedRooms.add(room.getRoomNumber());
                totalAllocations++;
                hotel.setTotalAvailableRooms(hotel.getTotalAvailableRooms() - 1);
            }
            if (totalAllocations == numberOfRooms) {
                return totalAllocations;
            }
        }
        return totalAllocations;
    }


}
