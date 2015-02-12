package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.Forklift;

import edu.wpi.first.wpilibj.command.Command;

public class Lift extends Command {

    private double speed;

    public Lift(double speedIn) {
	requires(Robot.forklift);
	this.speed = speedIn;
    }

    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
	Forklift.lift(this.speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
	return this.speed == 0;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
	Forklift.lift(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
	Forklift.lift(0);
    }
}