package com.comcast.hrm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
public String getDataFromPropertyFile(String key) throws Throwable {
	FileInputStream fis= new FileInputStream("./commonData/newFile.properties");
	Properties pobj= new Properties();
	pobj.load(fis);
	String data= pobj.getProperty(key);
	return data;
}
}
