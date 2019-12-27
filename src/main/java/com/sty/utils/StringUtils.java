package com.sty.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class StringUtils {
	
	
	/**
	 * 随机获取N个字符串  调用获取字符串的方法每次只能获取一个  那么 获取N字符串就需要调用N次方法就行组合
	 */
	public static String getCharByN(int n) {
		StringBuilder sb = new StringBuilder();
		StringBuilder str1 = null;
		for(int i = 0; i < n; i++) {
			char str = getStr();
			str1 = sb.append(str);
		}
		return str1.toString();
	}
	/**
	 * 获取n个随机中文字符串
	 * @return
	 */
	private  static char getStr() {
		String str = "";

		int hightPos; //

		int lowPos;

		Random random = new Random();

		hightPos = (176 + Math.abs(random.nextInt(39)));

		lowPos = (161 + Math.abs(random.nextInt(93)));

		byte[] b = new byte[2];

		b[0] = (Integer.valueOf(hightPos)).byteValue();

		b[1] = (Integer.valueOf(lowPos)).byteValue();

		try {
		
			str = new String(b, "GBK");
		
			} catch (Exception e) {
		
			e.printStackTrace();
			
			System.out.println("错误");
		
			}
		return str.charAt(0);
	}
	
	
	/**
	 * 判断是否是空的字符串
	 */
	public static boolean hasTest(String src) {
		if(src == null || src.trim().equals("")) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * 获取  长度为n的  随机字符串
	 * 大写字母   
	 */
	public static String getRandomStr(int n) {
		
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		
		for (int i = 0; i < n; i++) {
			char c = (char)('A' +  random.nextInt(26));
			sb.append(c);
		}
		return sb.toString();
	}
	
	
	
	/**
	 * 获取随机字符串  仅仅包含字符串
	 * @param n
	 * @return
	 */
	public static String getRandomNumber(int n) {
		
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		
		for (int i = 0; i < n; i++) {
			char c = (char)('0' +  random.nextInt(10));
			sb.append(c);
		}
		return sb.toString();
	}
	
	
	
	
	/**
	 * 随机字符串  仅仅包含大写字母 和 数字  生成的长度为  n
	 */
	public static String getRandomStr2(int n) {
		
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		
		for (int i = 0; i < n; i++) {
			int r = random.nextInt(36);
			if(r<26) {
				char c = (char)('A' +  r );
				sb.append(c);
			}else {
				sb.append(r-26);
			}
			
		}
		return sb.toString();
	}
	
	public static String replaceFileChar(String str) {
		str = str.replace("|", "").replace("*", "").replace("\"", "").replace("?", "").replace("/", "")
				.replace("\\", "").replace(">", "").replace("<", "").replace(":", "");
		return str;
	}
	
	
	
	/**
	 * 
	 * @Title: test2Demo 
	 * @Description: 给一个地址 读取出文件名和文件内容 也就是读取文章标题和文章内容
	 * @param path
	 * @return
	 * @throws Exception
	 * @return: List<String>
	 */
	public static List<String> readTitleAndConments(String path) throws Exception{
		//首先读取本地的序列化文件
		File file = new File(path);
		File[] listFiles = file.listFiles();
		List<String> list = new ArrayList<String>();
		for (File file2 : listFiles) {
			//获取标题信息
			String title = file2.getName().substring(0 ,file2.getName().lastIndexOf("."));
			//然后读取标题里面的信息
			String content = FIleUtils.readFile(file2, "utf8");
			String str = title + "=" + content;
			list.add(str);
			//将信息返回回去
		}
		return list;
	}
	
}






















