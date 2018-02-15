package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.RobotMap;
import org.usfirst.frc.team5630.robot.commands.RaiseClimber;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimberSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	WPI_TalonSRX srx_climberArm, srx_winchA, srx_winchB;
	SpeedControllerGroup winch;
	
	public void init() {
		srx_climberArm = new WPI_TalonSRX(RobotMap.climberArm);
		srx_winchA = new WPI_TalonSRX(RobotMap.winchA);
		srx_winchB = new WPI_TalonSRX(RobotMap.winchB);
		srx_winchB.setInverted(true);
		winch = new SpeedControllerGroup(srx_winchA, srx_winchB);
	}
	
	public void turnClimberArm(double speed) {
		srx_climberArm.set(speed);
	}
	
	public void activateWinch() {
		winch.set(RobotMap.climbingSpeed);
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new RaiseClimber());
    }
}

