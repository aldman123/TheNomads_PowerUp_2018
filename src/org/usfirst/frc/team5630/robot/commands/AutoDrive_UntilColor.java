package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.Robot;
import org.usfirst.frc.team5630.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Alexander Aldridge
 * Drives the robot forwards in a straight line until
 *  the brightness sensor hits a line
 */
public class AutoDrive_UntilColor extends Command {
	
	private double distance, brightness;
	final private double maxDistance, speed;
	PIDController pidController = Robot.driveTrainAuto.getPidController();
	AnalogInput colorSensor = Robot.sensorSubsystem.getColorSensor();
	
	/**
	 * Drives the robot forwards until the brightness sensor is activated
	 * @param maxDistance The maximum distance to travel in feet 
	 * @param speed The Speed of the Robot
	 */
	public AutoDrive_UntilColor(double maxDistance, double speed) {
    	requires(Robot.driveTrainAuto);
    	requires(Robot.sensorSubsystem);
    	
    	this.maxDistance = maxDistance * RobotMap.feet;
    	this.speed = speed;

	}
    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.sensorSubsystem.navXReset();
    	
    	pidController.setSetpoint(0); //At what angle?
    	Robot.driveTrainAuto.setForwardSpeed(speed); //How fast forwards?
    	pidController.setAbsoluteTolerance(3); //How precise should you be? (degrees)
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	pidController.enable(); //GO!
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	distance = Robot.sensorSubsystem.getNavXDistanceForwards();
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
