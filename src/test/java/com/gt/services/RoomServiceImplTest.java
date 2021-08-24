package com.gt.services;

import com.gt.utils.Room;
import junit.framework.TestCase;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

import static org.junit.Assert.*;

public class RoomServiceImplTest {

    @Test
    public void roomServiceTest() throws Exception {
        RoomService roomService=RoomServiceImpl.getInstance();
        Map<String, Room> rooms=roomService.getRooms();

        rooms.forEach((key,room)-> {
            System.out.println(room.toString());
            System.out.println(room.getName());
            System.out.println(room.getCapacity());
            System.out.println(room.getTimeSlots().toString());
            room.bookRoom(0,4);
            assertNotNull(room);
        });
        assertNotNull(rooms);

        assertTrue(roomService.createLocalTime("10:00") instanceof LocalTime);
        assertTrue(!(roomService.createLocalTime("100:00") instanceof LocalTime));
    }
}

