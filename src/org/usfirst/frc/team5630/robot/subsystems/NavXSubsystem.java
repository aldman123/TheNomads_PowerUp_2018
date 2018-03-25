package org.usfirst.frc.team5630.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Alexander Aldridge
 * This subsystem controls the navX
 */
public class NavXSubsystem extends Subsystem {
	private AHRS navx;
	
	private double targetAngle;
	
	public NavXSubsystem() {
		navx = new AHRS(SPI.Port.kMXP);
		navx.enableLogging(true);
		navx.resetDisplacement();
		navx.reset();
		targetAngle = 0;
		
	}
	
    public void initDefaultCommand() {
    }

    
    /**
     * WARNING: The navX's angle may drift an average of 1 degree a minute!
     * Reset the navX periodically to prevent this
     * @return The navX's current angle
     */
    public double getNavXAngle() {
    	return navx.getAngle() % 360;
    }
    
    public void navXResetAngle() {
    	this.targetAngle = 0;
    	//navx.reset();
    }
    
    public void setTargetAngle(double angle) {
    	this.targetAngle = ( angle + targetAngle ) % 360;
    }
    
    public double getTargetAngle() {
    	return this.targetAngle;
    }
    
    public AHRS getNavX() {
    	return this.navx;
    }
    
}

