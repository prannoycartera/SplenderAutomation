package com.prannoy.testng2.maven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageObjectModelTest {
	
	public  WebDriver driver;
	
	@Test
	public void main()
	{
		SplendorPage sp = new SplendorPage(this.driver);
		
		if(!("pocketrewards - Development Environment").equals(sp.getTitle()))
		{
			System.out.println("Not on currentpage");
		}
	   sp.checkElementDisplay(sp.offers);
	   sp.checkElementDisplay(sp.stores);
	   
	   StoresPage stores =sp.clickStores(this.driver);	
	}
	
	@BeforeMethod 
	  public void beforeMethod() 
	  { 
		  this.driver = new FirefoxDriver();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver.get("http://qa.b2c-fe.com/#!/ "); 
	  }
	 
	  @AfterMethod 
	  public void afterMethod()
	  {
	
	      driver.quit();
	 
	  }

}
