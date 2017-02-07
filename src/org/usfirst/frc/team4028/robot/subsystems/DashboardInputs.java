package org.usfirst.frc.team4028.robot.subsystems;

import org.usfirst.frc.team4028.robot.constants.MotorConfigEnums.ANALOG_MODE_JOYSTICK;
import org.usfirst.frc.team4028.robot.constants.MotorConfigEnums.BRAKE_MODE;
import org.usfirst.frc.team4028.robot.constants.MotorConfigEnums.DIGITAL_LATCH_MODE;
import org.usfirst.frc.team4028.robot.constants.MotorConfigEnums.DIGITAL_MODE_BUTTON;
import org.usfirst.frc.team4028.robot.constants.MotorConfigEnums.MOTOR_DIRECTION;
import org.usfirst.frc.team4028.robot.constants.MotorConfigEnums.MOTOR_MAX_SPEED;
import org.usfirst.frc.team4028.robot.constants.MotorConfigEnums.MOTOR_MODE;
import org.usfirst.frc.team4028.robot.constants.MotorConfigEnums.MOTOR_CONSTANTV_TARGET;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class defines the behavior of the Dashboard Inputs
 * 	it encapsulates all interaction with the Inputs on the Dashboard
 *  Dashboard outputs are handled in the outputToSmartDashboard() method in each subsystem class
 */
public class DashboardInputs 
{
	// ===================================
	// define working & state variables
	// ===================================
	private TestMotorConfig _motor1Configuration;
	private TestMotorConfig _motor2Configuration;
	private TestMotorConfig _motor3Configuration;
	private TestMotorConfig _motor4Configuration;
	private TestMotorConfig _motor5Configuration;
	private TestMotorConfig _motor6Configuration;
	public DIGITAL_MODE_BUTTON _actuatorUpChoice;
	public DIGITAL_MODE_BUTTON _actuatorDownChoice;
	
	// ===================================
	// define Smart Dashboard choosers
	// ===================================
	private SendableChooser<MOTOR_MODE> _dcMotor1_Mode_Chooser;
	private SendableChooser<MOTOR_DIRECTION> _dcMotor1_Direction_Chooser;
	private SendableChooser<ANALOG_MODE_JOYSTICK> _dcMotor1_AnalogModeJoystickChooser;
	private SendableChooser<DIGITAL_MODE_BUTTON> _dcMotor1_DigitalModeButtonChooser;
	private SendableChooser<MOTOR_MAX_SPEED> _dcMotor1_MaxSpeedChooser;
	private SendableChooser<BRAKE_MODE> _dcMotor1_BrakeModeChooser;
	private SendableChooser<DIGITAL_LATCH_MODE> _dcMotor1_DigitalLatchModeChooser;
	private SendableChooser<MOTOR_CONSTANTV_TARGET> _dcMotor1_TargetRPMChooser;
	
	private SendableChooser<MOTOR_MODE> _dcMotor2_Mode_Chooser;
	private SendableChooser<MOTOR_DIRECTION> _dcMotor2_Direction_Chooser;
	private SendableChooser<ANALOG_MODE_JOYSTICK> _dcMotor2_AnalogModeJoystickChooser;
	private SendableChooser<DIGITAL_MODE_BUTTON> _dcMotor2_DigitalModeButtonChooser;
	private SendableChooser<MOTOR_MAX_SPEED> _dcMotor2_MaxSpeedChooser;
	private SendableChooser<BRAKE_MODE> _dcMotor2_BrakeModeChooser;
	private SendableChooser<DIGITAL_LATCH_MODE> _dcMotor2_DigitalLatchModeChooser;
	private SendableChooser<MOTOR_CONSTANTV_TARGET> _dcMotor2_TargetRPMChooser;
	
	private SendableChooser<MOTOR_MODE> _dcMotor3_Mode_Chooser;
	private SendableChooser<MOTOR_DIRECTION> _dcMotor3_Direction_Chooser;
	private SendableChooser<ANALOG_MODE_JOYSTICK> _dcMotor3_AnalogModeJoystickChooser;
	private SendableChooser<DIGITAL_MODE_BUTTON> _dcMotor3_DigitalModeButtonChooser;
	private SendableChooser<MOTOR_MAX_SPEED> _dcMotor3_MaxSpeedChooser;
	private SendableChooser<BRAKE_MODE> _dcMotor3_BrakeModeChooser;
	private SendableChooser<DIGITAL_LATCH_MODE> _dcMotor3_DigitalLatchModeChooser;
	private SendableChooser<MOTOR_CONSTANTV_TARGET> _dcMotor3_TargetRPMChooser;
	
	private SendableChooser<MOTOR_MODE> _dcMotor4_Mode_Chooser;
	private SendableChooser<MOTOR_DIRECTION> _dcMotor4_Direction_Chooser;
	private SendableChooser<ANALOG_MODE_JOYSTICK> _dcMotor4_AnalogModeJoystickChooser;
	private SendableChooser<DIGITAL_MODE_BUTTON> _dcMotor4_DigitalModeButtonChooser;
	private SendableChooser<MOTOR_MAX_SPEED> _dcMotor4_MaxSpeedChooser;
	private SendableChooser<BRAKE_MODE> _dcMotor4_BrakeModeChooser;
	private SendableChooser<DIGITAL_LATCH_MODE> _dcMotor4_DigitalLatchModeChooser;
	private SendableChooser<MOTOR_CONSTANTV_TARGET> _dcMotor4_TargetRPMChooser;
	
