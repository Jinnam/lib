package com.blog.beast4307.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class test {

	public void doCurrentDate(){
	    int nYear;
	    int nMonth;
	    int nDay;
	     
	    // 현재 날짜 구하기 
	    Calendar calendar = new GregorianCalendar(Locale.KOREA);
	    nYear = calendar.get(Calendar.YEAR);
	    nMonth = calendar.get(Calendar.MONTH) + 1;
	    nDay = calendar.get(Calendar.DAY_OF_MONTH);
	    System.out.println("GregorianCalendar = " + nYear + "-"
	            + nMonth + "-" + nDay);
	     
	    // Date 로 구하기 
	    SimpleDateFormat fm1 = new SimpleDateFormat("yyyy년MM월dd일");
	    String date = fm1.format(new Date());
	    System.out.println("현재시간 년월일 = " + date);
	 
	    SimpleDateFormat fm2= new SimpleDateFormat(
	            "yyyy년MM월dd일HH시mm분ss초");
	    String date1 = fm2.format(new Date());
	    System.out.println("현재시간 시분초 = " + date1);
}
}
