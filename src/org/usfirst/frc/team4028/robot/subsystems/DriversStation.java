package org.usfirst.frc.team4028.robot.subsystems;

import org.usfirst.frc.team4028.robot.constants.LogitechF310;
import edu.wpi.first.wpilibj.Joystick;

/**
 * This class defines the behavior of the Driver's Station
 * 	it encapsulates all interaction with the GamePads
 * 
 * Internally it keeps track of the current and previous scan values for all gamepads
 * 	but that is completely transparent to users of this class
 */
public class DriversStation 
{

	// ===================================
	// define robot objects for Driver & Operator station gamepads
	// ===================================
	private Joystick _driverGamepad;
	private Joystick _operatorGamepad;
	
	// ===================================
	// define working & state variables
	// ===================================
	private DriversStationInputs _currentValues;
	private DriversStationInputs _previousValues;
	
	private final double JOYSTICK_THRESHHOLD = 0.05;
	
	// ===================================
	// Constructors follow
	// ===================================
	public DriversStation(int driverGamePadUsbPort, int operatorGamePadUsbPort)
	{	
		try
		{
			_driverGamepad = new Joystick(driverGamePadUsbPort);				// std Logitech F310 Gamepad  
		}
		catch(Exception ex)
		{
			System.out.println(".._driverGamepad Not Available!");
		}
		
		try
		{
			_operatorGamepad = new Joystick(operatorGamePadUsbPort);			// std Logitech F310 Gamepad  
		}
		catch(Exception ex)
		{
			System.out.println(".._operatorGamepad Not Available!");
		}
	}
		
	/**
	 * Refreshes the locally cached copy of the Current (this scan) Driver's Station Input Values
	 */
	public DriversStationInputs ReadCurrentScanCycleValues()
	{
		// always set previousValues object to null (so that object can be gc'd)
		_previousValues = null;
		
		if(_currentValues != null)
		{
			// if we have _currentValues (From the last scan) push them into _previosuValues
			_previousValues = _currentValues;
		}
		
		// update _currentValues by reading from the gamepads
		_currentValues = new DriversStationInputs();
		
		if(_previousValues == null)
		{
			// if we DO NOT have _previousValues (From the last scan) set it equal to _currentValues
			_previousValues = _currentValues;
		}
		
		return _currentValues;
	}
	
	// ======================================================
	// Public Property Accessors
	// ======================================================
	
	// === driver buttons ===============================================
	public boolean getIsDriverGreenBtnAJustPressed()
	{
		return(_currentValues.getIsDriverGreenBtnAPressed()
    				&& !_previousValues.getIsDriverGreenBtnAPressed());
	}
	
	public boolean getIsDriverRedBtnBJustPressed()
	{
		return(_currentValues.getIsDriverRedBtnBPressed()
    				&& !_previousValues.getIsDriverRedBtnBPressed());
	}
	
	public boolean getIsDriverBlueBtnXJustPressed()
	{
		return(_currentValues.getIsDriverBlueBtnXPressed()
    				&& !_previousValues.getIsDriverBlueBtnXPressed());
	}
	
	public boolean getIsDriverYellowBtnYJustPressed()
	{
		return(_currentValues.getIsDriverYellowBtnYPressed()
    				&& !_previousValues.getIsDriverYellowBtnYPressed());
	}

	public boolean getIsDriverLeftBumperBtnJustPressed()
	{
		return(_currentValues.getIsDriverLeftBumperBtnPressed()
    				&& !_previousValues.getIsDriverLeftBumperBtnPressed());
	}
	
	public boolean getIsDriverRightBumperBtnJustPressed()
	{
		return(_currentValues.getIsDriverRightBumperBtnPressed()
    				&& !_previousValues.getIsDriverRightBumperBtnPressed());
	}

	public boolean getIsDriverBackBtnJustPressed()
	{
		return(_currentValues.getIsDriverBackBtnPressed()
    				&& !_previousValues.getIsDriverBackBtnPressed());
	}

	public boolean getIsDriverStartBtnJustPressed()
	{
		return (_currentValues.getIsDriverStartBtnPressed()
    				&& !_previousValues.getIsDriverStartBtnPressed());
	}
	
	// Instantaneous Driver Buttons
	public boolean getIsDriverGreenBtnAPressed()
	{
		return _currentValues.getIsDriverGreenBtnAPressed();
	}
	
