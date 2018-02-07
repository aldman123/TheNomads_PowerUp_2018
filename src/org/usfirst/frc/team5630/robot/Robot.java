
package org.usfirst.frc.team5630.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5630.robot.commands.ExampleCommand;
import org.usfirst.frc.team5630.robot.subsystems.DriveTrain_Subsystem;
import org.usfirst.frc.team5630.robot.RobotMap;

/*
 * Modified by Alexander Aldridge
 *  of Team 5630 for the 2018 FRC Season
 */

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final DriveTrain_Subsystem driveTrainSubsystem = new DriveTrain_Subsystem();
	public static OI oi;

	Command autonomousCommand, driveRobot;
	SendableChooser<Command> chooser = new SendableChooser<>();
	
	Joystick stickDriver, stickOperator;
	
	double robot_xSpeed, robot_ySpeed;
	
	String gameData;
	
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		CameraServer.getInstance().startAutomaticCapture();
		oi = new OI();
		chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
		
		
		
		stickDriver = new Joystick(RobotMap.joystickDriver);
		stickOperator = new Joystick(RobotMap.joystickOperator);
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();
		
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "Right Side":
			//autonomousCommand = new DriveRobot();
			if (gameData.charAt(0) == 'R') {
				
				
				
				/* 
				 * Go forwards until you cross the auto line
				 * Go forwards some more
				 * Turn to the left 90 degrees
				 * Go forwards until you hit the wall
				 * Place the cube
				 */
			} else {
				/*
				 * Cross the auto line
				 * Go much further
				 * Turn 90 degrees left
				 * go forward past two red lines
				 * Turn 90 degrees left
				 * Go forwards a little
				 * Turn 90 degrees left
				 * Go forwards until you hit the wall
				 * Place cube
				 */
			}
		 	break;
		 	
		case "Center Side": default:
			//autonomousCommand = new DriveRobot();
			/*
			 * Go forwards until you hit the wall
			 * Place Cube
			 */
			break;
			
		case "Left Side":
			autonomousCommand = new ExampleCommand();
			if (gameData.charAt(0) == 'L') {
				/* 
				 * Go forwards until you cross the auto line
				 *  Go forwards some more
				 *  Turn to the right 90 degrees
				 *  Go forwards until you hit the wall
				 * Place the cube
				 */
			} else {
				/*
				 * Cross the auto line
				 * Go much further
				 * Turn 90 degrees right
				 * go forward past two red lines
				 * Turn 90 degrees right
				 * Go forwards a little
				 * Turn 90 degrees right
				 * Go forwards until you hit the wall
				 * Place cube
				 */
			}
			break;
		}

		// schedule the autonomous command (example)
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
		
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		
		
		
		Scheduler.getInstance().add(driveRobot);
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		oi.teleop();
		Scheduler.getInstance().run();
		

		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		//LiveWindow.run();   What the hell is this?
	}
}
