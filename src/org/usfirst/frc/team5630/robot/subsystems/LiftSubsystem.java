package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	SpeedControllerGroup lift;
	WPI_TalonSRX srx_left, srx_right;

	public LiftSubsystem() {
		srx_left = new WPI_TalonSRX(RobotMap.liftMotorLeft);
		srx_right = new WPI_TalonSRX(RobotMap.liftMotorRight);
		
		srx_left.setNeutralMode(NeutralMode.Brake);
		srx_right.setNeutralMode(NeutralMode.Brake);
		
		srx_right.setInverted(true);
		
		lift = new SpeedControllerGroup(srx_left, srx_right);
	}
	
	public void moveLift (double speed) {
		lift.set(speed);
	}
	 
	 public void stop () {
		 lift.set(0);
	 }
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
	}
}