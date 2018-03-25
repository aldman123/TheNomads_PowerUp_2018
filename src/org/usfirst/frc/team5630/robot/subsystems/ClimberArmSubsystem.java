package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Alexander Aldridge
 * Subsystem for controlling the climber arm
 */
public class ClimberArmSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	WPI_TalonSRX srx_climberArm;
	
	public void init() {
		srx_climberArm = new WPI_TalonSRX(RobotMap.climberArm);
		srx_climberArm.setNeutralMode(NeutralMode.Brake);
	}
	
	public void turnClimberArm(double speed) {
		srx_climberArm.set(speed);
	}
	
	public void stopClimberArm() {
		srx_climberArm.stopMotor();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
}

