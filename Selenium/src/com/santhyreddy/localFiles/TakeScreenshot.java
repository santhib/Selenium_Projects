package com.santhyreddy.localFiles;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * Take Screen shot of web page and save it in a folder.
 * Filename - homePage+ <current time stamp>+.png
 * Save in same project folder.
 * Web page - http://book.theautomatedtester.co.uk
 * 
 */

public class TakeScreenshot
{
	public static void main(String[] args)
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://book.theautomatedtester.co.uk");
		driver.manage().window().maximize();
		String title = "homePage_" + getDateTime().replace(':', '_');
		File webScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = "C:/Users/santhi/Desktop/MyCrazyCoding/SelelinumProjects/LearningSelenium/src/com/santhyreddy/localFiles/"+ title + ".png";
		saveInFolder(webScreenshot, path);
	}
	private static void saveInFolder(File webScreenshot, String filePath)
	{
		try
		{
			FileUtils.copyFile(webScreenshot, new File(filePath));
		}
		catch (IOException e)
		{
			System.out.print("Failed to capture screenshot: " + e.getMessage());
		}
	}
	private final static String getDateTime()
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss");
		df.setTimeZone(TimeZone.getTimeZone("EST"));
		return df.format(new Date());
	}
}