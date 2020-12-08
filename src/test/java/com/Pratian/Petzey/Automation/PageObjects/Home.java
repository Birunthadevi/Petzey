package com.Pratian.Petzey.Automation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home extends BasePage {
	
	@FindBy(xpath = "//*[@id=\"site-header\"]/div/nav/div/ul/li[7]/a")
	WebElement logIn;
	
		
	public Home(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);		
	}
	
	public LogIn clickSignIn()
	{
		return new LogIn(driver);
	}

}
