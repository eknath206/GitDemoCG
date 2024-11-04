package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException
	{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		String browser_properties = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		
		String browser = browser_maven!=null ? browser_maven : browser_properties;
		
		if(driver==null)
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:/Eknath/Selenium/Drivers/chromedriver.exe");
				//System.setProperty("webdriver.chrome.driver", "G:/JarFiles/chromedriver.exe");
			    driver = new ChromeDriver();
			    //driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
			    driver.get(url);
			}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
		}
		
	    return driver;
	}

}

//C:/Eknath/Selenium/Drivers/chromedriver.exe
//G:/JarFiles/chromedriver.exe