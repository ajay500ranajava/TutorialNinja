package com.tutorialninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tutorialninja.qa.utils.Utilities;

public class Base {
   WebDriver driver;
  public Properties prop;
  public Properties prop1;
      
  public Base(){
	  prop=new Properties();
	  File propFile=new File(System.getProperty("user.dir") +"//src/main//java//com//tutorialsninja//qa//config//config.properties");
	 
	  try {
	  FileInputStream fis=new FileInputStream(propFile);
	  prop.load(fis);
	  }catch(Exception e) {
		 e.printStackTrace();
	  }  
	  
	  prop1=new Properties();
	  File propFileTestData=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialninja\\qa\\testdata\\testdata.properties");
	 try {
	  FileInputStream fis1=new FileInputStream(propFileTestData);
	  prop1.load(fis1);
	 }catch(Exception e) {
		 e.printStackTrace();
	 }
	 
      }
  
  
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) throws Exception{
		
     
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			//driver=new EdgeDriver();    // for Edge Browser
			
			 //String hubUrl = "http://65.2.186.123:4444/wd/hub";  // Replace <hub-ip> with your Hub IP address
			 
			
			
			EdgeOptions options = new EdgeOptions();
		       options.addArguments("--headless");  // Run in headless mode
		       options.addArguments("--disable-gpu");
		       options.addArguments("--no-sandbox");
		       options.addArguments("--disable-dev-shm-usage");
	       driver = new EdgeDriver(options);
			 //  driver = new RemoteWebDriver(new URL(hubUrl), options);
		       
		}else if(browserName.equalsIgnoreCase("safari")) {
			driver=new SafariDriver();
		}
		 //driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		 driver.get(prop.getProperty("url"));
		 
		 return driver;
		
	}
}
