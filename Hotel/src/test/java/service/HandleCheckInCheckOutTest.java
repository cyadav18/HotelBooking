package service;

import domain.Hotel;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class HandleCheckInCheckOutTest {
    Hotel hotel = new Hotel("ABIDE", 4, 5);

    @org.junit.jupiter.api.Test
    void checkInToDown() {
        System.out.println("=========================checkInToDown Entering=========================");
        hotel.cleanAllRooms();
        System.out.println(hotel);
        ArrayList<String> bookedRooms = HandleCheckInCheckOut.checkInToDown(hotel, 7);
        assertEquals(bookedRooms.size(), 7);
        System.out.println(bookedRooms);
        System.out.println(hotel);
        bookedRooms = HandleCheckInCheckOut.checkInToDown(hotel, 7);
        assertEquals(bookedRooms.size(), 7);
        System.out.println(bookedRooms);
        System.out.println(hotel);
        System.out.println("=========================checkInToDown Exit=========================");
    }

    @org.junit.jupiter.api.Test
    void checkBottomUp() {
        System.out.println("=========================checkBottomUp Entering=========================");
        hotel.cleanAllRooms();
        System.out.println(hotel);
        ArrayList<String> bookedRooms = HandleCheckInCheckOut.checkInBottomUp(hotel, 7);
        assertEquals(bookedRooms.size(), 7);
        System.out.println(bookedRooms);
        System.out.println(hotel);
        bookedRooms = HandleCheckInCheckOut.checkInToDown(hotel, 7);
        assertEquals(bookedRooms.size(), 7);
        System.out.println(bookedRooms);
        System.out.println(hotel);
        System.out.println("=========================checkBottomUp Exit=========================");
    }

    @org.junit.jupiter.api.Test
    void checkTopBottom() {
        System.out.println("=========================checkTopBottom Entering=========================");
        hotel.cleanAllRooms();
        System.out.println(hotel);
        ArrayList<String> bookedRooms = HandleCheckInCheckOut.checkInBottomUp(hotel, 6);
        assertEquals(bookedRooms.size(), 6);
        System.out.println(bookedRooms);
        System.out.println(hotel);
        bookedRooms = HandleCheckInCheckOut.checkInToDown(hotel, 6);
        assertEquals(bookedRooms.size(), 6);
        System.out.println(bookedRooms);
        System.out.println(hotel);

        bookedRooms = HandleCheckInCheckOut.checkInBottomUp(hotel, 3);
        assertEquals(bookedRooms.size(), 3);
        System.out.println(bookedRooms);
        System.out.println(hotel);

        bookedRooms = HandleCheckInCheckOut.checkInToDown(hotel, 3);
        assertEquals(bookedRooms.size(), 3);
        System.out.println(bookedRooms);
        System.out.println(hotel);

        System.out.println("=========================checkTopBottom Exit=========================");
    }

    @org.junit.jupiter.api.Test
    void checkOut() {
        System.out.println("=========================checkOut Entering=========================");
        System.out.println(hotel);
        ArrayList<String> bookedRooms = HandleCheckInCheckOut.checkInToDown(hotel, 6);
        assertEquals(bookedRooms.size(), 6);
        System.out.println(bookedRooms);
        System.out.println(hotel);
        assertTrue(HandleCheckInCheckOut.checkOut(hotel, "03"));
        System.out.println(hotel);
        bookedRooms = HandleCheckInCheckOut.checkInBottomUp(hotel, 6);
        assertEquals(bookedRooms.size(), 6);
        System.out.println(bookedRooms);
        System.out.println(hotel);
        System.out.println("=========================checkOut Exit=========================");
    }

}
