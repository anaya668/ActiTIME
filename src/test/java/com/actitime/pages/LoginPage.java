package com.actitime.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.actitime.utility.AutoConstant;
import com.actitime.utility.BasePage;
import com.actitime.utility.ExcelLibrary;

public class LoginPage extends BasePage implements AutoConstant
{
	public WebDriver driver;
	
	@FindBy(id = "username")
	private WebElement usernameTextfield;
	
	@FindBy(name = "pwd")
	private WebElement passwordTextfield;
	
	@FindBy(id = "loginButton")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginMethod() throws IOException
	{
		//waitElementVisibility(driver, usernameTextfield);
		usernameTextfield.sendKeys(ExcelLibrary.getStringDataFromExcel(login_sheet, 1, 0));
		
		//waitElementVisibility(driver, passwordTextfield);
		passwordTextfield.sendKeys(ExcelLibrary.getStringDataFromExcel(login_sheet, 1, 1));
		
		//waitElementVisibility(driver, loginButton);
		loginButton.click();
	}
}