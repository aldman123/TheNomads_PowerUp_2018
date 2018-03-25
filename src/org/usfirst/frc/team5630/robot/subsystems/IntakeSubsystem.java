package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *@author Caelan Hennig
 *This is for intake.
 */
public class IntakeSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	SpeedControllerGroup intake;
	WPI_TalonSRX srx_left, srx_right;
	DifferentialDrive robotDrive;

	public void init() {
		srx_left = new WPI_TalonSRX(RobotMap.intakeMotorLeft);
		srx_right = new WPI_TalonSRX(RobotMap.intakeMotorRight);
		
		intake = new SpeedControllerGroup(srx_left, srx_right);
		
		robotDrive.setSafetyEnabled(true);
	}
	
	public void inTake(double speed) {
		intake.set(speed);
	}
	
	public void outTake(double speed) {
		intake.set(speed);
	}
	
	public void stopTake() {
		intake.set(0);
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
}

