package com.t.webauto.web;


import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.t.webauto.utils.Base;
import com.t.webauto.utils.ExcelUtil;

 
public class RegisterPage2 extends Base {
	private Logger loggers=Logger.getLogger(RegisterPage2.class);

	@Test(dataProvider="datas")
	//反用例错误用例方法
	public void failtest(String usernames,String pwd,String confirmpwd,String email,String enpired) throws  Exception {

		//		webDrvier.get("http://localhost:8088/Discuz/upload/member.php?mod=register");
		//		//用户名
		//		webDrvier.findElement(By.id("tRYSs0")).sendKeys(usernames); 
		//		//密码
		//		webDrvier.findElement(By.id("dgfvkp")).sendKeys(pwd); 
		//		//输入密码
		//		webDrvier.findElement(By.id("Qz45kX")).sendKeys(confirmpwd);
		//
		//		//Email
		//		webDrvier.findElement(By.id("GciA35")).sendKeys(email);
		//
		//		//提交按钮 
		get("register.page");
		//用户名
		sendKeys(getElement("注册页","用户名输入框"),usernames); 
		//密码
		sendKeys(getElement("注册页","密码输入框"),pwd); 
		//输入密码
		sendKeys(getElement("注册页","请确认密码"),confirmpwd);

		//Email
		sendKeys(getElement("注册页","邮件输入框"),email);

		//提交按钮
		click(getElement("注册页","注册按钮"));

		//		String actual=webDrvier.findElement(By.id("tGG9NE")).sendKeys(email);

	}

	//	@DataProvider
	//	public Object[][] datas()
	//	{
	//		Object [][] datas= { 
	//				{"s90","","","","用户名不得小于 3 个字符"},
	//				{"s90","d","","","密码太短，不得少于 6 个字符"},  
	//				{"s90","123456","1234567","","两次输入的密码不一致"},
	//				{"s90","123456","123456","aa@163.com","地址无效"}
	//		};
	//		return datas;
	//	}

	@DataProvider
	public Object[][] datas()
	{
		int [] rows= {2,3,4,5}; 
		int [] cells= {1,2,3,4,5};
		Object [] [] dataOjbs=ExcelUtil.read("src/test/resources/Register.xlsx", rows, cells);
		return dataOjbs;
	}
	public static void main(String [] args)
	{
		int [] rows= {2,3,4,5}; 
		int [] cells= {1,2,3,4,5};
		Object [] [] dataOjbs=ExcelUtil.read("src/test/resources/Register.xlsx", rows, cells);
		for(Object [] objects:dataOjbs)
		{
			//打印行的数据
			for(Object objct:objects)
			{
				System.out.print("【"+objct+"】");
			}
			System.out.println();
		}

	}

	public String getText(WebElement element)
	{
		String text=element.getText();
		loggers.info("获取到的文本值：===================================【"+text+"】===========================================");
		return text;
	}


	public void sendKeys(WebElement element,String text)
	{

		loggers.info("输入文本内容：===================================【"+text+"】===========================================");
		element.sendKeys(text);
	}
	/**
	 * 
	 * 元素点击
	 */

	public void click(WebElement element)
	{
		loggers.info("===============================触发点击事件==============================================");
		element.click();
	}

}
