package com.gt;


import com.gt.helpers.Constants;
import com.gt.helpers.Validator;
import com.gt.utils.CCave;
import com.gt.utils.DTower;
import com.gt.utils.GMansion;
import com.gt.utils.Room;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class InitHelper {
    public static LocalTime createLocalTime(String timeStr) throws Exception {
        LocalTime lt = null;

        try {
            if(timeStr.length()==5){
                lt = LocalTime.parse(timeStr);
            }
            else if(timeStr.length()==4){
                lt = LocalTime.parse(timeStr);
            }
            return lt;
        } catch (Exception e) {
            throw new Exception("INVALID_INPUT");
        }

    }

    public static Map<String,Integer> getSlotDetails(LocalTime startTime,LocalTime endTime){

        Map <String,Integer> slotData=new HashMap<>();
        slotData.put("nos",Integer.valueOf((int) (Duration.between(startTime,endTime).toMinutes()/15)));
        slotData.put("slot",Integer.valueOf((int) Duration.between(LocalTime.MIDNIGHT,startTime).toMinutes() / 15));
        return slotData;

    }
    public static void bookSlotFromCommand(String[] args) {
        if(args.length<3){
            System.out.println("Arguments Provided not in Sync. Please provide in the format \nBOOK <start_time(inclusive)> <end_time(exclusive)> <person_capacity>");
            return;
        }
        String startTimeStr=args[0];
        String endTimeStr=args[1];
        String noOfPersons= args[2];

        Map<String,Room> rooms=createRoom();

        LocalTime startTime= null,endTime= null;
        Map<String,Integer> slotData=null;
        try {
            startTime = createLocalTime(startTimeStr);
            endTime = createLocalTime(endTimeStr);
            slotData= getSlotDetails(startTime,endTime);
        } catch (Exception e) {
            System.out.println("Exception: "+e.toString());
        }

        if(!Validator.validateTime(startTime,endTime)){
            System.out.println("INCORRECT_INPUT");
        }

        if (Integer.valueOf(noOfPersons) < 4){
            rooms.get(Constants.C_CAVE_NAME).bookRoom(slotData.get("slot"),slotData.get("nos"));
        }
        else if (Integer.valueOf(noOfPersons) < 8){
            rooms.get(Constants.D_TOWER_NAME).bookRoom(slotData.get("slot"),slotData.get("nos"));
        }else if (Integer.valueOf(noOfPersons) < 21){
            rooms.get(Constants.G_MANSION_NAME).bookRoom(slotData.get("slot"),slotData.get("nos"));
        }else {
            System.out.println("NO_VACANT_ROOM");
        }



    }

    public static HashMap<String,Room> createRoom() {
        HashMap<String,Room> roomMap= new HashMap<>();
        CCave cCave=new CCave();
        DTower dTower=new DTower();
        GMansion gMansion= new GMansion();

        roomMap.put(cCave.getName(),cCave);
        roomMap.put(dTower.getName(),dTower);
        roomMap.put(gMansion.getName(),gMansion);
        return roomMap;
    }
}