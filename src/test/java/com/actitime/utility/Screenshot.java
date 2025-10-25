package com.actitime.utility;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Screenshot implements ITestListener
{
	@Override
	public void onTestFailure(ITestResult result)
	{
		if(result.getStatus()==2)
			Reporter.log("test case is failed", true);
		String methodName=result.getName();
		Date date = Calendar.getInstance().getTime();
		String format = date.toString().replaceAll(":", "-");
		TakesScreenshot ts = (TakesScreenshot)BaseTest.driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		try 
		{
			FileHandler.copy(srcFile, new File("./failedscreenshot/" +methodName +format +".png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}