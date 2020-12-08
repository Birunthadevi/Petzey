package com.Pratian.Petzey.Automation.TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pratian.Petzey.Automation.FileHandling.PropertyManager;
import com.Pratian.Petzey.Automation.PageObjects.Home;
import com.Pratian.Petzey.Automation.PageObjects.LogIn;

public class TestSignIn extends BaseTest {

	@Test(dataProvider = "signIn")
	public void logInWithInvalidCredentials(String userName, String password) throws IOException
	{
		/*Check whether or not user is able to sign in into Petzey
		with Invalid credentials*/
		
		driver.get(PropertyManager.getProperty("url.app"));
		//load the home page and navigate to the login screen
		Home home=new Home(driver);		
		LogIn logIn= home.clickSignIn();
		
		//Enter the username and password
		logIn.provideUserName(userName);
		logIn.providePassword(password);
		logIn.clickSignInButton(driver);
		Assert.assertEquals(logIn.getErrorMessages().trim(), "WRONG CREDENTIALS, PLEASE TRY AGAIN!");			
	}
	

	@DataProvider(name="signIn")			
	public Object[][] getCredentials() {			

		return new Object[][] {				

			{"brintha@gmail.com","password@123"} 	

		};
	}


}
