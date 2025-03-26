package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterAccountPage {
	
	WebDriver driver;
	
	
	@FindBy(xpath="//input[@id='input-firstname']")
	private WebElement firstNameTextField;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	private WebElement lastNameTextField;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailTextField;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	private WebElement telephoneTextField;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement confirmPasswordTextField;
	
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement agreeCheckBox;
	
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitButton;
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement accountCreateSuccessMessage;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement newsLetterCheckBox;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement existingEmailWarningText;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacywarningMessageText;
	
	@FindBy(xpath="//div[text()='First Name must be between 1 and 32 characters!']")
	private WebElement firstNameTextFieldWarningMessageText;
	
	@FindBy(xpath="//div[text()='Last Name must be between 1 and 32 characters!']")
	private WebElement lastNameTextFieldWarningMessage;
	
	@FindBy(xpath="//div[text()='E-Mail Address does not appear to be valid!']")
	private WebElement emailTextFieldWarningMessage;
	
	@FindBy(xpath="//div[text()='Telephone must be between 3 and 32 characters!']")
	private WebElement telephoneTextFieldWarningMessage;
	
	@FindBy(xpath="//div[text()='Password must be between 4 and 20 characters!']")
    private	WebElement passwordTextFieldWarningMessage;
	
	
	public RegisterAccountPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Actions
	
	public void firstNameInputValue(String fisrtNameTextValue){
		firstNameTextField.sendKeys(fisrtNameTextValue);
	}

	
    public void lastNameInputValue(String lastNameTextValue){
    	lastNameTextField.sendKeys(lastNameTextValue);
		
	}
    
   public void emailInputValue(String emailTextValue){
	   emailTextField.sendKeys(emailTextValue);
	}
   
   public void telephoneInputValue(String telephoneTextValue){
	   telephoneTextField.sendKeys(telephoneTextValue);
 	}
   
   public void passwordInputValue(String passwordTextValue){
	   passwordTextField.sendKeys(passwordTextValue);
 	}
   
   public void confirmPasswordInputValue(String confirmPasswordTextValue){
	   confirmPasswordTextField.sendKeys(confirmPasswordTextValue);
 	}
   
  public void clickOnAgreeCheckBox(){
	  agreeCheckBox.click();
   }
  
 public void clickOnSubmitButton(){
	 submitButton.click();
  }
 public String retrievingAccountCreateSuccessMessage(){
	String accountCreateSuccessConfirmationMessageText= accountCreateSuccessMessage.getText();
	return accountCreateSuccessConfirmationMessageText;
 }
 
 public void clickOnNewsLetterCheckBox(){
	 newsLetterCheckBox.click();
 }
 
 public String retrievingExistingEmailWarningText(){
	String alreadyRegisteredEmailWarningText= existingEmailWarningText.getText();
	return alreadyRegisteredEmailWarningText;
	 
 }
 
 public String retrievingPrivacyWarningMessageText(){
	String privacyWarningMessageTextValue=privacywarningMessageText.getText();
	return privacyWarningMessageTextValue;
 }

 public String retrievingFirstNameTextFieldWarningMessage(){
	String firstNameWarningText=firstNameTextFieldWarningMessageText.getText();
	return firstNameWarningText;
}
 public String retrievingLastNameWarningMessageText(){
 String	lastNameTextFieldWarningMessageText= lastNameTextFieldWarningMessage.getText();
 return lastNameTextFieldWarningMessageText;
 }
 
 public String retrievingEmailTextFieldWarningText(){
	String emailTextFieldWarningMessageText=emailTextFieldWarningMessage.getText();
	return emailTextFieldWarningMessageText;
 }
 
 public String retrievingTelephoneTextFieldWarningMessageText(){
	String telephoneTextFieldWarningMessageText=telephoneTextFieldWarningMessage.getText();
	return telephoneTextFieldWarningMessageText;
 }
 
 public String retrievingPasswordTextFieldWarningMessageText(){
	String passwordTextFieldWarningMessageText= passwordTextFieldWarningMessage.getText();
	return passwordTextFieldWarningMessageText;
 }

}



