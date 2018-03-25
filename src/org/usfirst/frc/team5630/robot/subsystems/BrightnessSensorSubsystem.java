package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Alexander Aldridge
 * This subsystem controls inputs from a Vex Line Tracker
 */
public class BrightnessSensorSubsystem extends Subsystem {
	private AnalogInput colorSensorA = new AnalogInput(RobotMap.colorSensorA);
	private AnalogInput colorSensorB = new AnalogInput(RobotMap.colorSensorB);
	
    public void initDefaultCommand() {
    }
    
    public boolean isActivated() {
    	return isLeftTouching() || isRightTouching();
    }
    
    public boolean isLeftTouching() {
    	return colorSensorA.getVoltage() < RobotMap.colorSensorThreshhold;
    }
    
    public boolean isRightTouching() {
    	return colorSensorB.getVoltage() < RobotMap.colorSensorThreshhold;
    }
    
}

