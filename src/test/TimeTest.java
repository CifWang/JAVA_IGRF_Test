package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 测试getTime功能
 * @author xcc
 *
 */
public class TimeTest {
	public static void main(String[] args){
		//Calendar类的getInstance()可以初始化一个日历对象
		Calendar c=Calendar.getInstance();
		c.setTimeZone(TimeZone.getTimeZone("Etc/GMT+0"));
		
		//Calendar.MILLISECOND Field number for get and set indicating the millisecond within the second
		//sets the given calendar field to the given value
		c.set(Calendar.MILLISECOND, 0);
		//sets the values for the fields YEAR,MONTH,DAY_OF_MONTH,HOUR_OF_DAY,MINUTE,SECOND
		c.set(2013, 0, 1, 0, 0, 0);
		Date d=c.getTime();
		//d.setTimeZone(TimeZone.getTimeZone("Etc/GMT+0"));
		long l = c.getTime().getTime();
		//double ld=(double)l;
		//System.out.println(d);
		//System.out.println(ld);
		//Date d2=new Date(l);
		//System.out.println(d2);
		
		//设置date的时区
		Date date=new Date();
		date=c.getTime();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sf.setTimeZone(TimeZone.getTimeZone("Etc/GMT+0"));
		String date_format=sf.format(date);
		System.out.println(date_format);
		System.out.println(l);
		
		Date date2=new Date(l);
		String date2_format=sf.format(date2);
		System.out.println(date2_format);
		
	}

}
