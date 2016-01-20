package com.santhyreddy.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**********************************************************
 * 
 * *** Scenario to be automated **** Launch the web browser and open the webpage
 * Click on the “Google” hyperlink Navigate back to the original web page Select
 * the “Green” in color dropdown Select the “Orange” in the fruit dropdown
 * Select the “Elephant” in the animal dropdown
 * 
 **********************************************************/

public class JunitLocalHTML
{

	/**
	 * @param args
	 */

	WebDriver driver;

	@Before
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.get("file:///C:/Users/santhi/Desktop/new.html");
		driver.manage().window().maximize(); // Maximize the window

	}

	@Test
	public void testSelect() throws InterruptedException
	{
		driver.findElement(By.linkText("Google")).click();
		driver.navigate().back();
		Thread.sleep(1000);

		// Select operator to select an option from drop down menu -
		// selectByValue
		Select selectByValue = new Select(driver.findElement(By.id("SelectID_One")));
		selectByValue.selectByValue("greenvalue");
		Thread.sleep(5000);

		// Select operator to select an option from drop down menu -
		// selectByVisibleText
		Select selectByVisibleText = new Select(driver.findElement(By.id("SelectID_Two")));
		selectByVisibleText.selectByVisibleText("Lime");
		Thread.sleep(5000);

		// select the third dropdown using "select by index"
		//selectByIndex
		Select selectByIndex = new Select(driver.findElement(By.id("SelectID_Three")));
		selectByIndex.selectByIndex(2);
		Thread.sleep(5000);

	}		
		@After
		public void closeDriver()
		{
			driver.quit();
		}


}
