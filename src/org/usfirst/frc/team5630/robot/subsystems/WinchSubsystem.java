package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Alexander Aldridge
 * A subsystem for controlling the winch for the climber
 */
public class WinchSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	WPI_TalonSRX srx_winchA, srx_winchB;
	SpeedControllerGroup winch;
	
	public void init() {
		srx_winchA = new WPI_TalonSRX(RobotMap.winchA);
		srx_winchB = new WPI_TalonSRX(RobotMap.winchB);
		srx_winchA.setNeutralMode(NeutralMode.Brake);
		srx_winchB.setNeutralMode(NeutralMode.Brake);
		srx_winchB.setInverted(true);
		winch = new SpeedControllerGroup(srx_winchA, srx_winchB);
	}

	public void turnWinch(double speed) {
		winch.set(speed);
	}
	
	public void stopWinch() {
		winch.set(0);
		winch.stopMotor();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
}

