
package com.dld.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class FileUtils {
	
	//创建文件夹 一个月一个文件夹
	public static File createDir(String dir) {
		//子文件名称：201805 201806
		String month=new SimpleDateFormat("yyyyMM").format(new Date());
		File dir1=new File(new File(dir).getParent(),"updateimage");
		File dir2=new File(dir1,month) ;
		if(!dir2.exists()) {
			dir2.mkdirs();
		}
		return dir2;
	}
	//创建唯一名称 
	public static String createFileName(String fn) {
		if(fn.length()>30) {
			fn=fn.substring(fn.length()-30);
		}
		return UUID.randomUUID().toString()+"_"+fn;
	}
	public static File createDir(String root,String dir) {
		//子文件名称：201805 201806
		String month=new SimpleDateFormat("yyyyMM").format(new Date());
		File dir1=new File(new File(root).getParent(),"tickresource"+File.separator+dir);
		
		if(!dir1.exists()) {
			dir1.mkdirs();
		}
		return dir1;
	}
	

}
