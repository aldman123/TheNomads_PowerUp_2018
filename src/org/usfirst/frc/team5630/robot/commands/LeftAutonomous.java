package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.RobotMap;

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
    		//Distance is in feet, and speed is in percent.
    		
    		//Go forwards past the auto line
    		addSequential(new AutoDrive(10, RobotMap.speedFast));
    		addSequential(new AutoDrive(2, RobotMap.speedMedium));
    		
    		//Turn right and then hit the wall
    		addSequential(new AutoTurn(-90));
    		addSequential(new AutoDrive(1.5, RobotMap.speedSuperSlow)); //TODO fix this guessed value
    		//TODO Place Cube
    		
    		
    		
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
			addSequential(new AutoDrive(2, RobotMap.speedSuperSlow));	//TODO fix this guessed value
			
			//Place cube
		}
    }
}
