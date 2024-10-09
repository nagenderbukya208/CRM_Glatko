package com.comcast.hrm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
public void getPageLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
public void getElementWait(WebDriver driver,WebElement element) {
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));
}
public void switchToTabOnUrl(WebDriver driver,String partialUrl) {
	 Set<String> set=driver.getWindowHandles();
     Iterator<String> it=set.iterator();
     while(it.hasNext()) {
     	String windowId=it.next();
     	driver.switchTo().window(windowId);
     	String actUrl=driver.getCurrentUrl();
     	if(actUrl.contains(partialUrl)) {
     		break;
     	}
     }
}
public void switchToTabOnTitle(WebDriver driver,String partiaTitle) {
	 Set<String> set=driver.getWindowHandles();
    Iterator<String> it=set.iterator();
    while(it.hasNext()) {
    	String windowId=it.next();
    	driver.switchTo().window(windowId);
    	String actUrl=driver.getCurrentUrl();
    	if(actUrl.contains(partiaTitle)) {
    		break;
    	}
    }
}
    public void switchToFrame(WebDriver driver,int index) {
    	driver.switchTo().frame(index);
    }
    public void switchToFrame(WebDriver driver,String nameID) {
    	driver.switchTo().frame(nameID);
    }
    public void switchToFrame(WebDriver driver,WebElement element) {
    	driver.switchTo().frame(element);
}
    public void getMaximize(WebDriver driver) {
    	driver.manage().window().maximize();
    }
    public void mouseMoveOnElement(WebDriver driver, WebElement element) {
    	Actions act= new Actions(driver);
    	act.moveToElement(element).perform();
    }
    public void doubleClick(WebDriver driver, WebElement element) {
    	Actions act= new Actions(driver);
    	act.doubleClick(element).perform();
}
}
