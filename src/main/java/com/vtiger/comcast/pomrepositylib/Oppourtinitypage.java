package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Oppourtinitypage {
		
	
	public Oppourtinitypage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath="//img[@title='Create Opportunity...']")
	    private WebElement plusbuttonlnk;
	
	public WebElement getplusbuttonlnk() {
		 plusbuttonlnk.click();
		return plusbuttonlnk;
	}

}
