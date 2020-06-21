package com.qa.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.basketpage;
import com.qa.pages.homepage;

import co.qa.base.testbase;

public class basketpagetest extends testbase {
	
	basketpage basketPage;
	PropertiesConfiguration config ;
	
	public basketpagetest() {
		
		super();
		initialization();
		basketPage = new basketpage();
	}
	@Test(priority=1)
public void basketequalpagetest() throws javax.naming.ConfigurationException, org.apache.commons.configuration.ConfigurationException, InterruptedException {
		
		config=new PropertiesConfiguration("C:/Users/kubra/eclipse-workspace/Test/src/main/java/com/qa/config/basketconfig.properties");
	Thread.sleep(2000);
	//aldığı ürünle sepetteki ürünü karşılaştırıyor.
	Assert.assertEquals(config.getProperty("cost").toString().substring(0 ,  config.getProperty("cost").toString().indexOf(".")) ,
			basketPage.basket());
	
	
}
	@Test(priority=2)
	public void priceincreasingtest() throws InterruptedException {
		//sepetteki ürünün fiyatını 2 ye çıkartıyor.
		Assert.assertEquals(basketPage.priceincreasing(),"2");
		
	}
	@Test(priority=3)
	public void deleteProducttest() throws InterruptedException {
		//sepetin boş olup olmadığını kontrol ediyor.
		Assert.assertEquals(basketPage.deleteProduct(), "Sepetiniz Boş");
		
	}
	
}