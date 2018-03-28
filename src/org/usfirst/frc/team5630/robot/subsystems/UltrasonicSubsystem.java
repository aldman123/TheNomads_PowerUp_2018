package org.usfirst.frc.team5630.robot.subsystems;

import java.nio.ByteBuffer;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *	Created by @author Alexander Aldridge
 *	For controlling the ultrasonic sensor
 */
public class UltrasonicSubsystem extends Subsystem {
	
	I2C ultrasonic = new I2C(I2C.Port.kOnboard, 6); //Device address is definetly 6 -Minh
	ByteBuffer input = ByteBuffer.allocate(32);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public int getDistance() {
		input.clear();
		int output;
		if (ultrasonic.readOnly(input, 8)) {
			output = input.getInt();
		} else {
			output = 0;
		}
		return output;
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

