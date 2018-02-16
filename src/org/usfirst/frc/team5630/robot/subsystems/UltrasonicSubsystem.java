package org.usfirst.frc.team5630.robot.subsystems;

import org.usfirst.frc.team5630.robot.RobotMap;
import org.usfirst.frc.team5630.robot.commands.AutoDrive_UntilColor;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Alexander Aldridge
 * This subsystem controls any ultrasonic inputs
 */
public class UltrasonicSubsystem extends Subsystem {
	private Ultrasonic vexUltrasonic = new Ultrasonic(RobotMap.ultrasonicOut, RobotMap.ultrasonicIn);
	
    public void initDefaultCommand() {
    	setDefaultCommand(new AutoDrive_UntilColor(0, RobotMap.speedSuperSlow));
    }
    
    public Ultrasonic getUltrasonic() {
    	return vexUltrasonic;
    }
    
}

