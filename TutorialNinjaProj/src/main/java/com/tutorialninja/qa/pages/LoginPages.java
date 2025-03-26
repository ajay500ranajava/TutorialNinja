package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {

	WebDriver driver ;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailTextField; 
	
	@FindBy(xpath="//input[@id='input-password']")
	private	WebElement passwordTextField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement emailPasswordNoMatchWarning;
	
	
 public LoginPages(WebDriver driver ){
	 
	
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
	 
	 
	
}
 //Actions
 
 public void emailTextFieldInputValue(String emailTextValue){
	 emailTextField.sendKeys(emailTextValue);
 }
 
 public void passwordTextFieldEnteredValue(String passwordTextValue){
	 passwordTextField.sendKeys(passwordTextValue);
 }
public void clickOnLoginButton(){
	loginButton.click();
 }
public String retrievingTextMessageForEmailPasswordNotMatchWarning(){
String	warningText=emailPasswordNoMatchWarning.getText();
return warningText;
	
}
}
