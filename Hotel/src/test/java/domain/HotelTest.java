package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    Hotel hotel = new Hotel("ABIDE", 3, 4);

    @Test
    void getName() {
        assertEquals(hotel.getName(),"ABIDE");
    }


    @Test
    void getRooms() {
        assertNotNull(hotel.getRooms());
        System.out.println(hotel);
        for (ArrayList<Room> rooms: hotel.getRooms()){
            for(Room room :rooms){
                System.out.println(room);
                assertNotNull(room);
                assertNotNull(room.getRoomNumber());
                assertNotNull(room.isAvailable());
            }
        }
    }
}