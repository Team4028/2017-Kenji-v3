package org.usfirst.frc.team4028.robot.subsystems;

import org.usfirst.frc.team4028.robot.constants.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Servo;


public class LinearActuator 
{
	Servo _linearActuator;
	public double _currentPosition;
	
	public LinearActuator (int pwmPort)
	{
		_linearActuator = new Servo(pwmPort);
		_currentPosition = _linearActuator.get();
		DriverStation.reportWarning("Position " + _currentPosition, true);
	}
	
	public void InitialConfig() 
	{	
		_linearActuator.set(0.4);
	}
	
	public void UpOne()
	{
		DriverStation.reportWarning("Up", true);
		if (_currentPosition < RobotMap.MAX_THRESHOLD)
		{
			_linearActuator.set(_currentPosition + RobotMap.CHANGE_INTERVAL);
		}
		else
		{
			System.out.println("Error: Actuator cannot be inreased, already at maximum value");
		}
	}
	
	public void DownOne()
	{
		DriverStation.reportWarning("Down", true);
		if (_currentPosition > RobotMap.MIN_THRESHOLD)
		{
			_linearActuator.set(_currentPosition - RobotMap.CHANGE_INTERVAL);
		}
		else 
		{
			System.out.println("Error: Actuator cannot be decreased, already at minumum value.");
		}
	}
}
