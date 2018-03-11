package org.usfirst.frc.team5630.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team5630.robot.Robot;

/**
 * @author Alexander Aldridge
 * The autonomous command group that we use when
 * the robot is placed in the center.
 */

public class DriveRobot extends Command {
	
	public DriveRobot() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrainSubsystem);
	} 

	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.driveTrainSubsystem.getPidController().disable();
	}

	
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.driveTrainSubsystem.teleopDrive(
				Robot.oi.getJoystickDriver().getRawAxis(4), //Left Joystick to turn 5
				Robot.oi.getJoystickDriver().getRawAxis(1)	//Right Joystick to go forwards 0
				);
	}

	
	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return DriverStation.getInstance().isOperatorControl() != true;
	}

	
	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.driveTrainSubsystem.stop();
	}

	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		Robot.driveTrainSubsystem.stop();
	}
}
