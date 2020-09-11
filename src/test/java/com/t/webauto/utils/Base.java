package com.t.webauto.utils;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.t.webauto.pojo.Locator;

public class Base { 
	private Logger logger= Logger.getLogger(Base.class); 
	public static WebDriver webDrvier; 
	@BeforeClass 
	@Parameters(value= {"browserType","driverPath","seleniumVersion"})
	public void init(String browserType,String driverPath,String seleniumVersion )
	{
		logger.info("*****************************************测试开始***************************************************************************************");
		logger.info("配置浏览器："+browserType+",Selenium版本："+driverPath+",驱动文件路径："+seleniumVersion);
		//IE
		if("ie".equalsIgnoreCase(browserType))
		{
			//ָ�������ļ���·��
			System.setProperty("webdriver.ie.driver", driverPath); 
			DesiredCapabilities capabilities=new DesiredCapabilities();
			//���Ե�������İ�ȫģʽ����
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);

			capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
			webDrvier=new InternetExplorerDriver(capabilities);

		}
		else if("firefox".equalsIgnoreCase(browserType))
		{
			if("3.x".equalsIgnoreCase("seleniumVersion"))
			{ 

				System.setProperty("webdriver.gecko.driver", driverPath); 
			}
			webDrvier=new FirefoxDriver();
			logger.info("成功创建firefox驱动对象"); 
		}
		else if("chrome".equalsIgnoreCase(browserType))
		{

			System.setProperty("webdriver.chrome.driver", driverPath); 
			webDrvier=new ChromeDriver();
			webDrvier.get("https://www.baidu.com/");
			logger.info("成功创建Chrome驱动对象"); 
		}


		//		webDrvier =new FirefoxDriver();
	}	




	/**
	 * 根据页面关键字和元素获取页面元素集合
	 * @param pageKeyword
	 * @param elementKeyWord
	 * @return
	 */
	public List<WebElement> getListElements(String pageKeyword,String elementKeyWord){ 
		Locator locator=ExcelTxmlUtils.getLocator(pageKeyword, elementKeyWord);
		String tips="获取【"+pageKeyword+"】 上的 【"+elementKeyWord+"】： "+"{'by','"+locator.getBy()+"'},{'value','"+locator.getValue()+"'}";
		logger.info(tips);
		// 		String tips="获取";
		//拿出元素定位方式
		String by =locator.getBy();
		String value=locator.getValue();
		By seleniumBy=null;
		if("class".equalsIgnoreCase(by))
		{
			seleniumBy=By.className(value);
		}else if("tagName".equalsIgnoreCase(by))
		{
			seleniumBy=By.tagName(value); 
		}else if("cssSelector".equalsIgnoreCase(by))
		{
			seleniumBy=By.cssSelector(value); 
		}else {
			throw new RuntimeException("抱歉，当前配置的By类型定位方式暂不支持，请检查配置");
		}
		//延迟等待，显示等待统一处理元素定位
		WebDriverWait wait=new WebDriverWait(webDrvier,60); 
		List<WebElement> webElements=null;
		try {
			webElements=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(seleniumBy));
			return webElements;
		}catch(Exception e)
		{
			tips+="因为超时，【失败】";
			logger.error(tips);
		}

		tips+="【成功】";
		logger.info(tips);
		return webElements;
	}


	public WebElement getElement(String pageKeyword,String elementKeyWord){

		Locator locator=ExcelTxmlUtils.getLocator(pageKeyword, elementKeyWord);
		String tips="获取【"+pageKeyword+"】 上的 【"+elementKeyWord+"】： "+"{'by','"+locator.getBy()+"'},{'value','"+locator.getValue()+"'}";
		logger.info(tips);
		// 		String tips="获取";
		//拿出元素定位方式
		String by =locator.getBy();
		String value=locator.getValue();
		By seleniumBy=null;
		if("id".equalsIgnoreCase(by))
		{
			seleniumBy=By.id(value);
		}else if("class".equalsIgnoreCase(by))
		{
			seleniumBy=By.className(value); 
		}else if("tagName".equalsIgnoreCase(by))
		{
			seleniumBy=By.tagName(value); 
		}else if("cssSelector".equalsIgnoreCase(by))
		{
			seleniumBy=By.cssSelector(value); 
		}else if("linkText".equalsIgnoreCase(by))
		{
			seleniumBy=By.linkText(value); 
		}else if("partialLinkText".equalsIgnoreCase(by))
		{
			seleniumBy=By.partialLinkText(value); 
		}else if("xpath".equalsIgnoreCase(by))
		{
			seleniumBy=By.xpath(value); 
		}else {
			logger.error("抱歉，当前配置的By类型定位方式暂不支持，请检查配置");
			throw new RuntimeException("抱歉，当前配置的By类型定位方式暂不支持，请检查配置");
		}
		//延迟等待，显示等待统一处理元素定位
		WebDriverWait wait=new WebDriverWait(webDrvier,60); 
		WebElement webElement=null;
		try {
			webElement=wait.until(ExpectedConditions.presenceOfElementLocated(seleniumBy));

		}catch(Exception e)
		{
			tips+="因为超时，【失败】";
			logger.error(tips);
		}

		tips+="【成功】";
		logger.info(tips);
		return webElement;
	}

	@AfterSuite
	public void tearDown()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		webDrvier.quit();
		logger.info("*********************************************完成测试*********************************************"); 

	}


	/*
	 * 浏览器最大化
	 */
	public void maxiMize()
	{
		logger.info("浏览器最大化");
		webDrvier.manage().window().maximize();
	}

	/*
	 * 浏览器刷新
	 * 
	 */
	public void refresh()
	{
		logger.info("浏览器刷新"); 
		webDrvier.navigate().refresh();
	}

	/*
	 * 浏览器回退操作
	 * 
	 */
	public void backs()
	{
		logger.info("浏览器回退操作");
		webDrvier.navigate().back();
	}

	/*
	 * 浏览器前进操作
	 * 
	 */
	public void forward()
	{
		logger.info("浏览器前进操作");
		webDrvier.navigate().forward();
	}

	/*
	 * 浏览器回退操作
	 * 
	 */
	public void to(String url)
	{
		logger.info("访问页面"+url);
		webDrvier.navigate().to(url); 
	}

	/*
	 * 访问一个页面 
	 * @pageKeyUrl url
	 */
	public void get(String pageKeyUrl)
	{
		String url=ProperiesUtil.properties.getProperty(pageKeyUrl);
		logger.info("访问页面"+url);
		webDrvier.get(url);
	}
}
