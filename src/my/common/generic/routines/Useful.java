package my.common.generic.routines;

public class Useful {
	
	public static String getYYYYMMDD_HHMMSS(java.util.Calendar calendar){
		
		String rv;		
		
		rv=mycommons.routines.generic.Convert.convert9ToSomeDigit9(calendar.get(java.util.Calendar.YEAR),mycommons.constants.Date.CS_LEN_DATE_Year_4);	//year
		rv=rv+mycommons.routines.generic.Convert.convert9ToSomeDigit9(mycommons.routines.generic.Date.getMonthCausedByJavaUtilCalendar(calendar.get(java.util.Calendar.MONTH)), mycommons.constants.Date.CS_LEN_DATE_Month);	//month
		rv=rv+mycommons.routines.generic.Convert.convert9ToSomeDigit9(calendar.get(java.util.Calendar.DAY_OF_MONTH), mycommons.constants.Date.CS_LEN_DATE_Day);	//day of month
		rv=rv+"-";
		rv=rv+mycommons.routines.generic.Convert.convert9ToSomeDigit9(calendar.get(java.util.Calendar.HOUR_OF_DAY), mycommons.constants.Date.CS_LEN_TIME_HOUR);	//hour of day
		rv=rv+mycommons.routines.generic.Convert.convert9ToSomeDigit9(calendar.get(java.util.Calendar.MINUTE), mycommons.constants.Date.CS_LEN_TIME_MINUTE);
		rv=rv+mycommons.routines.generic.Convert.convert9ToSomeDigit9(calendar.get(java.util.Calendar.SECOND), mycommons.constants.Date.CS_LEN_TIME_SECOND);
		return rv;
	}

}
