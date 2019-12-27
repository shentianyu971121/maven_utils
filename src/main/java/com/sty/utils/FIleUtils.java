package com.sty.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FIleUtils {

	/**
	 * 
	 * @Title: getFileContent 
	 * @Description: TODO
	 * @param filePath
	 * @param charSet
	 * @return
	 * @return: List<String>
	 * ��ȡһ��  ���ҿ��� �����ַ����� ��ʽ
	 */
	public  static List<String>  getFileContent(String filePath, String charSet) {
		List<String> list = new  ArrayList<String>();
	    try{
	        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),charSet));
	        String s = null;
	        while((s = br.readLine())!=null){
	            System.err.println(s);
	            list.add(s);
	        }
	        br.close();    
	    }catch(Exception e){
	        e.printStackTrace();
	    }
	    return list;
	}
	
	
	
	/**
	 * 
	 * @param ���Ƕ�ȡ�ļ�  Ȼ�󽫶�ȡ�����ݷ��ص�list������ ֱ�ӵ����޸�
	 * @return
	 */
	public static List<String> ReadFileByLine(String filename) {
		List<String> list = new ArrayList<String>();
		File file = new File(filename);
		InputStream is = null;
		Reader reader = null;
		BufferedReader bufferedReader = null;
		try {
			is = new FileInputStream(file);
			reader = new InputStreamReader(is);
			bufferedReader = new BufferedReader(reader);
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
			list.add(line);
			}
			return list;
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != bufferedReader)
				bufferedReader.close();
				if (null != reader)
				reader.close();
				if (null != is)
				is.close();
			} catch (IOException e) {
					e.printStackTrace();
			}
			
		}
			return null;
	}
	
	/**
	* ���ֽڶ�ȡ�ļ�
	*
	* @param filename
	*/
	public static void ReadFileByBytes(String filename) {

	File file = new File(filename);

	InputStream is = null;

	try {

		is = new FileInputStream(file);
	
		int index = 0;
	
		while (-1 != (index = is.read())) {
	
		System.out.write(index);
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		try {
			if (null != is)
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		System.out.println("-----------------------------------");
		try {
			is = new FileInputStream(file);
			byte[] tempbyte = new byte[1000];
			int index = 0;
			while (-1 != (index = is.read(tempbyte))) {
			System.out.write(tempbyte, 0, index);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (null != is)
				is.close();
				} catch (IOException e) {
				e.printStackTrace();
				}
		}
	}
	
	/**
	 * 
	 * @param file
	 * @return  �����ļ������·��
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static String preccess(MultipartFile myFile) throws IllegalStateException, IOException {
		//��ȡ����
		String filename = myFile.getOriginalFilename();
		//Ȼ���ȡ ����������
		String end = filename.substring(filename.lastIndexOf("."));
		//����������
		String start = UUID.randomUUID().toString();
		//Ȼ���ȡ���µ�ʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String format = sdf.format(new Date());
		//Ȼ���ж���û������ļ���
		File file = new File("d:/pic/" + format);
		if(!file.exists()) {
			//���û������ļ��оͽ��д���
			file.mkdirs();
		}
		try {
			//Ȼ�󽫴��������ļ����Ƹ�ָ��·���ļ��� 
			myFile.transferTo(new File("d:/pic/" + format + "/" + start + end));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return format + "/" + start + end;
	}

	/**
	 * @Title: writeFile
	 * @Description: ����ָ���ı��������д��ָ�����ļ���
	 * @param path
	 * @param content
	 * @param charset
	 * @throws IOException
	 * @return: void
	 */
	public static void writeFile(String path, String content, String charset) throws IOException {
		// ����д����ļ�
		File file = new File(path);
		// �жϸ�Ŀ¼�Ƿ����
		if (!file.getParentFile().exists()) {
			// ������Ŀ¼
			file.getParentFile().mkdirs();
		}
		// �������������
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
		bw.write(content);
		bw.flush();
		bw.close();
	}

	/**
	 * @Title: readFile
	 * @Description: ��һ���ļ�����ȡ�ļ�����
	 * @param file
	 * @param charset
	 * @return
	 * @throws IOException
	 * @return: String
	 */
	public static String readFile(File file, String charset) throws IOException {
		// �������������
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
		// ���建�����
		StringBuffer sb = new StringBuffer();
		// �����ȡÿ�еĽ��
		String content = null;
		// ѭ����ȡ
		while ((content = br.readLine()) != null) {
			// ���뻺�����
			sb.append(content);
		}
		// �ر���
		br.close();
		// ���ؽ��
		return sb.toString();

	}

	
	
}
