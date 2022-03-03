package com.toyrobot.game.application.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * This enum determines the robot's orientation or where it is faceing.
 * 
 * @author Sherwen
 *
 */
public enum RobotOrientation {

	NORTH(0), 
	EAST(1), 
	SOUTH(2), 
	WEST(3);
	
    private int orientationIdx;
    
    private static Map<Integer, RobotOrientation> orientationMap = new HashMap<Integer, RobotOrientation>();

    private RobotOrientation(int orientationIdx) {
        this.orientationIdx = orientationIdx;
    }
    
    static {
        for (RobotOrientation orientation : RobotOrientation.values()) {
        	orientationMap.put(orientation.orientationIdx, orientation);
        }
    }
    
    public RobotOrientation rotateToLeft() {
        return rotate(-1);
    }

    public RobotOrientation rotateToRight() {
        return rotate(1);
    }

    private RobotOrientation rotate(int step) {
        int newOrientationIdx = (this.orientationIdx + step) < 0 ? orientationMap.size() - 1 : (this.orientationIdx + step) % orientationMap.size();
        System.out.println("Robot is now facing: " +orientationMap.get(newOrientationIdx));
        return orientationMap.get(newOrientationIdx);
    }
}
