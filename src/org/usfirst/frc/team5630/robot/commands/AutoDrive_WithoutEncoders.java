package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoDrive_WithoutEncoders extends Command {
	
	private double time, speed;
	PIDController pidController = Robot.driveTrainSubsystem.getPidController();
	
    public AutoDrive_WithoutEncoders(double time, double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.time = time;
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrainSubsystem.resetDistance();
    	Robot.navXSubsystem.navXResetAngle();
    	
    	pidController.setSetpoint(Robot.navXSubsystem.getTargetAngle());	//At what angle?
    	Robot.driveTrainSubsystem.setForwardSpeed(speed);					//How fast forwards?
    	pidController.setAbsoluteTolerance(3);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	pidController.enable();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return time >= DriverStation.getInstance().getMatchTime();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
