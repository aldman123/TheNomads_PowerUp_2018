package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDrive extends Command {
	
	private double distance, speed;
	PIDController pidController = Robot.driveTrainAuto.getPidController();
	
	
    public AutoDrive(double distance, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrainAuto);
    	
    	this.distance = distance;
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrainAuto.getNavx().reset();
    	Robot.driveTrainAuto.getNavx().resetDisplacement();
    	
    	pidController.setSetpoint(0); //At what angle?
    	Robot.driveTrainAuto.setForwardSpeed(speed); //How fast forwards?
    	pidController.setAbsoluteTolerance(3); //How percise should you be? (degrees)
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	pidController.enable(); //GO!
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	distance = Robot.driveTrainAuto.getDistanceTravled();
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	pidController.disable();
    	Robot.driveTrainAuto.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	pidController.disable();
    	Robot.driveTrainAuto.stop();
    }
}
