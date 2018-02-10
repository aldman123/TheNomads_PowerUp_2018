package org.usfirst.frc.team5630.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightAutonomous extends CommandGroup {

    public RightAutonomous() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	
    	
    	if ((DriverStation.getInstance().getGameSpecificMessage()).charAt(0) == 'R') {
			/* 
			 * Go forwards until you cross the auto line
			 * Go forwards some more
			 * Turn to the left 90 degrees
			 * Go forwards until you hit the wall
			 * Place the cube
			 */
		} else {
			/*
			 * Cross the auto line
			 * Go much further
			 * Turn 90 degrees left
			 * go forward past two red lines
			 * Turn 90 degrees left
			 * Go forwards a little
			 * Turn 90 degrees left
			 * Go forwards until you hit the wall
			 * Place cube
			 */
		}
    }
}
