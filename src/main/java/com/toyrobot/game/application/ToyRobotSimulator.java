package com.toyrobot.game.application;

import com.toyrobot.game.application.enums.Commands;
import com.toyrobot.game.application.enums.Messages;
import com.toyrobot.game.application.enums.RobotOrientation;
import com.toyrobot.game.application.exception.GameException;
import com.toyrobot.game.application.impl.TableTopImpl;

public class ToyRobotSimulator {
	
	private TableTopImpl tableTopBoard;
	private Robot robot;
	
	public ToyRobotSimulator(TableTopImpl tableTopBoard, Robot robot) {
		this.tableTopBoard = tableTopBoard;
		this.robot = robot;
	}	
	
    public boolean placeRobotOnBoard(Position position) throws GameException {
        if (tableTopBoard == null) {
            throw new GameException(Messages.INVALID_BOARD.toString());        	
        }

        if (position == null) {
            throw new GameException(Messages.INVALID_ROBOT_POSITION.toString());        	
        }

        if (position.getRobotOrientation() == null) {
            throw new GameException(Messages.INVALID_ROBOT_ORIENTATION.toString());        	
        }

        if (!tableTopBoard.isValid(position)) {
            return false;        	
        } else {
            robot.setPosition(position);
            return true;
        }
    }
    
    public String evaluateCommand(String inputString) throws GameException {
        String[] args = inputString.split(" ");
        
        Commands commands;
        try {
        	commands = Commands.valueOf(args[0]);
        } catch (IllegalArgumentException e) {
            throw new GameException(Messages.COMMAND_INVALID.toString());
        }
        if (commands == Commands.PLACE && args.length < 2) {
            throw new GameException(Messages.COMMAND_INVALID.toString());
        }

        String[] params;
        int x = 0;
        int y = 0;
        RobotOrientation commandOrientation = null;
        if (commands == Commands.PLACE) {
            params = args[1].split(",");
            try {
                x = Integer.parseInt(params[0]);
                y = Integer.parseInt(params[1]);
                commandOrientation = RobotOrientation.valueOf(params[2]);
            } catch (Exception e) {
                throw new GameException(Messages.COMMAND_INVALID.toString());
            }
        }

        String output;
        boolean isCorrect;

        switch (commands) {
            case PLACE:
            	isCorrect = placeRobotOnBoard(new Position(x, y, commandOrientation));
            	if(isCorrect) {
            		output = Messages.COMMAND_SUCCESS.toString();            		
            	} else {
            		output = Messages.COMMAND_FAILED.toString();   
            	}
                break;
            case MOVE:
                if(robot.getPosition() == null) {
                	output = Messages.NO_ROBOT_POSITION.toString();
                } else {
                	Position newPosition = robot.getPosition().getNextPosition();
                    if (!tableTopBoard.isValid(newPosition))
                    	output = Messages.NO_SPACE_TO_MOVE.toString();
                    else {
                    	isCorrect = robot.move(newPosition);
                    	if(isCorrect) {
                            output = Messages.COMMAND_SUCCESS.toString();            		
                    	} else {
                    		output = Messages.COMMAND_FAILED.toString();
                    	}                	
                    }                	
                }
                break;
            case LEFT:
            	if(robot.getPosition() == null) {
            		output = Messages.NO_ROBOT_POSITION.toString();
            	} else {
                	isCorrect = robot.rotateLeft();
                	if(isCorrect) {
                        output = Messages.COMMAND_SUCCESS.toString();            		
                	} else {
                		output = Messages.COMMAND_FAILED.toString();
                	}            		
            	} 
                break;
            case RIGHT:
            	if(robot.getPosition() == null) {
            		output = Messages.NO_ROBOT_POSITION.toString();
            	} else {
                	isCorrect = robot.rotateRight();
                	if(isCorrect) {
                        output = Messages.COMMAND_SUCCESS.toString();            		
                	} else {
                		output = Messages.COMMAND_FAILED.toString();
                	}             		
            	}
                break;
            case REPORT:
                output = reportCommand();
                break;
            default:
                throw new GameException(Messages.COMMAND_INVALID.toString());
        }
        return output;
    }
    
    public String reportCommand() {
        if (robot.getPosition() == null) {
        	return Messages.NO_ROBOT_POSITION.toString();        	
        } else {
            return robot.getPosition().getX() + "," + robot.getPosition().getY() + "," + robot.getPosition().getRobotOrientation().toString();        	
        }
    }
}
