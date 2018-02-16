package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.RobotMap;
import org.usfirst.frc.team5630.robot.commands.DriveRobot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class LiftSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	SpeedControllerGroup m_left, m_right;
	WPI_TalonSRX srx_left, srx_right;
	DifferentialDrive robotDrive;

	public void init() {
		srx_left = new WPI_TalonSRX(RobotMap.liftMotorLeft);
		srx_right = new WPI_TalonSRX(RobotMap.liftMotorRight);
		
		
		m_left = new SpeedControllerGroup(srx_left);
		m_right = new SpeedControllerGroup(srx_right);
		
		robotDrive = new DifferentialDrive(m_left, m_right);
		robotDrive.setSafetyEnabled(true);
	}
	
	public void teleopDrive(Joystick button) {
		button.whileHeld(new LiftingThing());// TODO: Name command.
		//Use a button? Two buttons for both ways?
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}
}

