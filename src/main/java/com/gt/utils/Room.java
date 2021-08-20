package com.gt.utils;

import com.gt.helpers.TimeSlots;

import java.util.List;

public class Room {
    TimeSlots ts = new TimeSlots();

    public void bookRoom(Integer slot, Integer nos) {
        for (int i = slot; i < slot + nos; i++) {
            this.ts.bookSlot(i);
        }
    }

    public List<Boolean> getTimeSlots() {
        return this.ts.getSlots();
    }

    public void printSlotsInRoom() {
        System.out.println(this.ts.getSlots().toString());
        ;
    }

    public TimeSlots getTs() {
        return ts;
    }

    public void setTs(TimeSlots ts) {
        this.ts = ts;
    }

    @Override
    public String toString() {
        return "Room{" +
                "ts=" + ts +
                '}';
    }
    //    default Integer getSlot()
}
