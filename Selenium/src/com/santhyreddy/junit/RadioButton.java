package com.santhyreddy.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * Scenario 1 is to select radio button in the chapter 1 of below website
 * http://book.theautomatedtester.co.uk
 * 
 * Scenario 2 is to click on link1 to open a window and 
 * get the text from that window.
 */
public class RadioButton
{
	WebDriver driver = new FirefoxDriver();
	@Before
	public void setUp() throws InterruptedException
	{
		
		driver.get("http://book.theautomatedtester.co.uk");
		driver.manage().window().maximize();
		//driver.wait(100);
	}
	
	@Test
	public void performTest()
	{
		driver.findElement(By.linkText("Chapter1")).click();
		driver.findElement(By.id("radiobutton")).click();
		driver.findElement(By.className("multiplewindow")).click();		
		driver.navigate().to("http://book.theautomatedtester.co.uk/windowpopup.html");
		String currURL = driver.getCurrentUrl(); //http://book.theautomatedtester.co.uk/windowpopup.html
		System.out.println("---> currURL after window.open : "+currURL);
		String popUpText = driver.findElement(By.id("popuptext")).getText();
		System.out.println("---> alertText : "+popUpText);		
		
	}
	
	@After
	public void afterTest()
	{
		driver.quit();
	}
	
}
