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
	
	
	
	//SRX Inputs
	final public static int leftMotorA = 1;
	final public static int leftMotorB = 2;
	final public static int rightMotorA = 11;
	final public static int rightMotorB = 10;
	
	final public static int climberArm = 3;
	final public static int winchA = 4;
	final public static int winchB = 5;
	
	final public static int intakeMotorRight = 8;
	final public static int intakeMotorLeft = 9;
	
	final public static int liftMotorLeft = 6;
	final public static int liftMotorRight = 7;
	
	//Joystick Inputs
	final public static int joystickDriver = 0;
	final public static int joystickOperator = 1;
	final public static int raiseArmAxis = 3;	//Right trigger
	final public static int lowerArmAxis = 2;	//Left trigger
	
	//Analog Inputs
	final public static int colorSensorA = 5;//right
	final public static int colorSensorB = 6;//left
	final public static int limitSwitchTopLift = 7;
	final public static int limitSwitchBottomLift = 4;
	final public static int limitSwitchTopClimber = 1;//Not done
	final public static int limitSwitchBottomClimber = 2;//Not done
	
	//TODO: Test this out on the real field
	final public static double colorSensorThreshhold = 3;	//Carpet should read more than this
															//and lines should read less
	
	//Digital Outputs
	final public static DigitalOutput ultrasonicOut = new DigitalOutput(1); //Output must be higher than input
	
	//Digital Inputs
	final public static DigitalInput ultrasonicIn = new DigitalInput(0);
	
	//Robot Speeds (Percent Power)
	final public static double speedFast = 0.85;
	final public static double speedMedium = 0.70;
	final public static double speedSlow = 0.55;
	final public static double speedSuperSlow = 0.40;
	final public static double climbingSpeed = 0.50;
	final public static double liftSpeed = 0.25;
	final public static double intakeSpeed = 0.8;

	
	//Measurements
	final public static double robotLength = 35.5 / 12;	//In feet
	final public static double robotWidth = 34 / 12;	//In feet
	final public static double outTakeTime = 3;			//In seconds
	
	//Encoder Inputs. TODO fix these ASAP
	final public static int encoderLeft = 0;
	final public static int encoderRight = 2;
	
	
	/**
	 * At the competition, we will trial and error this number, until the robot drives
	 * exactly eight feet. This will allow us to have precise measurements in autonomous.
	 */
	
	//Partially calculated in cimcoder subsystem
	//This is for the last little bit of accuracy
	final private static double eightFeet = 8;
	final public static double feet = eightFeet / 8;
	
	
	
	
	
}
