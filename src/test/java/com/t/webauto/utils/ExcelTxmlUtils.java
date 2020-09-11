package com.t.webauto.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.t.webauto.pojo.Locator;
import com.t.webauto.pojo.Page;



public class ExcelTxmlUtils { 


	public static List<Page> pages=new ArrayList<Page>();

	static {
		//解析数据
		parse();
	}
	/**
	 * 
	 * 根据页面关键字和元素关键字获取元素定位信息
	 * @param pageKeyWord 页面关键字
	 * @param elementKeyWord 元素关键字
	 * @return
	 */

	//拿到元素
	public static Locator getLocator(String pageKeyWord,String elementKeyWord)
	{
		for(Page page:pages)
		{
			if(pageKeyWord.equals(page.getKeyWord()))
			{
				List<Locator> locators=page.getLocators();
				for(Locator locator:locators)
				{
					if(elementKeyWord.equals(locator.getKeyword())){

						return locator;

					}
				}
			}
		}
		return null;
	}
	private static void parse()
	{
		//1.添加依赖:Dom4j

		//创建解析器SaxReader对象

		SAXReader sareader=new SAXReader();

		//获取Docuemnt对象

		try { 
			Document docuemnt=sareader.read(new File("src/test/resources/UILibray.xml"));

			//获取根元素

			Element root=docuemnt.getRootElement(); 
			//获取根元素下的子元素 
			List<Element>pages=root.elements(); 
			for(Element page:pages)
			{
				String keyWord=page.attributeValue("keyword");
				List<Element>locators=page.elements();
				//是为了保存每一个page底下所有元素定位信息
				List<Locator> lts=new ArrayList<Locator>();

				for(Element locator:locators) 
				{ 
					String kw=locator.attributeValue("keyword");

					String by=locator.attributeValue("by");

					String value=locator.attributeValue("value");

					Locator lc=new Locator(kw,by,value);

					lts.add(lc);

				}

				Page pg=new Page(keyWord,lts); 
				ExcelTxmlUtils.pages.add(pg);

			}

		} catch (DocumentException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}


		public static void main(String [] args)
		{
			for(Page page:pages)
			{
				System.out.println("关键字为："+page.getKeyWord());
				List<Locator> lts=page.getLocators();
				for(Locator lc:lts)
				{
					System.out.println(lc);
				}
			}
			
	 	}
}
