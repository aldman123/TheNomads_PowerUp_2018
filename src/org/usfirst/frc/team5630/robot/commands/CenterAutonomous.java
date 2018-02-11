package org.usfirst.frc.team5630.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterAutonomous extends CommandGroup {

    public CenterAutonomous() {
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
			 * Go forwards a little 
			 * Turn to the left 90 degrees
			 * Go forwards some more
			 * Place the cube
			 */
    		
    		//Values were guessed.
    		addSequential(new AutoDrive(1.5, 0.5));
    		addSequential(new AutoTurn(90));
    		addSequential(new AutoDrive(1.5, 0.3));
    	}
    	else {
    		/* 
			 * Go forwards a little 
			 * Turn to the right 90 degrees
			 * Go forwards some more
			 * Place the cube
			 */
    		
    		//Values were guessed.
    		addSequential(new AutoDrive(1.5, 0.5));
    		addSequential(new AutoTurn(-90));
    		addSequential(new AutoDrive(1.5, 0.3));
    	}
    }
}
