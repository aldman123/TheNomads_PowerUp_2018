package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.RobotMap;
import org.usfirst.frc.team5630.robot.commands.AutoDrive_UntilColor;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SensorSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private AnalogInput colorSensor = new AnalogInput(RobotMap.colorSensor);
	private Ultrasonic vexUltrasonic = new Ultrasonic(RobotMap.ultrasonicOut, RobotMap.ultrasonicIn);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new AutoDrive_UntilColor(999, 0.1));
    }
    
    public AnalogInput getColorSensor() {
    	return colorSensor;
    }
    
    public Ultrasonic getUltrasonic() {
    	return vexUltrasonic;
    }
    
}

