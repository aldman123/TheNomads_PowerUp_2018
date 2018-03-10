package org.usfirst.frc.team5630.robot.commands;

import org.usfirst.frc.team5630.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BaselineAuto extends CommandGroup {

    public BaselineAuto() {
        addSequential(new AutoDrive(8, RobotMap.speedSuperSlow));
        System.out.println(RobotMap.eightFeet);
    }
}
