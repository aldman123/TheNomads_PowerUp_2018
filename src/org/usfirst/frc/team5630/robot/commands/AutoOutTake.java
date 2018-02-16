package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.Robot;
import org.usfirst.frc.team5630.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *@author Caelan Hennig
 *This command is for removing things from intake.
 */
public class AutoOutTake extends Command {

    public AutoOutTake() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.intakeSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intakeSubsystem.inTake(RobotMap.intakeSpeed*-1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return DriverStation.getInstance().isOperatorControl() == false;
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
