package com.sty.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class StringUtils {
	
	
	/**
	 * �����ȡN���ַ���  ���û�ȡ�ַ����ķ���ÿ��ֻ�ܻ�ȡһ��  ��ô ��ȡN�ַ�������Ҫ����N�η����������
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
	 * ��ȡn����������ַ���
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
			
			System.out.println("����");
		
			}
		return str.charAt(0);
	}
	
	
	/**
	 * �ж��Ƿ��ǿյ��ַ���
	 */
	public static boolean hasTest(String src) {
		if(src == null || src.trim().equals("")) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * ��ȡ  ����Ϊn��  ����ַ���
	 * ��д��ĸ   
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
	 * ��ȡ����ַ���  ���������ַ���
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
	 * ����ַ���  ����������д��ĸ �� ����  ���ɵĳ���Ϊ  n
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
	 * @Description: ��һ����ַ ��ȡ���ļ������ļ����� Ҳ���Ƕ�ȡ���±������������
	 * @param path
	 * @return
	 * @throws Exception
	 * @return: List<String>
	 */
	public static List<String> readTitleAndConments(String path) throws Exception{
		//���ȶ�ȡ���ص����л��ļ�
		File file = new File(path);
		File[] listFiles = file.listFiles();
		List<String> list = new ArrayList<String>();
		for (File file2 : listFiles) {
			//��ȡ������Ϣ
			String title = file2.getName().substring(0 ,file2.getName().lastIndexOf("."));
			//Ȼ���ȡ�����������Ϣ
			String content = FIleUtils.readFile(file2, "utf8");
			String str = title + "=" + content;
			list.add(str);
			//����Ϣ���ػ�ȥ
		}
		return list;
	}
	
}






















