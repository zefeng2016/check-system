package com.zefeng.checksystem.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class PrintConsole {
	private static Logger logger = Logger.getLogger(PrintConsole.class);  
	
	public static void Print(String msg) {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy/MM/dd HH:mm:ss");// ���Է�����޸����ڸ�ʽ

		String time = dateFormat.format(now);
//		 logger.debug(time+":"+msg);
	}
}
