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
 * the robot is placed on the right.
 */
public class RightAutonomous extends CommandGroup {
	
	char gameData;
    public RightAutonomous() {
    }
    
    public void start() {
    	while (DriverStation.getInstance().getGameSpecificMessage().length() < 1){
    		SmartDashboard.putString("Game Data Status", "NO DATA");
    	}
    	gameData = DriverStation.getInstance().getGameSpecificMessage().charAt(0);
    	SmartDashboard.putString("Game Data Satus", gameData + "");
    	if (gameData == 'R') {
    		//Distance is in feet, and speed is in percent.
    		//Go forwards past the auto line
    		addSequential(new AutoDrive(10, RobotMap.speedFast));
    		addSequential(new AutoDrive(4, RobotMap.speedMedium));
    		
    		//Turn right and then hit the wall
    		addSequential(new AutoTurn(90));
    		
    		addSequential(new AutoDrive(2, RobotMap.speedSlow)); //TODO fix this guessed value
    		//addSequential(new AutoPlaceBlock());
    		
		} else {
			//Distance is in feet, and speed is in percent.
			//Go forward until you hit the white line (24 feet)
			addSequential(new AutoDrive(15, RobotMap.speedFast));
			addSequential(new AutoDrive_UntilColor(10, RobotMap.speedMedium));
			
			//Reverse and then turn right
			addSequential(new AutoDrive(-4, RobotMap.speedMedium));
			addSequential(new AutoTurn(90));
			
			//Go past two red/blue lines
			addSequential(new AutoDrive_UntilColor(5, RobotMap.speedFast));
			addSequential(new AutoDrive(1, RobotMap.speedMedium));
			addSequential(new AutoDrive_UntilColor(11, RobotMap.speedMedium));
			
			//Go Forwards, Turn, and Go Forwards a little
			addSequential(new AutoDrive(4, RobotMap.speedMedium));
			addSequential(new AutoTurn(90));
			addSequential(new AutoDrive(5, RobotMap.speedSlow));
			
			//Turn and then hit the wall
			addSequential(new AutoTurn(90));
			//addSequential(new AutoDrive(2, RobotMap.speedSuperSlow));	//TODO fix this guessed value
			addSequential(new AutoDrive(3, RobotMap.speedMedium));
			//addSequential(new AutoPlaceBlock());
		}
    	super.start();
    }
}
