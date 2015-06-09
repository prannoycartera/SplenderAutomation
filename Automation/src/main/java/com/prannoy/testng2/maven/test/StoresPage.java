package com.prannoy.testng2.maven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class StoresPage
{
	
	private final WebDriver driver;
	private String title;
	private String url = "http://qa.b2c-fe.com/#!/stores/c/all-categories/alpha/";
	
	
	StoresPage(WebDriver driver)
	{
		this.driver=driver;
		this.title=driver.getTitle();
		this.url=driver.getCurrentUrl();
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
	
	public String getUrl()
	{
		return this.url;
	}
	
	public StoresPage returnPage()
	{
		return this;
	}
	
	
	

}
