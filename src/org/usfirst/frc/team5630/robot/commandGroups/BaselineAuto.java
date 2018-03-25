package org.usfirst.frc.team5630.robot.commandGroups;

import org.usfirst.frc.team5630.robot.RobotMap;
import org.usfirst.frc.team5630.robot.commands.AutoDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Alexander Aldridge
 * The autonomous command group that we use when
 * the robot is placed in the center.
 */
public class BaselineAuto extends CommandGroup {
	
	public BaselineAuto() {
		addSequential(new AutoDrive(8, RobotMap.speedFast));
	}
	
	public void start() {
		
		super.start();
	}
}