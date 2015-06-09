package com.prannoy.testng2.maven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SplendorPage
{
	
	private final WebDriver driver;
	protected By offers = By.xpath("//a[@href='#!/offers']");
	protected By stores = By.xpath("//a[@href='#!/stores']");
	private String title;
	
	
	SplendorPage(WebDriver driver)
	{
		this.driver=driver;
		this.title=driver.getTitle();
	}
	
	public void checkElementDisplay(By element)
	{
		Assert.assertEquals(true,  driver.findElement(element).isDisplayed());
		System.out.println(driver.findElement(element).getText());
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public StoresPage clickStores(WebDriver driver)
	{
		StoresPage sp = new StoresPage(driver);
		driver.findElement(stores).click();
		return sp.returnPage();
	}
	
	

}
