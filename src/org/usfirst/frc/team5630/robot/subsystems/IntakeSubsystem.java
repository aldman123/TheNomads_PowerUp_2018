package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *@author Caelan Hennig
 *This is for intake.
 */
public class IntakeSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	WPI_TalonSRX srx_left = new WPI_TalonSRX(RobotMap.intakeMotorLeft);
	WPI_TalonSRX srx_right = new WPI_TalonSRX(RobotMap.intakeMotorRight);
	SpeedControllerGroup intake = new SpeedControllerGroup(srx_left, srx_right);

	public void init() {
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

