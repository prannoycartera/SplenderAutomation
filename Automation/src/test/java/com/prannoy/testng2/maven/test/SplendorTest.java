package com.prannoy.testng2.maven.test;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SplendorTest {

	public WebDriver driver;
	
	@Test
	 public void main()
	  {
		
		//checkSignUp();
		
		/*check for invalid credentials*/
		 Assert.assertEquals(checkLogin("jason@gmail.com","Hello123"), true);
		 driver.get("http://qa.splender.com/#!/ "); 
		 Assert.assertEquals(checkLogin("Hale@gmail.com","Hello123"), true);
		 driver.get("http://qa.splender.com/#!/ "); 
		 
		 /*check valid credential*/
		 Assert.assertEquals(checkLogin("j.doe@gmail.com","Hello123"), false);
		 WebElement welcome = driver.findElement(By.xpath("/html/body/div[1]/div/header/div/nav[1]/div/ul/li[1]/span"));
		 System.out.println(welcome.getText());
		 
	  }
	
	  @BeforeMethod 
	  public void beforeMethod()
	  { 
		  this.driver = new FirefoxDriver();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver.get("http://qa.splender.com/#!/ "); 
	  }
	  
	  public void checkSignUp()
	  {
		    WebElement  signup = driver.findElement(By.xpath("//span[contains(.,'Sign Up')]/.."));
			signup.click();
			
			WebElement signupModalShow = driver.findElement(By.xpath("//div[@id='join-modal']"));
			Assert.assertEquals(true,signupModalShow.isDisplayed());
			
			WebElement joinButton = driver.findElement(By.xpath("//div[@class='join-button default']/button[contains(.,'Join')]"));
			joinButton.click();
			
			WebElement signUpError = driver.findElement(By.xpath("//strong[@class='ng-binding']"));
			System.out.println(signUpError.getText());
			
			WebElement fname = driver.findElement(By.xpath("//input[@id='firstName']"));
			fname.sendKeys("Jason");
			WebElement lname = driver.findElement(By.xpath("//input[@id='lastName']"));
			lname.sendKeys("Voorhees");
			WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
			email.sendKeys("friday13@gmail.com");
			WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
			password.sendKeys("Hello123");
			WebElement agree = driver.findElement(By.xpath("//input[@id='toc']"));
			Assert.assertEquals(false, agree.isSelected());
			agree.click();
			Assert.assertEquals(true, agree.isSelected());
	  }
	  
	  public boolean checkLogin(String emailInput,String passwordInput)
	  {
		  WebElement login = driver.findElement(By.xpath("/html/body/div[1]/div/section/div/section[1]/div/div/div/div/div/div/div[2]/a"));
		  login.click();
		  
		  WebElement email = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/form/fieldset/div[1]/div/input"));
	      email.sendKeys(emailInput);
	      
	      WebElement password = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/form/fieldset/div[2]/div/input"));
	      password.sendKeys(passwordInput);
	      
	      WebElement loginButton = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/form/fieldset/div[4]/button"));
	      loginButton.click();
	      
	      WebElement errorMessage = (new WebDriverWait(driver, 10))
	    		  .until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/form/fieldset/div[3]/strong")));
	      
	      return errorMessage.isDisplayed();    
	  }
	  
	  
	 
	  @AfterMethod 
	  public void afterMethod()
	  {
	
	      driver.quit();
	 
	  }
	  
	  
}
