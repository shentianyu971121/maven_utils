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
	 * 读取一行  并且可以 设置字符编码 格式
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
	 * @param 就是读取文件  然后将读取的内容返回到list集合中 直接调用修改
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
	* 按字节读取文件
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
	 * @return  保存文件的相对路径
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public static String preccess(MultipartFile myFile) throws IllegalStateException, IOException {
		//获取名称
		String filename = myFile.getOriginalFilename();
		//然后截取 重新其名称
		String end = filename.substring(filename.lastIndexOf("."));
		//重新其名称
		String start = UUID.randomUUID().toString();
		//然后获取最新的时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String format = sdf.format(new Date());
		//然后判断有没有这个文件加
		File file = new File("d:/pic/" + format);
		if(!file.exists()) {
			//如果没有这个文件夹就进行创建
			file.mkdirs();
		}
		try {
			//然后将传进来的文件复制给指定路径文件夹 
			myFile.transferTo(new File("d:/pic/" + format + "/" + start + end));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return format + "/" + start + end;
	}

	/**
	 * @Title: writeFile
	 * @Description: 按照指定的编码把内容写入指定的文件中
	 * @param path
	 * @param content
	 * @param charset
	 * @throws IOException
	 * @return: void
	 */
	public static void writeFile(String path, String content, String charset) throws IOException {
		// 创建写入的文件
		File file = new File(path);
		// 判断父目录是否存在
		if (!file.getParentFile().exists()) {
			// 创建父目录
			file.getParentFile().mkdirs();
		}
		// 创建输出流对象
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
		bw.write(content);
		bw.flush();
		bw.close();
	}

	/**
	 * @Title: readFile
	 * @Description: 给一个文件，读取文件内容
	 * @param file
	 * @param charset
	 * @return
	 * @throws IOException
	 * @return: String
	 */
	public static String readFile(File file, String charset) throws IOException {
		// 创建输出流对象
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
		// 定义缓冲对象
		StringBuffer sb = new StringBuffer();
		// 定义读取每行的结果
		String content = null;
		// 循环读取
		while ((content = br.readLine()) != null) {
			// 加入缓冲对象
			sb.append(content);
		}
		// 关闭流
		br.close();
		// 返回结果
		return sb.toString();

	}

	
	
}
