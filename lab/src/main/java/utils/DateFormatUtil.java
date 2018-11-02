package main.java.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
    public static String dateformat() {
		//获得当前时间的工具
		SimpleDateFormat  sdFormat =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date2 =new Date();
		String aString =sdFormat.format(date2);
		System.out.println(aString);
		return aString;
	}
}
