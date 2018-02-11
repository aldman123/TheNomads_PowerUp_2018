package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.Robot;
import org.usfirst.frc.team5630.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDrive_UntilColor extends Command {
	
	private double distance, brightness;
	final private double maxDistance, speed;
	PIDController pidController = Robot.driveTrainAuto.getPidController();
	AnalogInput colorSensor = Robot.sensorSubsystem.getColorSensor();
	
	
	public AutoDrive_UntilColor(double maxDistance, double speed) {
    	requires(Robot.driveTrainAuto);
    	requires(Robot.sensorSubsystem);
    	
    	this.maxDistance = maxDistance;
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
    	brightness = colorSensor.getVoltage();
    	
    	return brightness < RobotMap.colorSensorThreshhold || distance >= maxDistance;
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
