package com.util;

public class YanZhengUtil {
	
	
	public static boolean isShuZi(String str){
		return str.matches("[0-9]+");
	}
	
	
	public static boolean isXiaoShu(String str){
		return str.matches("[0-9]*[.][0-9]+");
	}
	
	
}
