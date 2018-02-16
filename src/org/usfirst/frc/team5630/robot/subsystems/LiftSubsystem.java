package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.RobotMap;
import org.usfirst.frc.team5630.robot.commands.LiftTeleop;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class LiftSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	SpeedControllerGroup lift;
	WPI_TalonSRX srx_left, srx_right;
	DifferentialDrive robotDrive;

	public void init() {
		srx_left = new WPI_TalonSRX(RobotMap.liftMotorLeft);
		srx_right = new WPI_TalonSRX(RobotMap.liftMotorRight);
		
		srx_right.setInverted(true);
		
		lift = new SpeedControllerGroup(srx_left, srx_right);
		
		robotDrive.setSafetyEnabled(true);
	}
	
	public void moveLift (double speed) {
		lift.set(speed);
	}
	 
	 public void stop () {
		 lift.set(0);
	 }
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new LiftTeleop(0));
	}
}