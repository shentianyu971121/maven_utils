package com.sty.utils;

import java.util.Collection;

/**
 * 集合工具类
 * @author tianyu
 *
 */
public class ClectionUtils {

	public static boolean isEmpty(Collection src) {
		if(src==null||src.size()==0) {
			return  false;
		} else {
			return true;
		}
	}
	
	
}
