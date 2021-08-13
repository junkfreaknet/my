package my.common.generic.routines;

//import java.util.Locale;

public class Date {
	
	//
	//argument "date" must to be a "yyyy/mm/dd" or "yyyymmdd" format 
	//value.
	//
	public static String getWeekday(String date,java.util.Locale locale){
		
		java.util.Calendar calendar=new java.util.GregorianCalendar(mycommons.routines.generic.Date.getYear(date),mycommons.routines.generic.Date.createValueOfMonth(mycommons.routines.generic.Date.getMonth(date)),mycommons.routines.generic.Date.getDay(date));	
		java.text.SimpleDateFormat weekday=new java.text.SimpleDateFormat("EE", locale);
		java.util.Date dte=calendar.getTime();
		return weekday.format(dte);
		
	}
	public static int getWeekday(String date){
		 
		java.util.Calendar calendar=new java.util.GregorianCalendar(mycommons.routines.generic.Date.getYear(date),mycommons.routines.generic.Date.createValueOfMonth(mycommons.routines.generic.Date.getMonth(date)),mycommons.routines.generic.Date.getDay(date));		
		
		return calendar.get(java.util.Calendar.DAY_OF_WEEK);
			
	}
	public static int getYear(String date){
		
		int rv=mycommons.constants.Generic.CS_ZERO_AS_INT;
		
		date=mycommons.routines.generic.Convert.returnYYYYMMDD(date);
		date=date.substring(mycommons.constants.Generic.CS_ZERO_AS_INT, mycommons.constants.Date.CS_LEN_DATE_Year_4);
		rv=Integer.valueOf(date);
		
		return rv;
	}
	public static int getMonth(String date){
		
		int rv=mycommons.constants.Generic.CS_ZERO_AS_INT;
		
		date=mycommons.routines.generic.Convert.returnYYYYMMDD(date);
		date=date.substring(mycommons.constants.Date.CS_LEN_DATE_Year_4,mycommons.constants.Date.CS_LEN_DATE_Year_4+ mycommons.constants.Date.CS_LEN_DATE_Month);
		rv=Integer.valueOf(date);
		
		return rv;
		
	}
	public static int createValueOfMonth(int month){
		return month-mycommons.constants.Generic.CS_1_AS_INT;
	}
	public static int getDay(String date){
		
		int rv=mycommons.constants.Generic.CS_ZERO_AS_INT;
		
		date=mycommons.routines.generic.Convert.returnYYYYMMDD(date);
		date=date.substring(mycommons.constants.Date.CS_LEN_DATE_Year_4+mycommons.constants.Date.CS_LEN_DATE_Month, mycommons.constants.Date.CS_LEN_DATE_Year_4+mycommons.constants.Date.CS_LEN_DATE_Month+mycommons.constants.Date.CS_LEN_DATE_Day);
		rv=Integer.valueOf(date);
		
		return rv;
				
	}
	
	public static int getMonthCausedByJavaUtilCalendar(int month){
		
		int rv;
		rv=month+1;
		return rv;
	}
	public static String getYYYYMMDDHHMMSS(java.util.Calendar calendar){
		
		String rv;
		rv=mycommons.routines.generic.Convert.convert9ToSomeDigit9(calendar.get(java.util.Calendar.YEAR),mycommons.constants.Date.CS_LEN_DATE_Year_4);	//year
		rv=rv+mycommons.routines.generic.Convert.convert9ToSomeDigit9(mycommons.routines.generic.Date.getMonthCausedByJavaUtilCalendar(calendar.get(java.util.Calendar.MONTH)), mycommons.constants.Date.CS_LEN_DATE_Month);	//month
		rv=rv+mycommons.routines.generic.Convert.convert9ToSomeDigit9(calendar.get(java.util.Calendar.DAY_OF_MONTH), mycommons.constants.Date.CS_LEN_DATE_Day);	//day of month
		rv=rv+mycommons.routines.generic.Convert.convert9ToSomeDigit9(calendar.get(java.util.Calendar.HOUR_OF_DAY), mycommons.constants.Date.CS_LEN_TIME_HOUR);	//hour of day
		rv=rv+mycommons.routines.generic.Convert.convert9ToSomeDigit9(calendar.get(java.util.Calendar.MINUTE), mycommons.constants.Date.CS_LEN_TIME_MINUTE);
		rv=rv+mycommons.routines.generic.Convert.convert9ToSomeDigit9(calendar.get(java.util.Calendar.SECOND), mycommons.constants.Date.CS_LEN_TIME_SECOND);		
		
		return rv;
	}
	public static String getYYYYMMDD(java.util.Calendar calendar){
		
		String rv;
		rv=mycommons.routines.generic.Convert.convert9ToSomeDigit9(calendar.get(java.util.Calendar.YEAR),mycommons.constants.Date.CS_LEN_DATE_Year_4);	//year
		rv=rv+mycommons.routines.generic.Convert.convert9ToSomeDigit9(mycommons.routines.generic.Date.getMonthCausedByJavaUtilCalendar(calendar.get(java.util.Calendar.MONTH)), mycommons.constants.Date.CS_LEN_DATE_Month);	//month
		rv=rv+mycommons.routines.generic.Convert.convert9ToSomeDigit9(calendar.get(java.util.Calendar.DAY_OF_MONTH), mycommons.constants.Date.CS_LEN_DATE_Day);	//day of month
		return rv;
		
	}
	public static String getYYYYMMDD(){
		
		return mycommons.routines.generic.Date.getYYYYMMDD(java.util.Calendar.getInstance());
		
	}
}
