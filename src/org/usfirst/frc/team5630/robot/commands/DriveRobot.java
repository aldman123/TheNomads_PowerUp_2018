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
		System.out.println("DriveRobot");
		Robot.driveTrainSubsystem.teleopDrive(
				Robot.oi.getJoystickDriver().getRawAxis(5), //Right Joystick to go forwards
				Robot.oi.getJoystickDriver().getRawAxis(0)	//Left Joystick to turn
				);
	}

	
	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		System.out.println("Finished? " + DriverStation.getInstance().isOperatorControl());
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
