package com.fanqie.dc.support.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 
 * @author lei
 *
 */
public class JodaTimeUtil {
	/** 一天的毫秒数 */
	public static final long MILLION_SECONDS_OF_DAY = 86400000;
	/** 一小时的数 */
	public static final long MILLION_SECONDS_OF_HOUR = 3600000;
	/** 一分钟的毫秒数 */
	public static final long MILLION_SECONDS_OF_MINUTE = 60000;
	/** 日期格式化格式：yyyyMMdd */
	public static final String FORMAT_DATE_STR_NO_SEP = "yyyyMMdd";
	/** 日期格式化格式：yyyy-MM-dd */
	public static final String FORMAT_DATE_STR = "yyyy-MM-dd";
	/** 时间格式化格式：yyyy-MM-dd HH:mm */
	public static final String FORMAT_DATE_STR_ONE = "yyyy-MM-dd HH:mm";
	/** 时间格式化格式：显示秒 */
	public static final String FORMAT_DATE_STR_SECOND = "yyyy-MM-dd HH:mm:ss";
	/** 年月日时分秒毫秒(无下划线) yyyyMMddHHmmssSSS */
	public static final String FORMAT_DATE_STR_LONG = "yyyyMMddHHmmssSSS";
	/** 年月日时分秒,以横线分隔，类似于文件命名形式 */
	public static final String FORMAT_DATE_STR_SECOND_FILE_NAME = "yyyy-MM-dd-HH-mm-ss";

	public static final DateTimeFormatter simple_str = DateTimeFormat.forPattern(FORMAT_DATE_STR);
	
	/**
	 * 获取当前时间  
	 * @return timestamp
	 */
	public static Date getCurrentDate(){
		DateTime dateTime = new DateTime();
		Timestamp timestamp = new Timestamp(dateTime.getMillis());
		return timestamp;
	}
	
	/**
	 * 获取当前时间  
	 * @return timestamp
	 */
	public static Timestamp getCurrentTime(){
		DateTime dateTime = new DateTime();
		Timestamp timestamp = new Timestamp(dateTime.getMillis());
		return timestamp;
	}
	
	/**
	 * 获取 1970年1月1日00:00:00 GMT开始到现在所表示的毫秒数
	 * @return
	 */
	public static Long getCurrentMillis(){
		DateTime dateTime = new DateTime();
		return dateTime.getMillis();
	}
	
	/**
	 * 
	 * @param date 格式"yyyy-MM-dd"
	 * @return
	 */
	public static Date parse(String date){
		return DateTime.parse(date).toDate();
	}

	public static Date parse(String date,String pattern){
		DateTimeFormatter dtf = DateTimeFormat.forPattern(pattern);
		return DateTime.parse(date, dtf).toDate();
	}
	
	public static Timestamp parseTimestamp(String date){
		Date datetime = DateTime.parse(date).toDate();
		Timestamp timestamp = new Timestamp(datetime.getTime());
		return timestamp;
	}
	
	/**
	 * 默认的格式
	 * @param date 
	 * @return 返回默认格式"yyyy-MM-dd"的字符串
	 */
	public static String format(Date date){
		DateTime dateTime = new DateTime(date);
		return dateTime.toString(simple_str);
	}
	
	/**
	 * 默认的格式
	 * @param dateTime
	 * @return 返回默认格式"yyyy-MM-dd"的字符串
	 */
	public static String format(DateTime dateTime){
		return dateTime.toString(simple_str);
	}
	
	/**
	 * 
	 * @param date 当前时间
	 * @param format 格式
	 * @return
	 */
	public static String format(Date date,String format){
		DateTime dateTime = new DateTime(date);
		DateTimeFormatter dtf = DateTimeFormat.forPattern(format);
		return dateTime.toString(dtf);
	}
	
	/**
	 * 增加天数
	 * @param date yyyy-MM-dd"的字符串
	 * @param i
	 * @return yyyy-MM-dd"的字符串
	 */
	public static String addDay(String date,int i){
		if(i == 0)
			return date;
		DateTime dateTime = DateTime.parse(date);
		return dateTime.plusDays(i).toString(simple_str);
	}
	
	/**
	 * 增加天数
	 * @param date 
	 * @param i
	 * @param format 格式
	 * @return
	 */
	public static String addDay(String date,int i,String format){
		if(i == 0)
			return date;
		DateTimeFormatter dtf = DateTimeFormat.forPattern(format);
		DateTime dateTime = DateTime.parse(date);
		return dateTime.plusDays(i).toString(dtf);
	}
	
