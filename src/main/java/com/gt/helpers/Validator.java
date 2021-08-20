package com.gt.helpers;

import java.time.LocalTime;

public class Validator {
    public static boolean validateTime(LocalTime startTime, LocalTime endTime){

        if(startTime.getMinute()%15 != 0 || endTime.getMinute()%15 != 0) {
            return false;
        }
        if(startTime.isAfter(endTime)){
            return false;
        }
        return true;
    }
}
