package com.gt.services;

import com.gt.utils.Room;

import java.time.LocalTime;
import java.util.Map;

public interface RoomService {
    void createRooms();
    public Map<String, Room> getRooms();
    public void setRooms(Map<String, Room> rooms);
    Map<String,Integer> getSlotDetails(LocalTime startTime, LocalTime endTime);
    LocalTime createLocalTime(String timeStr) throws Exception;
    void resetRooms();

}
