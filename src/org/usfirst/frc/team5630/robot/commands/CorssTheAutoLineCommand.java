package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CorssTheAutoLineCommand extends Command {
	long startTime = 0;
    public CorssTheAutoLineCommand() {
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double time = System.currentTimeMillis();
		if (time - startTime <= 5000) {
			Robot.driveTrainSubsystem.teleopDrive(0.6, 0);
		} else {
			Robot.driveTrainSubsystem.teleopDrive(0, 0);
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return System.currentTimeMillis() >= 6000;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
