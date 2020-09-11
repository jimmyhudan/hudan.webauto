package com.t.webauto.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

	private final static String YMD="yyyy-MM-dd";
	private static SimpleDateFormat sdf=new SimpleDateFormat(YMD);
	
	public static String getYMDDateString(Date date)
	{
		return sdf.format(date);
	}
	
	public static void main(String [] args)
	{
		Date d=new Date();
		String dds=getYMDDateString(d);
		System.out.println(dds);
	}
}
