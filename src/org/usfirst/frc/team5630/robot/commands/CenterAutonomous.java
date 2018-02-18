package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Alexander Aldridge
 * The autonomous command group that we use when
 * the robot is placed in the center.
 */
public class CenterAutonomous extends CommandGroup {

	public CenterAutonomous() {
	}
	
	public void start() {
		if ((DriverStation.getInstance().getGameSpecificMessage()).charAt(0) == 'L') {

			/* 
			 * Distance is in feet, and speed is in percent.
			 * AutoLine is 10 feet away from Alliance Station
			 * Switch is 14 feet away
			 */
			addSequential(new AutoDrive(12 - RobotMap.robotLength, RobotMap.speedMedium)); 
			//DO NOT PLACE THE CUBE
		}
		else {

			//Distance is in feet, and speed is in percent.
			//AutoLine is 10 feet away from Alliance Station
			//Switch is 14 feet away
			addSequential(new AutoDrive(10, RobotMap.speedMedium)); 
			addSequential(new AutoDrive(4 - RobotMap.robotLength, RobotMap.speedSuperSlow)); //Allocates for robot size
			addSequential(new AutoPlaceBlock());
		}
		
		super.start();
	}
}
