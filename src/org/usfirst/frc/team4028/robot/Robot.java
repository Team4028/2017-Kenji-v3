
package org.usfirst.frc.team4028.robot;

import org.usfirst.frc.team4028.robot.constants.MotorConfigEnums.ANALOG_MODE_JOYSTICK;
import org.usfirst.frc.team4028.robot.constants.MotorConfigEnums.DIGITAL_MODE_BUTTON;
import org.usfirst.frc.team4028.robot.constants.MotorConfigEnums.MOTOR_MODE;

import java.util.Date;

import org.usfirst.frc.team4028.robot.constants.RobotMap;
import org.usfirst.frc.team4028.robot.subsystems.DCMotor;
import org.usfirst.frc.team4028.robot.subsystems.DashboardInputs;
import org.usfirst.frc.team4028.robot.subsystems.DashboardInputs.TestMotorConfig;
import org.usfirst.frc.team4028.robot.subsystems.DriversStation;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Utility;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot 
{
	// ===========================================================
	//   Define class level instance variables for Robot Runtime controllable objects  
	// ===========================================================
	private DriversStation _driversStation;
	private DashboardInputs _dashboardInputs;
	
	private DCMotor _dcMotor1;
	private DCMotor _dcMotor2;
	private DCMotor _dcMotor3;
	private DCMotor _dcMotor4;
	private DCMotor _dcMotor5;
	private DCMotor _dcMotor6;
	
	// Wrapper around data logging (if it is enabled)
	private DataLogger _dataLogger;
	// DTO (Data Transfer Object) holding all live Robot Data Values
	private LogData _liveLogData;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() 
    {
        //===================
    	// write jar (build) date & time to the dashboard
        //===================
    	Utilities.WriteBuildInfoToDashboard("SmartKenji 3.0");
    	
    	//====================================================
    	// create instances of all of the Robot SubSystems
    	//====================================================   	
    	_driversStation = new  DriversStation(RobotMap.DRIVER_GAMEPAD_USB_PORT, RobotMap.OPERATOR_GAMEPAD_USB_PORT);
    	_dashboardInputs = new DashboardInputs();
    }
    
    /*
     *****************************************************************************************************
     * This function is called 1x each time the robot enters autonomous mode
     *  (setup the initial robot state for autonomous mode)
     *****************************************************************************************************
     */
    public void autonomousInit() 
    {
    	// No Auton Mode
    }

    /*
     * *****************************************************************************************************
     * This function is called periodically during autonomous
     * *****************************************************************************************************
     */
    public void autonomousPeriodic() 
    {
    	// No Auton Mode
    }

    /*
     *****************************************************************************************************
     * This function is called 1x each time the robot enters tele-operated mode
     *  (setup the initial robot state for teleop mode)
     *****************************************************************************************************
     */
    public void teleopInit() 
    {        
    	// =====================================
    	// Step 1: Get the DASHBOARD Input values at the start of Telop
    	// =====================================
    	_dashboardInputs.ReadMotorCfgValues();
    	
    	// =====================================
    	// Step 2: Optionally Configure Each Motor 
    	// =====================================
    	
    	// ----------------
        // 2.1 ===> Motor 1
    	// ----------------
        if(_dashboardInputs.getMotor1Configuration().MotorMode == MOTOR_MODE.ENABLED_ANALOG_MODE 
        		|| _dashboardInputs.getMotor1Configuration().MotorMode == MOTOR_MODE.ENABLED_DIGITAL_MODE
        		|| _dashboardInputs.getMotor1Configuration().MotorMode == MOTOR_MODE.ENABLED_PID_MODE)
        {
        	_dcMotor1 = new DCMotor("Motor1", 
        								RobotMap.DC_MOTOR_1_CAN_ADDR, 
        								_dashboardInputs.getMotor1Configuration().IsMotorDirectionReversed, 
        								_dashboardInputs.getMotor1Configuration().IsBrakeModeEnabled,
        								_dashboardInputs.getMotor1Configuration().MotorMode,
	       								 RobotMap.DC_MOTOR_1_PID_F_GAIN,
	       								 RobotMap.DC_MOTOR_1_PID_P_GAIN,
	       								 RobotMap.DC_MOTOR_1_PID_I_GAIN,
	       								 RobotMap.DC_MOTOR_1_PID_D_GAIN);
        	
        	System.out.println("..Motor 1 Configured for " + _dashboardInputs.getMotor1Configuration().MotorMode + " mode!");
        }
        else
        {
        	if(_dcMotor1 != null)
        	{
        		_dcMotor1.StopMotor();
        	}
        	_dcMotor1 = null;
        	
        	System.out.println("....Motor 1 disabled!");
        }
    	
    	// ----------------
        // 2.2 ===> Motor 2
    	// ----------------
        if(_dashboardInputs.getMotor2Configuration().MotorMode == MOTOR_MODE.ENABLED_ANALOG_MODE 
        		|| _dashboardInputs.getMotor2Configuration().MotorMode == MOTOR_MODE.ENABLED_DIGITAL_MODE
        		|| _dashboardInputs.getMotor2Configuration().MotorMode == MOTOR_MODE.ENABLED_PID_MODE)
        {
        	_dcMotor2 = new DCMotor("Motor2", 
        								RobotMap.DC_MOTOR_2_CAN_ADDR, 
        								_dashboardInputs.getMotor2Configuration().IsMotorDirectionReversed, 
        								_dashboardInputs.getMotor2Configuration().IsBrakeModeEnabled,
        								_dashboardInputs.getMotor2Configuration().MotorMode,
	       								 RobotMap.DC_MOTOR_2_PID_F_GAIN,
	       								 RobotMap.DC_MOTOR_2_PID_P_GAIN,
	       								 RobotMap.DC_MOTOR_2_PID_I_GAIN,
	       								 RobotMap.DC_MOTOR_2_PID_D_GAIN);
        
        	System.out.println("..Motor 2 Configured for " + _dashboardInputs.getMotor2Configuration().MotorMode + " mode!");
        }
        else
        {
        	if(_dcMotor2 != null)
        	{
        		_dcMotor2.StopMotor();
        	}
        	_dcMotor2 = null;
        	
        	System.out.println("....Motor 2 disabled!");
        }
        
    	// ----------------
        // 2.3 ===> Motor 3
    	// ----------------
        if(_dashboardInputs.getMotor3Configuration().MotorMode == MOTOR_MODE.ENABLED_ANALOG_MODE 
        		|| _dashboardInputs.getMotor3Configuration().MotorMode == MOTOR_MODE.ENABLED_DIGITAL_MODE)
        {
        	_dcMotor3 = new DCMotor("Motor3", 
        								RobotMap.DC_MOTOR_3_CAN_ADDR, 
        								_dashboardInputs.getMotor3Configuration().IsMotorDirectionReversed, 
        								_dashboardInputs.getMotor3Configuration().IsBrakeModeEnabled,
        								_dashboardInputs.getMotor3Configuration().MotorMode,
	       								 RobotMap.DC_MOTOR_X_PID_F_GAIN,
	       								 RobotMap.DC_MOTOR_X_PID_P_GAIN,
	       								 RobotMap.DC_MOTOR_X_PID_I_GAIN,
	       								 RobotMap.DC_MOTOR_X_PID_D_GAIN);
        
        	System.out.println("..Motor 3 Configured for " + _dashboardInputs.getMotor3Configuration().MotorMode + " mode!");
        }
        else if(_dashboardInputs.getMotor3Configuration().MotorMode == MOTOR_MODE.ENABLED_PID_MODE)
        {
			DriverStation.reportError("Motor 3 is NOT configured to support PID at this time", false);
        }
        else
        {
        	if(_dcMotor3 != null)
        	{
        		_dcMotor3.StopMotor();
        	}
        	_dcMotor3 = null;
        	
        	System.out.println("....Motor 3 disabled!");
        }
        
    	// ----------------
        // 2.4 ===> Motor 4
    	// ----------------
        if(_dashboardInputs.getMotor4Configuration().MotorMode == MOTOR_MODE.ENABLED_ANALOG_MODE 
        		|| _dashboardInputs.getMotor4Configuration().MotorMode == MOTOR_MODE.ENABLED_DIGITAL_MODE)
        {
        	_dcMotor4 = new DCMotor("Motor4", 
        								RobotMap.DC_MOTOR_4_CAN_ADDR, 
        								_dashboardInputs.getMotor4Configuration().IsMotorDirectionReversed, 
        								_dashboardInputs.getMotor4Configuration().IsBrakeModeEnabled,
        								_dashboardInputs.getMotor4Configuration().MotorMode,
	       								 RobotMap.DC_MOTOR_X_PID_F_GAIN,
	       								 RobotMap.DC_MOTOR_X_PID_P_GAIN,
	       								 RobotMap.DC_MOTOR_X_PID_I_GAIN,
	       								 RobotMap.DC_MOTOR_X_PID_D_GAIN);
        
        	System.out.println("..Motor 4 Configured for " + _dashboardInputs.getMotor4Configuration().MotorMode + " mode!");
        }
        else if(_dashboardInputs.getMotor3Configuration().MotorMode == MOTOR_MODE.ENABLED_PID_MODE)
        {
        	DriverStation.reportError("Motor 4 is NOT configured to support PID at this time", false);
        }
        else
        {
        	if(_dcMotor4 != null)
        	{
        		_dcMotor4.StopMotor();
        	}
        	_dcMotor4 = null;
        	
        	System.out.println("....Motor 4 disabled!");
        }
        
    	// ----------------
        // 2.5 ===> Motor 5
    	// ----------------
        if(_dashboardInputs.getMotor5Configuration().MotorMode == MOTOR_MODE.ENABLED_ANALOG_MODE 
        		|| _dashboardInputs.getMotor5Configuration().MotorMode == MOTOR_MODE.ENABLED_DIGITAL_MODE)
        {
        	_dcMotor5 = new DCMotor("Motor5", 
        								RobotMap.DC_MOTOR_5_CAN_ADDR, 
        								_dashboardInputs.getMotor5Configuration().IsMotorDirectionReversed, 
        								_dashboardInputs.getMotor5Configuration().IsBrakeModeEnabled,
        								_dashboardInputs.getMotor5Configuration().MotorMode,
	       								 RobotMap.DC_MOTOR_X_PID_F_GAIN,
	       								 RobotMap.DC_MOTOR_X_PID_P_GAIN,
	       								 RobotMap.DC_MOTOR_X_PID_I_GAIN,
	       								 RobotMap.DC_MOTOR_X_PID_D_GAIN);
        
        	System.out.println("..Motor 5 Configured for " + _dashboardInputs.getMotor5Configuration().MotorMode + " mode!");
        }
        else if(_dashboardInputs.getMotor3Configuration().MotorMode == MOTOR_MODE.ENABLED_PID_MODE)
        {
        	DriverStation.reportError("Motor 5 is NOT configured to support PID at this time", false);
        }
        else
        {
        	if(_dcMotor5 != null)
        	{
        		_dcMotor5.StopMotor();
        	}
        	_dcMotor5 = null;
        	
        	System.out.println("....Motor 5 disabled!");
        }
        
    	// ----------------
        // 2.6 ===> Motor 6
    	// ----------------
        if(_dashboardInputs.getMotor6Configuration().MotorMode == MOTOR_MODE.ENABLED_ANALOG_MODE 
        		|| _dashboardInputs.getMotor6Configuration().MotorMode == MOTOR_MODE.ENABLED_DIGITAL_MODE)
        {
        	_dcMotor6 = new DCMotor("Motor5", 
        								RobotMap.DC_MOTOR_6_CAN_ADDR, 
        								_dashboardInputs.getMotor6Configuration().IsMotorDirectionReversed, 
        								_dashboardInputs.getMotor6Configuration().IsBrakeModeEnabled,
        								_dashboardInputs.getMotor6Configuration().MotorMode,
	       								 RobotMap.DC_MOTOR_X_PID_F_GAIN,
	       								 RobotMap.DC_MOTOR_X_PID_P_GAIN,
	       								 RobotMap.DC_MOTOR_X_PID_I_GAIN,
	       								 RobotMap.DC_MOTOR_X_PID_D_GAIN);
        
        	System.out.println("..Motor 6 Configured for " + _dashboardInputs.getMotor6Configuration().MotorMode + " mode!");
        }
        else if(_dashboardInputs.getMotor3Configuration().MotorMode == MOTOR_MODE.ENABLED_PID_MODE)
        {
        	DriverStation.reportError("Motor 6 is NOT configured to support PID at this time", false);
        }
        else
        {
        	if(_dcMotor6 != null)
        	{
        		_dcMotor6.StopMotor();
        	}
        	_dcMotor6 = null;
        	
        	System.out.println("....Motor 6 disabled!");
        }
        
    	// =====================================
    	// Step 3: Optionally Configure Logging
    	// =====================================
        _liveLogData = new LogData();
    	_dataLogger = Utilities.setupLogging("teleop", _liveLogData);
    }
    
    /*
     * ****************************************************************************************************
     * This function is called periodically during teleop (operator manual) mode
     * ****************************************************************************************************
     */
    public void teleopPeriodic() 
    {
    	// =====================================
    	// Step 1: Get the DASHBOARD Input values for the current scan cycle
    	// =====================================
    	_driversStation.ReadCurrentScanCycleValues();
    	
    	// =====================================
    	// Step 2: Handle each Motor
    	// =====================================
        // Motor 1
    	if(_dcMotor1 != null)
    	{
	    	switch(_dashboardInputs.getMotor1Configuration().MotorMode)
	    	{
	    		case ENABLED_ANALOG_MODE:
	    			_dcMotor1.RunMotorVBusMode(GetAnalogModeMotorCmd(_dashboardInputs.getMotor1Configuration(), _driversStation));
	    			break;
	    			
	    		case ENABLED_DIGITAL_MODE:
	    			_dcMotor1.RunMotorVBusMode(GetDigitalModeMotorCmd(_dashboardInputs.getMotor1Configuration(), _driversStation, _dcMotor1.getCurrentActualSpeedPercent()));
	    			break;
	    			
	    		case ENABLED_PID_MODE:
	    			_dcMotor1.RunMotorConstantVMode(GetConstantVModeMotorCmd(_dashboardInputs.getMotor1Configuration(), _driversStation, _dcMotor1.getCurrentCmdRPM()));
	    			break;
	    			
	    		case DISABLED:
	    			_dcMotor1.StopMotor();
	    			break;
	    	}
    	}
    	
        // Motor 2
    	if(_dcMotor2 != null)
    	{
	    	switch(_dashboardInputs.getMotor2Configuration().MotorMode)
	    	{
	    		case ENABLED_ANALOG_MODE:
	    			_dcMotor2.RunMotorVBusMode(GetAnalogModeMotorCmd(_dashboardInputs.getMotor2Configuration(), _driversStation));
	    			break;
	    			
	    		case ENABLED_DIGITAL_MODE:
	    			_dcMotor2.RunMotorVBusMode(GetDigitalModeMotorCmd(_dashboardInputs.getMotor2Configuration(), _driversStation, _dcMotor2.getCurrentActualSpeedPercent()));
	    			break;
	    			
	    		case ENABLED_PID_MODE:
	    			_dcMotor2.RunMotorConstantVMode(GetConstantVModeMotorCmd(_dashboardInputs.getMotor2Configuration(), _driversStation, _dcMotor2.getCurrentCmdRPM()));
	    			break;
	    			
	    		case DISABLED:
	    			_dcMotor2.StopMotor();
	    			break;
	    	}
    	}
    	
        // Motor 3
    	if(_dcMotor3 != null)
    	{
	    	switch(_dashboardInputs.getMotor3Configuration().MotorMode)
	    	{
	    		case ENABLED_ANALOG_MODE:
	    			_dcMotor3.RunMotorVBusMode(GetAnalogModeMotorCmd(_dashboardInputs.getMotor3Configuration(), _driversStation));
	    			break;
	    			
	    		case ENABLED_DIGITAL_MODE:
	    			_dcMotor3.RunMotorVBusMode(GetDigitalModeMotorCmd(_dashboardInputs.getMotor3Configuration(), _driversStation, _dcMotor3.getCurrentActualSpeedPercent()));
	    			break;
	    			
	    		case ENABLED_PID_MODE:
	    			_dcMotor3.RunMotorConstantVMode(GetConstantVModeMotorCmd(_dashboardInputs.getMotor3Configuration(), _driversStation, _dcMotor3.getCurrentCmdRPM()));
	    			break;
	    			
	    		case DISABLED:
	    			_dcMotor3.StopMotor();
	    			break;
	    	}
    	}
    	
        // Motor 4
    	if(_dcMotor4 != null)
    	{
	    	switch(_dashboardInputs.getMotor4Configuration().MotorMode)
	    	{
	    		case ENABLED_ANALOG_MODE:
	    			_dcMotor4.RunMotorVBusMode(GetAnalogModeMotorCmd(_dashboardInputs.getMotor4Configuration(), _driversStation));
	    			break;
	    			
	    		case ENABLED_DIGITAL_MODE:
	    			_dcMotor4.RunMotorVBusMode(GetDigitalModeMotorCmd(_dashboardInputs.getMotor4Configuration(), _driversStation, _dcMotor4.getCurrentActualSpeedPercent()));
	    			break;
	    			
	    		case ENABLED_PID_MODE:
	    			_dcMotor4.RunMotorConstantVMode(GetConstantVModeMotorCmd(_dashboardInputs.getMotor4Configuration(), _driversStation, _dcMotor4.getCurrentCmdRPM()));
	    			break;
	    			
	    		case DISABLED:
	    			_dcMotor4.StopMotor();
	    			break;
	    	}
    	}
    	
        // Motor 5
    	if(_dcMotor5 != null)
    	{
	    	switch(_dashboardInputs.getMotor5Configuration().MotorMode)
	    	{
	    		case ENABLED_ANALOG_MODE:
	    			_dcMotor5.RunMotorVBusMode(GetAnalogModeMotorCmd(_dashboardInputs.getMotor5Configuration(), _driversStation));
	    			break;
	    			
	    		case ENABLED_DIGITAL_MODE:
	    			_dcMotor5.RunMotorVBusMode(GetDigitalModeMotorCmd(_dashboardInputs.getMotor5Configuration(), _driversStation, _dcMotor5.getCurrentActualSpeedPercent()));
	    			break;
	    			
	    		case ENABLED_PID_MODE:
	    			_dcMotor5.RunMotorConstantVMode(GetConstantVModeMotorCmd(_dashboardInputs.getMotor5Configuration(), _driversStation, _dcMotor5.getCurrentCmdRPM()));
	    			break;
	    			
	    		case DISABLED:
	    			_dcMotor5.StopMotor();
	    			break;
	    	}
    	}
    	
        // Motor 6
    	if(_dcMotor6 != null)
    	{
	    	switch(_dashboardInputs.getMotor5Configuration().MotorMode)
	    	{
	    		case ENABLED_ANALOG_MODE:
	    			_dcMotor6.RunMotorVBusMode(GetAnalogModeMotorCmd(_dashboardInputs.getMotor6Configuration(), _driversStation));
	    			break;
	    			
	    		case ENABLED_DIGITAL_MODE:
	    			_dcMotor6.RunMotorVBusMode(GetDigitalModeMotorCmd(_dashboardInputs.getMotor6Configuration(), _driversStation, _dcMotor6.getCurrentActualSpeedPercent()));
	    			break;
	    			
	    		case ENABLED_PID_MODE:
	    			_dcMotor6.RunMotorConstantVMode(GetConstantVModeMotorCmd(_dashboardInputs.getMotor6Configuration(), _driversStation, _dcMotor6.getCurrentCmdRPM()));
	    			break;
	    			
	    		case DISABLED:
	    			_dcMotor6.StopMotor();
	    			break;
	    	}
    	}
    	
    	// =====================================
    	// Step 3: Refresh Dashboard
    	// =====================================
    	outputAllToSmartDashboard();
    	
    	// =============================
    	// Step 4: Optional Data Logging
    	// =============================
  	
    	if(_liveLogData.IsLoggingEnabled == true)
    	{
        	UpdateLiveLogData();
    		_dataLogger.WriteData(_liveLogData);
    		
    		// save last scan dt so we can calc delta
        	_liveLogData.LastScanDT = new Date();
    	}
    }
    
    // this method updates the data in our logging data object
    private void UpdateLiveLogData()
    {
    	_liveLogData.FPGATimeMicroSecs = Utility.getFPGATime();
    	
    	if(_dcMotor1 != null)
    	{
	    	_liveLogData.Motor1CmdVBus = _dcMotor1.getCurrentSpeedCmdClamped();
	    	_liveLogData.Motor1ActualVBus = _dcMotor1.getCurrentActualSpeedPercent();
	    	_liveLogData.Motor1CmdRPM = _dcMotor1.getCurrentCmdRPM();
	    	_liveLogData.Motor1ActualRPM = _dcMotor1.getCurrentActualRPM();
	    	_liveLogData.Motor1RPMDeltaPercent = _dcMotor1.getRPMErrorPercent();
    	}
    	
    	if(_dcMotor2 != null)
    	{
	    	_liveLogData.Motor2CmdVBus = _dcMotor2.getCurrentSpeedCmdClamped();
	    	_liveLogData.Motor2ActualVBus = _dcMotor2.getCurrentActualSpeedPercent();
	    	_liveLogData.Motor2CmdRPM = _dcMotor2.getCurrentCmdRPM();
	    	_liveLogData.Motor2ActualRPM = _dcMotor2.getCurrentActualRPM();
	    	_liveLogData.Motor2RPMDeltaPercent = _dcMotor2.getRPMErrorPercent();
    	}
    	
    	if(_dcMotor3 != null)
    	{
	    	_liveLogData.Motor3CmdVBus = _dcMotor3.getCurrentSpeedCmdClamped();
	    	_liveLogData.Motor3ActualVBus = _dcMotor3.getCurrentActualSpeedPercent();
	    	_liveLogData.Motor3CmdRPM = _dcMotor3.getCurrentCmdRPM();
	    	_liveLogData.Motor3ActualRPM = _dcMotor3.getCurrentActualRPM();
	    	_liveLogData.Motor3RPMDeltaPercent = _dcMotor3.getRPMErrorPercent();
    	}
    	
    	if(_dcMotor4 != null)
    	{
	    	_liveLogData.Motor4CmdVBus = _dcMotor4.getCurrentSpeedCmdClamped();
	    	_liveLogData.Motor4ActualVBus = _dcMotor4.getCurrentActualSpeedPercent();
	    	_liveLogData.Motor4CmdRPM = _dcMotor4.getCurrentCmdRPM();
	    	_liveLogData.Motor4ActualRPM = _dcMotor4.getCurrentActualRPM();
	    	_liveLogData.Motor4RPMDeltaPercent = _dcMotor4.getRPMErrorPercent();
    	}
    	
    	if(_dcMotor5 != null)
    	{
	    	_liveLogData.Motor5CmdVBus = _dcMotor5.getCurrentSpeedCmdClamped();
	    	_liveLogData.Motor5ActualVBus = _dcMotor5.getCurrentActualSpeedPercent();
	    	_liveLogData.Motor5CmdRPM = _dcMotor5.getCurrentCmdRPM();
	    	_liveLogData.Motor5ActualRPM = _dcMotor5.getCurrentActualRPM();
	    	_liveLogData.Motor5RPMDeltaPercent = _dcMotor5.getRPMErrorPercent();
    	}
    	
    	if(_dcMotor6 != null)
    	{
	    	_liveLogData.Motor6CmdVBus = _dcMotor6.getCurrentSpeedCmdClamped();
	    	_liveLogData.Motor6ActualVBus = _dcMotor6.getCurrentActualSpeedPercent();
	    	_liveLogData.Motor6CmdRPM = _dcMotor6.getCurrentCmdRPM();
	    	_liveLogData.Motor6ActualRPM = _dcMotor6.getCurrentActualRPM();
	    	_liveLogData.Motor6RPMDeltaPercent = _dcMotor6.getRPMErrorPercent();
    	}
    }
    
    // this method determines the command we should give to a motor in Analog (Joystick) Mode
    private double GetAnalogModeMotorCmd(TestMotorConfig motorConfig, DriversStation driversStation)
    {
    	double rawMotorCmd = 0;
    	
    	ANALOG_MODE_JOYSTICK analogModeJoyStick = motorConfig.AnalogModeJoystick;
    	
    	// get the cmd from the correct joystick
		switch(analogModeJoyStick)
		{
			case DRIVER_LEFT_X_AXIS:
				rawMotorCmd = driversStation.getDriverLeftXAxisCmd();
				break;
				
			case DRIVER_LEFT_Y_AXIS:
				rawMotorCmd = driversStation.getDriverLeftYAxisCmd();
				break;
				
			case DRIVER_RIGHT_X_AXIS:
				rawMotorCmd = driversStation.getDriverRightXAxisCmd();
				break;
				
			case DRIVER_RIGHT_Y_AXIS:
				rawMotorCmd = driversStation.getDriverRightYAxisCmd();
				break;
				
			case OPERATOR_LEFT_X_AXIS:
				rawMotorCmd = driversStation.getOperatorLeftXAxisCmd();
				break;
				
			case OPERATOR_LEFT_Y_AXIS:
				rawMotorCmd = driversStation.getOperatorLeftYAxisCmd();
				break;
				
			case OPERATOR_RIGHT_X_AXIS:
				rawMotorCmd = driversStation.getOperatorRightXAxisCmd();
				break;
				
			case OPERATOR_RIGHT_Y_AXIS:
				rawMotorCmd = driversStation.getOperatorRightYAxisCmd();
				break;
				
			default:
				break;
		}
		
		// clamp scaling factor
		double cmdScalingFactor = Utilities.ClampValue(motorConfig.CmdScalingFactor, 0.0, 1.0);
		
		// calc scaled speed
		double scaledMotorCmd = Utilities.RoundDouble((rawMotorCmd * cmdScalingFactor), 3);
		
		return scaledMotorCmd;
    }
    
    // this method determines the command we should give to a motor in Digital (Button) Mode
    private double GetDigitalModeMotorCmd(TestMotorConfig motorConfig, DriversStation driversStation, double currentActualSpeedPercent)
    {
    	double motorCmd = 0;
    	
		boolean isLatchEnabled = motorConfig.IsCmdLatchModeEnabled;
		
    	DIGITAL_MODE_BUTTON digitalModeButton = motorConfig.DigitalModeButton;
    	
    	// get the value from the correct button
    	boolean isBtnPressed = false;
    	boolean isBtnJustPressed = false;
    	switch(digitalModeButton)
    	{
    		case DRIVER_BACK_BUTTON:
    			isBtnJustPressed = driversStation.getIsDriverBackBtnJustPressed();
    			isBtnPressed = driversStation.getIsDriverBackBtnPressed();
    			break;
    			
    		case DRIVER_BLUE_BUTTON_X:
    			isBtnJustPressed = driversStation.getIsDriverBlueBtnXJustPressed();
    			isBtnPressed = driversStation.getIsDriverBlueBtnXPressed();
    			break;
    			
    		case DRIVER_GREEN_BUTTON_A:
    			isBtnJustPressed = driversStation.getIsDriverGreenBtnAJustPressed();
    			isBtnPressed = driversStation.getIsDriverGreenBtnAPressed();
    			break;
    			
    		case DRIVER_LEFT_BUMPER:
    			isBtnJustPressed = driversStation.getIsDriverLeftBumperBtnJustPressed();
    			isBtnPressed = driversStation.getIsDriverLeftBumperBtnPressed();
    			break;
    			
    		case DRIVER_LEFT_THUMBSTICK:
    			break;
    			
    		case DRIVER_RED_BUTTON_B:
    			isBtnJustPressed = driversStation.getIsDriverRedBtnBJustPressed();
    			isBtnPressed = driversStation.getIsDriverRedBtnBPressed();
    			break;
    			
    		case DRIVER_RIGHT_BUMPER:
    			isBtnJustPressed = driversStation.getIsDriverRightBumperBtnJustPressed();
    			isBtnPressed = driversStation.getIsDriverRightBumperBtnPressed();
    			break;
    			
    		case DRIVER_RIGHT_THUMBSTICK:
    			break;
    			
    		case DRIVER_START_BUTTON:
    			isBtnJustPressed = driversStation.getIsDriverStartBtnJustPressed();
    			isBtnPressed = driversStation.getIsDriverStartBtnPressed();
    			break;
    			
    		case DRIVER_YELLOW_BUTTON_Y:
    			isBtnJustPressed = driversStation.getIsDriverYellowBtnYJustPressed();
    			isBtnPressed = driversStation.getIsDriverYellowBtnYPressed();
    			break;
    			
    		case OPERATOR_BACK_BUTTON:
    			isBtnJustPressed = driversStation.getIsOperatorBackBtnJustPressed();
    			isBtnPressed = driversStation.getIsOperatorBackBtnPressed();
    			break;
    			
    		case OPERATOR_BLUE_BUTTON_X:
    			isBtnJustPressed = driversStation.getIsOperatorBlueBtnXJustPressed();
    			isBtnPressed = driversStation.getIsOperatorBlueBtnXPressed();
    			break;
    			
    		case OPERATOR_GREEN_BUTTON_A:
    			isBtnJustPressed = driversStation.getIsOperatorGreenBtnAJustPressed();
    			isBtnPressed = driversStation.getIsOperatorGreenBtnAPressed();
    			break;
    			
    		case OPERATOR_LEFT_BUMPER:
    			isBtnJustPressed = driversStation.getIsOperatorLeftBumperBtnJustPressed();
    			isBtnPressed = driversStation.getIsOperatorLeftBumperBtnPressed();
    			break;
    			
    		case OPERATOR_LEFT_THUMBSTICK:
    			break;
    			
    		case OPERATOR_RED_BUTTON_B:
    			isBtnJustPressed = driversStation.getIsOperatorRedBtnBJustPressed();
    			isBtnPressed = driversStation.getIsOperatorRedBtnBPressed();
    			break;
    			
    		case OPERATOR_RIGHT_BUMPER:
    			isBtnJustPressed = driversStation.getIsOperatorRightBumperBtnJustPressed();
    			isBtnPressed = driversStation.getIsOperatorRightBumperBtnPressed();
    			break;
    			
    		case OPERATOR_RIGHT_THUMBSTICK:
    			break;
    			
    		case OPERATOR_START_BUTTON:
    			isBtnJustPressed = driversStation.getIsOperatorStartBtnJustPressed();
    			isBtnPressed = driversStation.getIsOperatorStartBtnPressed();
    			break;
    			
    		case OPERATOR_YELLOW_BUTTON_Y:
    			isBtnJustPressed = driversStation.getIsOperatorYellowBtnYJustPressed();
    			isBtnPressed = driversStation.getIsOperatorYellowBtnYPressed();
    			break;
    			
    		default:
    			break;
    	}
    	
    	/*  Truth Table
    	 * 
    	 * isBtnJustPressed	isLatchEnabled	currentActualSpeedPercent		output
    	 * ================ ==============  ========================= 		======
    	 * 		Y				N						x					motorConfig.CmdScalingFactor
    	 * 		Y				Y			motorConfig.CmdScalingFactor	0		
    	 * 		Y				Y						0					motorConfig.CmdScalingFactor
    	 * 		N				N						x					0
    	 * 		N				Y			motorConfig.CmdScalingFactor	motorConfig.CmdScalingFactor
    	 * 		N				Y						0					0
    	 */
    	if(isLatchEnabled)
    	{
    		if(isBtnJustPressed)
    		{
    			if(Math.abs(currentActualSpeedPercent) > 0 )
    			{
        			motorCmd = 0.0;		// toggle off
    			}
        		else
        		{
        			motorCmd = motorConfig.CmdScalingFactor;	// toggle on
        		}
    		}
    		else
        	{
        		if(Math.abs(currentActualSpeedPercent) > 0 )
    			{
        			motorCmd = motorConfig.CmdScalingFactor;	// leave it on
    			}
        		else
        		{
        			motorCmd = 0.0;		// leave it off
        		}
        	}
    	}
    	else
    	{
    		if(isBtnPressed)
    		{
    			motorCmd = motorConfig.CmdScalingFactor;
    		}
    		else
    		{
    			motorCmd = 0;
    		}
    	}
		return motorCmd;
    }
    
    // this method determines the command we should give to a motor in ConstantV (PID) Mode
    private int GetConstantVModeMotorCmd(TestMotorConfig motorConfig, DriversStation driversStation, double currentActualSpeedRPM)
    {
    	int motorCmd = 0;
    	
		boolean isLatchEnabled = motorConfig.IsCmdLatchModeEnabled;
		
    	DIGITAL_MODE_BUTTON digitalModeButton = motorConfig.DigitalModeButton;
    	
    	// get the value from the correct button
    	boolean isBtnPressed = false;
    	boolean isBtnJustPressed = false;
    	switch(digitalModeButton)
    	{
    		case DRIVER_BACK_BUTTON:
    			isBtnJustPressed = driversStation.getIsDriverBackBtnJustPressed();
    			isBtnPressed = driversStation.getIsDriverBackBtnPressed();
    			break;
    			
    		case DRIVER_BLUE_BUTTON_X:
    			isBtnJustPressed = driversStation.getIsDriverBlueBtnXJustPressed();
    			isBtnPressed = driversStation.getIsDriverBlueBtnXPressed();
    			break;
    			
    		case DRIVER_GREEN_BUTTON_A:
    			isBtnJustPressed = driversStation.getIsDriverGreenBtnAJustPressed();
    			isBtnPressed = driversStation.getIsDriverGreenBtnAPressed();
    			break;
    			
    		case DRIVER_LEFT_BUMPER:
    			isBtnJustPressed = driversStation.getIsDriverLeftBumperBtnJustPressed();
    			isBtnPressed = driversStation.getIsDriverLeftBumperBtnPressed();
    			break;
    			
    		case DRIVER_LEFT_THUMBSTICK:
    			break;
    			
    		case DRIVER_RED_BUTTON_B:
    			isBtnJustPressed = driversStation.getIsDriverRedBtnBJustPressed();
    			isBtnPressed = driversStation.getIsDriverRedBtnBPressed();
    			break;
    			
    		case DRIVER_RIGHT_BUMPER:
    			isBtnJustPressed = driversStation.getIsDriverRightBumperBtnJustPressed();
    			isBtnPressed = driversStation.getIsDriverRightBumperBtnPressed();
    			break;
    			
    		case DRIVER_RIGHT_THUMBSTICK:
    			break;
    			
    		case DRIVER_START_BUTTON:
    			isBtnJustPressed = driversStation.getIsDriverStartBtnJustPressed();
    			isBtnPressed = driversStation.getIsDriverStartBtnPressed();
    			break;
    			
    		case DRIVER_YELLOW_BUTTON_Y:
    			isBtnJustPressed = driversStation.getIsDriverYellowBtnYJustPressed();
    			isBtnPressed = driversStation.getIsDriverYellowBtnYPressed();
    			break;
    			
    		case OPERATOR_BACK_BUTTON:
    			isBtnJustPressed = driversStation.getIsOperatorBackBtnJustPressed();
    			isBtnPressed = driversStation.getIsOperatorBackBtnPressed();
    			break;
    			
    		case OPERATOR_BLUE_BUTTON_X:
    			isBtnJustPressed = driversStation.getIsOperatorBlueBtnXJustPressed();
    			isBtnPressed = driversStation.getIsOperatorBlueBtnXPressed();
    			break;
    			
    		case OPERATOR_GREEN_BUTTON_A:
    			isBtnJustPressed = driversStation.getIsOperatorGreenBtnAJustPressed();
    			isBtnPressed = driversStation.getIsOperatorGreenBtnAPressed();
    			break;
    			
    		case OPERATOR_LEFT_BUMPER:
    			isBtnJustPressed = driversStation.getIsOperatorLeftBumperBtnJustPressed();
    			isBtnPressed = driversStation.getIsOperatorLeftBumperBtnPressed();
    			break;
    			
    		case OPERATOR_LEFT_THUMBSTICK:
    			break;
    			
    		case OPERATOR_RED_BUTTON_B:
    			isBtnJustPressed = driversStation.getIsOperatorRedBtnBJustPressed();
    			isBtnPressed = driversStation.getIsOperatorRedBtnBPressed();
    			break;
    			
    		case OPERATOR_RIGHT_BUMPER:
    			isBtnJustPressed = driversStation.getIsOperatorRightBumperBtnJustPressed();
    			isBtnPressed = driversStation.getIsOperatorRightBumperBtnPressed();
    			break;
    			
    		case OPERATOR_RIGHT_THUMBSTICK:
    			break;
    			
    		case OPERATOR_START_BUTTON:
    			isBtnJustPressed = driversStation.getIsOperatorStartBtnJustPressed();
    			isBtnPressed = driversStation.getIsOperatorStartBtnPressed();
    			break;
    			
    		case OPERATOR_YELLOW_BUTTON_Y:
    			isBtnJustPressed = driversStation.getIsOperatorYellowBtnYJustPressed();
    			isBtnPressed = driversStation.getIsOperatorYellowBtnYPressed();
    			break;
    			
    		default:
    			break;
    	}
    	
    	/*  Truth Table
    	 * 
    	 * isBtnJustPressed	isLatchEnabled	currentActualSpeedPercent		output
    	 * ================ ==============  ========================= 		======
    	 * 		Y				N						x					motorConfig.CmdScalingFactor
    	 * 		Y				Y			motorConfig.CmdScalingFactor	0		
    	 * 		Y				Y						0					motorConfig.CmdScalingFactor
    	 * 		N				N						x					0
    	 * 		N				Y			motorConfig.CmdScalingFactor	motorConfig.CmdScalingFactor
    	 * 		N				Y						0					0
    	 */
    	if(isLatchEnabled)
    	{
    		if(isBtnJustPressed)
    		{
    			if(Math.abs(currentActualSpeedRPM) > 0 )
    			{
        			motorCmd = 0;		// toggle off
    			}
        		else
        		{
        			motorCmd = motorConfig.ConstantVTargetRPM;	// toggle on
        		}
    		}
    		else
        	{
        		if(Math.abs(currentActualSpeedRPM) > 0 )
    			{
        			motorCmd = motorConfig.ConstantVTargetRPM;	// leave it on
    			}
        		else
        		{
        			motorCmd = 0;		// leave it off
        		}
        	}
    	}
    	else
    	{
    		if(isBtnPressed)
    		{
    			motorCmd = motorConfig.ConstantVTargetRPM;
    		}
    		else
    		{
    			motorCmd = 0;
    		}
    	}
		return motorCmd;
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() 
    {
    	// No Test Mode
    }
    
    // utility method that calls the outputToSmartDashboard method on all subsystems
    public void outputAllToSmartDashboard()
    {
    	if(_dcMotor1 != null)
    	{
    		_dcMotor1.outputToSmartDashboard();
    	}
    	
    	if(_dcMotor2 != null)
    	{
    		_dcMotor2.outputToSmartDashboard();
    	}
    	
    	if(_dcMotor3 != null)
    	{
    		_dcMotor3.outputToSmartDashboard();
    	}
    	
    	if(_dcMotor4 != null)
    	{
    		_dcMotor4.outputToSmartDashboard();
    	}
    	
    	if(_dcMotor5 != null)
    	{
    		_dcMotor5.outputToSmartDashboard();
    	}
    	
    	if(_dcMotor6 != null)
    	{
    		_dcMotor6.outputToSmartDashboard();
    	}
    }
}
