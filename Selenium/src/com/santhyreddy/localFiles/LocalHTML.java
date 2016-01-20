package com.santhyreddy.localFiles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class LocalHTML
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		WebDriver driver = new FirefoxDriver();
		// Assign the base URL
		String appURL = "file:///C:/Users/santhi/Desktop/new.html";
		// Attach url to driver
		driver.get(appURL);
		// Maximize the window
		driver.manage().window().maximize();
	}
}
