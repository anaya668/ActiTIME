package com.actitime.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest implements AutoConstant
{
	public static WebDriver driver;
	public Properties properties;
	
	@BeforeClass
	public void setup() throws IOException
	{
		//WebDriverManager.chromedriver().setup(); --- till selenium v4.5.0
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//fetching the url from AutoConstant Interface
		driver.get(url);
		
		//fetching the url from properties file
		FileInputStream fis=new FileInputStream(properties_path);
		properties=new Properties();
		properties.load(fis);
		driver.get(properties.getProperty("url"));
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}