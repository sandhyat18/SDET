package com.practice;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import junit.framework.Assert;


public class SampleTest2 extends Extent2{
	
		@Test
		public void getTitleForHome() {
			test = reports.createTest("getTitleForHome");

			String expTitle = "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";

			String actualTitle = driver.getTitle();
			Assert.assertEquals(expTitle, actualTitle);
		}
	}