	private SendableChooser<MOTOR_MODE> _dcMotor5_Mode_Chooser;
	private SendableChooser<MOTOR_DIRECTION> _dcMotor5_Direction_Chooser;
	private SendableChooser<ANALOG_MODE_JOYSTICK> _dcMotor5_AnalogModeJoystickChooser;
	private SendableChooser<DIGITAL_MODE_BUTTON> _dcMotor5_DigitalModeButtonChooser;
	private SendableChooser<MOTOR_MAX_SPEED> _dcMotor5_MaxSpeedChooser;
	private SendableChooser<BRAKE_MODE> _dcMotor5_BrakeModeChooser;
	private SendableChooser<DIGITAL_LATCH_MODE> _dcMotor5_DigitalLatchModeChooser;
	private SendableChooser<MOTOR_CONSTANTV_TARGET> _dcMotor5_TargetRPMChooser;
	
	private SendableChooser<MOTOR_MODE> _dcMotor6_Mode_Chooser;
	private SendableChooser<MOTOR_DIRECTION> _dcMotor6_Direction_Chooser;
	private SendableChooser<ANALOG_MODE_JOYSTICK> _dcMotor6_AnalogModeJoystickChooser;
	private SendableChooser<DIGITAL_MODE_BUTTON> _dcMotor6_DigitalModeButtonChooser;
	private SendableChooser<MOTOR_MAX_SPEED> _dcMotor6_MaxSpeedChooser;
	private SendableChooser<BRAKE_MODE> _dcMotor6_BrakeModeChooser;
	private SendableChooser<DIGITAL_LATCH_MODE> _dcMotor6_DigitalLatchModeChooser;
	private SendableChooser<MOTOR_CONSTANTV_TARGET> _dcMotor6_TargetRPMChooser;
	
	private SendableChooser<DIGITAL_MODE_BUTTON> _actuatorUpBtnChooser;
	private SendableChooser<DIGITAL_MODE_BUTTON> _actuatorDownBtnChooser;
	
	// Config all the Dashboard Choosers
	public DashboardInputs()
	{
        System.out.println("..Choosers Start Config!");
        
        TestMotorSendableChoosers choosers = ConfigDashboardInput("1");
        _dcMotor1_Mode_Chooser = choosers.DcMotorX_Mode_Chooser; 
        _dcMotor1_Direction_Chooser = choosers.DcMotorX_Direction_Chooser; 
        _dcMotor1_AnalogModeJoystickChooser = choosers.DcMotorX_AnalogModeJoystickChooser; 
        _dcMotor1_DigitalModeButtonChooser = choosers.DcMotorX_DigitalModeButtonChooser; 
        _dcMotor1_MaxSpeedChooser = choosers.DcMotorX_MaxSpeedChooser; 
        _dcMotor1_BrakeModeChooser = choosers.DcMotorX_BrakeModeChooser; 
        _dcMotor1_DigitalLatchModeChooser = choosers.DcMotorX_DigitalLatchModeChooser; 
        _dcMotor1_TargetRPMChooser = choosers.DcMotorX_TargetRPMChooser; 
        
        choosers = ConfigDashboardInput("2");
        _dcMotor2_Mode_Chooser = choosers.DcMotorX_Mode_Chooser; 
        _dcMotor2_Direction_Chooser = choosers.DcMotorX_Direction_Chooser; 
        _dcMotor2_AnalogModeJoystickChooser = choosers.DcMotorX_AnalogModeJoystickChooser; 
        _dcMotor2_DigitalModeButtonChooser = choosers.DcMotorX_DigitalModeButtonChooser; 
        _dcMotor2_MaxSpeedChooser = choosers.DcMotorX_MaxSpeedChooser; 
        _dcMotor2_BrakeModeChooser = choosers.DcMotorX_BrakeModeChooser; 
        _dcMotor2_DigitalLatchModeChooser = choosers.DcMotorX_DigitalLatchModeChooser;
        _dcMotor2_TargetRPMChooser = choosers.DcMotorX_TargetRPMChooser; 
		
        choosers = ConfigDashboardInput("3");
        _dcMotor3_Mode_Chooser = choosers.DcMotorX_Mode_Chooser; 
        _dcMotor3_Direction_Chooser = choosers.DcMotorX_Direction_Chooser; 
        _dcMotor3_AnalogModeJoystickChooser = choosers.DcMotorX_AnalogModeJoystickChooser; 
        _dcMotor3_DigitalModeButtonChooser = choosers.DcMotorX_DigitalModeButtonChooser; 
        _dcMotor3_MaxSpeedChooser = choosers.DcMotorX_MaxSpeedChooser; 
        _dcMotor3_BrakeModeChooser = choosers.DcMotorX_BrakeModeChooser; 
        _dcMotor3_DigitalLatchModeChooser = choosers.DcMotorX_DigitalLatchModeChooser; 
        _dcMotor3_TargetRPMChooser = choosers.DcMotorX_TargetRPMChooser; 
        
        choosers = ConfigDashboardInput("4");
        _dcMotor4_Mode_Chooser = choosers.DcMotorX_Mode_Chooser; 
        _dcMotor4_Direction_Chooser = choosers.DcMotorX_Direction_Chooser; 
        _dcMotor4_AnalogModeJoystickChooser = choosers.DcMotorX_AnalogModeJoystickChooser; 
        _dcMotor4_DigitalModeButtonChooser = choosers.DcMotorX_DigitalModeButtonChooser; 
        _dcMotor4_MaxSpeedChooser = choosers.DcMotorX_MaxSpeedChooser; 
        _dcMotor4_BrakeModeChooser = choosers.DcMotorX_BrakeModeChooser; 
        _dcMotor4_DigitalLatchModeChooser = choosers.DcMotorX_DigitalLatchModeChooser; 
        _dcMotor4_TargetRPMChooser = choosers.DcMotorX_TargetRPMChooser; 
        
        choosers = ConfigDashboardInput("5");
        _dcMotor5_Mode_Chooser = choosers.DcMotorX_Mode_Chooser; 
        _dcMotor5_Direction_Chooser = choosers.DcMotorX_Direction_Chooser; 
        _dcMotor5_AnalogModeJoystickChooser = choosers.DcMotorX_AnalogModeJoystickChooser; 
        _dcMotor5_DigitalModeButtonChooser = choosers.DcMotorX_DigitalModeButtonChooser; 
        _dcMotor5_MaxSpeedChooser = choosers.DcMotorX_MaxSpeedChooser; 
        _dcMotor5_BrakeModeChooser = choosers.DcMotorX_BrakeModeChooser; 
        _dcMotor5_DigitalLatchModeChooser = choosers.DcMotorX_DigitalLatchModeChooser; 
        _dcMotor5_TargetRPMChooser = choosers.DcMotorX_TargetRPMChooser; 
        
        choosers = ConfigDashboardInput("6");
        _dcMotor6_Mode_Chooser = choosers.DcMotorX_Mode_Chooser; 
        _dcMotor6_Direction_Chooser = choosers.DcMotorX_Direction_Chooser; 
        _dcMotor6_AnalogModeJoystickChooser = choosers.DcMotorX_AnalogModeJoystickChooser; 
        _dcMotor6_DigitalModeButtonChooser = choosers.DcMotorX_DigitalModeButtonChooser; 
        _dcMotor6_MaxSpeedChooser = choosers.DcMotorX_MaxSpeedChooser; 
        _dcMotor6_BrakeModeChooser = choosers.DcMotorX_BrakeModeChooser; 
        _dcMotor6_DigitalLatchModeChooser = choosers.DcMotorX_DigitalLatchModeChooser; 
        _dcMotor6_TargetRPMChooser = choosers.DcMotorX_TargetRPMChooser; 

        
        // setup output fields
        SmartDashboard.putString("Motor1" + "_Actual", "0.0");
        SmartDashboard.putString("Motor2" + "_Actual", "0.0");
        SmartDashboard.putString("Motor3" + "_Actual", "0.0");
        SmartDashboard.putString("Motor4" + "_Actual", "0.0");
        SmartDashboard.putString("Motor5" + "_Actual", "0.0");
        SmartDashboard.putString("Motor6" + "_Actual", "0.0");
        
        TestActuatorSendableChoosers();
        
        System.out.println("..Choosers End Config!");
    
	}
	
