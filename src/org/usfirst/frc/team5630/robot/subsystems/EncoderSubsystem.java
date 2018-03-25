package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *	Created by Alexander Aldridge
 *	Monitors encoder values
 */
public class EncoderSubsystem extends Subsystem {
	
	private Encoder leftSide = new Encoder(RobotMap.encoderLeftA, RobotMap.encoderLeftB, false);
	private Encoder rightSide = new Encoder(RobotMap.encoderRightA, RobotMap.encoderRightB, true);
	
	public EncoderSubsystem() {
		leftSide.setDistancePerPulse(1/2 * Math.PI / 20); 	// 1/2 foot diameter
		rightSide.setDistancePerPulse(1/2 * Math.PI / 20);	// 20 pulses per rotation
	}
	
	public double getDistanceRight() {
		return rightSide.getDistance();
	}
	
	public double getDistanceLeft() {
		return leftSide.getDistance();
	}
	
	public double getAverageDistance() {
		return (getDistanceLeft() + getDistanceRight()) / 2;
	}
	
	public void reset() {
		leftSide.reset();
		rightSide.reset();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
}

