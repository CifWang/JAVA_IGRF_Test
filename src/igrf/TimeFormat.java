package igrf;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 处理时间
 * @author xcc
 *
 */
public class TimeFormat {
	
	public final String timeZone="Etc/GMT+0";
	private String timestr;
	
	public TimeFormat(double t){
		Date date=new Date((long)t);
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sf.setTimeZone(TimeZone.getTimeZone(timeZone));
		String time=sf.format(date);
		this.timestr=time;
	}
	
	public String getTimestr(){
		return this.timestr;
	}
	
	/**
	public static void main(String[] args){
		Calendar c=Calendar.getInstance();
		c.setTimeZone(TimeZone.getTimeZone("Etc/GMT+0"));
		c.set(2013, 0, 1, 0, 0, 0);
		long l = c.getTime().getTime();
		double ld=(double)l;
		TimeFormat tf=new TimeFormat(l);
		String ls=tf.getTimestr();
		//long time=1356998400643;
		double timed=1.356998400978E12;
		long time=(long)timed;
		TimeFormat tf2=new TimeFormat(time);
		String times=tf2.getTimestr();
		System.out.println(ld);
		System.out.println(l);
		System.out.println(ls);
	}*/

}
