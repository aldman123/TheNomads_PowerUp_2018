package org.usfirst.frc.team5630.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Alexander Aldridge
 * This subsystem controls the navX
 */
public class NavXSubsystem extends Subsystem {
	private AHRS navx;
	
	public NavXSubsystem() {
		navx = new AHRS(SPI.Port.kMXP);
	}
	
    public void initDefaultCommand() {
    }
    
    public double getNavXDistanceForwards() {
    	return this.navx.getDisplacementY();
    }
    
    /**
     * WARNING: The navX's angle may drift an average of 1 degree a minute!
     * Reset the navX periodically to prevent this
     * @return The navX's current angle
     */
    public double getNavXAngle() {
    	return this.navx.getAngle();
    }
    
    public void navXReset() {
    	this.navx.reset();
    	this.navx.resetDisplacement();
    }
    
    public AHRS getNavX() {
    	return this.navx;
    }
    
}

