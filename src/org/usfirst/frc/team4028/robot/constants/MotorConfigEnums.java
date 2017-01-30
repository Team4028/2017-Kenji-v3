package org.usfirst.frc.team4028.robot.constants;

public class MotorConfigEnums 
{
	public enum MOTOR_MODE
	{
		DISABLED,
		ENABLED_ANALOG_MODE,
		ENABLED_DIGITAL_MODE,
		ENABLED_PID_MODE
	}
	
	public enum MOTOR_DIRECTION
	{
		STANDARD	(false),
		REVERSED	(true);
		
		private final boolean _isReversed;  
		
		MOTOR_DIRECTION(boolean isReversed)
		{
			_isReversed = isReversed;
		}
		
		public boolean get_isReversed()
		{
			return _isReversed;
		}
	}
	
	public enum BRAKE_MODE
	{
		DISABLED	(false),
		ENABLED		(true);
		
		private final boolean _isEnabled;  
		
		BRAKE_MODE(boolean isEnabled)
		{
			_isEnabled = isEnabled;
		}
		
		public boolean get_isEnabled()
		{
			return _isEnabled;
		}
	}
	
	public enum DIGITAL_LATCH_MODE
	{
		DISABLED	(false),
		ENABLED	(	true);
		
		private final boolean _isEnabled;  
		
		DIGITAL_LATCH_MODE(boolean isEnabled)
		{
			_isEnabled = isEnabled;
		}
		
		public boolean get_isEnabled()
		{
			return _isEnabled;
		}
	}
	
	public enum ANALOG_MODE_JOYSTICK
	{
		UNDEFINED,
		DRIVER_LEFT_X_AXIS,
		DRIVER_LEFT_Y_AXIS,
		DRIVER_LEFT_TRIGGER,
		DRIVER_RIGHT_TRIGGER,
		DRIVER_RIGHT_X_AXIS,
		DRIVER_RIGHT_Y_AXIS,
		OPERATOR_LEFT_X_AXIS,
		OPERATOR_LEFT_Y_AXIS,
		OPERATOR_LEFT_TRIGGER,
		OPERATOR_RIGHT_TRIGGER,
		OPERATOR_RIGHT_X_AXIS,
		OPERATOR_RIGHT_Y_AXIS,
	}
	
	public enum DIGITAL_MODE_BUTTON
	{
		UNDEFINED,
		DRIVER_GREEN_BUTTON_A,
		DRIVER_RED_BUTTON_B,
		DRIVER_BLUE_BUTTON_X,
		DRIVER_YELLOW_BUTTON_Y,
		DRIVER_LEFT_BUMPER,
		DRIVER_RIGHT_BUMPER,
		DRIVER_BACK_BUTTON,
		DRIVER_START_BUTTON,
		DRIVER_LEFT_THUMBSTICK,
		DRIVER_RIGHT_THUMBSTICK,
		OPERATOR_GREEN_BUTTON_A,
		OPERATOR_RED_BUTTON_B,
		OPERATOR_BLUE_BUTTON_X,
		OPERATOR_YELLOW_BUTTON_Y,
		OPERATOR_LEFT_BUMPER,
		OPERATOR_RIGHT_BUMPER,
		OPERATOR_BACK_BUTTON,
		OPERATOR_START_BUTTON,
		OPERATOR_LEFT_THUMBSTICK,
		OPERATOR_RIGHT_THUMBSTICK
	}
	
	public enum MOTOR_MAX_SPEED
	{
		PERCENT_0 	(0),
		PERCENT_5 	(.05),
		PERCENT_10	(.10),
		PERCENT_15	(.15),
		PERCENT_20	(.20),
		PERCENT_25	(.25),
		PERCENT_30	(.30),
		PERCENT_35	(.35),
		PERCENT_40	(.40),
		PERCENT_45 	(.45),
		PERCENT_50 	(.50),
		PERCENT_55	(.55),
		PERCENT_60	(.60),
		PERCENT_65	(.65),
		PERCENT_70	(.70),
		PERCENT_75	(.75),
		PERCENT_80	(.80),
		PERCENT_85	(.85),		
		PERCENT_90	(.90),
		PERCENT_95	(.95),
		PERCENT_100	(1);
	
		
		private final double _maxSpeed;  
		
		MOTOR_MAX_SPEED(double maxSpeed)
		{
			_maxSpeed = maxSpeed;
		}
		
		public double get_maxSpeed()
		{
			return _maxSpeed;
		}
	}
	
	public enum MOTOR_CONSTANTV_TARGET
	{
		RPM_500		(500),
		RPM_750		(750),
		RPM_1000	(1000),
		RPM_1250	(1250),
		RPM_1500	(1500),
		RPM_1750	(1750),
		RPM_2000	(2000),
		RPM_2250	(2250),
		RPM_2500	(2500),
		RPM_2750	(2750),
		RPM_3000	(3000),
		RPM_3250	(3250),
		RPM_3500	(3500),
		RPM_3750	(3750),
		RPM_4000	(4000),
		RPM_4250	(4250),
		RPM_4500	(4500),
		RPM_4750	(4750),
		RPM_5000	(5000),
		RPM_5250	(5250),
		RPM_5500	(5500),
		RPM_5750	(5750),
		RPM_6000	(6000);
		
		private final int _targetRPM;  
				
		MOTOR_CONSTANTV_TARGET (int targetRPM)
		{
			_targetRPM = targetRPM;
		}
		
		public int get_targetRPM()
		{
			return _targetRPM;
		}
	}
}
