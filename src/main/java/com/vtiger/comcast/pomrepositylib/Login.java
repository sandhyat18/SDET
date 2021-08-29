package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	   private WebElement UserNameEdt;
	
	@FindBy(name="user_password")
	   private WebElement UserPasswordEdt;
	
	@FindBy(id="submitButton")
	   private WebElement LoginButton;
	
	public WebElement getUserNameEdt() {
		return UserNameEdt;
		
	}
	 
	public WebElement getUserPasswordEdt() {
		return UserPasswordEdt;
		
	}
	public WebElement getLoginButton() {
		return LoginButton;
		
	}
	
	public void loginToApp(String username, String password) {
		UserNameEdt.sendKeys(username);
		UserPasswordEdt.sendKeys(password);
		LoginButton.click();
		
		
	}

}
