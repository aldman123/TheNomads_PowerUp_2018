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
public class AutoDrive_UntilColor extends AutoDrive {
	
	private double distance;
	
	/**
	 * Drives the robot forwards until the brightness sensor is activated
	 * @param maxDistance The maximum distance to travel in feet 
	 * @param speed The Speed of the Robot
	 */
	public AutoDrive_UntilColor(double maxDistance, double speed) {
		super(maxDistance, speed);
    	requires(Robot.colorSensorSubsystem);

	}
    // Called just before this Command runs the first time
    protected void initialize() {
    	super.initialize();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	super.execute();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	distance = Robot.navXSubsystem.getNavXDistanceForwards();
    	
    	return Robot.colorSensorSubsystem.isActivated() || distance >= super.getFinalDistance();
    }

    // Called once after isFinished returns true
    protected void end() {
    	super.end();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	super.interrupted();
    }
}
