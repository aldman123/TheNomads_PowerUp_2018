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
		addSequential(new AutoTurn(-45));
		addSequential(new AutoTurn(90));
		addSequential(new AutoTurn(-45));
	}
	
	public void start() {
		
		super.start();
	}
}