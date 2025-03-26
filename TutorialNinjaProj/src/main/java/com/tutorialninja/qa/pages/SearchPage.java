package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	
	@FindBy(xpath="//input[contains(@class,'form-control input-lg')]")
	private WebElement searchWithValidProduct;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement clickOnSearchButton;
	
	@FindBy(linkText="HP LP3065")
	private WebElement validateHpIsDisplayed;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	private WebElement noProductMatchWarningMessage;
	
	public SearchPage(WebDriver driver){
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public void searchWithValidProductHp(String validProduct){
		
		searchWithValidProduct.sendKeys(validProduct);
	}
	
	public void clickOnSearchButton(){
		clickOnSearchButton.click();
	}
	
	public boolean validateHpProductIsDisplayed(){
		boolean verifyHpProductIsDisplayed=validateHpIsDisplayed.isDisplayed();
		return verifyHpProductIsDisplayed;
	}
	
	public String retrieveNoProductMatchWarningMessage(){
		String noProductMatchWarningMessageText=noProductMatchWarningMessage.getText();
		return noProductMatchWarningMessageText;
	}

}