	private void TestActuatorSendableChoosers()
	{
		_actuatorUpBtnChooser = new SendableChooser<DIGITAL_MODE_BUTTON>();
		_actuatorUpBtnChooser.addDefault("Undefined=UP", DIGITAL_MODE_BUTTON.UNDEFINED);
		_actuatorUpBtnChooser.addObject("DRIVER_GREEN_BUTTON_A", DIGITAL_MODE_BUTTON.DRIVER_GREEN_BUTTON_A);
		_actuatorUpBtnChooser.addObject("DRIVER_RED_BUTTON_B", DIGITAL_MODE_BUTTON.DRIVER_RED_BUTTON_B);
		_actuatorUpBtnChooser.addObject("DRIVER_BLUE_BUTTON_X", DIGITAL_MODE_BUTTON.DRIVER_BLUE_BUTTON_X);
		_actuatorUpBtnChooser.addObject("DRIVER_YELLOW_BUTTON_Y", DIGITAL_MODE_BUTTON.DRIVER_YELLOW_BUTTON_Y);
		_actuatorUpBtnChooser.addObject("OPERATOR_GREEN_BUTTON_A", DIGITAL_MODE_BUTTON.OPERATOR_GREEN_BUTTON_A);
		_actuatorUpBtnChooser.addObject("OPERATOR_RED_BUTTON_B", DIGITAL_MODE_BUTTON.OPERATOR_RED_BUTTON_B);
		_actuatorUpBtnChooser.addObject("OPERATOR_BLUE_BUTTON_X", DIGITAL_MODE_BUTTON.OPERATOR_BLUE_BUTTON_X);
		_actuatorUpBtnChooser.addObject("OPERATOR_YELLOW_BUTTON_Y", DIGITAL_MODE_BUTTON.OPERATOR_YELLOW_BUTTON_Y);
		
		SmartDashboard.putData("Actuator Up Button", _actuatorUpBtnChooser);
		
		_actuatorDownBtnChooser = new SendableChooser<DIGITAL_MODE_BUTTON>();
		_actuatorDownBtnChooser.addDefault("Undefined=DOWN", DIGITAL_MODE_BUTTON.UNDEFINED);
		_actuatorDownBtnChooser.addObject("DRIVER_GREEN_BUTTON_A", DIGITAL_MODE_BUTTON.DRIVER_GREEN_BUTTON_A);
		_actuatorDownBtnChooser.addObject("DRIVER_RED_BUTTON_B", DIGITAL_MODE_BUTTON.DRIVER_RED_BUTTON_B);
		_actuatorDownBtnChooser.addObject("DRIVER_BLUE_BUTTON_X", DIGITAL_MODE_BUTTON.DRIVER_BLUE_BUTTON_X);
		_actuatorDownBtnChooser.addObject("DRIVER_YELLOW_BUTTON_Y", DIGITAL_MODE_BUTTON.DRIVER_YELLOW_BUTTON_Y);
		_actuatorDownBtnChooser.addObject("OPERATOR_GREEN_BUTTON_A", DIGITAL_MODE_BUTTON.OPERATOR_GREEN_BUTTON_A);
		_actuatorDownBtnChooser.addObject("OPERATOR_RED_BUTTON_B", DIGITAL_MODE_BUTTON.OPERATOR_RED_BUTTON_B);
		_actuatorDownBtnChooser.addObject("OPERATOR_BLUE_BUTTON_X", DIGITAL_MODE_BUTTON.OPERATOR_BLUE_BUTTON_X);
		_actuatorDownBtnChooser.addObject("OPERATOR_YELLOW_BUTTON_Y", DIGITAL_MODE_BUTTON.OPERATOR_YELLOW_BUTTON_Y);
		
		SmartDashboard.putData("Actuator Down Button", _actuatorDownBtnChooser);
	}
	
