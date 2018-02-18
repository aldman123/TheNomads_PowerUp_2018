package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.RobotMap;
import org.usfirst.frc.team5630.robot.commands.AutoDrive_UntilColor;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Alexander Aldridge
 * This subsystem controls inputs from a Vex Line Tracker
 */
public class BrightnessSensorSubsystem extends Subsystem {
	private AnalogInput colorSensor = new AnalogInput(RobotMap.colorSensor);
	
    public void initDefaultCommand() {
    }
    
    public AnalogInput getColorSensor() {
    	return colorSensor;
    }
}

