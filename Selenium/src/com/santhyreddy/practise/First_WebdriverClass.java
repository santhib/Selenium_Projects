package com.santhyreddy.practise;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class First_WebdriverClass
{
	public static void main(String[] args)
	{
		System.out.println("Selenium project");
		WebDriver driver = new FirefoxDriver(); // Get driver
		String appURL = "http://www.google.com"; // Assign the base URL
		driver.get(appURL); //Attach url to driver
		driver.manage().window().maximize(); //Maximize the window
		String actualTitle = driver.getTitle(); // Grab title
		System.out.println("Page title : " + actualTitle);
		String expectedTitle = "Google";
		
		if (expectedTitle.equals(actualTitle)) // Verify if titles match
		{
			System.out.println("titles matched");
		}
		
		WebElement searchBox = driver.findElement(By.id("lst-ib")); // Grab Search Box
		searchBox.clear(); // Clear it
		searchBox.sendKeys("Telidos"); // Type 'Santhi' to search box
		
		WebElement searchButton = driver.findElement(By.name("btnG")); // Get Search button
		searchButton.click(); //Click it
		
		String PagetitleAfterSearch = "Santhi - Google Search";
		String acPagetitle = driver.getTitle();
		System.out.println("actitle:" + acPagetitle);
		
		if (PagetitleAfterSearch.equals(acPagetitle))
		{
			System.out.println("titles matched after search");
		}
		else
		{
			System.out.println("titles are not matched");
		}
	}
}
