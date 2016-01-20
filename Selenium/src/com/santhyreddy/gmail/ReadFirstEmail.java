package com.santhyreddy.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadFirstEmail
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String browser = "Firefox"; 
		WebDriver driver = getWebDriver(browser);
		String webSite = "http://www.gmail.com";
		By emailInputfield = By.id("Email");
		By passInputField = By.id("Passwd");
		String emailAddress = "email"; //changed 
		String password = "password"; //changed 
		By nextButton = By.id("next");
		By signInbutton = By.id("signIn");
		By firstEmailXpath =  By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div[4]/div[2]/div[2]/div/table/tbody/tr[1]/td[6]/div/div/div/span[1]/b");
		
		if(driver!=null)
		{
			driver.get(webSite);
			driver.manage().window().maximize();
			driver.findElement(emailInputfield).sendKeys(emailAddress);
			driver.findElement(nextButton).click();
			
			//Wait for 10 seconds till password frame is visible.
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(passInputField));
			
			driver.findElement(passInputField).sendKeys(password);
			driver.findElement(signInbutton).click();
			
			//Wait for 30 seconds till inbox opens.
			WebDriverWait waitt = new WebDriverWait(driver, 30);
			waitt.until(ExpectedConditions
					.visibilityOfElementLocated(firstEmailXpath));
			String firstEmailsubject = driver.findElement(firstEmailXpath).getText();
			System.out.println("First email subject : "+firstEmailsubject);
		}

	}
	/*
	 * @Param browser
	 */

	private static WebDriver getWebDriver(String browser)
	{
		WebDriver browserDriver = null;
		
		if(browser.equalsIgnoreCase("Firefox"))
		{
			browserDriver = new FirefoxDriver();
		}
		if(browser.equalsIgnoreCase("IE"))
		{
			browserDriver = new InternetExplorerDriver();
		}
		if(browser.equalsIgnoreCase("Chrome"))
		{
			browserDriver = new ChromeDriver();
		}
		return browserDriver;
	}

}
