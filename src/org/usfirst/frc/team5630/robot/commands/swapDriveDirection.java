package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class swapDriveDirection extends Command {
	
	private boolean swappedDirection;
	
    public swapDriveDirection() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	swappedDirection = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrainSubsystem.changeDirection();
    	swappedDirection = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return swappedDirection;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
