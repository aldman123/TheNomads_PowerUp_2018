package org.usfirst.frc.team5630.robot;

import org.usfirst.frc.team5630.robot.commands.LiftTeleop;
import org.usfirst.frc.team5630.robot.commands.TurnWinch;
import org.usfirst.frc.team5630.robot.commands.InTake;
import org.usfirst.frc.team5630.robot.commands.OutTake;

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
	Button	button1Driver = new JoystickButton(stickDriver, 1),
			button2Driver = new JoystickButton(stickDriver, 2),
			button3Driver = new JoystickButton(stickDriver, 3),
			button4Driver = new JoystickButton(stickDriver, 4),
			button5Driver = new JoystickButton(stickDriver, 5),
			button6Driver = new JoystickButton(stickDriver, 6),
			button7Driver = new JoystickButton(stickDriver, 7),
			button8Driver = new JoystickButton(stickDriver, 8),
			button1Opperator = new JoystickButton(stickDriver, 1),
			button2Opperator = new JoystickButton(stickDriver, 2),
			button3Opperator = new JoystickButton(stickDriver, 3),
			button4Opperator = new JoystickButton(stickDriver, 4),
			button5Opperator = new JoystickButton(stickDriver, 5),
			button6Opperator = new JoystickButton(stickDriver, 6),
			button7Opperator = new JoystickButton(stickDriver, 7),
			button8Opperator = new JoystickButton(stickDriver, 8);
	
	public OI() {
		button8Opperator.whileHeld(new TurnWinch());		//Start button

		button2Opperator.whileHeld(new InTake());			//B Button
		button1Opperator.whileHeld(new OutTake());			//A Button
		
		button5Opperator.whenPressed(new LiftTeleop(-1));	//Left bumper
		button6Opperator.whenPressed(new LiftTeleop(1));	//Right bumper
	}
	
	public Joystick getJoystickOpperator() {
		return stickOpperator;
	}
	
	public Joystick getJoystickDriver() {
		return stickDriver;
	}
}
