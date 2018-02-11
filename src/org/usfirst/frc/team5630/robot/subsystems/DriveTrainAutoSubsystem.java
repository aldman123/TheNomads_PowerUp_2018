package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.RobotMap;
import org.usfirst.frc.team5630.robot.commands.DriveRobot;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

/*
 * Modified by Alexander Aldridge
 *  of Team 5630 for the 2018 FRC Season
 */

/**
 * @author Alexander Aldridge
 * Used to control our robot's drive train
 */
public class DriveTrainAutoSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	SpeedControllerGroup m_left, m_right;
	WPI_TalonSRX srx_leftA, srx_leftB, srx_rightA, srx_rightB;
	DifferentialDrive robotDrive;
	
	AHRS navx = new AHRS(SPI.Port.kMXP);
	
	PIDOutput pidOutput;
	PIDController pidController;
	
	double forwardSpeed = 0.0;
	private double distanceTravled = 0.0;
	
	public void init() {
		srx_leftA = new WPI_TalonSRX(RobotMap.leftMotorA);
		srx_leftB = new WPI_TalonSRX(RobotMap.leftMotorB);
		srx_rightA = new WPI_TalonSRX(RobotMap.rightMotorA);
		srx_rightB = new WPI_TalonSRX(RobotMap.rightMotorB);
		
		
		m_left = new SpeedControllerGroup(srx_leftA, srx_leftB);
		m_right = new SpeedControllerGroup(srx_rightA, srx_rightB);
		
		robotDrive = new DifferentialDrive(m_left, m_right);
		robotDrive.setSafetyEnabled(true);
		
		
		pidOutput = new PIDOutput() {
			@Override
			public void pidWrite(double output) {
				/*
				 * srx_leftA.set(ControlMode.Velocity, forwardSpeed + output);
				 * srx_leftB.set(ControlMode.Velocity, forwardSpeed + output);
				 * srx_rightA.set(ControlMode.Velocity, forwardSpeed - output);
				 * srx_rightB.set(ControlMode.Velocity, forwardSpeed - output);
				 */
				
				robotDrive.arcadeDrive(forwardSpeed, output);
				
			}
		};
		pidController = new PIDController(5, 0.0001, 0, navx, pidOutput);	//Caculus values that Charlie
																			//told me to put in
	}
	
	public void stop() {
		robotDrive.arcadeDrive(0, 0);
		robotDrive.stopMotor();	//Safety. It's probably helpful
	}
	
	public double getDistanceTravled() {
		return navx.getDisplacementX();
		//TODO this should return the distance traveled by the robot
	}
	
	
	public AHRS getNavx() {
		return navx;
	}

	public void setNavx(AHRS navx) {
		this.navx = navx;
	}

	public PIDController getPidController() {
		return pidController;
	}

	public void setPidController(PIDController pidcontrol) {
		this.pidController = pidcontrol;
	}

	public double getForwardSpeed() {
		return forwardSpeed;
	}

	public void setForwardSpeed(double forwardSpeed) {
		this.forwardSpeed = forwardSpeed;
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveRobot());
	}
}
