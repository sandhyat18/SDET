package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Oppourtinityinfopage {
	public Oppourtinityinfopage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

//	public void oppourtinityinfo(WebDriver driver) {
//		PageFactory.initElements(driver, this);
//	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	 private WebElement succesfullmsg;
	
	public WebElement getsuccessfullmsg() {
		return succesfullmsg;
	}

}