	public boolean getIsDriverRedBtnBPressed()
	{
		return _currentValues.getIsDriverRedBtnBPressed();
	}
	
	public boolean getIsDriverBlueBtnXPressed()
	{
		return _currentValues.getIsDriverBlueBtnXPressed();
    }
	
	public boolean getIsDriverYellowBtnYPressed()
	{
		return _currentValues.getIsDriverYellowBtnYPressed();
    }

	public boolean getIsDriverLeftBumperBtnPressed()
	{
		return _currentValues.getIsDriverLeftBumperBtnPressed();
    }
	
	public boolean getIsDriverRightBumperBtnPressed()
	{
		return _currentValues.getIsDriverRightBumperBtnPressed();
    };

	public boolean getIsDriverBackBtnPressed()
	{
		return _currentValues.getIsDriverBackBtnPressed();
    }

	public boolean getIsDriverStartBtnPressed()
	{
		return _currentValues.getIsDriverStartBtnPressed();
	}
	
	// === operator buttons ===============================================
	
	public boolean getIsOperatorGreenBtnAJustPressed()
	{
		return(_currentValues.getIsOperatorGreenBtnAPressed()
    				&& !_previousValues.getIsOperatorGreenBtnAPressed());
	}
	
	public boolean getIsOperatorRedBtnBJustPressed()
	{
		return(_currentValues.getIsOperatorRedBtnBPressed()
    				&& !_previousValues.getIsOperatorRedBtnBPressed());
	}
	
	public boolean getIsOperatorBlueBtnXJustPressed()
	{
		return(_currentValues.getIsOperatorBlueBtnXPressed()
    				&& !_previousValues.getIsOperatorRedBtnBPressed());
	}
	
	public boolean getIsOperatorYellowBtnYJustPressed()
	{
		return(_currentValues.getIsOperatorYellowBtnYPressed()
    				&& !_previousValues.getIsOperatorYellowBtnYPressed());
	}

	public boolean getIsOperatorLeftBumperBtnJustPressed()
	{
		return(_currentValues.getIsOperatorLeftBumperBtnPressed()
    				&& !_previousValues.getIsOperatorLeftBumperBtnPressed());
	}
	
	public boolean getIsOperatorRightBumperBtnJustPressed()
	{
		return(_currentValues.getIsOperatorRightBumperBtnPressed()
    				&& !_previousValues.getIsOperatorRightBumperBtnPressed());
	}

	public boolean getIsOperatorBackBtnJustPressed()
	{
		return(_currentValues.getIsOperatorBackBtnPressed()
    				&& !_previousValues.getIsOperatorBackBtnPressed());
	}

	public boolean getIsOperatorStartBtnJustPressed()
	{
		return (_currentValues.getIsOperatorStartBtnPressed()
    				&& !_previousValues.getIsOperatorStartBtnPressed());
	}
	
	//Instantaneous Operator Buttons
	public boolean getIsOperatorGreenBtnAPressed()
	{
		return(_currentValues.getIsOperatorGreenBtnAPressed());
	}
	
	public boolean getIsOperatorRedBtnBPressed()
	{
		return(_currentValues.getIsOperatorRedBtnBPressed());
	}
	
	public boolean getIsOperatorBlueBtnXPressed()
	{
		return(_currentValues.getIsOperatorBlueBtnXPressed());
	}
	
	public boolean getIsOperatorYellowBtnYPressed()
	{
		return(_currentValues.getIsOperatorYellowBtnYPressed());
	}

	public boolean getIsOperatorLeftBumperBtnPressed()
	{
		return(_currentValues.getIsOperatorLeftBumperBtnPressed());
	}
	
	public boolean getIsOperatorRightBumperBtnPressed()
	{
		return(_currentValues.getIsOperatorRightBumperBtnPressed());
	}

	public boolean getIsOperatorBackBtnPressed()
	{
		return(_currentValues.getIsOperatorBackBtnPressed());
	}

	public boolean getIsOperatorStartBtnPressed()
	{
		return (_currentValues.getIsOperatorStartBtnPressed());
	}
	
	// === driver joysticks ===============================================
	public double getDriverLeftXAxisCmd()
	{
		return _currentValues.getDriverLeftXAxisCmd();
	}
	
	public double getDriverLeftYAxisCmd()
	{
		return _currentValues.getDriverLeftYAxisCmd();
	}

	public double getDriverLeftTriggerCmd()
	{
		return _currentValues.getDriverLeftTriggerCmd();
	}

