package com.vtiger.comcast.oppourtinitytest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.comcast.genericUtility.BaseClass;
import com.vtiger.comcast.genericUtility.ExcelUtility;
import com.vtiger.comcast.genericUtility.FileUtility;
import com.vtiger.comcast.genericUtility.JavaUtility;
import com.vtiger.comcast.genericUtility.WebDriverUtility;
import com.vtiger.comcast.pomrepositylib.CreateNewOppourtinitypage;
import com.vtiger.comcast.pomrepositylib.Homepage;
import com.vtiger.comcast.pomrepositylib.Login;
import com.vtiger.comcast.pomrepositylib.Oppourtinityinfopage;
import com.vtiger.comcast.pomrepositylib.Oppourtinitypage;

@Listeners(com.vtiger.comcast.genericUtility.ListerImp.class)

public class TC1_createOppourtinity extends BaseClass{
	
	@Test
	public void TC1_createOppourtinity() throws Throwable  {
		
		
		
    	String Opponame =elib.getDataFromExcel("Sheet1", 1, 1);
 		String orgName = elib.getDataFromExcel("Sheet1", 0, 1);
    	String assignto = elib.getDataFromExcel("Sheet1", 2, 1);

		
		Homepage homepage = new Homepage(driver);
		homepage.getopportunitylnk().click();
	
		
		Oppourtinitypage oppourtinitypage = new Oppourtinitypage(driver);
		oppourtinitypage.getplusbuttonlnk().click();
		

		
		CreateNewOppourtinitypage cno = new CreateNewOppourtinitypage(driver);
		String Createoppourtinityurl = driver.getCurrentUrl();
		String parentId = driver.getWindowHandle();
		cno.enteroppname(Opponame);
		cno.getplusbutton().click();
		
				
	Set<String> allid = driver.getWindowHandles();
	for(String wid:allid) {
			
			if(!(wid.equals(parentId))) {
				driver.switchTo().window(wid);
				break;
			}
				
				
		}
		
		driver.switchTo().activeElement();
				
		cno.getsearchtextfield(orgName);
		cno.getsearchnow().click();
		cno.getSelectorg().click();
		
		driver.switchTo().window(parentId);
		
		cno.getrelatedtodropdown().click();
		
		cno.getradiobutton().click();
		
		
		cno.getassignedtodropdown();
		cno.getsalesstagedropdown();
		cno.getsavebutton().click();
		
		Oppourtinityinfopage oppourtinityinfo = new Oppourtinityinfopage(driver);
		String actsuccesfullmsg = oppourtinityinfo.getsuccessfullmsg().getText();
		String expRes = "Opportunity" + Opponame+ " is created Successfully";
		Assert.assertEquals(actsuccesfullmsg, expRes);

	
	}

	
		@Test
		

		public void TC2_CreateOppourtinityandclickcancel() throws Throwable  {
			
			String Opponame =elib.getDataFromExcel("Sheet1", 1, 1);
	 		String orgName = elib.getDataFromExcel("Sheet1", 0, 1);
	    	String assignto = elib.getDataFromExcel("Sheet1", 2, 1);

						
			Homepage homepage = new Homepage(driver);
			homepage.getopportunitylnk().click();
			
						
			Oppourtinitypage oppourtinitypage = new Oppourtinitypage(driver);
			oppourtinitypage.getplusbuttonlnk().click();
			
						
			CreateNewOppourtinitypage cno = new CreateNewOppourtinitypage(driver);
			String Createoppourtinityurl = driver.getCurrentUrl();
			String parentId = driver.getWindowHandle();
			cno.enteroppname("abcd");
			cno.getplusbutton().click();
						
			
			Set<String> allid = driver.getWindowHandles();
			for(String wid:allid) {
					if(!(wid.equals(parentId))) {
						driver.switchTo().window(wid);
						break;
					}
						
						
				}
				
				driver.switchTo().activeElement();
				
				
				cno.getsearchtextfield(orgName);
				cno.getsearchnow().click();
				cno.getSelectorg().click();
				
				driver.switchTo().window(parentId);
				cno.getrelatedtodropdown().click();
				cno.getradiobutton().click();
				cno.getassignedtodropdown();
				cno.getsalesstagedropdown();
				cno.getcancelbutton().click();
			
				Oppourtinityinfopage oppourtinityinfo = new Oppourtinityinfopage(driver);
				String actsuccesfullmsg = oppourtinityinfo.getsuccessfullmsg().getText();
				
			    Assert.assertTrue(true, actsuccesfullmsg);
				

		


		}

	}



