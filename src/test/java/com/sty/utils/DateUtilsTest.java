package com.sty.utils;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateUtilsTest {

	@Test
	public void test() {
		//根据出生日期来获取年龄
		Calendar c = Calendar.getInstance();
		c.set(1997, 10, 21);
		try {
			int ageByDate = DateUtils.getAgeByDate(c.getTime());
			System.out.println(ageByDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void tets2() {
		Calendar c = Calendar.getInstance();
		c.set(1997, 10, 21);
		boolean today = DateUtils.isToday(new Date());
		System.out.println(today);
	}

	@Test
	public void test3() {
		Calendar c = Calendar.getInstance();
		c.set(2019, 11, 21);
		
		boolean thisWeek = DateUtils.isThisWeek(c.getTime());
		System.out.println(thisWeek);
	}
	
	@Test
	public void test4() {
		Calendar c = Calendar.getInstance();
		c.set(1997, 10, 21);
		Date initDate = DateUtils.getInitDate(c.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sdf.format(initDate);
		System.out.println(format);
	}
	@Test
	public void test5() {
		Calendar c = Calendar.getInstance();
		c.set(2001, 1, 10);
		Date initDate = DateUtils.getDateByFullMonth(c.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format = sdf.format(initDate);
		System.out.println(format);
	}
}








