package my.common.date;

import my.common.generic.Constants;
import my.common.generic.Convert;

public class Date {


	//about date
	public static final int CS_LEN_DATE_YYYYMMDD=8; //yyyymmdd
	public static final int CS_LEN_DATE_DATEFORMAT=10;//yyyy/mm/dd
	public static final int CS_LEN_DATE_Year_4=4;
	public static final int CS_LEN_DATE_Year_2=2;
	public static final int CS_LEN_DATE_Month=2;
	public static final int CS_LEN_DATE_Day=2;
	
	//time
	public static final int CS_LEN_TIME_HOUR=2;
	public static final int CS_LEN_TIME_MINUTE=2;
	public static final int CS_LEN_TIME_SECOND=2;

	//
	//argument "date" must to be a "yyyy/mm/dd" or "yyyymmdd" format 
	//value.
	//
	public static String getWeekday(String date,java.util.Locale locale){
		
		java.util.Calendar calendar=new java.util.GregorianCalendar(getYear(date),createValueOfMonth(getMonth(date)),getDay(date));	
		java.text.SimpleDateFormat weekday=new java.text.SimpleDateFormat("EE", locale);
		java.util.Date dte=calendar.getTime();
		return weekday.format(dte);
		
	}
	public static int getWeekday(String date){
		 
		java.util.Calendar calendar=new java.util.GregorianCalendar(getYear(date),createValueOfMonth(getMonth(date)),getDay(date));
		
		return calendar.get(java.util.Calendar.DAY_OF_WEEK);
			
	}
	public static int getYear(String date){
		
		int rv=Constants.CS_ZERO_AS_INT;
		
		date=Convert.returnYYYYMMDD(date);
		date=date.substring(Constants.CS_ZERO_AS_INT,CS_LEN_DATE_Year_4);
		rv=Integer.valueOf(date);
		
		return rv;
	}
	public static int getMonth(String date){
		
		int rv=Constants.CS_ZERO_AS_INT;
		
		date=Convert.returnYYYYMMDD(date);
		date=date.substring(CS_LEN_DATE_Year_4,CS_LEN_DATE_Year_4+ CS_LEN_DATE_Month);
		rv=Integer.valueOf(date);
		
		return rv;
		
	}
	public static int createValueOfMonth(int month){
		return month-Constants.CS_1_AS_INT;
	}
	public static int getDay(String date){
		
		int rv=Constants.CS_ZERO_AS_INT;
		
		date=Convert.returnYYYYMMDD(date);
		date=date.substring(CS_LEN_DATE_Year_4+CS_LEN_DATE_Month,CS_LEN_DATE_Year_4+CS_LEN_DATE_Month+CS_LEN_DATE_Day);
		rv=Integer.valueOf(date);
		
		return rv;
				
	}

}
