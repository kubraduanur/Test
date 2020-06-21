package com.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.qa.pages.loginpage;

import co.qa.base.testbase;
import junit.framework.Assert;



public class loginpagetest extends testbase{
	loginpage loginPage;
	
	
	public loginpagetest() {
		super();
		initialization();
		loginPage = new loginpage();
	}
	
	
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "n11.com - Alışverişin Uğurlu Adresi");
	}
	
	@Test(priority=2)
	public void loginTest() throws InterruptedException{
	//giriş kısmında butona basınca tekrar aynı sayfa dönüyor.
		Thread.sleep(2000);
	    loginPage.login("kubraduanur898@gmail.com", "kbr654");
		
	}

	
	
	

}
