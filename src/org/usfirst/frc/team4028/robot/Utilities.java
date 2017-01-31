package org.usfirst.frc.team4028.robot;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.usfirst.frc.team4028.robot.constants.RobotMap;

import edu.wpi.first.wpilibj.DriverStation;

public class Utilities 
{
	public static void WriteBuildInfoToDashboard(String robotName) 
	{
		try
    	{
    		//DriverStation.reportError("** Team 4028 The Beak Squad **", false);
    		
    		//get the path of the currently executing jar file
			String currentJarFilePath = Robot.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();		
			//DriverStation.reportError(currentJarFilePath , false);
			Path filePath = Paths.get(currentJarFilePath);
			
			//get file system details from current file
			BasicFileAttributes attr = Files.readAttributes(filePath, BasicFileAttributes.class);
			Date utcFileDate = new Date(attr.lastModifiedTime().toMillis());
	
			// convert from UTC to local time zone
			SimpleDateFormat outputFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			outputFormatter.setTimeZone(TimeZone.getTimeZone("US/Eastern")); 
			String newDateString = outputFormatter.format(utcFileDate);
			
			// write the build date & time to the operator's console log window
			DriverStation.reportWarning("== Robot Name == " + robotName + "| Build Date and Time: " + newDateString + "|", false);
			
		} 
    	catch (URISyntaxException e) 
    	{
    		DriverStation.reportWarning("Error determining filename of current JAR file", true);
			//e.printStackTrace();
		} 
    	catch (IOException e) 
    	{	
    		DriverStation.reportWarning("General Error trying to determine current JAR file", true);
			//e.printStackTrace();
		}
	}
	
    /**
    / This method optionally sets up logging
	**/
	@SuppressWarnings("null")
	public static DataLogger setupLogging(String mode, LogData robotLiveData) 
	{
		DataLogger dataLogger;
		
		// see if the USB stick is plugged into to RoboRIO
		Path path = Paths.get(RobotMap.LOG_FILE_PATH);
    	if (Files.exists(path)) 
    	{
    		try 
    		{
				dataLogger = new DataLogger(RobotMap.LOG_FILE_PATH, mode);
				dataLogger.WriteData(robotLiveData.BuildTSVHeader());
				
				robotLiveData.LogFilePathName = dataLogger.LogFilePathName;
	    		robotLiveData.IsLoggingEnabled = true;
	    		//robotLiveData.LoggingStartedDT = new Date();
	    		//robotLiveData.LastScanDT = new Date();
	    		
	    		System.out.println("..Logging enabled to: " + dataLogger.LogFilePathName);
			} 
    		catch (IOException e) 
    		{
				e.printStackTrace();
				
	    		dataLogger = null;
				robotLiveData.LogFilePathName = "";
	    		robotLiveData.IsLoggingEnabled = false;
	    		
	    		System.out.println("..Error configuring Logging to: " + dataLogger.LogFilePathName);
			}
    	}
    	else
    	{
    		dataLogger = null;
			robotLiveData.LogFilePathName = "";
    		robotLiveData.IsLoggingEnabled = false;
    		
    		System.out.println("..Logging Disabled!");
    	}
    	
    	return dataLogger;
	}
	
	// helper method
	public static double RoundDouble(Double originalValue, int decimalPlaces)
	{
		BigDecimal bd = new BigDecimal(originalValue).setScale(decimalPlaces, RoundingMode.HALF_EVEN);
		
		return bd.doubleValue();
	}
	
	public static double ClampValue(double originalValue, double minValue, double maxValue) 
	{
		double clampedValue = originalValue;
		
		if (clampedValue > maxValue)
		{
			clampedValue = maxValue;
		}
		else if (clampedValue < minValue)
		{
			clampedValue = minValue;
		}
		
		return clampedValue;
	}
}
