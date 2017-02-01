package org.usfirst.frc.team4028.robot;

import java.util.Date;

public class LogData 
{
	public LogData()
	{
		LoggingStartedDT = new Date();
		LastScanDT = new Date();
	}
	
	public boolean IsLoggingEnabled;
	public String LogFilePathName;
	public Date LoggingStartedDT;
	public Date LastScanDT;
	
	public long FPGATimeMicroSecs;
	
	public double Motor1CmdVBus;
	public double Motor1ActualVBus;
	public double Motor1CmdRPM;
	public double Motor1ActualRPM;
	public double Motor1RPMDeltaPercent;
	
	public double Motor2CmdVBus;
	public double Motor2ActualVBus;
	public double Motor2CmdRPM;
	public double Motor2ActualRPM;
	public double Motor2RPMDeltaPercent;
	
	public double Motor3CmdVBus;
	public double Motor3ActualVBus;
	public double Motor3CmdRPM;
	public double Motor3ActualRPM;
	public double Motor3RPMDeltaPercent;
	
	public double Motor4CmdVBus;
	public double Motor4ActualVBus;
	public double Motor4CmdRPM;
	public double Motor4ActualRPM;
	public double Motor4RPMDeltaPercent;
	
	public double Motor5CmdVBus;
	public double Motor5ActualVBus;
	public double Motor5CmdRPM;
	public double Motor5ActualRPM;
	public double Motor5RPMDeltaPercent;	
	
	public double Motor6CmdVBus;
	public double Motor6ActualVBus;
	public double Motor6CmdRPM;
	public double Motor6ActualRPM;
	public double Motor6RPMDeltaPercent;
	
	
	// build a TSV for the header
	public String BuildTSVHeader()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("LoggingStartedDT" + "\t");
		sb.append("LastScanDT" + "\t");
		sb.append("FPGATimeMicroSecs" + "\t");
		
		sb.append("Mtr1CmdVBus" + "\t");
		sb.append("Mtr1ActualVBus" + "\t");
		sb.append("Mtr1CmdRPM" + "\t");
		sb.append("Mtr1ActualRPM" + "\t");
		sb.append("Mtr1RPMDelta%" + "\t");
		
		sb.append("Mtr2CmdVBus" + "\t");
		sb.append("Mtr2ActualVBus" + "\t");
		sb.append("Mtr2CmdRPM" + "\t");
		sb.append("Mtr2ActualRPM" + "\t");
		sb.append("Mtr2PMDelta%" + "\t");
		
		sb.append("Mtr3CmdVBus" + "\t");
		sb.append("Mtr3ActualVBus" + "\t");
		sb.append("Mtr3CmdRPM" + "\t");
		sb.append("Mtr3ActualRPM" + "\t");
		sb.append("Mtr3RPMDelta%" + "\t");
		
		sb.append("Mtr4CmdVBus" + "\t");
		sb.append("Mtr4ActualVBus" + "\t");
		sb.append("Mtr4CmdRPM" + "\t");
		sb.append("Mtr4ActualRPM" + "\t");
		sb.append("Mtr4RPMDelta%" + "\t");
		
		sb.append("Mtr5CmdVBus" + "\t");
		sb.append("Mtr5ActualVBus" + "\t");
		sb.append("Mtr5CmdRPM" + "\t");
		sb.append("Mtr5ActualRPM" + "\t");
		sb.append("Mtr5RPMDelta%" + "\t");
		
		sb.append("Mtr6CmdVBus" + "\t");
		sb.append("Mtr6ActualVBus" + "\t");
		sb.append("Mtr6CmdRPM" + "\t");
		sb.append("Mtr6ActualRPM" + "\t");
		sb.append("Mtr6RPMDelta%" + "\r\n");
			
		return sb.toString();
	}
	
	// build a TSV for the data
	public String BuildTSVData()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(LoggingStartedDT + "\t");
		sb.append(LastScanDT + "\t");
		sb.append(FPGATimeMicroSecs + "\t");
		
		sb.append(Motor1CmdVBus + "\t");
		sb.append(Motor1ActualVBus + "\t");
		sb.append(Motor1CmdRPM + "\t");
		sb.append(Motor1ActualRPM + "\t");
<<<<<<< HEAD
		sb.append(String.format( "%.2f", Motor1RPMDeltaPercent) + "\t");
=======
		sb.append(Motor1ActualRPM - Motor1CmdRPM + "\t");
		sb.append(String.format( "%.0f RPM (%.2f%%)", Motor1RPMDeltaPercent) + "\t");
>>>>>>> origin/master
		
		sb.append(Motor2CmdVBus + "\t");
		sb.append(Motor2ActualVBus + "\t");
		sb.append(Motor2CmdRPM + "\t");
		sb.append(Motor2ActualRPM + "\t");
		sb.append(String.format( "%.2f", Motor2RPMDeltaPercent) + "\t");
		
		sb.append(Motor3CmdVBus + "\t");
		sb.append(Motor3ActualVBus + "\t");
		sb.append(Motor3CmdRPM + "\t");
		sb.append(Motor3ActualRPM + "\t");
		sb.append(String.format( "%.2f", Motor3RPMDeltaPercent) + "\t");
		
		sb.append(Motor4CmdVBus + "\t");
		sb.append(Motor4ActualVBus + "\t");
		sb.append(Motor4CmdRPM + "\t");
		sb.append(Motor4ActualRPM + "\t");
		sb.append(String.format( "%.2f", Motor4RPMDeltaPercent) + "\t");
		
		sb.append(Motor5CmdVBus + "\t");
		sb.append(Motor5ActualVBus + "\t");
		sb.append(Motor5CmdRPM + "\t");
		sb.append(Motor5ActualRPM + "\t");
		sb.append(String.format( "%.2f", Motor5RPMDeltaPercent) + "\t");
		
		sb.append(Motor6CmdVBus + "\t");
		sb.append(Motor6ActualVBus + "\t");
		sb.append(Motor6CmdRPM + "\t");
		sb.append(Motor6ActualRPM + "\t");
		sb.append(String.format( "%.2f", Motor6RPMDeltaPercent) + "\r\n");
		
		return sb.toString();
	}

}
