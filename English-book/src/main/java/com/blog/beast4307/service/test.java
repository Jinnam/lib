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
	     
	    // ���� ��¥ ���ϱ� 
	    Calendar calendar = new GregorianCalendar(Locale.KOREA);
	    nYear = calendar.get(Calendar.YEAR);
	    nMonth = calendar.get(Calendar.MONTH) + 1;
	    nDay = calendar.get(Calendar.DAY_OF_MONTH);
	    System.out.println("GregorianCalendar = " + nYear + "-"
	            + nMonth + "-" + nDay);
	     
	    // Date �� ���ϱ� 
	    SimpleDateFormat fm1 = new SimpleDateFormat("yyyy��MM��dd��");
	    String date = fm1.format(new Date());
	    System.out.println("����ð� ����� = " + date);
	 
	    SimpleDateFormat fm2= new SimpleDateFormat(
	            "yyyy��MM��dd��HH��mm��ss��");
	    String date1 = fm2.format(new Date());
	    System.out.println("����ð� �ú��� = " + date1);
}
}
