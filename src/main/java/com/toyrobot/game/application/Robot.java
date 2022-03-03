package com.toyrobot.game.application;

import com.toyrobot.game.application.exception.GameException;

public class Robot {
	
	private Position position;
	
	public Robot() {
	}

	public Robot(Position position) {
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}

	public boolean setPosition(Position position) {
        if (position == null) {
        	return false;	
        } else {
            this.position = position;
            return true;	
        }
	}
	
    public boolean move(Position newPosition) {
        if (newPosition == null) {
        	return false;        	
        } else {
            this.position = newPosition;
            return true;	
        }
    }
    
    public boolean move() throws GameException {
        return move(position.getNextPosition());
    }
    
    public boolean rotateLeft() {
    	if(this.position == null) {
    		return false;  
    	} else {
            if (this.position.robotOrientation == null) {
                return false;        	
            } else {
                this.position.robotOrientation = this.position.robotOrientation.rotateToLeft();
                return true;        	
            }    		
    	}
    }

    public boolean rotateRight() {
    	if(this.position == null) {
    		return false;  
    	} else {
            if (this.position.robotOrientation == null) {
            	return false;
            } else {
                this.position.robotOrientation = this.position.robotOrientation.rotateToRight();
                return true;	
            }    		
    	}
    }

}