	public double getDriverRightTriggerCmd()
	{
		return _currentValues.getDriverRightTriggerCmd();
	}

	public double getDriverRightXAxisCmd()
	{
		return _currentValues.getDriverRightXAxisCmd();
	}

	public double getDriverRightYAxisCmd()
	{
		return _currentValues.getDriverRightYAxisCmd();
	}
	
	// === operator joysticks ===============================================
	public double getOperatorLeftXAxisCmd()
	{
		return _currentValues.getOperatorLeftXAxisCmd();
	}
	
	public double getOperatorLeftYAxisCmd()
	{
		return _currentValues.getOperatorLeftYAxisCmd();
	}

	public double getOperatorLeftTriggerCmd()
	{
		return _currentValues.getOperatorLeftTriggerCmd();
	}

	public double getOperatorRightTriggerCmd()
	{
		return _currentValues.getOperatorRightTriggerCmd();
	}

	public double getOperatorRightXAxisCmd()
	{
		return _currentValues.getOperatorRightXAxisCmd();
	}

	public double getOperatorRightYAxisCmd()
	{
		return _currentValues.getOperatorRightYAxisCmd();
	}
	
	
	
	/**
	 * 
	 * Immutable class to hold data read from the gamepads
	 *
	 */
	public final class DriversStationInputs
	{
		// =============================
		// private backing fields
		// =============================
		
		// digital inputs
    	private final boolean _isDriverGreenBtnAPressed;
    	private final boolean _isDriverRedBtnBPressed;
    	private final boolean _isDriverBlueBtnXPressed;
    	private final boolean _isDriverYellowBtnYPressed;
    	private final boolean _isDriverLeftBumperBtnPressed;
    	private final boolean _isDriverRightBumperBtnPressed;
    	private final boolean _isDriverBackBtnPressed;
    	private final boolean _isDriverStartBtnPressed;
    	
    	private final boolean _isOperatorGreenBtnAPressed;
    	private final boolean _isOperatorRedBtnBPressed;
    	private final boolean _isOperatorBlueBtnXPressed;
    	private final boolean _isOperatorYellowBtnYPressed;
    	private final boolean _isOperatorLeftBumperBtnPressed;
    	private final boolean _isOperatorRightBumperBtnPressed;
    	private final boolean _isOperatorBackBtnPressed;
    	private final boolean _isOperatorStartBtnPressed;
    	
    	// analog inputs
    	// remember:	on gamepads fwd/up = -1 and rev/down = +1 so invert the values
    	private final double _driverLeftXAxisCmd;
    	private final double _driverLeftYAxisCmd;
    	private final double _driverLeftTriggerCmd;
    	private final double _driverRightTriggerCmd;
    	private final double _driverRightXAxisCmd;
    	private final double _driverRightYAxisCmd;
    	
    	private final double _operatorLeftXAxisCmd;
    	private final double _operatorLeftYAxisCmd;
    	private final double _operatorLeftTriggerCmd;
    	private final double _operatorRightTriggerCmd;
    	private final double _operatorRightXAxisCmd;
    	private final double _operatorRightYAxisCmd;
		
