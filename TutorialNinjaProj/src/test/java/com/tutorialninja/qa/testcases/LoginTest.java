package com.tutorialninja.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialninja.qa.base.Base;
import com.tutorialninja.qa.pages.AccountPage;
import com.tutorialninja.qa.pages.HomePage;
import com.tutorialninja.qa.pages.LoginPages;
import com.tutorialninja.qa.utils.Utilities;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LoginTest extends Base  {
	public WebDriver driver;
	LoginPages loginPage;
	
public LoginTest() {
	super();
}

 
	@BeforeMethod
	public void setUp(){
		
		 driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		 HomePage homePage=new HomePage(driver);
		 homePage.clickOnMyAccount();
	     loginPage= homePage.selectLoginOption();
		// driver.findElement(By.xpath("//span[text()='My Account']")).click();
		 //driver.findElement(By.linkText("Login")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority=1, dataProvider="validCredentialsSupplier")
public void	verifyLoginWithValidCredentials(String email, String password){
		
	
		 //LoginPages loginPage=new LoginPages(driver);
		 loginPage.emailTextFieldInputValue(email);
		 loginPage.passwordTextFieldEnteredValue(password);
		 loginPage.clickOnLoginButton();
		 
		 AccountPage accountPage=new AccountPage(driver);
		 Assert.assertTrue(accountPage.validateEditYourAccountInfoIsDisplayed());
	
		
		// Assert.assertTrue(driver.findElement(By.linkText("Change your password")).isDisplayed());
		
		 
	}
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyTestData()  {
		Object [][] data=Utilities.getTestDataFromExcel("Login");
		//Object [] [] data= {{"ajay44314@gmail.com","8871500667@Ar"},
			//{"testing1000@gmail.com","8871500667@Ar"},{"testing10@gmail.com","8871500667@Ar"}};
				
		return data;
	}
	
	
	@Test(priority=2)
	public void verifyLoginWithInvalidCredentials() {
		 //LoginPages loginPage=new LoginPages(driver);
		 
		 loginPage.emailTextFieldInputValue(Utilities.generateEmailWithStamp());
		 loginPage.passwordTextFieldEnteredValue(prop1.getProperty("invalidPassword"));
		 loginPage.clickOnLoginButton();
		// driver.findElement(By.xpath("//input[@id=\"input-email\"]")).sendKeys(Utilities.generateEmailWithStamp());
		// driver.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys(prop1.getProperty("invalidPassword"));
		 //driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		// String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		 String	 actualWarningMessage=loginPage.retrievingTextMessageForEmailPasswordNotMatchWarning();
		
		 String expectedWarningMessage=prop1.getProperty("emailPasswordNoMatchWarning");
		 Assert.assertEquals(actualWarningMessage, expectedWarningMessage);
		
		
	}
	
	
         
          
          
          @Test(priority=3)
     public void verifyLoginWithInValidEmailandValidPassword(){
    	 
        	 // LoginPages loginPage=new LoginPages(driver);
     		 loginPage.emailTextFieldInputValue(Utilities.generateEmailWithStamp());
     		 loginPage.passwordTextFieldEnteredValue(prop.getProperty("password"));
     		 loginPage.clickOnLoginButton();
		// driver.findElement(By.xpath("//input[@id=\"input-email\"]")).sendKeys(Utilities.generateEmailWithStamp());
		// driver.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys(prop.getProperty("password"));
		// driver.findElement(By.xpath("//input[@value='Login']")).click();
		 
		 //String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
         String	 actualWarningMessage=loginPage.retrievingTextMessageForEmailPasswordNotMatchWarning();
		 String expectedWarningMessage=prop1.getProperty("emailPasswordNoMatchWarning");
		 Assert.assertEquals(actualWarningMessage, expectedWarningMessage);
	
          }
          
          
          
          @Test(priority=4)
     public void VerifyLoginWithValidEmailandInvalidPassword(){
        	//  LoginPages loginPage=new LoginPages(driver);
      		 loginPage.emailTextFieldInputValue(prop.getProperty("validEmail"));
      		 loginPage.passwordTextFieldEnteredValue(Utilities.generateEmailWithStamp());
      		 loginPage.clickOnLoginButton();
    	
		// driver.findElement(By.xpath("//input[@id=\"input-email\"]")).sendKeys(prop.getProperty("validEmail"));
		// driver.findElement(By.xpath("//input[@id=\"input-password\"]")).sendKeys(Utilities.generateEmailWithStamp());
		// driver.findElement(By.xpath("//input[@value='Login']")).click();
		 
		 //String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
      	 String	 actualWarningMessage=loginPage.retrievingTextMessageForEmailPasswordNotMatchWarning();
		 String expectedWarningMessage=prop1.getProperty("emailPasswordNoMatchWarning");
		 Assert.assertEquals(actualWarningMessage, expectedWarningMessage);
		 
        	  
          }
          @Test(priority=5)
  public void VerifyLoginWithoutCredentials(){
	  
	  
        	//  LoginPages loginPage=new LoginPages(driver);
       		
       		 loginPage.clickOnLoginButton();
		   //  driver.findElement(By.xpath("//input[@value='Login']")).click();
		 
		// String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		 String	 actualWarningMessage=loginPage.retrievingTextMessageForEmailPasswordNotMatchWarning();
		 String expectedWarningMessage=prop1.getProperty("emailPasswordNoMatchWarning");
		 Assert.assertEquals(actualWarningMessage, expectedWarningMessage);
		
        	  
          }
          
          
   @Test(priority=6)       
  public void tableDataFetch() throws InterruptedException {
	  Thread.sleep(2000);
	   
	  driver.findElement(By.linkText("Tablets")).click();
	   List<WebElement> menuOption = driver.findElements(By.xpath("//div[@class='list-group']/a"));
	  
	   System.out.println(menuOption.get(6).getText());
	   
	   for (int i = 0; i < menuOption.size(); i++) {
		   
		String  ele1= menuOption.get(i).getText();
		
		System.out.println(ele1);
		
	}
	   
	   
	   menuOption.get(6).click();
	   
	  /* for (WebElement ele : menuOption) {
		   
		   System.out.println(ele.getText());
		
	}*/
	 
        	  
          }
}


