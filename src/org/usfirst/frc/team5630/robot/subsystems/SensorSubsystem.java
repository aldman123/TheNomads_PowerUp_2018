package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.RobotMap;
import org.usfirst.frc.team5630.robot.commands.AutoDrive_UntilColor;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Alexander Aldridge
 * This subsystem controls all the sensor inputs from the roboRIO's ports
 */
public class SensorSubsystem extends Subsystem {
	private AnalogInput colorSensor = new AnalogInput(RobotMap.colorSensor);
	private Ultrasonic vexUltrasonic = new Ultrasonic(RobotMap.ultrasonicOut, RobotMap.ultrasonicIn);
	private AHRS navx = new AHRS(SPI.Port.kMXP);
	
    public void initDefaultCommand() {
    	setDefaultCommand(new AutoDrive_UntilColor(0, RobotMap.speedSuperSlow));
    }
    
    public AnalogInput getColorSensor() {
    	return colorSensor;
    }
    
    public Ultrasonic getUltrasonic() {
    	return vexUltrasonic;
    }
    
    public double getNavXDistanceForwards() {
    	return navx.getDisplacementY();
    }
    
    /**
     * WARNING: The navX's angle may drift an average of 1 degree a minute!
     * Reset the navX periodically to prevent this
     * @return The navX's current angle
     */
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

