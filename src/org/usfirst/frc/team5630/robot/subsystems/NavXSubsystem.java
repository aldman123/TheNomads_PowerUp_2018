package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.commands.AutoDrive;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Alexander Aldridge
 * This subsystem controls the navX
 */
public class NavXSubsystem extends Subsystem {
	private AHRS navx = new AHRS(SPI.Port.kMXP);
	
    public void initDefaultCommand() {
    	setDefaultCommand(new AutoDrive(0, 0));
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

