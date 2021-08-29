package com.vtiger.comcast.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.comcast.pomrepositylib.Homepage;
import com.vtiger.comcast.pomrepositylib.Login;

public class BaseClass {
	public static WebDriver sdriver;
	public WebDriver driver;
	  /*Object Creation for Lib*/
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	
	@BeforeSuite(groups= {"smokeTest", "regressionTest"})
	public void configBS() {
		System.out.println("========================connect to DB========================");
	}
//	@Parameters("Browser")
		
	@BeforeClass//(groups= {"smokeTest", "regressionTest"})
	public void configBC() {
		System.out.println("=============Launch the Browser=======");
//		if(Browser.e) {
//			
//		}
		driver = new ChromeDriver();
		wlib.waitUntilPageLoad(driver);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod//(groups= {"smokeTest", "regressionTest"})
	public void configBM() throws Throwable {
		/*common Data*/

		String UserName = flib.getPropertyKeyValue("UserName");
		String Password = flib.getPropertyKeyValue("Password"); 
		String Url = flib.getPropertyKeyValue("Url");
		String Browser = flib.getPropertyKeyValue("Browser");
		/* Navigate to app*/
		   driver.get(Url);
	        /* step 1 : login */
	        Login loginPage = new Login(driver);
	        loginPage.loginToApp(UserName, Password);
	}
	
	
	@AfterMethod//(groups= {"smokeTest", "regressionTest"})
	public void configAM() {
		System.out.println("Logout from the browser");
	      /*step 6 : logout*/
		Homepage home = new Homepage(driver);
		home.Logout();
    
	}
	
	@AfterClass//(groups= {"smokeTest", "regressionTest"})
	public void configAC() {
		System.out.println("=============Close the Browser=======");
		driver.quit();
	}
	
	@AfterSuite//(groups= {"smokeTest", "regressionTest"})
	public void configAS() {
		System.out.println("========================close DB========================");
	}


	

}
