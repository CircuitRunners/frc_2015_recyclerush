package org.usfirst.frc.team1002.robot.commands;

import org.usfirst.frc.team1002.robot.Robot;
import org.usfirst.frc.team1002.robot.subsystems.Drive;

import edu.wpi.first.wpilibj.command.Command;

public class Move extends Command {

	private final double x;
	private final double y;
	private final double rotation;
	private final boolean cartesian;
	private double timeout;

	/**
	 * Default move function. Polar is used.
	 *
	 * @param x The speed to move in the x-direction.
	 * @param y The speed to move in the y-direction.
	 * @param rotation The speed to rotate.
	 */
	public Move(double x, double y, double rotation) {
		requires(Robot.drive);
		this.x = x;
		this.y = y;
		this.rotation = rotation;
		cartesian = false;
	}

	/**
	 * Default move function. Polar is used unless set.
	 *
	 * @param x The speed to move in the x-direction.
	 * @param y The speed to move in the y-direction.
	 * @param rotation The speed to rotate.
	 * @param cartesian Use cartesian instead of polar.
	 */
	public Move(double x, double y, double rotation, boolean cartesian) {
		requires(Robot.drive);
		this.x = x;
		this.y = y;
		this.rotation = rotation;
		this.cartesian = cartesian;
	}

	/**
	 * Default move function. Polar is used unless set.
	 *
	 * @param xIn The speed to move in the x-direction.
	 * @param yIn The speed to move in the y-direction.
	 * @param rotationIn The speed to rotate.
	 * @param cartesian Use cartesian instead of polar.
	 * @param timeout The delay in seconds to stop moving.
	 */
	public Move(double x, double y, double rotation, boolean cartesian, double timeout) {
		requires(Robot.drive);
		this.x = x;
		this.y = y;
		this.rotation = rotation;
		this.cartesian = cartesian;
		this.timeout = timeout;
	}

	/**
	 * Default move function. Polar is used.
	 *
	 * @param xIn The speed to move in the x-direction.
	 * @param yIn The speed to move in the y-direction.
	 * @param rotationIn The speed to rotate.
	 * @param timeOut The delay in seconds to stop moving.
	 */
	public Move(double xIn, double yIn, double rotationIn, double runTime) {
		requires(Robot.drive);
		x = xIn;
		y = yIn;
		rotation = rotationIn;
		cartesian = false;
		timeout = runTime;
	}

	@Override
	protected void end() {
		Drive.move(0, 0, 0);
	}

	@Override
	protected void execute() {
		Drive.move(x, y, rotation, cartesian);
	}

	@Override
	protected void initialize() {
		if (timeout != 0) setTimeout(timeout);
	}

	@Override
	protected void interrupted() {
		Drive.move(0, 0, 0);
	}

	@Override
	protected boolean isFinished() {
		if (timeout == 0) return x == 0 && y == 0 && rotation == 0;
		return x == 0 && y == 0 && rotation == 0 || isTimedOut();
	}
}