		/**
		 * Create an entirely new instance by reading from the Gamepads
		 * @param driverGamepad
		 * @param operatorGamepad
		 */
		protected DriversStationInputs()
		{
	    	// ==========================
	    	// get values from the gamepads
	    	// ==========================
			// digital inputs
			_isDriverGreenBtnAPressed = _driverGamepad.getRawButton(LogitechF310.GREEN_BUTTON_A);
	    	_isDriverRedBtnBPressed = _driverGamepad.getRawButton(LogitechF310.RED_BUTTON_B);
	    	_isDriverBlueBtnXPressed = _driverGamepad.getRawButton(LogitechF310.BLUE_BUTTON_X);
	    	_isDriverYellowBtnYPressed = _driverGamepad.getRawButton(LogitechF310.YELLOW_BUTTON_Y);
	    	_isDriverLeftBumperBtnPressed = _driverGamepad.getRawButton(LogitechF310.LEFT_BUMPER);
	    	_isDriverRightBumperBtnPressed = _driverGamepad.getRawButton(LogitechF310.RIGHT_BUMPER);
	    	_isDriverBackBtnPressed = _driverGamepad.getRawButton(LogitechF310.BACK_BUTTON);
	    	_isDriverStartBtnPressed = _driverGamepad.getRawButton(LogitechF310.START_BUTTON);
	    	
			_isOperatorGreenBtnAPressed = _operatorGamepad.getRawButton(LogitechF310.GREEN_BUTTON_A);
	    	_isOperatorRedBtnBPressed = _operatorGamepad.getRawButton(LogitechF310.RED_BUTTON_B);
	    	_isOperatorBlueBtnXPressed = _operatorGamepad.getRawButton(LogitechF310.BLUE_BUTTON_X);
	    	_isOperatorYellowBtnYPressed = _operatorGamepad.getRawButton(LogitechF310.YELLOW_BUTTON_Y);
	    	_isOperatorLeftBumperBtnPressed = _operatorGamepad.getRawButton(LogitechF310.LEFT_BUMPER);
	    	_isOperatorRightBumperBtnPressed = _operatorGamepad.getRawButton(LogitechF310.RIGHT_BUMPER);
	    	_isOperatorBackBtnPressed = _operatorGamepad.getRawButton(LogitechF310.BACK_BUTTON);
	    	_isOperatorStartBtnPressed = _operatorGamepad.getRawButton(LogitechF310.START_BUTTON);
			
	    	// analog inputs
	    	// remember:	on gamepads fwd/up = -1 and rev/down = +1 so invert the values
	    	_driverLeftXAxisCmd = _driverGamepad.getRawAxis(LogitechF310.LEFT_X_AXIS);
	    	_driverLeftYAxisCmd = _driverGamepad.getRawAxis(LogitechF310.LEFT_Y_AXIS);
	    	_driverLeftTriggerCmd = _driverGamepad.getRawAxis(LogitechF310.LEFT_TRIGGER);
	    	_driverRightTriggerCmd = _driverGamepad.getRawAxis(LogitechF310.RIGHT_TRIGGER);
	    	_driverRightXAxisCmd = _driverGamepad.getRawAxis(LogitechF310.RIGHT_X_AXIS);
	    	_driverRightYAxisCmd = _driverGamepad.getRawAxis(LogitechF310.RIGHT_Y_AXIS);
	    	
	    	_operatorLeftXAxisCmd = _operatorGamepad.getRawAxis(LogitechF310.LEFT_X_AXIS);
	    	_operatorLeftYAxisCmd = _operatorGamepad.getRawAxis(LogitechF310.LEFT_Y_AXIS);
	    	_operatorLeftTriggerCmd = _operatorGamepad.getRawAxis(LogitechF310.LEFT_TRIGGER);
	    	_operatorRightTriggerCmd = _operatorGamepad.getRawAxis(LogitechF310.RIGHT_TRIGGER);
	    	_operatorRightXAxisCmd = _operatorGamepad.getRawAxis(LogitechF310.RIGHT_X_AXIS);
	    	_operatorRightYAxisCmd = _operatorGamepad.getRawAxis(LogitechF310.RIGHT_Y_AXIS);
	    
		}
		
		// === driver buttons ====================================
		public boolean getIsDriverGreenBtnAPressed()
    	{
    		return _isDriverGreenBtnAPressed;
    	}
		
		public boolean getIsDriverRedBtnBPressed()
    	{
    		return _isDriverRedBtnBPressed;
    	}
		
		public boolean getIsDriverBlueBtnXPressed()
    	{
    		return _isDriverBlueBtnXPressed;
    	}
		
		public boolean getIsDriverYellowBtnYPressed()
    	{
    		return _isDriverYellowBtnYPressed;
    	}

		public boolean getIsDriverLeftBumperBtnPressed()
    	{
    		return _isDriverLeftBumperBtnPressed;
    	}

		public boolean getIsDriverRightBumperBtnPressed()
    	{
    		return _isDriverRightBumperBtnPressed;
    	}
		
		public boolean getIsDriverBackBtnPressed()
    	{
    		return _isDriverBackBtnPressed;
    	}

		public boolean getIsDriverStartBtnPressed()
    	{
    		return _isDriverStartBtnPressed;
    	}
		
		// === operator buttons ====================================
		public boolean getIsOperatorGreenBtnAPressed()
    	{
    		return _isOperatorGreenBtnAPressed;
    	}
		
		public boolean getIsOperatorRedBtnBPressed()
    	{
    		return _isOperatorRedBtnBPressed;
    	}
		
		public boolean getIsOperatorBlueBtnXPressed()
    	{
    		return _isOperatorBlueBtnXPressed;
    	}
		
