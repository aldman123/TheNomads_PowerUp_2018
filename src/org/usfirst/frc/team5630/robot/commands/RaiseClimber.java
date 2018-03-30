package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.Robot;
import org.usfirst.frc.team5630.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Alexander Aldridge
 * This command rotates the Climber Arm based
 * upon the opperator's joystick input
 */
public class RaiseClimber extends Command {

	public RaiseClimber() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.climberSubsystem);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.climberSubsystem.turnClimberArm(
				Robot.oi.getJoystickOpperator().getRawAxis(RobotMap.raiseArmAxis)
				-(Robot.oi.getJoystickOpperator().getRawAxis(RobotMap.lowerArmAxis) / 3));
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.limitSwitchSubsystem.isTopClimberPushed();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.climberSubsystem.stopClimberArm();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.climberSubsystem.stopClimberArm();
	}
}