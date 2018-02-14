package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.RobotMap;
import org.usfirst.frc.team5630.robot.commands.AutoDrive_UntilColor;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SPI;
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
	private AHRS navx = new AHRS(SPI.Port.kMXP);
	
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
    
    public double getNavXDistanceX() {
    	return navx.getDisplacementX();
    }
    
    public double getNavXDistanceY() {
    	return navx.getDisplacementY();
    }
    
    public double getNavXDistanceZ() {
    	return navx.getDisplacementZ();
    }
    
    public double getNavXAngle() {
    	return navx.getAngle();
    }
    
    public void navXReset() {
    	navx.reset();
    	navx.resetDisplacement();
    }
    
    public AHRS getNavX() {
    	return navx;
    }
    
}

