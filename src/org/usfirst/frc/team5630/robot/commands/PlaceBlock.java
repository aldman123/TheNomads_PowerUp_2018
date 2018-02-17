package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Alexander Aldridge
 * This command group places a cube in autonomous.
 */
public class PlaceBlock extends CommandGroup {

    public PlaceBlock() {
    	addSequential(new AutoLiftUp());
    	addSequential(new AutoDrive(1, RobotMap.speedSuperSlow));
    	addSequential(new OutTake());
    	addSequential(new AutoDrive(-1, RobotMap.speedMedium));
    }
}
