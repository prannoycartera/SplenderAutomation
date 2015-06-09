package com.prannoy.testng2.maven.test;
import java.util.concurrent.TimeUnit;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AppTest
{

public WebDriver driver;
	 
	  @Test 
	  public void main() 
	  {
		splendor();	
	  }
	  
	  public void splendor()
	  {
		
		   WebElement stores = driver.findElement(By.xpath("//a[@href='#!/stores']"));
		   WebElement offers = driver.findElement(By.xpath("//a[@href='#!/offers']"));
		   WebElement shopAll = driver.findElement(By.xpath("//button[contains(.,'Shop All Stores')]"));
		   
		   Assert.assertEquals(true, stores.isDisplayed());
		   Assert.assertEquals(true, offers.isDisplayed());
		   Assert.assertEquals("Splender QA", driver.getTitle());
		   
		   shopAll.click();
		    
		   WebElement allStores = driver.findElement(By.xpath("//h1[contains(.,'All Stores')]"));   
		   Assert.assertEquals(true, allStores.isDisplayed());
		   try 
		   {
			 Thread.sleep(5000);
		   } 
		   catch (InterruptedException e) 
		   {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }   
		   if(allStores.isDisplayed())
		   {
			   WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
			   search.sendKeys("Macy's");
			   WebElement searchButton=driver.findElement(By.xpath("//button[@type='submit']"));
			   Assert.assertEquals(true,searchButton.isDisplayed());
			   searchButton.click();
			   
			   driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			   
			   try 
			   {
					Thread.sleep(2000);
			   } 
			   catch (InterruptedException e)
			   {
					// TODO Auto-generated catch block
					e.printStackTrace();
			   }   
			   
			   WebElement altText = driver.findElement(By.xpath("//img[@alt='Macys.com']"));
			   Assert.assertEquals(true, altText.isDisplayed());
		   }
		   else
		   {
			   System.out.println("Clicking on All Stores link did not work");
		   }
		   	   	      
	  }
	  

	  @BeforeMethod 
	  public void beforeMethod() 
	  { 
	      this.driver = new FirefoxDriver();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver.get("http://qa.splender.com/#!/ "); 
	  }
	 
	  @AfterMethod 
	  public void afterMethod()
	  {
	
	      driver.quit();
	 
	  }
}