package org.usfirst.frc.team4028.robot.subsystems;

import org.usfirst.frc.team4028.robot.Utilities;
import org.usfirst.frc.team4028.robot.constants.MotorConfigEnums.MOTOR_MODE;

import com.ctre.*;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.FeedbackDeviceStatus;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// This class defines the behavior of a standalone DC Motor
public class DCMotor 
{
	// ===================================
	// define robot objects
	// ===================================
	private CANTalon _dcMotor;
	
	// ===================================
	// define working & state variables
	// ===================================
	private double _lastCycleSpeedCmdClamped;
	private String _motorName;
	private Boolean _isMotorReversed;
	private Boolean _isBrakeModeEnabled;
	private int _targetRPM;
	private MOTOR_MODE _motorMode;
	
	// ===================================
	// Constructors follow
	// ===================================
	public DCMotor(String motorName, int talonCanBusAddr, boolean isMotorReversed, boolean isBrakeModeEnabled, 
					MOTOR_MODE motorMode, double pidFGain, double pidPGain, double pidIGain, double pidDGain)
	{
		_motorName = motorName;
		_isMotorReversed = isMotorReversed;
		_isBrakeModeEnabled = isBrakeModeEnabled;
		_motorMode = motorMode;
		
		_dcMotor = new CANTalon(talonCanBusAddr);
		_dcMotor.enableBrakeMode(_isBrakeModeEnabled);						
		_dcMotor.enableLimitSwitch(false, false);					// disable limit switches
		
    	//_dcMotor.reverseOutput(true);								// only applies to closed loop mode
    	//_dcMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);	// set encoder to be feedback device
		//_dcMotor.reverseSensor(false);  							// do not invert encoder feedback
		
		_dcMotor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		
		if(isMotorReversed)
		{
			_dcMotor.reverseSensor(true);
		}
		else
		{
			_dcMotor.reverseSensor(false);
		}
		
		if(motorMode == MOTOR_MODE.ENABLED_PID_MODE)
		{
			// setup PID MODE
			_dcMotor.changeControlMode(TalonControlMode.Speed);		// Constant Velocity Mode
			_dcMotor.set(0);										// always immediately 0 the output when changing modes
	
			// no minimum bias offset reqd
			_dcMotor.configNominalOutputVoltage(+0.0f, -0.0f);
			
			// do not drive the motor in the opposite direction if overspeed
			if(isMotorReversed)
			{
				_dcMotor.configPeakOutputVoltage(0.0f, -12.0f);
			}
			else
			{
				_dcMotor.configPeakOutputVoltage(12.0f, 0.0f);
			}
			
			_dcMotor.setAllowableClosedLoopErr(0);
			
	        /* set closed loop gains in slot0 */
			_dcMotor.setProfile(0);
			_dcMotor.setF(pidFGain);
			_dcMotor.setP(pidPGain); //0.22);
			_dcMotor.setI(pidIGain); 
			_dcMotor.setD(pidDGain);
		}
		else
		{
			// Setup % VBus Mode
			_dcMotor.changeControlMode(TalonControlMode.PercentVbus);		// open loop throttle
			_dcMotor.set(0.0);												// always immediately 0 the output when changing modes
		}
		
		// optionally zero the encoder if present
		if(getIsFeedbackSensorConnected())
		{
			// reset the position to 0
			_dcMotor.setPosition(0);
		}
	}
	
	//============================================================================================
	// Methods follow (methods make the robot do something (ie: push changes to the robot hardware)
	//============================================================================================
	
	// This is the main drive method
	public void RunMotorVBusMode(double newSpeedCmdRaw)
	{				
		// scale speed
		double newSpeedCmdClamped = Utilities.ClampValue(newSpeedCmdRaw, -1.0, 1.0);
		
		// optionally reverse cmd
		if(_isMotorReversed)
		{
			newSpeedCmdClamped = newSpeedCmdClamped * -1.0;
		}
		
		// send cmd to mtr controller
		_dcMotor.set(newSpeedCmdClamped);
		
		// snapshot the current command
		_lastCycleSpeedCmdClamped = newSpeedCmdClamped;
	}
	
	public void RunMotorConstantVMode(int targetRPM)
	{
		_targetRPM = targetRPM;
		
		if(_isMotorReversed)
		{
			_targetRPM = _targetRPM * -1;
		}
		
		// send cmd to mtr controller
		_dcMotor.set(_targetRPM);
	}
	
	public void StopMotor()
	{
		if(_motorMode == MOTOR_MODE.ENABLED_PID_MODE)
		{
			RunMotorConstantVMode(0);
		}
		else
		{
			RunMotorVBusMode(0.0);
		}
	}
	
	public void outputToSmartDashboard()
	{
		String outData = "?";

		
		switch (_motorMode)
		{
			case ENABLED_ANALOG_MODE:
			case ENABLED_DIGITAL_MODE:
				outData = String.format( "%.2f", getCurrentActualSpeedPercent());
				if(getIsFeedbackSensorConnected())
				{
					outData = outData + String.format(" (%.0f RPM)", getCurrentActualRPM());
				}
				break;
				
			case ENABLED_PID_MODE:
				//double error = getRPMErrorPercent(); //((getCurrentCmdRPM() - getCurrentActualRPM()) / getCurrentCmdRPM()) * 100.0 * -1.0;
				outData = String.format( "%.0f RPM (%.2f%%)", getCurrentActualRPM(), getRPMErrorPercent());
				break;
		}
		
		SmartDashboard.putString(_motorName + "_Actual", outData);

	}
	
	//============================================================================================
	// Property Accessors follow (properties only change internal state) (ie: DO NOT push changes to the robot hardware)
	//============================================================================================
	
	public double getCurrentSpeedCmdClamped()
	{
		return _lastCycleSpeedCmdClamped;
	}
	
	public String getMotorName()
	{
		return _motorName;
	}
	
	public Boolean getIsMotorReversed()
	{
		return _isMotorReversed;
	}
	
	public Boolean getIsBrakeModeEnabled()
	{
		return _dcMotor.getBrakeEnableDuringNeutral();
	}
	
	public double getCurrentActualSpeedPercent()
	{
		double currentOutputVoltage = _dcMotor.getOutputVoltage();
		double currentBusVoltage = _dcMotor.getBusVoltage();
		
		double currentActualSpeed = (currentOutputVoltage / currentBusVoltage);
		
		return Utilities.RoundDouble(currentActualSpeed, 2);
	}
	
	public double getCurrentCmdRPM()
	{
		return _targetRPM;
	}

	public double getCurrentActualRPM()
	{
		return _dcMotor.getSpeed();
	}
	
	public boolean getIsFeedbackSensorConnected()
	{
		return (_dcMotor.isSensorPresent(FeedbackDevice.CtreMagEncoder_Relative) 
					== FeedbackDeviceStatus.FeedbackStatusPresent);
	}
	
	public double getRPMErrorPercent()
	{
		if(Math.abs(getCurrentCmdRPM()) > 0 )
		{		
			return ((getCurrentCmdRPM() - getCurrentActualRPM()) / getCurrentCmdRPM()) * 100.0 * -1.0;
		}
		else
		{
			return 0.0;
		}
	}
}
