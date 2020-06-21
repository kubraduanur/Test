package com.qa.testcases;

import org.apache.commons.configuration.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.homepage;
import com.qa.pages.loginpage;

import co.qa.base.testbase;

public class homepagetest extends testbase {

	homepage homePage;
	

	
	
	public homepagetest() {
		super();
		initialization();
		homePage = new homepage();
	}
	
	/*@BeforeMethod
	public void setUp(){
		initialization();
		homePage = new homepage();	
	}*/
	
	@Test(priority=1)
	public void HomePageTitleTest(){
		
		String title = homePage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test(priority=2)
	public void homeTest() throws InterruptedException, ConfigurationException{
	
		Thread.sleep(2000);
	    homePage.home("bilgisayar");
		
	}
	
	
	
	
	

}
