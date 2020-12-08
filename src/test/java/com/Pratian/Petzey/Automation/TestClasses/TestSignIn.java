package com.Pratian.Petzey.Automation.TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pratian.Petzey.Automation.FileHandling.PropertyManager;
import com.Pratian.Petzey.Automation.PageObjects.Home;
import com.Pratian.Petzey.Automation.PageObjects.SignIn;

public class TestSignIn extends BaseTest {

	@Test(dataProvider = "signIn")
	public void signInWithValidCredentials(String userName, String password) throws IOException
	{
		/*Check whether or not user is able to sign in into Petzey
		with valid credentials*/
		
		driver.get(PropertyManager.getProperty("url.app"));
		SignIn signIn= new SignIn(driver);
		signIn.provideUserName(userName);
		signIn.providePassword(password);
		Home home= signIn.clickSignInButton(driver);
		Assert.assertEquals(home.getUserName().trim(), "Netravati Alagundi");			
	}
	

	@DataProvider(name="signIn")			
	public Object[][] getCredentials() {			

		return new Object[][] {				

			{"netravati@pratian.com","password@123"} 	

		};
	}

	//	@Test
	//	public void signInWithInvalidCredentials(String userName, String password)
	//	{
	//		
	//	}
	//	
	//	@Test
	//	public void signInWithoutCredentials()
	//	{
	//		
	//	}

}
