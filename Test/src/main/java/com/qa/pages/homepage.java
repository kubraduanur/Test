package com.qa.pages;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import co.qa.base.testbase;

public class homepage extends testbase{
	Actions action = new Actions(driver);


	@FindBy(id="searchData")
	WebElement search;
	
		@FindBy(id="password")
		WebElement password;
		
		@FindBy(linkText="2")
		WebElement page2;
		
		@FindBy( xpath="//*[@id=\"p-178058764\"]/div[1]/a/img")
		WebElement product;
		
		@FindBy(id="quantity")
		WebElement quan;
		
		@FindBy( xpath="//*[@id=\"contentProDetail\"]/div/div[3]/div[2]/div[3]/div[3]/a[2]")
		WebElement addbasket;
		
		PropertiesConfiguration config ;
		
		
		public homepage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle() {
			return driver.getTitle();
		}
		

		public void home(String src ) throws InterruptedException, ConfigurationException{
			
			//gelen pencereyi kapatıyor
			Thread.sleep(3000);
			action.sendKeys(Keys.ESCAPE).perform();
			//arama butonuna bilgisayar yazıracak.
			search.sendKeys(src);
			search.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			//2. sayfaya tıklama yapıyor.
			page2.click();
			Thread.sleep(3000);
			//ürünü seçiyor.
			product.click();
			Thread.sleep(3000);
			//ürünü sepete ekliyor.
			addbasket.click();
		}
		
	}
