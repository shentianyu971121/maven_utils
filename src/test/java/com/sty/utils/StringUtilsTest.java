package com.sty.utils;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void test() throws Exception {
		//ֱ�ӵ��þ�̬���� ��ȡn���ַ���
		List<String> readTitleAndConments = StringUtils.readTitleAndConments("D:/week");
		for (String string : readTitleAndConments) {
			System.err.println(string);
		}
	}

}
