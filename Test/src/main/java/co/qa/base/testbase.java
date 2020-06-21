package co.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testbase {
	public static WebDriver driver;
	public static Properties prop;

public testbase(){
	try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com"
				+ "/qa/config/config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver_win32\\chromedriver.exe");	
			driver = new ChromeDriver(); 
			
		// driver.get("https://urun.n11.com/mouse/asus-wt425-kablosuz-optik-sessiz-tiklama-ozellikli-siyah-mouse-P178058764");
		}
	
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	
		//driver.get(prop.getProperty("https://www.n11.com/giris-yap"));
		
	}
}