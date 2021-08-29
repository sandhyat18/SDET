package com.vtiger.comcast.oppourtinitytest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.comcast.pomrepositylib.CreateNewOppourtinitypage;
import com.vtiger.comcast.pomrepositylib.Homepage;
import com.vtiger.comcast.pomrepositylib.Login;
import com.vtiger.comcast.pomrepositylib.Oppourtinityinfopage;
import com.vtiger.comcast.pomrepositylib.Oppourtinitypage;

public class TC1_createOppourtinity {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String oppname = "abcd";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
		
		Login loginpage = new Login(driver);
		loginpage.loginToApp("admin", "admin");
		
		
		Homepage homepage = new Homepage(driver);
		homepage.getopportunitylnk().click();
	
		
		Oppourtinitypage oppourtinitypage = new Oppourtinitypage(driver);
		oppourtinitypage.getplusbuttonlnk().click();
		

		
		CreateNewOppourtinitypage cno = new CreateNewOppourtinitypage(driver);
		String Createoppourtinityurl = driver.getCurrentUrl();
		String parentId = driver.getWindowHandle();
		cno.enteroppname(oppname);
		cno.getplusbutton().click();
		
		
		
	Set<String> allid = driver.getWindowHandles();
	for(String wid:allid) {
			
			if(!(wid.equals(parentId))) {
				driver.switchTo().window(wid);
				break;
			}
				
				
		}
		
		driver.switchTo().activeElement();
		
		
		cno.getsearchtextfield("HpLaptop");
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
		
		if(actsuccesfullmsg.contains(oppname)) {
			System.out.println(oppname +" == Created successfully");
		}else {
			System.out.println(oppname + " ==== not created successfully");
		}
	


	}

}
