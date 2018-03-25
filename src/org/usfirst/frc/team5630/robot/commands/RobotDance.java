package org.usfirst.frc.team5630.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Alexander Aldridge
 * The autonomous command group that we use when
 * the robot is placed in the center.
 */
public class RobotDance extends CommandGroup {
	
	public RobotDance() {
		addSequential(new AutoTurn(-90));
		addSequential(new AutoTurn(45));
		addSequential(new AutoTurn(-10));
		addSequential(new AutoTurn(55));
	}
	
	public void start() {
		
		super.start();
	}
}