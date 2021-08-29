package com.vtiger.comcast.genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListerImp implements ITestListener {
	
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getMethod().getMethodName();
		System.out.println("======= Execute And I Am Listening========");
		
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File scrfile = edriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrfile, new File("./screenshot/"+testName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