	// Config the Dashboard Choosers for a Motor
	private TestMotorSendableChoosers ConfigDashboardInput(String motorIndex)
	{    
        //===================
        // Smart DashBoard User Input
        //   http://wpilib.screenstepslive.com/s/3120/m/7932/l/81109-choosing-an-autonomous-program-from-smartdashboard
        //===================
		SendableChooser<MOTOR_MODE> dcMotorX_Mode_Chooser;
		SendableChooser<MOTOR_DIRECTION> dcMotorX_Direction_Chooser;
		SendableChooser<ANALOG_MODE_JOYSTICK> dcMotorX_AnalogModeJoystickChooser;
		SendableChooser<DIGITAL_MODE_BUTTON> dcMotorX_DigitalModeButtonChooser;
		SendableChooser<MOTOR_MAX_SPEED> dcMotorX_MaxSpeedChooser;
		SendableChooser<BRAKE_MODE> dcMotorX_BrakeModeChooser;
		SendableChooser<DIGITAL_LATCH_MODE> dcMotorX_DigitalLatchModeChooser;
		SendableChooser<MOTOR_CONSTANTV_TARGET> dcMotorX_TargetRPMChooser;
		
		// *****************************
        // ***** _dcMotorX_Mode_Chooser
		// *****************************
        dcMotorX_Mode_Chooser = new SendableChooser<MOTOR_MODE>();
        dcMotorX_Mode_Chooser.addDefault("Disabled_" + motorIndex, MOTOR_MODE.DISABLED);
        dcMotorX_Mode_Chooser.addObject("Joystick Mode", MOTOR_MODE.ENABLED_ANALOG_MODE);
        dcMotorX_Mode_Chooser.addObject("Button %VBus Mode", MOTOR_MODE.ENABLED_DIGITAL_MODE);
        dcMotorX_Mode_Chooser.addObject("Button PID-V Mode", MOTOR_MODE.ENABLED_PID_MODE);
        SmartDashboard.putData("Motor" + motorIndex + "_Mode", dcMotorX_Mode_Chooser);
        
        // *****************************
        // ***** _dcMotorX_Direction_Chooser
        // *****************************
        dcMotorX_Direction_Chooser = new SendableChooser<MOTOR_DIRECTION>();
        dcMotorX_Direction_Chooser.addDefault("Standard (+=CW)_" + motorIndex, MOTOR_DIRECTION.STANDARD);
        dcMotorX_Direction_Chooser.addObject("Reversed (+=CCW)", MOTOR_DIRECTION.REVERSED);
        SmartDashboard.putData("Motor" + motorIndex + "_Direction", dcMotorX_Direction_Chooser);
        
        // *****************************
        // ***** _dcMotorX_AnalogModeJoystickChooser
        // *****************************
        dcMotorX_AnalogModeJoystickChooser = new SendableChooser<ANALOG_MODE_JOYSTICK>();
        dcMotorX_AnalogModeJoystickChooser.addDefault("UNDEFINED_" + motorIndex, ANALOG_MODE_JOYSTICK.UNDEFINED);
        //ANALOG_MODE_JOYSTICK.DRIVER_LEFT_X_AXIS,
        dcMotorX_AnalogModeJoystickChooser.addObject("DRIVER_LEFT_Y", ANALOG_MODE_JOYSTICK.DRIVER_LEFT_Y_AXIS);
        //ANALOG_MODE_JOYSTICK.DRIVER_LEFT_TRIGGER,
        //ANALOG_MODE_JOYSTICK.DRIVER_RIGHT_TRIGGER,
        //ANALOG_MODE_JOYSTICK.DRIVER_RIGHT_X_AXIS,
        dcMotorX_AnalogModeJoystickChooser.addObject("DRIVER_RIGHT_Y", ANALOG_MODE_JOYSTICK.DRIVER_RIGHT_Y_AXIS);
		//OPERATOR_LEFT_X_AXIS,
        dcMotorX_AnalogModeJoystickChooser.addObject("OPERATOR_LEFT_Y", ANALOG_MODE_JOYSTICK.OPERATOR_LEFT_Y_AXIS);
		//OPERATOR_LEFT_TRIGGER,
		//OPERATOR_RIGHT_TRIGGER,
		//OPERATOR_RIGHT_X_AXIS,
        dcMotorX_AnalogModeJoystickChooser.addObject("OPERATOR_RIGHT_Y", ANALOG_MODE_JOYSTICK.OPERATOR_RIGHT_Y_AXIS);
        SmartDashboard.putData("Motor" + motorIndex +"_Joystick", dcMotorX_AnalogModeJoystickChooser);
         
        // *****************************
        // ***** _dcMotorX_DigitalModeButtonChooser
        // *****************************
        dcMotorX_DigitalModeButtonChooser  = new SendableChooser<DIGITAL_MODE_BUTTON>();
        dcMotorX_DigitalModeButtonChooser.addDefault("UNDEFINED_" + motorIndex, DIGITAL_MODE_BUTTON.UNDEFINED);
        dcMotorX_DigitalModeButtonChooser.addObject("DRIVER_GREEN_BUTTON_A", DIGITAL_MODE_BUTTON.DRIVER_GREEN_BUTTON_A);
        dcMotorX_DigitalModeButtonChooser.addObject("DRIVER_RED_BUTTON_B", DIGITAL_MODE_BUTTON.DRIVER_RED_BUTTON_B);
        dcMotorX_DigitalModeButtonChooser.addObject("DRIVER_BLUE_BUTTON_X", DIGITAL_MODE_BUTTON.DRIVER_BLUE_BUTTON_X);
        dcMotorX_DigitalModeButtonChooser.addObject("DRIVER_YELLOW_BUTTON_Y", DIGITAL_MODE_BUTTON.DRIVER_YELLOW_BUTTON_Y);
		//DRIVER_LEFT_BUMPER,
		//DRIVER_RIGHT_BUMPER,
		//DRIVER_BACK_BUTTON,
		//DRIVER_START_BUTTON,
		//DRIVER_LEFT_THUMBSTICK,
		//DRIVER_RIGHT_THUMBSTICK,
        dcMotorX_DigitalModeButtonChooser.addObject("OPERATOR_GREEN_BUTTON_A", DIGITAL_MODE_BUTTON.OPERATOR_GREEN_BUTTON_A);
        dcMotorX_DigitalModeButtonChooser.addObject("OPERATOR_RED_BUTTON_B", DIGITAL_MODE_BUTTON.OPERATOR_RED_BUTTON_B);
        dcMotorX_DigitalModeButtonChooser.addObject("OPERATOR_BLUE_BUTTON_X", DIGITAL_MODE_BUTTON.OPERATOR_BLUE_BUTTON_X);
        dcMotorX_DigitalModeButtonChooser.addObject("OPERATOR_YELLOW_BUTTON_Y", DIGITAL_MODE_BUTTON.OPERATOR_YELLOW_BUTTON_Y);
		//OPERATOR_LEFT_BUMPER,
		//OPERATOR_RIGHT_BUMPER,
		//OPERATOR_BACK_BUTTON,
		//OPERATOR_START_BUTTON,
		//OPERATOR_LEFT_THUMBSTICK,
		//OPERATOR_RIGHT_THUMBSTICK
        SmartDashboard.putData("Motor" + motorIndex + "_Button", dcMotorX_DigitalModeButtonChooser);
        
        // *****************************
        // ***** _dcMotorX_MaxSpeedChooser
        // *****************************
        dcMotorX_MaxSpeedChooser = new SendableChooser<MOTOR_MAX_SPEED>();
        dcMotorX_MaxSpeedChooser.addDefault("0%_" + motorIndex, MOTOR_MAX_SPEED.PERCENT_0);
        dcMotorX_MaxSpeedChooser.addObject("5%", MOTOR_MAX_SPEED.PERCENT_5);
        dcMotorX_MaxSpeedChooser.addObject("10%", MOTOR_MAX_SPEED.PERCENT_10);
        dcMotorX_MaxSpeedChooser.addObject("15%", MOTOR_MAX_SPEED.PERCENT_15);
        dcMotorX_MaxSpeedChooser.addObject("20%", MOTOR_MAX_SPEED.PERCENT_20);
        dcMotorX_MaxSpeedChooser.addObject("25%", MOTOR_MAX_SPEED.PERCENT_25);
        dcMotorX_MaxSpeedChooser.addObject("30%", MOTOR_MAX_SPEED.PERCENT_30);
        dcMotorX_MaxSpeedChooser.addObject("35%", MOTOR_MAX_SPEED.PERCENT_35);
        dcMotorX_MaxSpeedChooser.addObject("40%", MOTOR_MAX_SPEED.PERCENT_40);
        dcMotorX_MaxSpeedChooser.addObject("45%", MOTOR_MAX_SPEED.PERCENT_45);
        dcMotorX_MaxSpeedChooser.addObject("50%", MOTOR_MAX_SPEED.PERCENT_50);
        dcMotorX_MaxSpeedChooser.addObject("55%", MOTOR_MAX_SPEED.PERCENT_55);
        dcMotorX_MaxSpeedChooser.addObject("60%", MOTOR_MAX_SPEED.PERCENT_60);
        dcMotorX_MaxSpeedChooser.addObject("65%", MOTOR_MAX_SPEED.PERCENT_65);
        dcMotorX_MaxSpeedChooser.addObject("70%", MOTOR_MAX_SPEED.PERCENT_60);
        dcMotorX_MaxSpeedChooser.addObject("75%", MOTOR_MAX_SPEED.PERCENT_75);
        dcMotorX_MaxSpeedChooser.addObject("80%", MOTOR_MAX_SPEED.PERCENT_80);
        dcMotorX_MaxSpeedChooser.addObject("85%", MOTOR_MAX_SPEED.PERCENT_85);
        dcMotorX_MaxSpeedChooser.addObject("90%", MOTOR_MAX_SPEED.PERCENT_90);
        dcMotorX_MaxSpeedChooser.addObject("95%", MOTOR_MAX_SPEED.PERCENT_95);
        dcMotorX_MaxSpeedChooser.addObject("100%", MOTOR_MAX_SPEED.PERCENT_100);
        SmartDashboard.putData("Motor" + motorIndex + "_MaxSpeed", dcMotorX_MaxSpeedChooser);
        
        // *****************************
        // ***** _dcMotorX_BrakeMode_Chooser
        // *****************************
        dcMotorX_BrakeModeChooser = new SendableChooser<BRAKE_MODE>();
        dcMotorX_BrakeModeChooser.addDefault("DISABLED_" + motorIndex, BRAKE_MODE.DISABLED);
        dcMotorX_BrakeModeChooser.addObject("ENABLED", BRAKE_MODE.ENABLED);
        SmartDashboard.putData("Motor" + motorIndex + "_BrakeMode", dcMotorX_BrakeModeChooser);
        
        // *****************************
        // ***** _dcMotorX_DigitalLatchModeChooser
        // *****************************
        dcMotorX_DigitalLatchModeChooser = new SendableChooser<DIGITAL_LATCH_MODE>();
        dcMotorX_DigitalLatchModeChooser.addDefault("DISABLED_" + motorIndex, DIGITAL_LATCH_MODE.DISABLED);
        dcMotorX_DigitalLatchModeChooser.addObject("ENABLED", DIGITAL_LATCH_MODE.ENABLED);
        SmartDashboard.putData("Motor" + motorIndex + "_LatchMode", dcMotorX_DigitalLatchModeChooser);
        
        // *****************************
        // ***** _dcMotorX_PIDRPMChooser
        // *****************************
        dcMotorX_TargetRPMChooser = new SendableChooser<MOTOR_CONSTANTV_TARGET>();
        dcMotorX_TargetRPMChooser.addDefault("500rpm_" + motorIndex, MOTOR_CONSTANTV_TARGET.RPM_500);
        dcMotorX_TargetRPMChooser.addObject("750rpm", MOTOR_CONSTANTV_TARGET.RPM_750);
        dcMotorX_TargetRPMChooser.addObject("1000rpm", MOTOR_CONSTANTV_TARGET.RPM_1000);
        dcMotorX_TargetRPMChooser.addObject("1250rpm", MOTOR_CONSTANTV_TARGET.RPM_1250);
        dcMotorX_TargetRPMChooser.addObject("1500rpm", MOTOR_CONSTANTV_TARGET.RPM_1500);
        dcMotorX_TargetRPMChooser.addObject("1750rpm", MOTOR_CONSTANTV_TARGET.RPM_1750);
        dcMotorX_TargetRPMChooser.addObject("2000rpm", MOTOR_CONSTANTV_TARGET.RPM_2000);
        dcMotorX_TargetRPMChooser.addObject("2250rpm", MOTOR_CONSTANTV_TARGET.RPM_2250);
        dcMotorX_TargetRPMChooser.addObject("2500rpm", MOTOR_CONSTANTV_TARGET.RPM_2500);
        dcMotorX_TargetRPMChooser.addObject("2750rpm", MOTOR_CONSTANTV_TARGET.RPM_2750);
        dcMotorX_TargetRPMChooser.addObject("3000rpm", MOTOR_CONSTANTV_TARGET.RPM_3000);
        dcMotorX_TargetRPMChooser.addObject("3250rpm", MOTOR_CONSTANTV_TARGET.RPM_3250);
        dcMotorX_TargetRPMChooser.addObject("3500rpm", MOTOR_CONSTANTV_TARGET.RPM_3500);
        dcMotorX_TargetRPMChooser.addObject("3750rpm", MOTOR_CONSTANTV_TARGET.RPM_3750);
        dcMotorX_TargetRPMChooser.addObject("4000rpm", MOTOR_CONSTANTV_TARGET.RPM_4000);
        dcMotorX_TargetRPMChooser.addObject("4250rpm", MOTOR_CONSTANTV_TARGET.RPM_4250);
        dcMotorX_TargetRPMChooser.addObject("4500rpm", MOTOR_CONSTANTV_TARGET.RPM_4500);
        dcMotorX_TargetRPMChooser.addObject("4750rpm", MOTOR_CONSTANTV_TARGET.RPM_4750);
        dcMotorX_TargetRPMChooser.addObject("5000rpm", MOTOR_CONSTANTV_TARGET.RPM_5000);
        dcMotorX_TargetRPMChooser.addObject("5250rpm", MOTOR_CONSTANTV_TARGET.RPM_5250);
        dcMotorX_TargetRPMChooser.addObject("5500rpm", MOTOR_CONSTANTV_TARGET.RPM_5500);
        dcMotorX_TargetRPMChooser.addObject("5750rpm", MOTOR_CONSTANTV_TARGET.RPM_5750);
        dcMotorX_TargetRPMChooser.addObject("6000rpm", MOTOR_CONSTANTV_TARGET.RPM_6000);        
        SmartDashboard.putData("Motor" + motorIndex + "_PIDRPM", dcMotorX_TargetRPMChooser);
        
        TestMotorSendableChoosers testMotorSendableChoosers = new TestMotorSendableChoosers();
        
        testMotorSendableChoosers.DcMotorX_Mode_Chooser = dcMotorX_Mode_Chooser;
        testMotorSendableChoosers.DcMotorX_Direction_Chooser = dcMotorX_Direction_Chooser;
        testMotorSendableChoosers.DcMotorX_AnalogModeJoystickChooser = dcMotorX_AnalogModeJoystickChooser;
		testMotorSendableChoosers.DcMotorX_DigitalModeButtonChooser = dcMotorX_DigitalModeButtonChooser;
		testMotorSendableChoosers.DcMotorX_MaxSpeedChooser = dcMotorX_MaxSpeedChooser;
		testMotorSendableChoosers.DcMotorX_BrakeModeChooser = dcMotorX_BrakeModeChooser;
		testMotorSendableChoosers.DcMotorX_DigitalLatchModeChooser = dcMotorX_DigitalLatchModeChooser;
		testMotorSendableChoosers.DcMotorX_TargetRPMChooser = dcMotorX_TargetRPMChooser;
		
        return testMotorSendableChoosers;
        
        
	}


