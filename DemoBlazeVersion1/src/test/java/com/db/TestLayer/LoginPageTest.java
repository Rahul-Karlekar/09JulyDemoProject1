package com.db.TestLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.db.PageLayer.LoginPage;
import com.db.TestBase.TestBase;

public class LoginPageTest extends TestBase {
	
	
	
	@Test
	public void verifyLoginFunctionalitywithValidCred() throws InterruptedException
	{
		String expected_url ="https://apps.dalalstreet.ai/dashboard" ; //we get this url when successfully login
		
		LoginPage login = new LoginPage();                     //LoginPage class object created 
		login.enterEmailID("karlekarrahul@gmail.com");      //parameter is pass under enterEmailID(-----)
		login.enterPassword("rahul@9696");                    //parameter is pass in enterPassword(-----)
		login.clickOnLoginButton();
		Thread.sleep(2000);
		String actual_url = login.getCUrl();
		Assert.assertEquals(actual_url, expected_url);
		logger.info("Login Test Case Pass");
	}
	
	@Test(enabled = false)
	public void verifyLoginFunctionalitywithInvalidCred() throws InterruptedException
	{
		String expected_url ="https://apps.dalalstreet.ai/login" ; //we get this url when successfully login
		
		LoginPage login = new LoginPage();                     //LoginPage class object created 
		login.enterEmailID("amarwaghmare573@gmail.com");      //parameter is pass under enterEmailID(-----)
		login.enterPassword("Test@1222");                    //parameter is pass in enterPassword(-----)
		login.clickOnLoginButton();
		Thread.sleep(2000);
		String actual_url = login.getCUrl();
		Assert.assertEquals(actual_url, expected_url);
	}

}
