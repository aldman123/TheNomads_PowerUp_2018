package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.RobotMap;
import org.usfirst.frc.team5630.robot.commands.DriveRobot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/*
 * Modified by Alexander Aldridge
 *  of Team 5630 for the 2018 FRC Season
 */

/**
 * @author Alexander Aldridge
 * Used to control our robot's drive train
 */
public class DriveTrainTeleopSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	SpeedControllerGroup m_left, m_right;
	WPI_TalonSRX srx_leftA, srx_leftB, srx_rightA, srx_rightB;
	DifferentialDrive robotDrive;
	
	
	public void init() {
		srx_leftA = new WPI_TalonSRX(RobotMap.leftMotorA);
		srx_leftB = new WPI_TalonSRX(RobotMap.leftMotorB);
		srx_rightA = new WPI_TalonSRX(RobotMap.rightMotorA);
		srx_rightB = new WPI_TalonSRX(RobotMap.rightMotorB);
		
		
		m_left = new SpeedControllerGroup(srx_leftA, srx_leftB);
		m_right = new SpeedControllerGroup(srx_rightA, srx_rightB);
		
		robotDrive = new DifferentialDrive(m_left, m_right);
		robotDrive.setSafetyEnabled(true);
		

	}
	
	public void teleopDrive(Joystick stick) {
		robotDrive.arcadeDrive(stick.getRawAxis(1), stick.getRawAxis(5));	//Move forward with right joystick, turn with left	
	}
	
	public void stop() {
		robotDrive.arcadeDrive(0, 0);
		robotDrive.stopMotor();	//Safety. It's probably helpful
	}
	
	
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveRobot());
	}
}