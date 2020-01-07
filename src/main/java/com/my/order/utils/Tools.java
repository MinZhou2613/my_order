package com.my.order.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public class Tools {
	
	public static String NowTime() {
		return new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());
		
	}
	public static String Now() {
		return new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
		
	}
	public static String NowMonth() {
		return new SimpleDateFormat("yyyy年MM月").format(new Date());
		
	}

}
