package domain;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    Room room = new Room("23");

    @org.junit.jupiter.api.Test
    void getRoomNumber() {
        room.setRoomNumber("23");
        assertEquals(room.getRoomNumber(), "23");
    }

    @org.junit.jupiter.api.Test
    void getAvailable() {
        room.setAvailable(true);
        assertTrue(room.isAvailable());
    }

}