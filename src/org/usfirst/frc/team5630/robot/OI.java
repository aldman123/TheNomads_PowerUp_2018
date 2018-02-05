package org.usfirst.frc.team5630.robot;

import edu.wpi.first.wpilibj.Joystick;


/*
 * Modified by Alexander Aldridge
 *  of Team 5630 for the 2018 FRC Season
 */


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	Joystick stickDriver = new Joystick(0);
	Joystick stickOperator = new Joystick(1);
	
	double liftDirection;
	
	public OI() {
		
	}
	
	
	
	/*
	 * Is called in teleop before the scheduler runs commands
	 */
	public void teleop() {
		
		//Intake Arm
		if (stickOperator.getRawButton(5) && !stickOperator.getRawButton(4)) {
			//Intake pulls cube in
		} else if (!stickOperator.getRawButton(5) && stickOperator.getRawButton(4)) {
			//Intake pushes cube out
		} else {
			//Intake stops
		}
		
		
		//Intake lift
		liftDirection = stickOperator.getRawAxis(2) - stickOperator.getRawAxis(3); //Compares values of triggers
		
		
	}
	
	public Joystick getJoystickDriver() {
		return stickDriver;
	}
	
	public Joystick getJoystickOperator() {
		return stickOperator;
	}
	
	
}
