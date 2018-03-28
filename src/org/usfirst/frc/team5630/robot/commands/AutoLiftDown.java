package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.Robot;
import org.usfirst.frc.team5630.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * @author Alexander Aldridge
 * This command moves the lift downwards in autonomous
 */
public class AutoLiftDown extends Command {

    public AutoLiftDown() {
    	requires(Robot.liftSubsystem);
    	requires(Robot.limitSwitchSubsystem);
    }

    // Called just before this Command runs the first time
   
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.liftSubsystem.moveLift(-1 * RobotMap.liftSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.limitSwitchSubsystem.isBottomLiftPushed();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.liftSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.liftSubsystem.stop();
    }
}