	/**
	 * 得到两个日期之间相差的天数,两头不算,取出数据后，可以根据需要再加
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getDifferDay(Date date1, Date date2) {
		String d1 = format(date1);
		String d2 = format(date2);
		return getDifferDay(d1, d2);
	}

	/**
	 * 得到两个日期之间相差的天数,两头不算,取出数据后，可以根据需要再加
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getDifferDay(String date1, String date2) {
		DateTime dateTime1_tmp = DateTime.parse(date1);
		DateTime dateTime2_tmp = DateTime.parse(date2);
		Period p = new Period(dateTime1_tmp, dateTime2_tmp, PeriodType.days());
		int days = p.getDays();  
		return Math.abs(days);
	}
	
	/**
	 * 判断当前天是星期几
	 * @param date
	 * @return 数字
	 */
	public static int dayOfWeek(String date){
		DateTime dateTime = DateTime.parse(date);
		return dateTime.dayOfWeek().get();
	}
	
	/**
	 * 比较时间大小
	 * @param date1
	 * @param date2
	 * @return date1 < date2 true
	 */
	public static boolean compareDate(String date1,String date2){
		DateTime dateTime1 = new DateTime(date1);
		long a = dateTime1.getMillis();
		DateTime dateTime2 = new DateTime(date2);
		long b = dateTime2.getMillis();
		return a < b ? true : false;
	}
	
	/**
	 * 比较时间大小
	 * @param date1
	 * @param date2
	 * @return date1 > date2 返回1
	 *         date1 < date2 返回-1
	 *         date1 = date2 返回0
	 */
	public static int compareDates(String date1,String date2){
		DateTime dateTime1 = new DateTime(date1);
		long a = dateTime1.getMillis();
		DateTime dateTime2 = new DateTime(date2);
		long b = dateTime2.getMillis();
		if(a > b){
			return 1;
		}else if(a < b){
			return -1;
		}else{
			return 0;
		}
	}
	
	/**
	 * 比较两个时间， 取较大的时间
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static String compareOfMax(String date1,String date2){
		DateTime dateTime1 = new DateTime(date1);
		long a = dateTime1.getMillis();
		DateTime dateTime2 = new DateTime(date2);
		long b = dateTime2.getMillis();
		return a >= b? date1:date2;
	}
	
	/**
	 * 比较两个时间，取较小的时间
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static String compareOfMin(String date1,String date2){
		DateTime dateTime1 = new DateTime(date1);
		long a = dateTime1.getMillis();
		DateTime dateTime2 = new DateTime(date2);
		long b = dateTime2.getMillis();
		return a >= b? date2:date1;
	}

	/**
	 * @param date  eg: 2015-05-06 -> 2015-05-06 23:59:59
	 */
	public static String add23Hours(String date) {
		if (StringUtils.isNotEmpty(date)){
			String day = addDay(date, 1);
			DateTime dateTime = DateTime.parse(day);
			DateTime time = dateTime.plusSeconds(-1);
			return time.toString(FORMAT_DATE_STR_SECOND);

		}
		return null;
	}

    /**
     * 判断两个时间是否属于同一个月
     * @param date1
     * @param date2
     * @return
     */
    public static boolean judgeOfOneMonth(String date1,String date2){
        DateTime dt1 = DateTime.parse(date1);
        DateTime dt2 = DateTime.parse(date2);
        return dt1.year().get() == dt2.year().get() && dt1.monthOfYear().get() == dt2.monthOfYear().get();
    }

    /**
     * 获取本月第一天时间类型
     * @param date
     * @return
     */
    public static Timestamp getFirstDayOfMontht(String date){
        DateTime dt = DateTime.parse(date);
        DateTime dateTime = dt.dayOfMonth().withMinimumValue();
        return parseTimestamp(format(dateTime));
    }

    /**
     * 获取本月第一天
     * @param date
     * @return
     */
    public static String getFirstDayOfMonth(String date){
        DateTime dt = DateTime.parse(date);
        DateTime dateTime = dt.dayOfMonth().withMinimumValue();
        return format(dateTime);
    }

    /**
     * 获取本月最后一天
     * @param date
     * @return
     */
    public static String getLastDayOfMonth(String date){
        DateTime dt = DateTime.parse(date);
        DateTime dateTime = dt.dayOfMonth().withMaximumValue();
        return format(dateTime);
    }
	
	public static void main(String[] args) {
        String firstDayOfMonth = getLastDayOfMonth("2015-09-13");
        System.out.println(firstDayOfMonth);
    }
	

}
