package JavaOO;

import java.util.Calendar;

/**
 * Java库里面有一个Calendar的单例使用
 * @Description:  
 * @Title:  JavaCalendar.java   
 * @Package JavaOO   
 * @author: ZhangYang     
 * @date:   2018年11月18日 下午3:54:30
 */
public class JavaCalendar {


	public static void main(String[] args) {
		//单例Calendar的实例化
		Calendar calendar = Calendar.getInstance();
		
		//获取年，月，日，小时，分钟，秒，毫秒
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;   //month从0开始
		int date = calendar.get(Calendar.DATE);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);  //24小时制
		int min = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int millisecond = calendar.get(Calendar.MILLISECOND);
		
		System.out.println("现在时间：");
		String strTime = String.format("%d-%02d-%02d,%d-%02d-%d:%d", 
			year,month,date,hour,min,second,millisecond	
		);
		System.out.println(strTime);
	}

}
