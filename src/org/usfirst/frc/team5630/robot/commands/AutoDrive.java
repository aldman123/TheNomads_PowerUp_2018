package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.Robot;
import org.usfirst.frc.team5630.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Alexander Aldridge
 * Drives the robot forwards in a straight line
 */
public class AutoDrive extends Command {
	
	private double distance, speed;
	PIDController pidController = Robot.driveTrainSubsystem.getPidController();
	
	/**
	 * Drives the robot forwards until it reaches the distance in feet
	 * @param distance to drive
	 * @param speed from -1.0 to 1.0
	 */
    public AutoDrive(double distance, double speed) {
    	requires(Robot.driveTrainSubsystem);
    	requires(Robot.navXSubsystem);
    	this.distance = distance * RobotMap.feet;
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrainSubsystem.resetDistance();
    	Robot.navXSubsystem.navXResetAngle();
    	
    	pidController.setSetpoint(Robot.navXSubsystem.getTargetAngle());	//At what angle?
    	Robot.driveTrainSubsystem.setForwardSpeed(speed);					//How fast forwards?
    	pidController.setAbsoluteTolerance(3); 								//How percise should you be? (degrees)
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	pidController.enable(); //GO!
    	SmartDashboard.putString("AutoDrive", "" + distance);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return distance >= Robot.driveTrainSubsystem.getDistance();
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
