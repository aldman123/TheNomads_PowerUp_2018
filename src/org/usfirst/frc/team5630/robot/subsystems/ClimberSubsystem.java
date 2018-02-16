package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.RobotMap;
import org.usfirst.frc.team5630.robot.commands.TurnClimberArm;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Alexander Aldridge
 * It really should be two seperate subsystems.
 * TODO: Split these up
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
	
	public void turnWinch(double speed) {
		winch.set(speed);
	}
	
	public void stopClimberArm() {
		srx_climberArm.stopMotor();
	}
	
	public void stopWinch() {
		winch.set(0);
		winch.stopMotor();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TurnClimberArm());
    }
}

