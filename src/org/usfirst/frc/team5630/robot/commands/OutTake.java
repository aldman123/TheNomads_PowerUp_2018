package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.Robot;
import org.usfirst.frc.team5630.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class OutTake extends Command {

    public OutTake() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.intakeSubsystem);
    }

    // Called just before this Command runs the first time
    double startTime;
    protected void initialize() {
    	startTime = DriverStation.getInstance().getMatchTime();	//In seconds
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intakeSubsystem.outTake(RobotMap.intakeSpeed*-1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (DriverStation.getInstance().getMatchTime() - startTime) >= RobotMap.outTakeTime;	//In seconds
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.intakeSubsystem.stopTake();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.intakeSubsystem.stopTake();
    }
}
