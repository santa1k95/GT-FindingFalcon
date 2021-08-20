package com.gt;

import com.gt.helpers.Constants;
import com.gt.utils.CCave;
import com.gt.utils.DTower;
import com.gt.utils.GMansion;
import com.gt.utils.Room;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.gt.InitHelper.*;


public class Main {
    static void prompt(){
        System.out.print("Enter a command or type 'Exit' to quit \n>> ");
    }

    public static void main(String[] args) {
        Map<String, Room> rooms=createRoom();
        Scanner sc = new Scanner(System.in);

        for (prompt(); sc.hasNextLine(); prompt()) {
            String line = sc.nextLine().replaceAll("\n", "");

            // return pressed
            if (line.length() == 0)
                continue;

            // split line into arguments
            String[] arguments = line.split(" ");

            // process arguments
            if (arguments.length > 0) {
                if (arguments[0].equalsIgnoreCase("exit"))
                    System.exit(0);
                if (arguments[0].equalsIgnoreCase("book"))
                {
                    if(arguments.length<4){
                        System.out.println("Arguments Provided not in Sync. Please provide in the format \nBOOK <start_time(inclusive)> <end_time(exclusive)> <person_capacity>");
                        continue;
                    }
                    String startTimeStr=arguments[1];
                    String endTimeStr=arguments[2];
                    String noOfPersons= arguments[3];
                    LocalTime startTime= null,endTime= null;
                    Map<String,Integer> slotData=null;
                    try {
                        startTime = createLocalTime(startTimeStr);
                        endTime = createLocalTime(endTimeStr);
                        slotData= getSlotDetails(startTime,endTime);
                    } catch (Exception e) {
                        System.out.println("Exception: "+e.toString());
                    }

//                    List<Room> freeRoomsToBook=checkIfFree(rooms,slotData);
//                    freeRoomsToBook.stream().anyMatch(it-> it.getClass().getSimpleName()=="CCave");
                    if (Integer.valueOf(noOfPersons) < 4){
                        rooms.get(Constants.C_CAVE_NAME).bookRoom(slotData.get("slot"),slotData.get("nos"));
                        rooms.get(Constants.C_CAVE_NAME).printSlotsInRoom();
                        rooms.get(Constants.D_TOWER_NAME).printSlotsInRoom();
                        rooms.get(Constants.G_MANSION_NAME).printSlotsInRoom();
                    }
                    else if (Integer.valueOf(noOfPersons) < 8){
                        rooms.get(Constants.D_TOWER_NAME).bookRoom(slotData.get("slot"),slotData.get("nos"));
                    }else if (Integer.valueOf(noOfPersons) < 21){
                        rooms.get(Constants.G_MANSION_NAME).bookRoom(slotData.get("slot"),slotData.get("nos"));
                    }else {
                        System.out.println("NO_VACANT_ROOM");
                    }
                }else if(arguments[0].equalsIgnoreCase("vacancy")){
                    if(arguments.length<3){
                        System.out.println("Arguments Provided not in Sync. Please provide in the format \nBOOK <start_time(inclusive)> <end_time(exclusive)> <person_capacity>");
                        continue;
                    }
                    String startTimeStr=arguments[1];
                    String endTimeStr=arguments[2];
                    Map<String,Integer> slotData=null;
                    LocalTime startTime= null,endTime= null;
                    try {
                        startTime = createLocalTime(startTimeStr);
                        endTime = createLocalTime(endTimeStr);
                        slotData= getSlotDetails(startTime,endTime);
                    } catch (Exception e) {
                        System.out.println("Exception: "+e.toString());
                    }
                    List<Room> freeRooms=checkIfFree(rooms,slotData);
                    freeRooms.forEach(room -> System.out.println(room.getClass().getSimpleName()));

                }
            }
        }


    }
    public static List<Room> checkIfFree(Map<String,Room> rooms, Map<String,Integer> slotData){
        List<Room> roomsFree=new ArrayList<>();
        rooms.forEach((key,room)->{
            System.out.println("Checking "+key);
            int i;
            for(i=slotData.get("slot");i<slotData.get("slot")+slotData.get("nos");i++){
                if(room.getTimeSlots().get(i) == true){

                    break;
                };
            }
            if(i==slotData.get("slot")+slotData.get("nos")){
                roomsFree.add(room);
            }
        });

        return  roomsFree;
    }
}
