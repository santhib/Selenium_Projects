package com.santhyreddy.gmail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/*
 * **************** WORK IN PROGRESS *****************
 * 
 */
public class SendEmail
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
		By composeButton = By
				.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div[1]/div/div");
		// By toField =
		// By.xpath("/html/body/div[14]/div/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/form/div[1]/table/tbody/tr[1]/td[2]/div/div/textarea");
		By toField = By.id(":xa");
		By subjectField = By
				.xpath("/html/body/div[14]/div/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/form/div[3]/input");
		By bodyTextArea = By
				.xpath("/html/body/div[14]/div/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/div/div[1]/div[2]/div[1]/div/table/tbody/tr/td[2]/div[2]/div");
		By sendButton = By
				.xpath("/html/body/div[14]/div/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/div/div/div[4]/table/tbody/tr/td[1]/div/div[2]");
		if (driver != null)
		{
			driver.get(webSite);
			driver.manage().window().maximize();
			driver.findElement(emailInputfield).sendKeys(emailAddress);
			driver.findElement(nextButton).click();
			// Wait till password frame is visible.
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(passInputField));
			driver.findElement(passInputField).sendKeys(password);
			driver.findElement(signInbutton).click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(composeButton));
			driver.findElement(composeButton).click();
			driver.findElement(toField).sendKeys("santhyreddy@gmail.com");
			// driver.switchTo().
			// driver.findElement(By.cssSelector("textarea[class='aoD hl']")).sendKeys("santhyreddy@gmail.com");
		}
	}
	private static WebDriver getWebDriver(String browser)
	{
		WebDriver browserDriver = null;
		if (browser.equalsIgnoreCase("Firefox"))
		{
			browserDriver = new FirefoxDriver();
		}
		if (browser.equalsIgnoreCase("IE"))
		{
			browserDriver = new InternetExplorerDriver();
		}
		if (browser.equalsIgnoreCase("Chrome"))
		{
			browserDriver = new ChromeDriver();
		}
		return browserDriver;
	}
}
