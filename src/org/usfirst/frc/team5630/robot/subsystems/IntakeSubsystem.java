package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	SpeedControllerGroup m_left, m_right;
	WPI_TalonSRX srx_left, srx_right;
	DifferentialDrive robotDrive;

	public void init() {
		srx_left = new WPI_TalonSRX(RobotMap.intakeMotorLeft);
		srx_right = new WPI_TalonSRX(RobotMap.intakeMotorRight);
				
		m_left = new SpeedControllerGroup(srx_left);
		m_right = new SpeedControllerGroup(srx_right);
		
		robotDrive = new DifferentialDrive(m_left, m_right);
		robotDrive.setSafetyEnabled(true);
	}
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

