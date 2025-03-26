package com.tutorialninja.qa.testcases;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.base.Base;
import com.tutorialninja.qa.pages.HomePage;
import com.tutorialninja.qa.pages.RegisterAccountPage;
import com.tutorialninja.qa.utils.Utilities;
public class RegisterTest extends Base  {
	public	WebDriver driver;
	RegisterAccountPage registerAccountPage;
	
public	RegisterTest(){
	super();
		
	}

	
	@BeforeMethod
	public void setUp(){
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage=new HomePage(driver);
		homePage.clickOnMyAccount();
		registerAccountPage=homePage.selectRegisterOption();
		//driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//driver.findElement(By.linkText("Register")).click();
	}
	
	@AfterMethod
public void	tearDown(){
		driver.quit();
	}
	
	@Test(priority=1)
public void	verifyRegisteringAnAccountWithMandatoryFields(){
	
		//RegisterAccountPage registerAccountPage=new RegisterAccountPage(driver);
		
		registerAccountPage.firstNameInputValue(prop1.getProperty("firstName"));
		registerAccountPage.lastNameInputValue(prop1.getProperty("lastName"));
		registerAccountPage.emailInputValue(Utilities.generateEmailWithStamp());
		registerAccountPage.telephoneInputValue(prop1.getProperty("telephone"));
		registerAccountPage.passwordInputValue(prop1.getProperty("passwordForRegister"));
		registerAccountPage.confirmPasswordInputValue(prop1.getProperty("passwordForRegister"));
		registerAccountPage.clickOnAgreeCheckBox();
		registerAccountPage.clickOnSubmitButton();
		String accountCreateSuccessMessage=registerAccountPage.retrievingAccountCreateSuccessMessage();
	    String expectedSuccessMessage=prop1.getProperty("accountSuccessHeading");
		Assert.assertEquals(accountCreateSuccessMessage, expectedSuccessMessage);
	//driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(prop1.getProperty("firstName"));
	//driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(prop1.getProperty("lastName"));
	//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateEmailWithStamp());
	//driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(prop1.getProperty("telephone"));
	//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop1.getProperty("passwordForRegister"));
	//driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop1.getProperty("passwordForRegister"));
	////driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click(); it's not mandatory
	//driver.findElement(By.xpath("//input[@name='agree']")).click();
	//driver.findElement(By.xpath("//input[@type='submit']")).click();
	//String accountCreateSuccessMessage=driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
	
	

	
	
		
	}
	@Test(priority=2)
	public void verifyRegisteringAnAccountWithAllFields(){
		
		
	//RegisterAccountPage registerAccountPage=new RegisterAccountPage(driver);
		
		registerAccountPage.firstNameInputValue(prop1.getProperty("firstName"));
		registerAccountPage.lastNameInputValue(prop1.getProperty("lastName"));
		registerAccountPage.emailInputValue(Utilities.generateEmailWithStamp());
		registerAccountPage.telephoneInputValue(prop1.getProperty("telephone"));
		registerAccountPage.passwordInputValue(prop1.getProperty("passwordForRegister"));
		registerAccountPage.confirmPasswordInputValue(prop1.getProperty("passwordForRegister"));
		registerAccountPage.clickOnNewsLetterCheckBox();
		registerAccountPage.clickOnAgreeCheckBox();
		registerAccountPage.clickOnSubmitButton();
		String accountCreateSuccessMessage=registerAccountPage.retrievingAccountCreateSuccessMessage();
	    String expectedSuccessMessage=prop1.getProperty("accountSuccessHeading");
		Assert.assertEquals(accountCreateSuccessMessage, expectedSuccessMessage);
		/*driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(prop1.getProperty("firstName"));
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(prop1.getProperty("lastName"));
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(Utilities.generateEmailWithStamp());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(prop1.getProperty("telephone"));
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop1.getProperty("passwordForRegister"));
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop1.getProperty("passwordForRegister"));
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String accountCreateSuccessMessage=driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
	    String expectedSuccessMessage=prop1.getProperty("accountSuccessHeading");
		Assert.assertEquals(accountCreateSuccessMessage, expectedSuccessMessage); */
		
	 
	}
	@Test(priority=3)
	public void verifyRegisteringAnAccountWithAnExistingEmail(){
		
	//	RegisterAccountPage registerAccountPage=new RegisterAccountPage(driver);
		registerAccountPage.firstNameInputValue(prop1.getProperty("firstName"));
		registerAccountPage.lastNameInputValue(prop1.getProperty("lastName"));
		registerAccountPage.emailInputValue(prop.getProperty("validEmail"));
		registerAccountPage.telephoneInputValue(prop1.getProperty("telephone"));
		registerAccountPage.passwordInputValue(prop1.getProperty("passwordForRegister"));
		registerAccountPage.confirmPasswordInputValue(prop1.getProperty("passwordForRegister"));
		registerAccountPage.clickOnNewsLetterCheckBox();
		registerAccountPage.clickOnAgreeCheckBox();
		registerAccountPage.clickOnSubmitButton();
		String actualWarningMessage=registerAccountPage.retrievingExistingEmailWarningText();
		String expectedWarningMessage=prop1.getProperty("emailAlreadyResistredWarning");
		Assert.assertTrue(actualWarningMessage.contains(prop1.getProperty("emailAlreadyResistredWarning")),"Email address is not duplicate");
		//driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(prop1.getProperty("firstName"));
		//driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(prop1.getProperty("lastName"));
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(prop.getProperty("validEmail"));
		//driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(prop1.getProperty("telephone"));
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(prop.getProperty("password"));
		//driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(prop.getProperty("password"));
		//driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		//driver.findElement(By.xpath("//input[@name='agree']")).click();
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		//String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		////Assert.assertEquals(actualWarningMessage, expectedWarningMessage,"Email address is not duplicate");

	
		
	 
	}
	@Test(priority=4)
	public void verifyRegisteringAnAccountWithoutFillingAnyDetails(){
		
		//RegisterAccountPage registerAccountPage=new RegisterAccountPage(driver);
	
		 registerAccountPage.clickOnSubmitButton();
		 
		 String actualWarningMessage=registerAccountPage.retrievingPrivacyWarningMessageText();
		 Assert.assertTrue(actualWarningMessage.contains(prop1.getProperty("privacyWarning")),"No warning message displayed");
		 
		String firstNameValidationMsg=registerAccountPage.retrievingFirstNameTextFieldWarningMessage();
		Assert.assertTrue(firstNameValidationMsg.contains(prop1.getProperty("firstNameWarning")),"No warning message displayed for firstName Text field");
		String lastNameValidationMsg=registerAccountPage.retrievingLastNameWarningMessageText();
		Assert.assertTrue(lastNameValidationMsg.contains(prop1.getProperty("lastNameWarning")),"No warning message displayed for lastname Text field");
		String emailAddValidationMsg=registerAccountPage.retrievingEmailTextFieldWarningText();
		Assert.assertTrue(emailAddValidationMsg.contains(prop1.getProperty("emailWarning")),"No warning message displayed for email address Text field");
		String	telephoneValidationMsg=	registerAccountPage.retrievingTelephoneTextFieldWarningMessageText();
        Assert.assertTrue(telephoneValidationMsg.contains(prop1.getProperty("telephoneWarning")),"No warning message displayed for telephone Text field");
        String	passwordValidationMsg=registerAccountPage.retrievingPasswordTextFieldWarningMessageText();
        Assert.assertTrue(passwordValidationMsg.contains(prop1.getProperty("passwordWarning")),"No warning message displayed for password Text field");
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
	    //String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
	    //String firstNameValidationMsg=driver.findElement(By.xpath("//div[text()='First Name must be between 1 and 32 characters!']")).getText();
	    //String lastNameValidationMsg=driver.findElement(By.xpath("//div[text()='Last Name must be between 1 and 32 characters!']")).getText();
	    //String emailAddValidationMsg=driver.findElement(By.xpath("//div[text()='E-Mail Address does not appear to be valid!']")).getText();
		//String	telephoneValidationMsg=driver.findElement(By.xpath("//div[text()='Telephone must be between 3 and 32 characters!']")).getText();
		//	String	passwordValidationMsg=driver.findElement(By.xpath("//div[text()='Password must be between 4 and 20 characters!']")).getText();
	
	

	}

}
