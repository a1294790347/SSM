package com.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetNowDate {
	public static String getDate(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nowDate = sdf.format(date);
		return nowDate;
	}
}
