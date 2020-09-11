package com.t.webauto.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ScreenUtil {


	public static File takeScreenShot(String screenShotPath)
	{
		File from =null; 
		if(Base.webDrvier instanceof FirefoxDriver) 
		{

			FirefoxDriver driver=(FirefoxDriver) Base.webDrvier; 
			from=driver.getScreenshotAs(OutputType.FILE);

		}else if(Base.webDrvier instanceof ChromeDriver) {

			ChromeDriver driver=(ChromeDriver) Base.webDrvier; 
			from=driver.getScreenshotAs(OutputType.FILE);

		}else if(Base.webDrvier instanceof InternetExplorerDriver){

			InternetExplorerDriver driver=(InternetExplorerDriver) Base.webDrvier; 
			from=driver.getScreenshotAs(OutputType.FILE); 
		}


		//拷贝 
		File to =new File(screenShotPath); 
		try { 
			FileUtils.copyFile(from,to);

		} catch (IOException e) {

			// TODO Auto-generated catch block 
			e.printStackTrace();

		} 

		return to;

	}
}
