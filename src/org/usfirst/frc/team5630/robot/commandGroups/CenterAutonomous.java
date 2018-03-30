package org.usfirst.frc.team5630.robot.commandGroups;

import org.usfirst.frc.team5630.robot.RobotMap;
import org.usfirst.frc.team5630.robot.commands.AutoDrive;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Alexander Aldridge
 * The autonomous command group that we use when
 * the robot is placed in the center.
 */
public class CenterAutonomous extends CommandGroup {
	
	char gameData;
	public CenterAutonomous() {
	}
	public void start() {
		
//		while (DriverStation.getInstance().getGameSpecificMessage().length() < 1){
//    		SmartDashboard.putString("Game Data Status", "NO DATA");
//    	}
//    	gameData = DriverStation.getInstance().getGameSpecificMessage().charAt(0);
//    	SmartDashboard.putString("Game Data Satus", gameData + "");
		
		//if (gameData == 'L') {

			/* 
			 * Distance is in feet, and speed is in percent.
			 * AutoLine is 10 feet away from Alliance Station
			 * Switch is 14 feet away
			 */
			
			addSequential(new AutoDrive(14 - RobotMap.robotLength, RobotMap.speedMedium)); 
			//DO NOT PLACE THE CUBE
		//} else {

			//Distance is in feet, and speed is in percent.
			//AutoLine is 10 feet away from Alliance Station
			//Switch is 14 feet away
			//addSequential(new AutoDrive(10, RobotMap.speedMedium)); 
			//addSequential(new AutoDrive(4 - RobotMap.robotLength, RobotMap.speedSlow)); //Allocates for robot size
			//addSequential(new AutoPlaceBlock());
		//}
	}
}
