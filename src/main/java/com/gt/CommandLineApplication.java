package com.gt;

import com.gt.services.RoomService;
import com.gt.services.RoomServiceImpl;

import java.util.Scanner;

public class CommandLineApplication {
    static void prompt(){
        System.out.print("Enter a command or type 'Exit' to quit \n>> ");
    }
    public static void main(String[] args) {
        RoomService roomService= RoomServiceImpl.getInstance();
        Scanner sc=new Scanner(System.in);

        for (prompt(); sc.hasNextLine(); prompt()){
            String command = sc.nextLine().replaceAll("\n", "");
            if (command.length() == 0)
                continue;
            String[] arguments = command.split(" ");
        }
    }
}
