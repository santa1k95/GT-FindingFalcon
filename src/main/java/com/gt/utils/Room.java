package com.gt.utils;

import java.util.List;

abstract public class Room {
    TimeSlots ts = new TimeSlots();

    public abstract Integer getCapacity();

    public abstract String getName();

    public abstract void setCapacity(Integer capacity);

    public abstract void setName(String name);

    public boolean bookRoom(Integer slot, Integer nos) {
        int i;
        for (i = slot; i < slot + nos; i++) {
            if(!this.ts.getSlots().get(i))
            this.ts.bookSlot(i);
            else break;
        }
        if (i!=slot+nos){
            return false;
        }
        return true;
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
