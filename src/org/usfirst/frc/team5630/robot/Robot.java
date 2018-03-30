
package org.usfirst.frc.team5630.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5630.robot.commandGroups.*;
import org.usfirst.frc.team5630.robot.commands.*;
import org.usfirst.frc.team5630.robot.subsystems.*;

/**
 * @author Alexander Aldridge and Caelan Kan
 * Created for the 2018 FIRST Robotics Season
 */

public class Robot extends IterativeRobot {

	public final static NavXSubsystem navXSubsystem = new NavXSubsystem(); //NavX goes first
	public final static BrightnessSensorSubsystem colorSensorSubsystem = new BrightnessSensorSubsystem();
	public final static LimitSwitchSubsystem limitSwitchSubsystem = new LimitSwitchSubsystem();
	public final static UltrasonicSubsystem ultrasonicSubsystem = new UltrasonicSubsystem();
	
	public final static DriveTrainSubsystem driveTrainSubsystem = new DriveTrainSubsystem();
	public final static ClimberArmSubsystem climberSubsystem = new ClimberArmSubsystem();
	public final static WinchSubsystem winchSubsystem = new WinchSubsystem();
	public final static LiftSubsystem liftSubsystem = new LiftSubsystem();
	public final static IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
	
	public static OI oi = new OI();

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	Joystick stickDriver, stickOperator;

	double robot_ySpeed,robot_xSpeed; // Make a change to this (switched values)

	long startTime;
	String gameData, autonomousSection;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		CameraServer.getInstance().startAutomaticCapture();
		chooser.addObject("RightAutonomous", new RightAutonomous());
		chooser.addObject("LeftAutonomous", new LeftAutonomous());
		chooser.addDefault("Center Autonomous", new CenterAutonomous());
		chooser.addObject("Right Simple", new RightAutoSimple());
		chooser.addObject("Left Simple", new LeftAutoSimple());
		chooser.addDefault("BackUp", new CrossAutoLine());
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
		
		driveTrainSubsystem.setAutoMode(true);
		
		autonomousSection = "Init";
		
		navXSubsystem.navXResetAngle();
		
		startTime = System.currentTimeMillis();
		
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler shcd = Scheduler.getInstance();
		Scheduler.getInstance().run();
		SmartDashboard.putString("Autonomous Section", autonomousSection);
//		double time = System.currentTimeMillis();
//		if (time - startTime <= 5000) {
//			driveTrainSubsystem.teleopDrive(0.6, 0);
//		} else {
//			driveTrainSubsystem.teleopDrive(0, 0);
//		}
		
		
    	

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
		

		driveTrainSubsystem.setAutoMode(false);
		
		//Scheduler.getInstance().add(new RaiseClimber());
		Scheduler.getInstance().add(new DriveRobot());
		//oi.startOpperator.whileHeld(new TurnWinch());
		
		oi.buttonADriver.whenReleased(new swapDriveDirection());
		
		oi.buttonBOpperator.whileHeld(new InTake());
		oi.buttonAOpperator.whileHeld(new OutTake());
		
		oi.leftBumperOpperator.whenPressed(new LiftTeleop(-1));
		oi.rightBumperOpperator.whenPressed(new LiftTeleop(1));
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		limitSwitchSubsystem.debug();
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		
	}
	
	public void setAutonomousSection(String section) {
		autonomousSection = section;
	}
	
}
