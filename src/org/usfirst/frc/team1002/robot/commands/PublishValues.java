package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.Dashboard;
import org.usfirst.frc.team1002.robot.subsystems.Drive;
import org.usfirst.frc.team1002.robot.subsystems.Forklift;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PublishValues extends Command {

    public PublishValues() {
	requires(Robot.dash);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
	String driveType;
	if (Drive.isCartesian) {
	    driveType = "Cartesian";
	} else {
	    driveType = "Polar";
	}
	Dashboard.publish(((Double) Robot.xbox.getX()).toString().substring(0, 5), ((Double) Robot.xbox.getY()).toString().substring(0, 5),
		((Double) Robot.xbox.getRawAxis(4)).toString().substring(0, 5), ((Boolean) Forklift.limitSensorBot.get()).toString(),
		((Boolean) Forklift.limitSensorTop.get()).toString(), ((Boolean) Forklift.limitSensorFork.get()).toString(), driveType);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
	return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
