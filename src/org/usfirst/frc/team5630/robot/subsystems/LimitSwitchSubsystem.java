package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Alexander Aldridge
 * This subsystem is for controlling limit switches on our robot
 * primarily for our lift system.
 */
public class LimitSwitchSubsystem extends Subsystem {

	AnalogInput limitSwitchTopLift = new AnalogInput(RobotMap.limitSwitchTopLift);
    AnalogInput limitSwitchBottomLift = new AnalogInput(RobotMap.limitSwitchBottomLift);
    AnalogInput limitSwitchTopClimber = new AnalogInput(RobotMap.limitSwitchTopClimber);
    AnalogInput limitSwitchBottomClimber = new AnalogInput(RobotMap.limitSwitchBottomClimber);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
    
    //When pushed, it should have a value of 3 or 4
    //When it's released, it should have a value of ~210
    public boolean isTopLiftPushed() {
    	return limitSwitchTopLift.getValue() < 50;
    }
    
    //When pushed, it should have a value of 3 or 4
    //When it's released, it should have a value of ~210
    public boolean isBottomLiftPushed() {
    	return limitSwitchBottomLift.getValue() < 50;
    }
    
    public boolean isBottomClimberPushed() {
    	return limitSwitchBottomClimber.getValue() < 50;
    }
    
    public boolean isTopClimberPushed() {
    	return limitSwitchTopClimber.getValue() < 50;
    }
    
}

