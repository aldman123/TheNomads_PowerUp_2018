package org.usfirst.frc.team5630.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5630.robot.Robot;

/*
 * Modified by Alexander Aldridge
 *  of Team 5630 for the 2018 FRC Season
 */

public class DriveRobot extends Command {
	
	public DriveRobot() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrainTeleop);
	}

	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.driveTrainTeleop.teleopDrive(Robot.oi.getJoystickDriver());
	}

	
	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	
	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.driveTrainTeleop.stop();
	}

	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.driveTrainTeleop.stop();
	}
}
