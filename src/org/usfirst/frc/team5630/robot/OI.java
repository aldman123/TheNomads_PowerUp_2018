package org.usfirst.frc.team5630.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


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
	Joystick stickOpperator = new Joystick(1);
	
	//TODO Get rid of most of these
	public Button
			buttonADriver = new JoystickButton(stickDriver, 1),
			buttonBDriver = new JoystickButton(stickDriver, 2),
			buttonXDriver = new JoystickButton(stickDriver, 3),
			buttonYDriver = new JoystickButton(stickDriver, 4),
			leftBumperDriver = new JoystickButton(stickDriver, 5),
			rightBumperDriver = new JoystickButton(stickDriver, 6),
			selectDriver = new JoystickButton(stickDriver, 7),
			startDriver = new JoystickButton(stickDriver, 8),
			buttonAOpperator = new JoystickButton(stickOpperator, 1),
			buttonBOpperator = new JoystickButton(stickOpperator, 2),
			buttonXOpperator = new JoystickButton(stickOpperator, 3),
			buttonYOpperator = new JoystickButton(stickOpperator, 4),
			leftBumperOpperator = new JoystickButton(stickOpperator, 5),
			rightBumperOpperator = new JoystickButton(stickOpperator, 6),
			selectOpperator = new JoystickButton(stickOpperator, 7),
			startOpperator = new JoystickButton(stickOpperator, 8);
	
	public Joystick getJoystickOpperator() {
		return stickOpperator;
	}
	
	public Joystick getJoystickDriver() {
		return stickDriver;
	}
	
	public int getOpperatorPOV() {
		return stickOpperator.getPOV();
	}
	
	public int getDriverPOV() {
		return stickDriver.getPOV();
	}
}
