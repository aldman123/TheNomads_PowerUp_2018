package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.Robot;
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
	
	public void runLift() {
		double speedRun;
		speedRun = 1;
		
		if (Robot.oi.getOpperatorPOV() == 180.0) {
			speedRun = -1;
		} else if (Robot.oi.getOpperatorPOV() == 0.0) {
			speedRun = 1;
		} else {
			speedRun = 0;
		}
		
		boolean stop = false;
		if (speedRun < 0) {
    		stop = Robot.limitSwitchSubsystem.isBottomLiftPushed();
    	} else if (speedRun > 0) {
    		stop =  Robot.limitSwitchSubsystem.isTopLiftPushed();
    	}
		
		if (stop) {
			speedRun = 0;
		}
		
		
		lift.set(-speedRun * 0.6);
	}
	 
	 public void stop () {
		 lift.set(0);
	 }
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
	}
}