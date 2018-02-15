package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.RobotMap;

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
    		
    		//Distance is in feet, and speed is in percent.
    		//AutoLine is 10 feet away from Alliance Station
    		//Switch is 14 feet away
    		addSequential(new AutoDrive(10, RobotMap.speedMedium)); 
    		//DO NOT PLACE THE CUBE
    	}
    	else {

    		//Distance is in feet, and speed is in percent.
    		//AutoLine is 10 feet away from Alliance Station
    		//Switch is 14 feet away
    		addSequential(new AutoDrive(10, RobotMap.speedMedium)); 
    		addSequential(new AutoDrive(4 - RobotMap.robotLength, RobotMap.speedSuperSlow)); //Allocates for robot size
    		//TODO Place the cube
    	}
    }
}
