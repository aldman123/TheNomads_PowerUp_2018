package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.Robot;
import org.usfirst.frc.team5630.robot.RobotMap;
import org.usfirst.frc.team5630.robot.subsystems.LimitSwitchSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LiftTeleop extends Command {

	private int direction;
	private int height, maxHeight;
	private double liftSpeedModifier;
    public LiftTeleop() {
//    	requires(Robot.liftSubsystem);
//    	requires(Robot.limitSwitchSubsystem);
//    	if (direction > 0) {
//    		this.direction = 1;
//    	} else if (direction < 0) {
//    		this.direction = -1;
//    	} else {
//    		this.direction = 0;
//    	}
//    	
//    	height = 0;
//    	maxHeight = 66;
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	height += 1;
//    	liftSpeedModifier = 1;
//    	if (height < maxHeight * 3/4) {
//    		liftSpeedModifier = 2;
//    	}
    	
//    	SmartDashboard.putNumber("Lift Speed Mod", liftSpeedModifier);
    	
    	
    	/*
    	 * if going upwards and below half the height,
    	 * or going downwards and above half the height
    	 * double the speed
    	 */
    	
    	Robot.liftSubsystem.runLift();
    	
//    	Robot.liftSubsystem.moveLift(RobotMap.liftSpeed * this.direction * liftSpeedModifier);
//    	SmartDashboard.putString("Lift Height", "Current Height: " + height);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.liftSubsystem.stop();
    	height = 0;
    	SmartDashboard.putString("Lift Height", "Reset to Zero");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
//    	Robot.liftSubsystem.stop();
//    	height = 0;
//    	SmartDashboard.putString("Lift Height", "interrupted");
    }
}
