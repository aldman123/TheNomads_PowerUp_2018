package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Alexander Aldridge
 * Turns the robot without moving.
 */
public class AutoTurn extends Command {
	PIDController pidController = Robot.driveTrainSubsystem.getPidController();
	
	private double turnAngle;
	
	/**
	 * @param turnAngle The angle at which the robot will end at.
	 */
    public AutoTurn(double turnAngle) {
    	requires(Robot.driveTrainSubsystem);
    	this.turnAngle = turnAngle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.navXSubsystem.setTargetAngle(turnAngle);
    	pidController.setSetpoint(Robot.navXSubsystem.getTargetAngle()); //What is your angle goal?
    	Robot.driveTrainSubsystem.setForwardSpeed(0); //How fast forwards?
    	pidController.setAbsoluteTolerance(1); //How percise should you be? (degrees)
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	pidController.enable(); //GO!
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	return pidController.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	pidController.disable();
    	Robot.driveTrainSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	pidController.disable();
    	Robot.driveTrainSubsystem.stop();
    }
}
