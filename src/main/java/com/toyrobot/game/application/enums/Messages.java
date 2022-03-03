package com.toyrobot.game.application.enums;

public enum Messages {
	
    COMMAND_INVALID("Command is INVALID. Please try again(\'CMD\' to show list of valid commands."),
    COMMAND_SUCCESS("Command executed SUCCESSFULLY!"),
    COMMAND_FAILED("Command FAILED to execute!"),
    INVALID_BOARD("Invalid table top board!"),
    INVALID_ROBOT_POSITION("Invalid robot position!"),
    INVALID_ROBOT_ORIENTATION("Invalid robot orientation!"),
    NO_ROBOT_POSITION("Robot is NOT on the board. Please use PLACE command first."),
    NO_SPACE_TO_MOVE("That move will cause the robot to fall. Please face it to another direction.");

    private final String message;

    Messages(final String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}