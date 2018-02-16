package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.Robot;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Alexander Aldridge
 * This command should be used to test values
 * and to test the robot in general.
 */
public class testFunction extends Command {
	
	Ultrasonic ultrasonic;
    public testFunction() {
        requires(Robot.sensorSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	ultrasonic = Robot.sensorSubsystem.getUltrasonic();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("Ultrasonic MM", ultrasonic.getRangeMM());
    	SmartDashboard.putNumber("Ultrasonic Inches", ultrasonic.getRangeInches());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
