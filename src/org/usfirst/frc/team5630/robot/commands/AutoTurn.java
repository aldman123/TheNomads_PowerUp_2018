package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTurn extends Command {
	
	private double turnAngle;
	PIDController pidController = Robot.driveTrainAuto.getPidcontrol();
	
	
    public AutoTurn(double turnAngle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrainAuto);
    	
    	this.turnAngle = turnAngle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrainAuto.getNavx().reset();
    	
    	pidController.setSetpoint(turnAngle); //What is your angle goal?
    	Robot.driveTrainAuto.setForwardSpeed(0); //How fast forwards?
    	pidController.setAbsoluteTolerance(2); //How percise should you be? (degrees)
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	pidController.enable(); //GO!

    	// TODO
    	// Set turn directions dependant on which direction is required
    	// ie: turn 90 degrees right rather than 270 degrees leftMotorA
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	return pidController.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	pidController.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	pidController.disable();
    }
}
