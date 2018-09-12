package igrf;
/**
 * 根据给出的long time,float lat,float lon,float alt,利用igrf计算Bx,By,Bz
 * @author xcc
 *
 */

import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

import igrf.TimeFormat;
import igrf.IGRF;

public class IgrfCalculate {
	private double time;
	private float lat;
	private float lon;
	private float alt;
	private String coord;
	private float[] BValue;
	
	
	public IgrfCalculate(double t, float latitude,float longitude,float altitude)throws MWException{
		this.coord="geodestic";
		this.time=t;
		this.lat=latitude;
		this.lon=longitude;
		this.alt=altitude;
		
		TimeFormat tf=new TimeFormat(this.time);
		String timestr=tf.getTimestr();
		//System.out.println(timestr);
		
		MWNumericArray latArray=new MWNumericArray(Float.valueOf(this.lat));
		MWNumericArray lonArray=new MWNumericArray(Float.valueOf(this.lon));
		MWNumericArray altArray=new MWNumericArray(Float.valueOf(this.alt));
		
		
		IGRF ig=new IGRF();
		Object[] in={timestr,latArray,lonArray,altArray};
		
		Object[] out=ig.igrf(3, in);
		float[] B=new float[out.length];
		for(int i=0;i<out.length;i++){
			float b=Float.parseFloat(out[i].toString());
			B[i]=b;
		}
		
		this.BValue=B;
	}
	
	public IgrfCalculate(double t,float latitude,float longitude,float altitude,String coordinate) throws MWException{
		this.time=t;
		this.lat=latitude;
		this.lon=longitude;
		this.alt=altitude;
		this.coord=coordinate;
		
		TimeFormat tf=new TimeFormat(this.time);
		String timestr=tf.getTimestr();
		//System.out.println(timestr);
		
		MWNumericArray latArray=new MWNumericArray(Float.valueOf(this.lat));
		MWNumericArray lonArray=new MWNumericArray(Float.valueOf(this.lon));
		MWNumericArray altArray=new MWNumericArray(Float.valueOf(this.alt));
		
		
		IGRF ig=new IGRF();
		Object[] in={timestr,latArray,lonArray,altArray};
		
		Object[] out=ig.igrf(3, in);
		float[] B=new float[out.length];
		for(int i=0;i<out.length;i++){
			float b=Float.parseFloat(out[i].toString());
			B[i]=b;
		}
		
		this.BValue=B;
		
	}
	
	public float[] getBvalue3(){
		return this.BValue;
	}
	
	/**
	public static void main(String[] args) throws MWException{
		double time=1.356998400978E12;
		
		IgrfCalculate ic=new IgrfCalculate(time,-60,180,0);
		float[] b=ic.getBvalue3();
		for(int i=0;i<b.length;i++){
			System.out.println(b[i]);
		}
	}*/

}
