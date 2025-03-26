package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	public HomePage (WebDriver driver){
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
		
		
	}
	//Actions
	public void clickOnMyAccount(){
		myAccountDropMenu.click();
		
	}
	
	public LoginPages selectLoginOption(){
		loginOption.click();
		return new LoginPages(driver);
	}
	
	public RegisterAccountPage selectRegisterOption(){
		registerOption.click();
		
		return new RegisterAccountPage(driver);
	}

}
