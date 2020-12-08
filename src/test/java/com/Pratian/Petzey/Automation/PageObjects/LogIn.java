package com.Pratian.Petzey.Automation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn extends BasePage{
	
	public LogIn(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	//PROPERTIES
	@FindBy(xpath = "//*[@id=\"username_input\"]")
	WebElement email;
	@FindBy(xpath = "//*[@id=\"password_input\"]")
	WebElement password;
	@FindBy(xpath = "//*[@id=\"login-button\"]")
	WebElement logInButton;
	@FindBy(xpath="//*[@id=\"innerContent\"]/div[2]/p")
	WebElement errorMessages;
	
	//METHODS
	public void provideUserName(String email)
	{
		this.email.sendKeys(email);
	}
	public void providePassword(String password)
	{
		this.password.sendKeys(password);
	}
	public String getErrorMessages()
	{
		return this.errorMessages.getText();
	}
	
	public void clickSignInButton(WebDriver driver)
	{
		logInButton.click();		
	}
	
	

}
