package org.usfirst.frc.team5630.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftAutonomous extends CommandGroup {

    public LeftAutonomous() {
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
    	
    	
    	
    	if ((DriverStation.getInstance().getGameSpecificMessage()).charAt(0) == 'L') {
			/* 
			 * Go forwards until you cross the auto line
			 * Go forwards some more
			 * Turn to the right 90 degrees
			 * Go forwards until you hit the wall
			 * Place the cube
			 */
    		
    		//Values were guessed.
    		addSequential(new AutoDrive(3, 0.5));
    		addSequential(new AutoDrive(3, 0.3));
    		addSequential(new AutoTurn(-90));
    		
    		
		} else {
			/*
			 * Cross the auto line
			 * Go much further
			 * Turn 90 degrees right
			 * go forward past two red/blue lines
			 * Turn 90 degrees right
			 * Go forwards a little
			 * Turn 90 degrees right
			 * Go forwards until you hit the wall
			 * Place cube
			 */
		}
    }
}
