package com.santhyreddy.localFiles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**********************************************************************************************
 * Scenario to be automated --
 * 
 * Launch the web browser and open the application under test –
 * 'file:///C:/Users/santhi/Desktop/new.html' Verify the web page title Verify
 * if the “Try it” button is displayed Verify that the “Try it” button is
 * enabled Select "Green" value from the select drop down. Based on visibility
 * of the "Try it"button, click it.
 ***********************************************************************************************/
public class VisibilityConditions
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		boolean isEnabled = false;
		WebDriver driver = new FirefoxDriver();
		
		driver.get("file:///C:/Users/santhi/Desktop/new.html");
		driver.manage().window().maximize();
		
		String actualPageTitle = driver.getTitle();
		WebElement tryButton = driver.findElement(By
				.xpath("/html/body/div[3]/div/table/tbody/tr[2]/td/button"));
		String expectedPageTitle = "Testing Select Class";
		
		System.out.println("<--------------- Title Test -----------------> ");
		
		if (actualPageTitle.equals(expectedPageTitle))
		{
			System.out.println("Test Pass");
		}
		else
		{
			System.out.println("Test Fail");
		}
		System.out
				.println("<--------------- Button display Test -----------------> ");
		
		if (tryButton.isDisplayed())
		{
			System.out.println("Test Pass ");
		}
		else
		{
			System.out.println("Test Fail");
		}
		System.out
				.println("<--------------- Button enable Test -----------------> ");
		
		if (tryButton.isEnabled())
		{
			isEnabled = true;
			System.out.println("Test Pass ");
		}
		
		// Select Green color
		Select colorSelect = new Select(driver.findElement(By
				.id("SelectID_One")));
		colorSelect.selectByVisibleText("Green"); // CAN USE
		// selectByValue("greenvalue") ALSO;
		
		if (isEnabled)
		{
			tryButton.click();
		}
		
		driver.close();
	}
}