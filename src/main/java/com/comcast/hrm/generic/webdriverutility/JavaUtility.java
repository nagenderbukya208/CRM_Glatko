package com.comcast.hrm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
public int getRandom() {
	Random obj=new Random();
	int randomint= obj.nextInt(5000);
	return randomint;
}
public String getSystemDate() {
	Date obj= new Date();
	SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
    String date=sim.format(obj);
	return date;
}
public String requiredDate(int days) {
	Date obj= new Date();
	SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
	Calendar cal= sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH,days);
	String reqdate=sim.format(cal.getTime());
	return reqdate;
}
}
