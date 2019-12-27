package com.sty.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberUtils {
	public static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";  
    public static final String LETTERCHAR = "abcdefghijkllmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";  
    public static final String NUMBERCHAR = "0123456789"; 
	/**
	 * 是否电话
	 * @return
	 */
	public static boolean isMobile(String str) {
		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
		Pattern p =  Pattern.compile(regex);
		Matcher matcher = p.matcher(str);
		return matcher.find();
			
	}
	
	/**
	 * 是否邮件
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
	 * 验证是否是URL
	 * @param url
	 * @return
	 */
	public static boolean isHttpUrl(String str){
		 //转换为小写
        str = str.toLowerCase();
        String regex = "^((https|http|ftp|rtsp|mms)?://)"  //https、http、ftp、rtsp、mms
                + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@  
               + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 例如：199.194.52.184               
                 + "|" // 允许IP和DOMAIN（域名） 或单域名
                 + "[0-9a-z]*"  // 或单域名
                 + "|" // 允许IP和DOMAIN（域名） 或单域名
                 + "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.  
                 + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名  
                + "[a-z]{2,6})" // first level domain- .com or .museum  
                + "(:[0-9]{1,5})?" // 端口号最大为65535,5位数
                + "((/?)|" // a slash isn't required if there is no file name  
                + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";  
        return  str.matches(regex);	
	}
	
	/**
	 *  获取整数类型的随机数
	 * @param min  随机数最小数值
	 * @param max  随机数最大数值
	 * @return
	 */
	public static int getRandomInt(int min,int max) {
		Random random = new Random();
		return min +  random.nextInt(max-min+1);
		
	}
	
	/**
	 * 获取长整数类型的随机数
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
	 * @Description: 判断是不是数字
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
     * 返回一个定长的随机字符串(只包含大小写字母、数字) 
     *  
     * @param length 
     *            随机字符串长度 
     * @return 随机字符串 
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
