package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.Robot;
import org.usfirst.frc.team5630.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftTeleop extends Command {

	private int direction;
    public LiftTeleop(int direction) {
    	requires(Robot.liftSubsystem);
    	requires(Robot.limitSwitchSubsystem);
    	if (direction > 0) {
    		this.direction = 1;
    	} else if (direction < 0) {
    		this.direction = -1;
    	} else {
    		this.direction = 0;
    	}
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.liftSubsystem.moveLift(RobotMap.liftSpeed * this.direction);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (this.direction == 1) {
    		return Robot.limitSwitchSubsystem.isTopPushed();
    	} else if (this.direction == -1) {
    		return Robot.limitSwitchSubsystem.isBottomPushed();
    	} else {
    		return false;
    	}
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.liftSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.liftSubsystem.stop();
    }
}
