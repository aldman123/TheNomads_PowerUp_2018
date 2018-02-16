package org.usfirst.frc.team5630.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;

/*
 * Modified by Alexander Aldridge
 *  of Team 5630 for the 2018 FRC Season
 */

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//PWM Inputs
	final public static int intakeMotorRight = 0;
	final public static int intakeMotorLeft = 1;
	
	final public static int liftMotorLeft = 2;
	final public static int liftMotorRight = 3;
	
	//SRX Inputs
	final public static int leftMotorA = 1;
	final public static int leftMotorB = 2;
	final public static int rightMotorA = 3;
	final public static int rightMotorB = 4;
<<<<<<< HEAD
	final public static int climberArm = 5;
	final public static int winchA = 6;
	final public static int winchB = 7;
=======
>>>>>>> origin/LiftSubsystem
	
	//Joystick Inputs
	final public static int joystickDriver = 0;
	final public static int joystickOperator = 1;
	
	//Analog Inputs
	final public static int colorSensor = 0;
	
	//TODO: Test this out on the real field
	final public static double colorSensorThreshhold = 3;	//Carpet should read more than this
															//and lines should read less
	
	//Digital Outputs
	final public static DigitalOutput ultrasonicOut = new DigitalOutput(1); //Output must be higher than input
	
	//Digital Inputs
	final public static DigitalInput ultrasonicIn = new DigitalInput(0);
	
	//Robot Speeds (Percent Power)
	final public static double speedFast = 0.7;
	final public static double speedMedium = 0.5;
	final public static double speedSlow = 0.25;
	final public static double speedSuperSlow = 0.15;
	final public static double climbingSpeed = 0.5;

	
	//Measurements
	final public static double robotLength = 33 / 12;	//In feet = 2.75
	final public static double robotWidth = 32 / 12;	//In feet = 2.66
	
	/**
	 * At the competition, we will trial and error this number, until the robot drives
	 * exactly eight feet. This will allow us to have precise measurements in autonomous.
	 */
	final public static double eightFeet = 3.14159268;
	final public static double feet = eightFeet / 4;
	
	
	
	
	
}
