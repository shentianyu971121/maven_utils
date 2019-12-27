package com.sty.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberUtils {
	public static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";  
    public static final String LETTERCHAR = "abcdefghijkllmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";  
    public static final String NUMBERCHAR = "0123456789"; 
	/**
	 * �Ƿ�绰
	 * @return
	 */
	public static boolean isMobile(String str) {
		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		Pattern p =  Pattern.compile(regex);
		Matcher matcher = p.matcher(str);
		return matcher.find();
			
	}
	
	/**
	 * �Ƿ��ʼ�
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str) {
		
		String regex="^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		Pattern p =  Pattern.compile(regex);
		Matcher matcher = p.matcher(str);
		return matcher.find();
		
	}
	
	
	/**
	 * ��֤�Ƿ���URL
	 * @param url
	 * @return
	 */
	public static boolean isHttpUrl(String str){
		 //ת��ΪСд
        str = str.toLowerCase();
        String regex = "^((https|http|ftp|rtsp|mms)?://)"  //https��http��ftp��rtsp��mms
                + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp��user@  
               + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP��ʽ��URL- ���磺199.194.52.184               
                 + "|" // ����IP��DOMAIN�������� ������
                 + "[0-9a-z]*"  // ������
                 + "|" // ����IP��DOMAIN�������� ������
                 + "([0-9a-z_!~*'()-]+\\.)*" // ����- www.  
                 + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // ��������  
                + "[a-z]{2,6})" // first level domain- .com or .museum  
                + "(:[0-9]{1,5})?" // �˿ں����Ϊ65535,5λ��
                + "((/?)|" // a slash isn't required if there is no file name  
                + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";  
        return  str.matches(regex);	
	}
	
	/**
	 *  ��ȡ�������͵������
	 * @param min  �������С��ֵ
	 * @param max  ����������ֵ
	 * @return
	 */
	public static int getRandomInt(int min,int max) {
		Random random = new Random();
		return min +  random.nextInt(max-min+1);
		
	}
	
	/**
	 * ��ȡ���������͵������
	 * @param min
	 * @param max
	 * @return
	 */  //  100   1000
	public static long getRandomLong(long min,long max) {
		//Random random = new Random();
		double random = Math.random();// 0 ~ 1 
		return (long)(random * (max-min+1) +  min);
	}
	
	/**
	 * 
	 * @Title: isInteger 
	 * @Description: �ж��ǲ�������
	 * @param s
	 * @return
	 * @return: boolean
	 */
	public static boolean isNum(String s){    
        if((s != null)&&(s!=""))    
         return s.matches("^[0-9]*$");    
        else    
         return false;    
    } 
	
    /** 
     * ����һ������������ַ���(ֻ������Сд��ĸ������) 
     *  
     * @param length 
     *            ����ַ������� 
     * @return ����ַ��� 
     */  
    public static String getLenNum(int length) {  
        StringBuffer sb = new StringBuffer();  
        Random random = new Random();  
        for (int i = 0; i < length; i++) {  
            sb.append(NUMBERCHAR.charAt(random.nextInt(NUMBERCHAR.length())));  
        }  
        return sb.toString();  
    }  
	
	
	
	
}
