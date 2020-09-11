package com.t.webauto.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

 
public class AssertionUtil {
//	private  Logger loggers=Logger.getLogger(assertTextPresent.class);

	public static void  assertTextPresent(String text) 
	{

		//通过传进来的文本值去定位到页面上 的元素 
		WebElement element=Base.webDrvier.findElement(By.xpath("//*[contains(text(),'"+text+"')]"));
       //如果页面元素存在，则断言通过，否则不通过 
		boolean findeds=false;

		if(element!=null) 
		{

			findeds=true;

		}

		Assert.assertTrue(findeds);

	}



	/***

	 * 断言某一文本值出现在了我们当前的页面(精准匹配)

	 * 检查点

	 * @param text

	 */



	public static void assertTextPresentPrecesion(String text)

	{

		//通过传进来的文本值去定位到页面上 的元素

		WebElement element=Base.webDrvier.findElement(By.xpath("//*[text()='"+text+"']"));
 
		//如果页面元素存在，则断言通过，否则不通过 
		boolean findeds=false; 
		if(element!=null)

		{

			findeds=true;

		}

		Assert.assertTrue(findeds);

	}







	/***

	 * 断言页面某元素是否可编辑

	 * 
	 */ 

	public static void assertElementEditable(WebElement element) 
	{

		boolean isEnabled=element.isEnabled(); 
		Assert.assertTrue(isEnabled);

	}

	/***

	 * 断言页面某元素是否可编辑

	 *

	 */ 

	public static void assertElementAttributeEquals(WebElement element,String attrName,String text)
	{ 
		String attrValue=element.getAttribute(attrName); 
		Assert.assertEquals(attrValue, text);

	}



	/***

	 * 断言页面的URL是否包含某一部分

	 * @param text

	 */ 

	public static void assertUrlContains(String text)

	{

		String currentUrl=Base.webDrvier.getCurrentUrl(); 
		Boolean isContains=currentUrl.contains(text); 
		Assert.assertTrue(isContains);

	}



	public static WebElement getElementbyAssert(WebDriver webDriver,By by) 
	{

		WebDriverWait wait=new WebDriverWait(webDriver,30); 
		WebElement element=null; 
		try { 
			element=wait.until(ExpectedConditions.presenceOfElementLocated(by));

		}catch(Exception e) 
		{

			//记录日志 
//			loggers.error("定位元素超时",e); 


		} 
		return element;

	}

}
