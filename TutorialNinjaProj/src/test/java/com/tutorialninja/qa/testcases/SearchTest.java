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
import com.tutorialninja.qa.pages.SearchPage;
public class SearchTest extends Base{
	
	public WebDriver driver;
	public SearchTest(){
		super();
	}
	
	
	@BeforeMethod
public void	setUp(){
		driver=initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	}
	
	@AfterMethod
public void	tearDown(){
		driver.quit();
	}
	@Test(priority=1)
public void	verifySearchwithValidProduct(){
		
	SearchPage searchPage=new SearchPage(driver);
	searchPage.searchWithValidProductHp(prop1.getProperty("validProduct"));
	searchPage.clickOnSearchButton();
	Assert.assertTrue(searchPage.validateHpProductIsDisplayed(), "item is not displayed");
	//driver.findElement(By.xpath("//input[contains(@class,'form-control input-lg')]")).sendKeys(prop1.getProperty("validProduct"));
	//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	//Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(), "item is not displayed");
	
	
	}
	@Test(priority=2)
public void	verifySearchWithInvalidProduct(){
		SearchPage searchPage=new SearchPage(driver);
		searchPage.searchWithValidProductHp(prop1.getProperty("inValidProduct"));
		searchPage.clickOnSearchButton();
		String	actualResult=searchPage.retrieveNoProductMatchWarningMessage();
	//driver.findElement(By.xpath("//input[contains(@class,'form-control input-lg')]")).sendKeys(prop1.getProperty("inValidProduct"));
	//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
//String	actualResult=driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
        String expectedResult=prop1.getProperty("noProductMatchWarning");
        Assert.assertEquals(actualResult, expectedResult,"Search item is not matched");
	}

	@Test(priority=3)
public void	verifySearchWithOutAnyProduct(){
		
		SearchPage searchPage=new SearchPage(driver);
		searchPage.searchWithValidProductHp("");
		searchPage.clickOnSearchButton();
		String	actualResult=searchPage.retrieveNoProductMatchWarningMessage();
	
	//driver.findElement(By.xpath("//input[contains(@class,'form-control input-lg')]")).sendKeys("");
	//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
//String	actualResult=driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
String expectedResult=prop1.getProperty("noProductMatchWarning");
Assert.assertEquals(actualResult, expectedResult,"Search item is not matched");
	}
}
