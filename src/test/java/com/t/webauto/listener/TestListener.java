package com.t.webauto.listener;

import java.io.File;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter; 
import com.t.webauto.utils.DataUtil;
import com.t.webauto.utils.ScreenUtil;

public class TestListener extends TestListenerAdapter {

	/*
	 * 自定义的监听器
	 * 当用例执行失败，截图保存
	 * 
	 * */
	@Override
	public void onTestFailure(ITestResult tr)
	{
		//获取结果目录
		String filepath=tr.getTestContext().getOutputDirectory();
		//路径截取\\后面得不要  最后一个出现截取
		filepath=filepath.substring(0,filepath.lastIndexOf("\\"));
		//System.out.println("filepath:"+filepath);
		//File.separator  等于 “ \”符号     \ screenshot
		String screenShotPath=filepath+File.separator+"screenshot";
		//     File file=new File();
		//取出套件得名字->  XML  registerTest 这个名字 <test name="registerTest">  在Testng.xml

		String testName=tr.getTestContext().getCurrentXmlTest().getName();
		Date date=new Date();
		String dateString=DataUtil.getYMDDateString(date); 
		//拼文件夹  保证文件夹不一样 日期 
		screenShotPath=screenShotPath+File.separator+testName+File.separator+dateString;
		Date date2=new Date();
		long time =date2.getTime();
		screenShotPath=screenShotPath+File.separator+time+".jpg";
		File to=ScreenUtil.takeScreenShot(screenShotPath);
		String absolutePath=to.getAbsolutePath(); 
		String toBeReplaced=absolutePath.substring(0,absolutePath.indexOf("screenshot"));
		absolutePath=absolutePath.replace(toBeReplaced, "http://localhost:8088/surefire-reports/"); 
		String accessPath=absolutePath.replace("\\", "/"); 
		System.setProperty("org.uncommons.reportng.escape-output", "false"); 
		Reporter.log("<img src='"+accessPath+"' width='100' height='100'><a href='"+accessPath+"' target='_blank'>查看大图 </a></img>",false);

	}

	public  static void main(String [] args)
	{
		String absolutePath="D:\\repository1\\hudan.webauto\\screenshot\\registerTest\\2019-11-27\\165465776678.jpg";
		String toBeReplaced=absolutePath.substring(0,absolutePath.indexOf("screenshot"));
		absolutePath=absolutePath.replace(toBeReplaced, "http://localhost/");
		String accessPath=absolutePath.replace("\\", "/");
		String a="<img src='"+accessPath+"' width='100' height='100'><a href='"+accessPath+"' target='_blank'>查看图片</a></img>";
		System.out.println(a);
	}
}
