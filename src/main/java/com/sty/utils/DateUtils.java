package com.sty.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils {
	
	/**
	 * 根据出出生日期来获取年龄
	 * @param birthDay
	 * @return
	 * @throws Exception
	 */
	public static int getAgeByDate(Date birthDay) throws Exception {

		Calendar cal = Calendar.getInstance();
		if (cal.before(birthDay)) {

			throw new IllegalArgumentException(
				"The birthDay is before Now.It's unbelievable!");
		}

		int yearNow = cal.get(Calendar.YEAR);

		int monthNow = cal.get(Calendar.MONTH);

		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

		cal.setTime(birthDay);

		int yearBirth = cal.get(Calendar.YEAR);

		int monthBirth = cal.get(Calendar.MONTH);

		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;

		if (monthNow <= monthBirth) {

			if (monthNow == monthBirth) {

				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			}else{
				age--;
			}
			
		}
	
		return age;
	}
	
	/**
	 * 判断日期是否是今天的日期
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		if (fmt.format(date).toString().equals(fmt.format(new Date()).toString())) {
			// 格式化为相同格式
			return true;

		} else {

			return false;
		}
	}
	
	/**
	 * 判断是不是在本周
	 * @param date
	 * @return
	 */
	public static boolean isThisWeek(Date date) {

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		Calendar firstDayOfWeek = Calendar.getInstance(Locale.getDefault());

		firstDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

		int day = firstDayOfWeek.get(Calendar.DAY_OF_WEEK);

		firstDayOfWeek.add(Calendar.DATE, -day+1+1);// 后面的+1是因为从周日开始

		// 本周一的日期

		System.out.println(format.format(firstDayOfWeek.getTime()));

		Calendar lastDayOfWeek = Calendar.getInstance(Locale.getDefault());

		lastDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

		day = lastDayOfWeek.get(Calendar.DAY_OF_WEEK);

		lastDayOfWeek.add(Calendar.DATE, 7-day+1);

		// 本周星期天的日期

		System.out.println(format.format(lastDayOfWeek.getTime()));

		return (date.getTime()<lastDayOfWeek.getTime().getTime() && date.getTime()>firstDayOfWeek.getTime().getTime() );

		}
	
	/**
	 * 给定时间对象  返回该月的一号00.00.00
	 */
	public static Date getInitDate(Date src) {
		Calendar c = Calendar.getInstance();
		//设置日历类为 传进来的日期
		c.setTime(src);
		// 设
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		
		return c.getTime();
	}
	
	/**
	 * 给定一个时间 返回该月的最后一天的最后一秒
	 */
	public static Date getDateByFullMonth(Date src) {
		Calendar c = Calendar.getInstance();
		//设置日历类为 传进来的日期
		c.setTime(src);
		//让月份加一
		c.add(Calendar.MONTH, 1);
		//再让日期设置为月初
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		
		c.add(Calendar.SECOND, -1);
		//然后再进行返回
		
		return c.getTime();
	}
	/**
	 * 
	 * @Title: randomDate 
	 * @Description: TODO
	 * @param beginDate 开始时间
	 * @param endDate 结束时间
	 * @return
	 * @return: Date
	 */
	public static Date randomDate(String beginDate, String endDate) {  
        try {  
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
            Date start = format.parse(beginDate);// 构造开始日期  
            Date end = format.parse(endDate);// 构造结束日期  
            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。  
            if (start.getTime() >= end.getTime()) {  
                return null;  
            }  
            long date = random(start.getTime(), end.getTime());  

            return new Date(date);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
	/**
	 * 
	 * @Title: random 
	 * @Description: 随机生成时间
	 * @param begin
	 * @param end
	 * @return
	 * @return: long
	 */
    private static long random(long begin, long end) {  
        long rtn = begin + (long) (Math.random() * (end - begin));  
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值  
        if (rtn == begin || rtn == end) {  
            return random(begin, end);  
        }  
        return rtn;  
    }  
	
    

    //匹配函数
  	private static boolean isMatch(String regex, String orginal){
  		if (orginal == null || orginal.trim().equals("")) {
              return false;
          }
  		Pattern pattern = Pattern.compile(regex);
  		Matcher isNum = pattern.matcher(orginal);
  		return isNum.matches();
  	}
  	//是否为日期,只能判断yyyy-mm-dd/yyyy.mm.dd hh:MM:ss
  	public static boolean isDate(String orginal){
  		return isMatch("\\d{4}[-.]\\d{1,2}[-.]\\d{1,2}(\\s\\d{2}:\\d{2}(:\\d{2})?)?", orginal);

  	}    
	
	
	
	
	
	
	
	
}