	// === Motor Configuration ===============================================	
	public TestMotorConfig getMotor1Configuration()
	{
		return _motor1Configuration;
	}
	
	public TestMotorConfig getMotor2Configuration()
	{
		return _motor2Configuration;
	}
	
	public TestMotorConfig getMotor3Configuration()
	{
		return _motor3Configuration;
	}
	
	public TestMotorConfig getMotor4Configuration()
	{
		return _motor4Configuration;
	}
	
	public TestMotorConfig getMotor5Configuration()
	{
		return _motor5Configuration;
	}
	
	public TestMotorConfig getMotor6Configuration()
	{
		return _motor6Configuration;
	}
	
	public void ReadActuatorConfig()
	{
		_actuatorUpChoice = (DIGITAL_MODE_BUTTON)_actuatorUpBtnChooser.getSelected();
		_actuatorDownChoice = (DIGITAL_MODE_BUTTON)_actuatorDownBtnChooser.getSelected();
		DriverStation.reportWarning("Actuator Up Choice " + _actuatorUpChoice, true);
		DriverStation.reportWarning("Actuator Down Choice " + _actuatorDownChoice, true);
	}
	
	public DIGITAL_MODE_BUTTON get_actuatorUpBtn ()
	{
		return _actuatorUpChoice;
	}
	
