
package org.usfirst.frc.team5630.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5630.robot.commands.*;
import org.usfirst.frc.team5630.robot.subsystems.*;

/**
 * @author Alexander Aldridge and Caelan Kan
 * Created for the 2018 FIRST Robotics Season
 */

public class Robot extends IterativeRobot {

//	public static final DriveTrainTeleopSubsystem driveTrainTeleop = new DriveTrainTeleopSubsystem();
	public static NavXSubsystem navXSubsystem = new NavXSubsystem();
	public static DriveTrainSubsystem driveTrainSubsystem = new DriveTrainSubsystem();
	public static final ClimberSubsystem climberSubsystem = new ClimberSubsystem();
	public static final BrightnessSensorSubsystem colorSensorSubsystem = new BrightnessSensorSubsystem();
	public static final LiftSubsystem liftSubsystem = new LiftSubsystem();
	public static final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();

	public static final LimitSwitchSubsystem limitSwitchSubsystem = new LimitSwitchSubsystem();

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
		chooser.addDefault("Center Autonomous", new CenterAutonomous());
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

		// schedule the autonomous command (example)
		if (autonomousCommand != null) {
		} else {
			autonomousCommand = new CenterAutonomous();
		}
		autonomousCommand.start();
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
		Scheduler.getInstance().removeAll();
		Scheduler.getInstance().enable();
		driveTrainSubsystem.getPidController().disable();
		

		navXSubsystem.navXReset();
		Scheduler.getInstance().add(new TurnClimberArm());
		Scheduler.getInstance().add(new DriveRobot());
		oi.button8Opperator.whileHeld(new TurnWinch());		//Start button

		oi.button2Opperator.whileHeld(new InTake());			//B Button
		oi.button1Opperator.whileHeld(new OutTake());			//A Button
		
		oi.button5Opperator.whenPressed(new LiftTeleop(-1));	//Left bumper
		oi.button6Opperator.whenPressed(new LiftTeleop(1));	//Right bumper

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
