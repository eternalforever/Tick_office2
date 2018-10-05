package com.dld.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.expression.ParseException;
import org.springframework.util.StringUtils;

public class DateUtils {
	/**
	 * 43 * 时间格式化成字符串 44 * @param date Date 45 * @param pattern
	 * StrUtils.DATE_TIME_PATTERN || StrUtils.DATE_PATTERN， 如果为空，则为yyyy-MM-dd 46
	 * * @return 47 * @throws ParseException 48
	 */
	public static String dateFormat(Date date, String pattern) throws ParseException {
		if (StringUtils.isEmpty(pattern)) {
			pattern = "yyyy-mm-dd HH:MM";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
}