	public DIGITAL_MODE_BUTTON get_actuatorDownBtn ()
	{
		return _actuatorDownChoice;
	}
	
	public void ReadMotorCfgValues()
	{
    	// read auton values
    	_motor1Configuration = new TestMotorConfig();
    	_motor1Configuration.MotorMode = _dcMotor1_Mode_Chooser.getSelected();
    	_motor1Configuration.AnalogModeJoystick = _dcMotor1_AnalogModeJoystickChooser.getSelected();
    	_motor1Configuration.DigitalModeButton = _dcMotor1_DigitalModeButtonChooser.getSelected();
    	_motor1Configuration.CmdScalingFactor = _dcMotor1_MaxSpeedChooser.getSelected().get_maxSpeed();
    	_motor1Configuration.IsMotorDirectionReversed = _dcMotor1_Direction_Chooser.getSelected().get_isReversed();
    	_motor1Configuration.IsBrakeModeEnabled = _dcMotor1_BrakeModeChooser.getSelected().get_isEnabled();
    	_motor1Configuration.IsCmdLatchModeEnabled = _dcMotor1_DigitalLatchModeChooser.getSelected().get_isEnabled();
    	_motor1Configuration.ConstantVTargetRPM = _dcMotor1_TargetRPMChooser.getSelected().get_targetRPM();
    	
        //System.out.println("M1 Selection" + _motor1Configuration.MotorMode);
    	
    	_motor2Configuration = new TestMotorConfig();
    	_motor2Configuration.MotorMode = _dcMotor2_Mode_Chooser.getSelected();
    	_motor2Configuration.AnalogModeJoystick = _dcMotor2_AnalogModeJoystickChooser.getSelected();
    	_motor2Configuration.DigitalModeButton = _dcMotor2_DigitalModeButtonChooser.getSelected();
    	_motor2Configuration.CmdScalingFactor = _dcMotor2_MaxSpeedChooser.getSelected().get_maxSpeed();
    	_motor2Configuration.IsMotorDirectionReversed = _dcMotor2_Direction_Chooser.getSelected().get_isReversed();
    	_motor2Configuration.IsBrakeModeEnabled = _dcMotor2_BrakeModeChooser.getSelected().get_isEnabled();
    	_motor2Configuration.IsCmdLatchModeEnabled = _dcMotor2_DigitalLatchModeChooser.getSelected().get_isEnabled();
    	_motor2Configuration.ConstantVTargetRPM = _dcMotor2_TargetRPMChooser.getSelected().get_targetRPM();
    	
    	_motor3Configuration = new TestMotorConfig();
    	_motor3Configuration.MotorMode = _dcMotor3_Mode_Chooser.getSelected();
    	_motor3Configuration.AnalogModeJoystick = _dcMotor3_AnalogModeJoystickChooser.getSelected();
    	_motor3Configuration.DigitalModeButton = _dcMotor3_DigitalModeButtonChooser.getSelected();
    	_motor3Configuration.CmdScalingFactor = _dcMotor3_MaxSpeedChooser.getSelected().get_maxSpeed();
    	_motor3Configuration.IsMotorDirectionReversed = _dcMotor3_Direction_Chooser.getSelected().get_isReversed();
    	_motor3Configuration.IsBrakeModeEnabled = _dcMotor3_BrakeModeChooser.getSelected().get_isEnabled();
    	_motor3Configuration.IsCmdLatchModeEnabled = _dcMotor3_DigitalLatchModeChooser.getSelected().get_isEnabled();
    	_motor3Configuration.ConstantVTargetRPM = _dcMotor3_TargetRPMChooser.getSelected().get_targetRPM();
    	
    	_motor4Configuration = new TestMotorConfig();
    	_motor4Configuration.MotorMode = _dcMotor4_Mode_Chooser.getSelected();
    	_motor4Configuration.AnalogModeJoystick = _dcMotor4_AnalogModeJoystickChooser.getSelected();
    	_motor4Configuration.DigitalModeButton =  _dcMotor4_DigitalModeButtonChooser.getSelected();
    	_motor4Configuration.CmdScalingFactor = _dcMotor4_MaxSpeedChooser.getSelected().get_maxSpeed();
    	_motor4Configuration.IsMotorDirectionReversed = _dcMotor4_Direction_Chooser.getSelected().get_isReversed();
    	_motor4Configuration.IsBrakeModeEnabled = _dcMotor4_BrakeModeChooser.getSelected().get_isEnabled();
    	_motor4Configuration.IsCmdLatchModeEnabled = _dcMotor4_DigitalLatchModeChooser.getSelected().get_isEnabled();
    	_motor4Configuration.ConstantVTargetRPM = _dcMotor4_TargetRPMChooser.getSelected().get_targetRPM();
    	
    	_motor5Configuration = new TestMotorConfig();
    	_motor5Configuration.MotorMode = _dcMotor5_Mode_Chooser.getSelected();
    	_motor5Configuration.AnalogModeJoystick =  _dcMotor5_AnalogModeJoystickChooser.getSelected();
    	_motor5Configuration.DigitalModeButton = _dcMotor5_DigitalModeButtonChooser.getSelected();
    	_motor5Configuration.CmdScalingFactor = _dcMotor5_MaxSpeedChooser.getSelected().get_maxSpeed();
    	_motor5Configuration.IsMotorDirectionReversed = _dcMotor5_Direction_Chooser.getSelected().get_isReversed();
    	_motor5Configuration.IsBrakeModeEnabled = _dcMotor5_BrakeModeChooser.getSelected().get_isEnabled();
    	_motor5Configuration.IsCmdLatchModeEnabled = _dcMotor5_DigitalLatchModeChooser.getSelected().get_isEnabled();
    	_motor5Configuration.ConstantVTargetRPM = _dcMotor5_TargetRPMChooser.getSelected().get_targetRPM();
    	
    	_motor6Configuration = new TestMotorConfig();    
    	_motor6Configuration.MotorMode = _dcMotor6_Mode_Chooser.getSelected();
    	_motor6Configuration.AnalogModeJoystick = _dcMotor6_AnalogModeJoystickChooser.getSelected();
    	_motor6Configuration.DigitalModeButton = _dcMotor6_DigitalModeButtonChooser.getSelected();
    	_motor6Configuration.CmdScalingFactor = _dcMotor6_MaxSpeedChooser.getSelected().get_maxSpeed();
    	_motor6Configuration.IsMotorDirectionReversed = _dcMotor6_Direction_Chooser.getSelected().get_isReversed();
    	_motor6Configuration.IsBrakeModeEnabled = _dcMotor6_BrakeModeChooser.getSelected().get_isEnabled();
    	_motor6Configuration.IsCmdLatchModeEnabled = _dcMotor6_DigitalLatchModeChooser.getSelected().get_isEnabled();
    	_motor6Configuration.ConstantVTargetRPM = _dcMotor6_TargetRPMChooser.getSelected().get_targetRPM();
    	
    	
	}

