package org.usfirst.frc.team5630.robot.commandGroups;

import org.usfirst.frc.team5630.robot.RobotMap;
import org.usfirst.frc.team5630.robot.commands.AutoDrive;
import org.usfirst.frc.team5630.robot.commands.AutoTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Alexander Aldridge
 * The autonomous command group that we use when
 * the robot is placed in the center.
 */
public class RobotDance extends CommandGroup {
	
	public RobotDance() {
		addSequential(new AutoTurn(-90));
		addSequential(new AutoTurn(90));
		
		for (int i = 0; i < 4; i++) {
			addSequential(new AutoDrive(2, RobotMap.speedMedium));
			addSequential(new AutoTurn(90));
		}
		
		for (int i = 0; i < 4; i++) {
			addSequential(new AutoTurn(180));
		}
		
	}
	
	public void start() {
		
		super.start();
	}
}