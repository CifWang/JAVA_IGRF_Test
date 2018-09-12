package test;

import java.util.ArrayList;
import java.util.List;

import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

import igrf.IGRF;
import timeConvert.TimeConvert;
/**
 * 调用igrf终于成功了
 * @author xcc
 *
 */

public class Test {
	public static void main(String[] args) throws MWException{
		IGRF igrfTest=new IGRF();
		//double[] timed={2007,7,17,6,30,0};
		//List in=new ArrayList();
		
		String time="2017/7/17";
		String time2="2017-07-17-06.30.00";
		
		TimeConvert t2=new TimeConvert();
		Object[] time_2={time2};
		Object[] t=t2.timeConvert(1, time_2);
		
		MWNumericArray lat=new MWNumericArray(Double.valueOf(-60.0),MWClassID.DOUBLE);
		MWNumericArray lon=new MWNumericArray(Double.valueOf(180.0),MWClassID.DOUBLE);
		MWNumericArray alt=new MWNumericArray(Double.valueOf(0.0),MWClassID.DOUBLE);
		
		Object[] in={t[0],lat,lon,alt};
		
		/**
		int lat=-60;
		String lats=String.valueOf(lat);
		int lon=180;
		String lons=String.valueOf(lon);
		int alt=0;
		String alts=String.valueOf(alt);
		String coord="geodetic";*/
		
		//in.add(timed);in.add(lats);in.add(lons);in.add(alts);in.add(coord);
		//String[] in={time,lats,lons,alts};
		Object[] result=igrfTest.igrf(3, in);
		
		//System.out.println(result.length);
		//System.out.println(type(result[0]));
		//System.out.println("----------------");
		//System.out.println(result[0]);
		
		
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}
	
	public static String type(Object o){
		String typeName=o.getClass().getName();
		int length=typeName.lastIndexOf(".");
		String type=typeName.substring(length+1);
		return type;
	}

}
