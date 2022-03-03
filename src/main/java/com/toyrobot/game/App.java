package com.toyrobot.game;

import java.util.Scanner;

import com.toyrobot.game.application.Robot;
import com.toyrobot.game.application.ToyRobotSimulator;
import com.toyrobot.game.application.exception.GameException;
import com.toyrobot.game.application.impl.TableTopImpl;

public class App {
	static final int ROWS = 4;
	static final int COLUMNS = 4;
	
    public static void main(String[] args) {
        Scanner scanner;

        TableTopImpl tableTopBoard = new TableTopImpl(ROWS, COLUMNS);
        Robot robot = new Robot();
        ToyRobotSimulator toyRobotSimulator = new ToyRobotSimulator(tableTopBoard, robot);

        System.out.println("Toy Robot Game");
        System.out.println("List of valid commands are:");
        System.out.println("[1] \'PLACE X,Y,NORTH | SOUTH | EAST | WEST\' (i.e PLACE 0,1,NORTH)");
        System.out.println("[2] \'MOVE\'");
        System.out.println("[3] \'LEFT\'");
        System.out.println("[4] \'RIGHT\'");
        System.out.println("[5] \'REPORT\'");
        System.out.println("[6] \'CMD\'");
        System.out.println("[7] \'EXIT\'");
        System.out.println("Note: Commands are CASE sensitive.");
        System.out.println("Enter a command:");
        
        for (int i = 0; i < args.length; i++) {
            System.out.println("ARGS: " +args[i]);	
		}

        boolean continuePlaying = true;
        while (continuePlaying) {
        	scanner = new Scanner(System.in);
        	String inputString = scanner.nextLine();
//        	String inputString = System.console().readLine();
//        	System.out.println(inputString);
            if ("EXIT".equals(inputString)) {
            	continuePlaying = false;
            } else if("CMD".equals(inputString)) {
                System.out.println("List of valid commands are:");
                System.out.println("[1] \'PLACE X,Y,NORTH | SOUTH | EAST | WEST\' (i.e PLACE 0,1,NORTH)");
                System.out.println("[2] \'MOVE\'");
                System.out.println("[3] \'LEFT\'");
                System.out.println("[4] \'RIGHT\'");
                System.out.println("[5] \'REPORT\'");
                System.out.println("[6] \'CMD\'");
                System.out.println("[7] \'EXIT\'");
                System.out.println("Note: Commands are CASE sensitive.");
                System.out.println("Enter a command:");            	
            } else {
                try {
                    String outputVal = toyRobotSimulator.evaluateCommand(inputString);
                    System.out.println(outputVal);
                } catch (GameException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
