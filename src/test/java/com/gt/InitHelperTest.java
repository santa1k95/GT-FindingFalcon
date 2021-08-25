package com.gt;


import com.gt.helpers.Constants;
import com.gt.utils.CCave;
import com.gt.utils.DTower;
import com.gt.utils.GMansion;
import com.gt.utils.Room;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class InitHelperTest {

    @Test
    public void createLocalTime() {
        try {
            LocalTime localTime=LocalTime.parse("10:00");
            LocalTime result=InitHelper.createLocalTime("10:00");
            assertNotNull(result);
            assertEquals(localTime,result);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Test
    public void createLocalTimeException() {
        try {
            LocalTime localTime=LocalTime.parse("10:00");
            LocalTime result=InitHelper.createLocalTime("1000");

        } catch (Exception e) {
            System.out.println(e);
            assertEquals(e.toString(),"INVALID_INPUT");
        }

    }

    @Test
    public void getSlotDetails() {
        Map<String,Integer> result= InitHelper.getSlotDetails(LocalTime.parse("10:00"),LocalTime.parse("11:00"));
        System.out.println(result);
        assertEquals(result.get("slot"),Integer.valueOf(40));
        assertEquals(result.get("nos"),Integer.valueOf(4));

    }

    @Test
    public void createRoom() {
        HashMap<String, Room> result = InitHelper.createRoom();
        assertNotNull(result);
        assertTrue(result.get(Constants.C_CAVE_NAME) instanceof CCave);
        assertTrue(result.get(Constants.D_TOWER_NAME) instanceof DTower);
        assertTrue(result.get(Constants.G_MANSION_NAME) instanceof GMansion);
    }
}