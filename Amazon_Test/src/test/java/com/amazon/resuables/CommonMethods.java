package com.amazon.resuables;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class CommonMethods {

	static WebDriver driver;
	public ExtentReports extent;
	public static ExtentTest test;

	/**
	 * Launch Driver
	 */
	public void launchBrowser() {

//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		// Initialize browser
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(getProperty("url"));

		// Maximize browser
		driver.manage().window().maximize();
	}

	/**
	 * Get property from a JSON
	 */
	public String getProperty(String str) {

		JSONObject jo = null;

		try {
			// parsing file "JSONExample.json"
			Object obj = new JSONParser().parse(new FileReader(".\\src\\test\\resources\\Config\\config.json"));
			// typecasting obj to JSONObject
			jo = (JSONObject) obj;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return (String) jo.get(str);
	}

	/**
	 * Wait
	 */
	public void wait(By by) {

		new WebDriverWait(driver, 12).until(ExpectedConditions.presenceOfElementLocated(by));
	}

	/**
	 * Is element present
	 */
	public boolean isElementPresent(By by) {

		boolean flag = false;

		try {
			if (driver.findElement(by) != null)
				flag = true;
		} catch (Exception e) {
			flag = false;
			System.err.println("Element, " + by + " is not found");
		}

		return flag;
	}

	/**
	 * Click
	 */
	public void click(By by) {

		try {
			wait(by);
			hoverOver(by);
			highlightElement(by);
			driver.findElement(by).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Click
	 */
	public void hoverOver(By by) {

		try {
			wait(by);
			new Actions(driver).moveToElement(driver.findElement(by));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Switch
	 */
	public void switchToCurrentWindow() {

		try {
			driver.getWindowHandles().forEach(x -> driver.switchTo().window(x));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Enter text
	 */
	public void enterText(By by, String str) {
		try {
			wait(by);
			highlightElement(by);
			driver.findElement(by).sendKeys(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Take screenshot
	 */
	public void takeScreenshot() {

		try {
			FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
					new File(".\\" + getCurrentTime().replaceAll("\\W", "") + ".jpg"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Current time
	 */
	public String getCurrentTime() {
		return (LocalDateTime.now().toString());
	}

	/**
	 * Scroll to view
	 */
	public void scrollToView(By by) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Highlight element
	 */
	public void highlightElement(By by) {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid blue'",
				driver.findElement(by));
	}

	/**
	 * Get text
	 */
	public String getText(By by) {

		wait(by);
		return driver.findElement(by).getText();
	}

	/**
	 * Copy to a new notepad file
	 */
	public void copyToNotepad(String str) {

		try {
			Files.write(Paths.get(".\\output.txt"), str.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Tear down
	 */
	public static void tearDown() {
		driver.quit();
	}

	public void startExtentReport() {
		// 1 - Initializing Report
		extent = new ExtentReports(".\\extentReport.html", false);
		// By default, the OS, User Name, Java Version and Host Name will be available
		extent.addSystemInfo("Selenium Version", "2.46");
		extent.addSystemInfo("Environment", "Prod");

		extent.loadConfig(new File(".\\src\\test\\resources\\Config\\extent-config.xml"));
		test = extent.startTest("Test Name", "Sample description");
	}

	public void endExtentReport() {
		extent.endTest(test);
		extent.flush();
	}

}
