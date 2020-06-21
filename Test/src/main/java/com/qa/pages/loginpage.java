package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import co.qa.base.testbase;



public class loginpage extends testbase{
	
	//Page Factory - OR:
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginButton")
	WebElement loginBtn;
	
	@FindBy(linkText="Giriş Yap")
	WebElement loginBtn1;
	
	@FindBy(id="userKvkkModal")
	WebElement kvkk;
	public loginpage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	

	public void login(String un, String pwd) throws InterruptedException{
		
		Thread.sleep(3000);
		//kvkk penceresinde çıkıyor.
		kvkk.click();
		Thread.sleep(3000);
		//giriş yapa tıklıyor(giriş sayfasına yönlendirecek)
		loginBtn1.click();
		Thread.sleep(3000);
		//email giricek.
		username.sendKeys(un);
		Thread.sleep(3000);
		//şifre girecek.
		password.sendKeys(pwd);
		Thread.sleep(3000);
		//giriş yapa bastıktan sonra tekrar aynı sayfa geliyor.!!!
		loginBtn.click();
		    	
		    	
		
	}
	
}
