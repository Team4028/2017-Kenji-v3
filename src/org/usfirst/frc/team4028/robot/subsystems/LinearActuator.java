package org.usfirst.frc.team4028.robot.subsystems;

import org.usfirst.frc.team4028.robot.constants.RobotMap;

import edu.wpi.first.wpilibj.Servo;

public class LinearActuator {
	
	//====Define Robot Objects
	Servo _linearActuator;
	
	//====Define working and state variables
		public double _currentPosition = _linearActuator.getPosition();
	
public LinearActuator (int pwmPort)
{
	_linearActuator = new Servo(pwmPort);
}
	public void InitialConfig() {
		
		_linearActuator.set(0.3);
	}
	
	public void UpOne(){
		if (_linearActuator.getPosition() < RobotMap.MAX_THRESHOLD)
		{
			_linearActuator.setPosition(_currentPosition + RobotMap.CHANGE_INTERVAL);
		}
		else
		{
			System.out.println("Error: Actuator cannot be inreased, already at maximum value");
		}
	}
	
	public void DownOne(){
		if (_linearActuator.getPosition() > RobotMap.MIN_THRESHOLD)
		{
			_linearActuator.setPosition(_currentPosition - RobotMap.CHANGE_INTERVAL);
		}
		else 
		{
			System.out.println("Error: Actuator cannot be decreased, already at minumum value.");
		}
	}
	

}
