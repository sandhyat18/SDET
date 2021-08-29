package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.comcast.genericUtility.WebDriverUtility;

public class Homepage {
	public WebDriver driver;
	WebDriverUtility wdUtil = new WebDriverUtility();
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(linkText="Opportunities")
	   private WebElement opportunitylnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstatorImg;
	
	public WebElement getOpportunitylnk() {
		return opportunitylnk;
	}

	public WebElement getAdminstatorImg() {
		return adminstatorImg;
	}

	public WebElement getSignOutlnk() {
		return signOutlnk;
	}


	public WebDriver getDriver() {
		return driver;
	}


	@FindBy(linkText="Sign Out")
	private WebElement signOutlnk;
	
	public WebElement getopportunitylnk() {
		 opportunitylnk.click();
		return opportunitylnk;
	}

	public void Logout() {
		wdUtil.mouseOver(driver, getAdminstatorImg());
//		Actions action = new Actions(driver);
//		action.moveToElement(adminstatorImg).perform();
		signOutlnk.click();
		
	}
		
		
		
	}


