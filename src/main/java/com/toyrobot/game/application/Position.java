package com.toyrobot.game.application;

import com.toyrobot.game.application.enums.RobotOrientation;
import com.toyrobot.game.application.exception.GameException;

public class Position {
	
    int x;
    
    int y;
    
    RobotOrientation robotOrientation;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public RobotOrientation getRobotOrientation() {
		return robotOrientation;
	}

	public void setRobotOrientation(RobotOrientation robotOrientation) {
		this.robotOrientation = robotOrientation;
	}
    
    public Position(Position position) {
        this.x = position.getX();
        this.y = position.getY();
        this.robotOrientation = position.getRobotOrientation();
    }
    
    public Position(int x, int y, RobotOrientation robotOrientation) {
        this.x = x;
        this.y = y;
        this.robotOrientation = robotOrientation;
    }
    
    public void changePosition(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }
    
    public Position getNextPosition() throws GameException {
        if (this.robotOrientation == null) {
        	throw new GameException("Invalid robot direction");
        }          

        Position newPosition = new Position(this);
        switch (this.robotOrientation) {
            case NORTH:
                newPosition.changePosition(0, 1);
                break;
            case EAST:
                newPosition.changePosition(1, 0);
                break;
            case SOUTH:
                newPosition.changePosition(0, -1);
                break;
            case WEST:
                newPosition.changePosition(-1, 0);
                break;
        }
        return newPosition;
    }

}
