package com.gt.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TimeSlots {
    List<Boolean> slots=new ArrayList<>(Arrays.asList(new Boolean[Constants.SLOTS_HOUR * Constants.HOURS] ));
    public TimeSlots(){
        Collections.fill(slots, Boolean.FALSE);
    }

    public List<Boolean> getSlots() {
        return slots;
    }

    public void bookSlot(Integer slot){
        if(slot<slots.size()){
            slots.set(slot,true);
        }
        else {
            System.out.println("NO_VACANT_ROOM");
        }
    }
}
