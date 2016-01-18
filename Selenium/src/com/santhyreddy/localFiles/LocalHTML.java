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
		String appURL = "file:///C:/Users/santhi/Desktop/new.html"; // Assign the base URL
		driver.get(appURL); //Attach url to driver
		driver.manage().window().maximize(); //Maximize the window
		
	}

}