	public class TestMotorSendableChoosers
	{
		public SendableChooser<MOTOR_MODE> DcMotorX_Mode_Chooser;
		public SendableChooser<MOTOR_DIRECTION> DcMotorX_Direction_Chooser;
		public SendableChooser<ANALOG_MODE_JOYSTICK> DcMotorX_AnalogModeJoystickChooser;
		public SendableChooser<DIGITAL_MODE_BUTTON> DcMotorX_DigitalModeButtonChooser;
		public SendableChooser<MOTOR_MAX_SPEED> DcMotorX_MaxSpeedChooser;
		public SendableChooser<BRAKE_MODE> DcMotorX_BrakeModeChooser;
		public SendableChooser<DIGITAL_LATCH_MODE> DcMotorX_DigitalLatchModeChooser;
		public SendableChooser<MOTOR_CONSTANTV_TARGET> DcMotorX_TargetRPMChooser;
	}
	
	/*
	 * Each instance of this class holds cfg data (from the Dashboard) for a particular motor
	 */
	public class TestMotorConfig
	{
		public TestMotorConfig()
		{
			// default to disabled
			this.MotorMode = MOTOR_MODE.DISABLED;
		}
		
		public MOTOR_MODE MotorMode;
		
		public boolean IsMotorDirectionReversed;
		
		public boolean IsBrakeModeEnabled;
		
		public boolean IsCmdLatchModeEnabled;
		
		public double CmdScalingFactor;
		
		public ANALOG_MODE_JOYSTICK AnalogModeJoystick;
		
		public DIGITAL_MODE_BUTTON DigitalModeButton;
		
		public int ConstantVTargetRPM;
	}

/*	public class TestServoConfig
	{
		public DIGITAL_MODE_BUTTON ActuatorUpButton;
		public DIGITAL_MODE_BUTTON ActuatorDownButton;
	}
	*/
}
