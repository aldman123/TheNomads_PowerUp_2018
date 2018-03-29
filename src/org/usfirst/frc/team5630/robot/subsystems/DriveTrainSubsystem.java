package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.Robot;
import org.usfirst.frc.team5630.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/*
 * Modified by Alexander Aldridge
 *  of Team 5630 for the 2018 FRC Season
 */

/**
 * @author Alexander Aldridge
 * Used to control our robot's drive train
 * during the Auto mode
 */
public class DriveTrainSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	SpeedControllerGroup m_left, m_right;
	WPI_TalonSRX srx_leftA, srx_leftB, srx_rightA, srx_rightB;
	DifferentialDrive robotDrive;
	
	private PIDOutput pidOutput;
	private PIDController pidController;
	
	double forwardSpeed = 0.0;
	
	private int direction = 1;
	
	public DriveTrainSubsystem() {
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
				robotDrive.arcadeDrive(forwardSpeed, output);
			}
		};
		
		//These are caculus values that Charlie told Alexander to put in
		pidController = new PIDController(0.1, 0.000, 0, Robot.navXSubsystem.getNavX(), pidOutput);
		pidController.setOutputRange(-0.6, 0.6);
	}
	
	public void teleopDrive(double speed, double turnSpeed) {
		robotDrive.arcadeDrive(-turnSpeed, speed * direction);
		
	}
	
	public void changeDirection() {
		direction *= -1;
	}
	
	public void stop() {
		robotDrive.arcadeDrive(0, 0);
		robotDrive.stopMotor();	//Safety. It's probably helpful
		pidController.disable();
	}

	public PIDController getPidController() {
		return pidController;
	}

	public void setPidController(PIDController pidcontrol) {
		this.pidController = pidcontrol;
	}

	public double getForwardSpeed() {
		return this.forwardSpeed;
	}

	public void setForwardSpeed(double forwardSpeed) {
		this.forwardSpeed = forwardSpeed;
	}
	
	public void setAutoMode(boolean inAuto) {
		if (inAuto) {
			srx_leftA.setNeutralMode(NeutralMode.Brake);
			srx_leftB.setNeutralMode(NeutralMode.Brake);
			srx_rightA.setNeutralMode(NeutralMode.Brake);
			srx_rightB.setNeutralMode(NeutralMode.Brake);
		} else {
			srx_leftA.setNeutralMode(NeutralMode.Coast);
			srx_leftB.setNeutralMode(NeutralMode.Coast);
			srx_rightA.setNeutralMode(NeutralMode.Coast);
			srx_rightB.setNeutralMode(NeutralMode.Coast);
		}
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
	}
}
