package com.toyrobot.game.application.impl;

import com.toyrobot.game.application.I_TableTop;
import com.toyrobot.game.application.Position;

public class TableTopImpl implements I_TableTop{
	
    int x;
    int y;
    
	public TableTopImpl(int x, int y) {
		this.x = x;
		this.y = y;
	}

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

	public boolean isValid(Position position) {
		boolean isValid = !(position.getX() > this.y || position.getX() < 0 || position.getY() > this.x || position.getY() < 0);
        return isValid;
	}

}
