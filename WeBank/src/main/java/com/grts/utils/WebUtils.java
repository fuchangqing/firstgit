package com.grts.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WebUtils {

	private static int num=0;
	private static int fileNum=0;
	public static String createWorkOrderId(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmss");
		
		return "c"+sdf.format(new Date())+num++;
	}
	public static String createFileName(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		
		return "c"+sdf.format(new Date())+fileNum++;
	}
	public static boolean isEmpty(String str){
		if(str==null||"".equals(str)){
			return true;
		}
		return false;
	}
}
