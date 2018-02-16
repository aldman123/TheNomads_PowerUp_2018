
package org.usfirst.frc.team5630.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5630.robot.commands.CenterAutonomous;
import org.usfirst.frc.team5630.robot.commands.DriveRobot;
import org.usfirst.frc.team5630.robot.commands.LeftAutonomous;
import org.usfirst.frc.team5630.robot.commands.TurnClimberArm;
import org.usfirst.frc.team5630.robot.commands.RightAutonomous;
import org.usfirst.frc.team5630.robot.subsystems.ClimberSubsystem;
import org.usfirst.frc.team5630.robot.subsystems.DriveTrainAutoSubsystem;
import org.usfirst.frc.team5630.robot.subsystems.DriveTrainTeleopSubsystem;
import org.usfirst.frc.team5630.robot.subsystems.NavXSubsystem;
import org.usfirst.frc.team5630.robot.subsystems.UltrasonicSubsystem;
import org.usfirst.frc.team5630.robot.subsystems.BrightnessSensorSubsystem;


/**
 * @author Alexander Aldridge and Caelan Kan
 * Created for the 2018 FIRST Robotics Season
 */

public class Robot extends IterativeRobot {

	public static final DriveTrainTeleopSubsystem driveTrainTeleop = new DriveTrainTeleopSubsystem();
	public static final DriveTrainAutoSubsystem driveTrainAuto = new DriveTrainAutoSubsystem();
	public static final ClimberSubsystem climberSubsystem = new ClimberSubsystem();
	public static final NavXSubsystem navXSubsystem = new NavXSubsystem();
	public static final BrightnessSensorSubsystem colorSensorSubsystem = new BrightnessSensorSubsystem();
	public static final UltrasonicSubsystem ultrasonicSubsystem = new UltrasonicSubsystem();
	public static OI oi;

	Command autonomousCommand;
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
		chooser.addObject("RightAutonomous", new RightAutonomous());
		chooser.addObject("LeftAutonomous", new LeftAutonomous());
		chooser.addObject("Center Autonomous", new CenterAutonomous());
		SmartDashboard.putData("Auto Selector", chooser);
		
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
		//TODO: actually figure the fuck out how we're choosing autonomous
		autonomousCommand = chooser.getSelected();
		
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "Right Side":
			Scheduler.getInstance().add(new RightAutonomous());
		 	break;
		 	
		case "Center Side": default:
			break;
			
		case "Left Side":
			Scheduler.getInstance().add(new LeftAutonomous());
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
		autonomousCommand.cancel();
		
		navXSubsystem.navXReset();
		Scheduler.getInstance().add(new TurnClimberArm());
		Scheduler.getInstance().add(new DriveRobot());
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		

		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
	}
}
