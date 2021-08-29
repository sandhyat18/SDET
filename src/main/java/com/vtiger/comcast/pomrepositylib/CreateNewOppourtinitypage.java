package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOppourtinitypage {
	public WebDriver driver;

	public CreateNewOppourtinitypage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

		
	@FindBy(name="potentialname")
	  private WebElement opponametxtfild;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement plusbutton;
	
	@FindBy(id="search_txt")
	private WebElement searchtextfld;
	
	@FindBy(name="search")
	private WebElement searchnow;
	
	@FindBy(linkText="HP Laptop")
	private WebElement selectorg;
	
	@FindBy(id="related_to_type")
	   private WebElement relatedtodropdown;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement radiobutton;
	
	@FindBy(name="assigned_group_id")
	private WebElement assignedtodropdown;
	
	@FindBy(name="sales_stage")
	   private WebElement salesstagedropdown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebutton;
	@FindBy(xpath="//input[@title='Cancel [Alt+X]']")
	private WebElement cancelbutton;
		
	public void enteroppname(String oppname) {
		opponametxtfild.sendKeys(oppname);
	}
	public WebElement getplusbutton() {
		return plusbutton;
	}
	public void getsearchtextfield(String Orgname) {
		searchtextfld.sendKeys(Orgname);
	}
	public WebElement getsearchnow() {
		return searchnow;
	}
		
	public WebElement getrelatedtodropdown() {
		return relatedtodropdown;
	}
	
	public WebElement getradiobutton() {
		return radiobutton;
	}
	public void getassignedtodropdown() {
		Select s1 = new Select(assignedtodropdown);
		s1.selectByVisibleText("Team Selling");
	}
	
	public void getsalesstagedropdown() {
		Select s = new Select(salesstagedropdown);
		s.selectByVisibleText("Closed Lost");
		
	}
	
	public WebElement getsavebutton() {
		return savebutton;
	}
	public WebElement getcancelbutton() {
		return cancelbutton;
	}
	
	public WebElement getSelectorg() {
		// TODO Auto-generated method stub
		return selectorg;
	}
	
}
