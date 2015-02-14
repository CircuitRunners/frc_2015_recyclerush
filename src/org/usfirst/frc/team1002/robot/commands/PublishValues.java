package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.Dashboard;
import org.usfirst.frc.team1002.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PublishValues extends Command {

    public PublishValues() {
	requires(Robot.dash);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
	String driveType;
	if (Drive.isCartesian) {
	    driveType = "Cartesian";
	} else {
	    driveType = "Polar";
	}
	Dashboard.publish(((Double) Robot.joystickMove.getX()).toString(), ((Double) Robot.joystickMove.getY()).toString(), ((Double) Robot.joystickMove.getTwist()).toString(), driveType);
    }

    @Override
    protected boolean isFinished() {
	return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
