package com.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleTest {

	public WebDriver driver;
	ExtentHtmlReporter reporter;
	ExtentReports reports;
	ExtentTest report;

	@BeforeSuite
	public void configBS() {
		reporter = new ExtentHtmlReporter("./SDET/Extent/extent.html");
		System.out.println("Before Suit Execute");
		reporter.config().setDocumentTitle("SDET");
		reporter.config().setTheme(Theme.DARK);
		reports = new ExtentReports();
		reports.attachReporter(reporter);

	}

	@BeforeClass
	public void configBC() {
		System.out.println("=======Launch the browser=======");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");

	}

	@BeforeMethod
	public void configBM() {

		System.out.println("=======Login to the App=======");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();

	}

	@Test
	public void config() {
		System.out.println("=======Login to the App=======");

		String homepagetitle = driver.getTitle();
		System.out.println(homepagetitle);
		driver.findElement(By.linkText("Organizations")).click();
		String orgpagetitle = driver.getTitle();
		System.out.println(orgpagetitle);

	}

	@AfterMethod
	public void configAM() throws InterruptedException {
		System.out.println("======Logout from the application======");
		WebElement adminstatorImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/layerPopupBg.gif']"));
		Thread.sleep(5000);
		WebElement signOutLnk = driver.findElement(By.linkText("Sign Out"));
		Actions act = new Actions(driver);
		act.moveToElement(adminstatorImg).perform();
		signOutLnk.click();
	}

	@AfterClass
	public void configAC() {
		System.out.println("=========Close the Browser========");
		driver.close();
	}

	@AfterSuite
	public void configAS() {
		System.out.println("========Stop the server==========");
		driver.quit();
	}

}
