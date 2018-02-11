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
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	//PWM Inputs
	final public static int intakeMotorRight = 0;
	final public static int intakeMotorLeft = 1;
	
	//SRX Inputs
	final public static int leftMotorA = 1;
	final public static int leftMotorB = 2;
	final public static int rightMotorA = 3;
	final public static int rightMotorB = 4;
	
	
	//Joystick Inputs
	final public static int joystickDriver = 0;
	final public static int joystickOperator = 1;
	
	//Analog Inputs
	final public static int colorSensor = 0;
	
	final public static double colorSensorThreshhold = 3;	//Carpet should read more than this
															//and lines should read less
	
	//Digital Outputs
	final public static DigitalOutput ultrasonicOut = new DigitalOutput(0);
	
	//Digital Inputs
	final public static DigitalInput ultrasonicIn = new DigitalInput(1);
	
	
}
