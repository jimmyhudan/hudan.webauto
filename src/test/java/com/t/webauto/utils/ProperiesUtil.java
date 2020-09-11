package com.t.webauto.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProperiesUtil {
	public static Properties properties=new Properties();
	static {
		try {
			properties.load(new FileInputStream(new File("src/test/resources/url.properties")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
