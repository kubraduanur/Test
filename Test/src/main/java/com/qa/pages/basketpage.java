package com.qa.pages;

import javax.naming.ConfigurationException;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import co.qa.base.testbase;

public class basketpage extends testbase{
	//SEPET BÖLÜMÜNÜN VERİLERİ ALINIYOR
	PropertiesConfiguration config ;
	Actions action = new Actions(driver);
	
	@FindBy( xpath="//*[@id=\"productDisplayPrice\"]")
	WebElement price;
	
	@FindBy( xpath="//*[@id=\"contentProDetail\"]/div/div[3]/div[2]/div[3]/div[3]/a[2]")
	WebElement addbasket;
	
	@FindBy( xpath="//*[@id=\"header\"]/div/div/div[2]/div[2]/div[4]/a/i")
	WebElement basket;
	
	@FindBy( name="quantity")
	WebElement 	increase;
	
	@FindBy( xpath="//span[contains(text() , '+')]")
	WebElement pricebutton;
	
	@FindBy( xpath="//*[@id=\"newCheckout\"]/div/div[1]/div[2]/div[1]/section/table[2]/tbody/tr/td[1]/div[3]/div[2]/span[1]")
	WebElement delete;
	
	@FindBy( xpath="//*[@id=\"newCheckout\"]/div/div[1]/div[2]/div[1]/section/table[2]/tbody/tr/td[3]/div[2]/div/div/input")
	WebElement sepetfiyat;
	@FindBy( xpath="//*[@id=\"wrapper\"]/div[3]/div/div[1]/div[1]/h2")
	WebElement basketempty;
	
public basketpage(){
		
		PageFactory.initElements(driver, this);
	}
		
	
	public String basket() throws InterruptedException, ConfigurationException, org.apache.commons.configuration.ConfigurationException{
	    
		 //ALdığım ürünün linki geliyor(url1).
			config=new PropertiesConfiguration("C:\\Users\\kubra\\eclipse-workspace\\Test\\src\\main\\java\\com\\qa\\config\\basketconfig.properties");
			    driver.get((String) config.getProperty("url1"));
			    //ürünün fiyatını alıp basketconfig.propertiese setliyor.
			   Thread.sleep(3000);
			   config.setProperty("cost", price.getAttribute("value"));
			   config.save();
			   //ürünü sepete ekliyor
			   addbasket.click();
			   System.out.println(config.getProperty("cost")); 
			   //sepete tıklıyor.
			   basket.click();
			   action.sendKeys(Keys.ESCAPE).build().perform();
			   return sepetfiyat.getAttribute("value").substring(0,sepetfiyat.getAttribute("value").indexOf(","));		 
	}
	public String priceincreasing() throws InterruptedException {
		//sepetteki ürünün fiyatını artırıyor.
		Thread.sleep(3000);
		 pricebutton.click();
		Thread.sleep(3000);
	   return  increase.getAttribute("value");
	}
public String deleteProduct() throws InterruptedException {
	//sepeti boşaltıyor.
		Thread.sleep(3000);
		delete.click();
		Thread.sleep(3000);
	  driver.navigate().refresh();
	  return basketempty.getText();
	}
	
	
	
	
}