		public boolean getIsOperatorYellowBtnYPressed()
    	{
    		return _isOperatorYellowBtnYPressed;
    	}

		public boolean getIsOperatorLeftBumperBtnPressed()
    	{
    		return _isOperatorLeftBumperBtnPressed;
    	}

		public boolean getIsOperatorRightBumperBtnPressed()
    	{
    		return _isOperatorRightBumperBtnPressed;
    	}
		
		public boolean getIsOperatorBackBtnPressed()
    	{
    		return _isOperatorBackBtnPressed;
    	}

		public boolean getIsOperatorStartBtnPressed()
    	{
    		return _isOperatorStartBtnPressed;
    	}
		
		// === driver joysticks ====================================
		
    	// remember:	on gamepads fwd/up = -1 and rev/down = +1 so invert the values
    	public double getDriverLeftXAxisCmd()
    	{
    		if(Math.abs(_driverLeftXAxisCmd) > JOYSTICK_THRESHHOLD)
    		{
    			return (_driverLeftXAxisCmd);
    		}
    		else
    		{
    			return 0.0;
    		}
    	}
		
    	public double getDriverLeftYAxisCmd()
    	{
    		if(Math.abs(_driverLeftYAxisCmd) > JOYSTICK_THRESHHOLD)
    		{
    			return _driverLeftYAxisCmd;
    		}
    		else
    		{
    			return 0.0;
    		}
    	}

    	public double getDriverLeftTriggerCmd()
    	{
    		if(Math.abs(_driverLeftTriggerCmd) > JOYSTICK_THRESHHOLD)
    		{
    			return _driverLeftTriggerCmd;
    		}
    		else
    		{
    			return 0.0;
    		}
    	}

    	public double getDriverRightTriggerCmd()
    	{
    		if(Math.abs(_driverRightTriggerCmd) > JOYSTICK_THRESHHOLD)
    		{
    			return _driverRightTriggerCmd;
    		}
    		else
    		{
    			return 0.0;
    		}
    	}

    	public double getDriverRightXAxisCmd()
    	{
    		if(Math.abs(_driverRightXAxisCmd) > JOYSTICK_THRESHHOLD)
    		{
    			return _driverRightXAxisCmd;
    		}
    		else
    		{
    			return 0.0;
    		}
    	}
    	
    	public double getDriverRightYAxisCmd()
    	{
    		if(Math.abs(_driverRightYAxisCmd) > JOYSTICK_THRESHHOLD)
    		{
    			return _driverRightYAxisCmd;
    		}
    		else
    		{
    			return 0.0;
    		}
    	}
    	
		// === operator joysticks ====================================
    	public double getOperatorLeftXAxisCmd()
    	{
    		if(Math.abs(_operatorLeftXAxisCmd) > JOYSTICK_THRESHHOLD)
    		{
    			return (_operatorLeftXAxisCmd);
    		}
    		else
    		{
    			return 0.0;
    		}
    	}
		
    	public double getOperatorLeftYAxisCmd()
    	{
    		if(Math.abs(_operatorLeftYAxisCmd) > JOYSTICK_THRESHHOLD)
    		{
    			return _operatorLeftYAxisCmd;
    		}
    		else
    		{
    			return 0.0;
    		}
    	}

    	public double getOperatorLeftTriggerCmd()
    	{
    		if(Math.abs(_operatorLeftTriggerCmd) > JOYSTICK_THRESHHOLD)
    		{
    			return _operatorLeftTriggerCmd;
    		}
    		else
    		{
    			return 0.0;
    		}
    	}

    	public double getOperatorRightTriggerCmd()
    	{
    		if(Math.abs(_operatorRightTriggerCmd) > JOYSTICK_THRESHHOLD)
    		{
    			return _operatorRightTriggerCmd;
    		}
    		else
    		{
    			return 0.0;
    		}
    	}

    	public double getOperatorRightXAxisCmd()
    	{
    		if(Math.abs(_operatorRightXAxisCmd) > JOYSTICK_THRESHHOLD)
    		{
    			return _operatorRightXAxisCmd;
    		}
    		else
    		{
    			return 0.0;
    		}
    	}
    	
    	public double getOperatorRightYAxisCmd()
    	{
    		if(Math.abs(_operatorRightYAxisCmd) > JOYSTICK_THRESHHOLD)
    		{
    			return _operatorRightYAxisCmd;
    		}
    		else
    		{
    			return 0.0;
    		}
    	}	    	
	}
}
