package org.usfirst.frc.team5630.robot.commandGroups;

import org.usfirst.frc.team5630.robot.RobotMap;
import org.usfirst.frc.team5630.robot.commands.AutoDrive;
import org.usfirst.frc.team5630.robot.commands.AutoDrive_UntilColor;
import org.usfirst.frc.team5630.robot.commands.AutoTurn;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * @author Alexander Aldridge
 * The autonomous command group that we use when
 * the robot is placed on the left.
 */
public class LeftAutoSimple extends CommandGroup {
	
	char gameData;
	
    public LeftAutoSimple() {
    }
    
    public void start() {
    	//Distance is in feet, and speed is in percent.
    	
    	while (DriverStation.getInstance().getGameSpecificMessage().length() < 1){
    		SmartDashboard.putString("Game Data Status", "NO DATA");
    	}
    	gameData = DriverStation.getInstance().getGameSpecificMessage().charAt(0);
    	SmartDashboard.putString("Game Data Satus", gameData + "");
    	
    	//Go forwards past the auto line
    	addSequential(new AutoDrive(10, RobotMap.speedFast));
    	addSequential(new AutoDrive(4 - RobotMap.robotLength, RobotMap.speedMedium));
    	
    	//Turn right and then hit the wall
    	addSequential(new AutoTurn(-90));
    	addSequential(new AutoDrive(2, RobotMap.speedSlow)); //TODO fix this guessed value
    	addSequential(new AutoPlaceBlock());
    	if (gameData == 'L') {
    		addSequential(new AutoPlaceBlock());
    	}
    }
}
