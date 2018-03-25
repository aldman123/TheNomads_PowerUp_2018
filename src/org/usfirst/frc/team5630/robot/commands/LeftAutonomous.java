package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Alexander Aldridge
 * The autonomous command group that we use when
 * the robot is placed on the left.
 */
public class LeftAutonomous extends CommandGroup {

    public LeftAutonomous() {
    }
    
    public void start() {
    	if ((DriverStation.getInstance().getGameSpecificMessage()).charAt(0) == 'L') {
    		//Distance is in feet, and speed is in percent.
    		
    		//Go forwards past the auto line
    		addSequential(new AutoDrive(10, RobotMap.speedFast));
    		addSequential(new AutoDrive(2, RobotMap.speedMedium));
    		
    		//Turn right and then hit the wall
    		addSequential(new AutoTurn(-90));
    		//addSequential(new AutoDrive(1.5, RobotMap.speedSuperSlow)); //TODO fix this guessed value
    		addSequential(new AutoPlaceBlock());
    		
		} else {
			//Distance is in feet, and speed is in percent.
			//Go forward until you hit the white line (24 feet)
			addSequential(new AutoDrive(15, RobotMap.speedFast));
			addSequential(new AutoDrive_UntilColor(11, RobotMap.speedSlow));
			
			//Reverse and then turn right
			addSequential(new AutoDrive(-3, RobotMap.speedMedium));
			addSequential(new AutoTurn(-90));
			
			//Go past two red/blue lines
			addSequential(new AutoDrive_UntilColor(16, RobotMap.speedFast));
			addSequential(new AutoDrive(1, 0.5));
			addSequential(new AutoDrive_UntilColor(14, RobotMap.speedMedium));
			
			//Go Forwards, Turn, and Go Forwards a little
			addSequential(new AutoDrive(2, RobotMap.speedMedium));
			addSequential(new AutoTurn(-90));
			addSequential(new AutoDrive(4, RobotMap.speedSlow));
			
			//Turn and then hit the wall
			addSequential(new AutoTurn(-90));
			//addSequential(new AutoDrive(2, RobotMap.speedSuperSlow));	//TODO fix this guessed value
			
			addSequential(new AutoPlaceBlock());
		}
    }
}
