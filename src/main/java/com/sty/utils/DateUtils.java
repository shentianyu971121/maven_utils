package com.sty.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils {
	
	/**
	 * ���ݳ�������������ȡ����
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
	 * �ж������Ƿ��ǽ��������
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		if (fmt.format(date).toString().equals(fmt.format(new Date()).toString())) {
			// ��ʽ��Ϊ��ͬ��ʽ
			return true;

		} else {

			return false;
		}
	}
	
	/**
	 * �ж��ǲ����ڱ���
	 * @param date
	 * @return
	 */
	public static boolean isThisWeek(Date date) {

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		Calendar firstDayOfWeek = Calendar.getInstance(Locale.getDefault());

		firstDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

		int day = firstDayOfWeek.get(Calendar.DAY_OF_WEEK);

		firstDayOfWeek.add(Calendar.DATE, -day+1+1);// �����+1����Ϊ�����տ�ʼ

		// ����һ������

		System.out.println(format.format(firstDayOfWeek.getTime()));

		Calendar lastDayOfWeek = Calendar.getInstance(Locale.getDefault());

		lastDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

		day = lastDayOfWeek.get(Calendar.DAY_OF_WEEK);

		lastDayOfWeek.add(Calendar.DATE, 7-day+1);

		// ���������������

		System.out.println(format.format(lastDayOfWeek.getTime()));

		return (date.getTime()<lastDayOfWeek.getTime().getTime() && date.getTime()>firstDayOfWeek.getTime().getTime() );

		}
	
	/**
	 * ����ʱ�����  ���ظ��µ�һ��00.00.00
	 */
	public static Date getInitDate(Date src) {
		Calendar c = Calendar.getInstance();
		//����������Ϊ ������������
		c.setTime(src);
		// ��
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		
		return c.getTime();
	}
	
	/**
	 * ����һ��ʱ�� ���ظ��µ����һ������һ��
	 */
	public static Date getDateByFullMonth(Date src) {
		Calendar c = Calendar.getInstance();
		//����������Ϊ ������������
		c.setTime(src);
		//���·ݼ�һ
		c.add(Calendar.MONTH, 1);
		//������������Ϊ�³�
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		
		c.add(Calendar.SECOND, -1);
		//Ȼ���ٽ��з���
		
		return c.getTime();
	}
	/**
	 * 
	 * @Title: randomDate 
	 * @Description: TODO
	 * @param beginDate ��ʼʱ��
	 * @param endDate ����ʱ��
	 * @return
	 * @return: Date
	 */
	public static Date randomDate(String beginDate, String endDate) {  
        try {  
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
            Date start = format.parse(beginDate);// ���쿪ʼ����  
            Date end = format.parse(endDate);// �����������  
            // getTime()��ʾ������ 1970 �� 1 �� 1 �� 00:00:00 GMT ������ Date �����ʾ�ĺ�������  
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
	 * @Description: �������ʱ��
	 * @param begin
	 * @param end
	 * @return
	 * @return: long
	 */
    private static long random(long begin, long end) {  
        long rtn = begin + (long) (Math.random() * (end - begin));  
        // ������ص��ǿ�ʼʱ��ͽ���ʱ�䣬��ݹ���ñ������������ֵ  
        if (rtn == begin || rtn == end) {  
            return random(begin, end);  
        }  
        return rtn;  
    }  
	
    

    //ƥ�亯��
  	private static boolean isMatch(String regex, String orginal){
  		if (orginal == null || orginal.trim().equals("")) {
              return false;
          }
  		Pattern pattern = Pattern.compile(regex);
  		Matcher isNum = pattern.matcher(orginal);
  		return isNum.matches();
  	}
  	//�Ƿ�Ϊ����,ֻ���ж�yyyy-mm-dd/yyyy.mm.dd hh:MM:ss
  	public static boolean isDate(String orginal){
  		return isMatch("\\d{4}[-.]\\d{1,2}[-.]\\d{1,2}(\\s\\d{2}:\\d{2}(:\\d{2})?)?", orginal);

  	}    
	
	
	
	
	
	
	
	
}
