package org.usfirst.frc.team4028.robot.constants;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class RobotMap 
{
	// ======================================
	// Driver's station
	// ======================================
	public static final int DRIVER_GAMEPAD_USB_PORT = 0;
	public static final int OPERATOR_GAMEPAD_USB_PORT = 1;
	
	// ======================================
	// Constants for CAN Bus Addresses
	// ======================================
	
	// define constant for PCM (Pneumatic Control Module)
	public static final int PCM_CAN_ADDR = 0;				
	
	// define constant for PDP (Power Distribution Panel) CAN Bus Address
	//public static final int PDB_CAN_ADDR = 3; 
	
	// define constants for Talon SRX CAN Bus Addresses
	public static final int DC_MOTOR_1_CAN_ADDR = 53;
	public static final int DC_MOTOR_2_CAN_ADDR = 62;
	public static final int DC_MOTOR_3_CAN_ADDR = 50;
	public static final int DC_MOTOR_4_CAN_ADDR = 55;
	public static final int DC_MOTOR_5_CAN_ADDR = 61;
	public static final int DC_MOTOR_6_CAN_ADDR = 60;
	
	// Velocity Closed-Loop Walkthrough - Java  Section 12.4, Rev 1.21 Talon Software Reference Manual
	//	I used the documented procedure to calc an initial F Gain value, they refined via experimentation 
	public static final double DC_MOTOR_1_PID_F_GAIN = 0.0348;
	public static final double DC_MOTOR_1_PID_P_GAIN  = 0.11333; //0.22);
	public static final double DC_MOTOR_1_PID_I_GAIN  = 0.0; 
	public static final double DC_MOTOR_1_PID_D_GAIN  = 0.0;
	
	public static final double DC_MOTOR_2_PID_F_GAIN  = 0.0405;
	public static final double DC_MOTOR_2_PID_P_GAIN  = 0.425; //1.0;//0.87328; //0.73995;//0.60662;//0.47329; //0.33999; //0.22666; //0.11333; //0.22);
	public static final double DC_MOTOR_2_PID_I_GAIN  = 0.0; 
	public static final double DC_MOTOR_2_PID_D_GAIN  = 0.0;
	
	public static final double DC_MOTOR_X_PID_F_GAIN  = 0.0;
	public static final double DC_MOTOR_X_PID_P_GAIN = 0.0;
	public static final double DC_MOTOR_X_PID_I_GAIN = 0.0; 
	public static final double DC_MOTOR_X_PID_D_GAIN  = 0.0;
	
	// ======================================
	// define constants for PWM Ports on RobioRio
	// ======================================
	//public static final int AND1_SERVO_PWM_PORT = 1;
	
	// ======================================
	// define constants for DIO Ports on RoboRio
	// ======================================
	//public static final int TURRET_HOME_LIMIT_SWITCH_DIO_PORT = 0;

	// ======================================
	// define constants for usb cameras
	// ======================================
	//public static final String SHOOTER_CAMERA_NAME = "cam0";

	// ======================================
	// Define constants for solenoid ports on Pneumatic Control Module (PCM)
	// ======================================
	//public static final int PUMA_FRONT_SOLENOID_RETRACT_PCM_PORT = 2;
	
	// ======================================
	// Define constants for solenoid positions 
	// ======================================
	//public static final Value PUMA_FRONT_UP_POSITION = DoubleSolenoid.Value.kForward;
	//public static final Value PUMA_FRONT_DOWN_POSITION = DoubleSolenoid.Value.kReverse;		

	// ======================================
	// define constants for logging
	// ======================================
	// this is where the USB stick is mounted on the RoboRIO filesystem.  You can confirm by logging into the RoboRIO using WinSCP
	public static final String LOG_FILE_PATH = "/media/sda1/logging";

}
