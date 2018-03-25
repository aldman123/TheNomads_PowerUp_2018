package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Alexander Aldridge
 * The autonomous command group that we use when
 * the robot is placed in the center.
 */
public class BaselineAuto extends CommandGroup {
	
	public BaselineAuto() {
		addSequential(new AutoDrive(3, RobotMap.speedFast));
	}
	
	public void start() {
		
		super.start();
	}
}