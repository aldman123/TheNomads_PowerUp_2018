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

    AnalogInput limitSwitchTop = new AnalogInput(RobotMap.limitSwitchTop);
    AnalogInput limitSwitchBottom = new AnalogInput(RobotMap.limitSwitchBottom);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
    
    //When pushed, it should have a value of 3 or 4
    //When it's released, it should have a value of ~210
    public boolean isTopPushed() {
    	return limitSwitchTop.getValue() < 50;
    }
    
    //When pushed, it should have a value of 3 or 4
    //When it's released, it should have a value of ~210
    public boolean isBottomPushed() {
    	return limitSwitchBottom.getValue() < 50;
    }
    
}

