package com.comcast.createhrmProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.hrm.generic.databaseutility.DataBaseUtilities;
import com.comcast.hrm.generic.fileutility.FileUtility;
import com.comcast.hrm.generic.webdriverutility.JavaUtility;
import com.comcast.hrm.generic.webdriverutility.WebdriverUtility;

public class CreateHRMProj {
public static void main(String[] args) throws Throwable {
	FileUtility fLib= new FileUtility();
	JavaUtility jLib= new JavaUtility();
	DataBaseUtilities dLib = new DataBaseUtilities();
	WebdriverUtility wLib= new WebdriverUtility();
	dLib.getDbconnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
	String ProjectID="TYH_PROJ_"+ jLib.getRandom();
	String PrjManager= "Nagender"+jLib.getRandom();
	String Date= jLib.getSystemDate();
	String ProjName = "Ngdr_"+jLib.getRandom();
	String Query= "insert into project values ('"+ProjectID+"','"+PrjManager+"','"+Date+"','"+ProjName+"',"+"'Completed','10')";
	int result=dLib.executeNonSelectQuery(Query);
     System.out.println(result);                                          
	dLib.closeDbconnection();
	 String Browser = fLib.getDataFromPropertyFile("browser");
	 String URL =fLib.getDataFromPropertyFile("url");
	 String USERNAME =fLib.getDataFromPropertyFile("username");
	 String PASSWORD =fLib.getDataFromPropertyFile("password");
	 WebDriver driver=null;
     if(Browser.equals("chrome")){
			driver=new ChromeDriver();  }
		  else if(Browser.equals("firefox")){
			 driver=new FirefoxDriver();}
		  else if(Browser.equals("edge")){
		    driver=new EdgeDriver();}
		  else {
			 driver=new ChromeDriver();
		 }
      wLib.getMaximize(driver);
      wLib.getPageLoad(driver);
      driver.get(URL);
	  driver.findElement(By.name("username")).sendKeys(USERNAME);
	  driver.findElement(By.name("password")).sendKeys(PASSWORD);
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  driver.findElement(By.xpath("//a[text()='Projects']")).click();
	driver.findElement(By.xpath("//input[@class=\"form-control\" and @placeholder=\"Search by Project Id\"]")).sendKeys(ProjectID);
	String text = driver.findElement(By.xpath("//tr[@class=\"tr\"]/a/td")).getText();
	if(ProjectID.equals(text))
	{
		System.out.println("Project Id Is Found");
	}
}
}