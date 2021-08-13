package my.common.generic.routines;

public class Convert {
	
	public static String convert9ToSomeDigit9(String in,int len){
	
		String rv=mycommons.constants.Generic.CS_SPACE;

		//
		//if argument "String in" is not numeric,
		//we return value same as argument "String in".
		//
		try{
			Integer.parseInt(in);
		}catch(NumberFormatException e){
			return in;
		}
		
		//pass the numeric test. and converting goes on.
		rv=mycommons.routines.generic.Core.convert9ToSomeDigit9(Integer.valueOf(in), len);

		return rv;
	
	}
	
	public static String convert9ToSomeDigit9(int in,int len){
		
		String rv=mycommons.constants.Generic.CS_SPACE;
		
		rv=mycommons.routines.generic.Core.convert9ToSomeDigit9(in, len);
		
		return rv;
		
	}
	//
	//convert yyyymmdd --->yyyy/mm/dd
	//
	public static String convertYYYYMMDDToDateFormat(String in){
		
		String rv=mycommons.constants.Generic.CS_SPACE;
		int posStart,posEnd;
		
		//set year
		posStart=mycommons.constants.Generic.CS_ZERO_AS_INT;
		posEnd=mycommons.constants.Date.CS_LEN_DATE_Year_4;
		rv=in.substring(posStart, posEnd);
		//System.out.println("year "+String.valueOf(posStart)+","+String.valueOf(posEnd)+","+rv);
		
		//set month
		posStart=posStart+mycommons.constants.Date.CS_LEN_DATE_Year_4;
		posEnd=posStart+mycommons.constants.Date.CS_LEN_DATE_Month;
		rv=rv+"/"+in.substring(posStart, posEnd);
		//System.out.println("month "+String.valueOf(posStart)+","+String.valueOf(posEnd)+","+rv);
		//set day
		posStart=posStart+mycommons.constants.Date.CS_LEN_DATE_Month;
		posEnd=posStart+mycommons.constants.Date.CS_LEN_DATE_Day;
		rv=rv+"/"+in.substring(posStart, posEnd);		
		//System.out.println("day "+String.valueOf(posStart)+","+String.valueOf(posEnd)+","+rv);
		
		return rv;
		
	}
	public static String convertDateFormatToYYYYMMDD(String in){
		
		String rv=mycommons.constants.Generic.CS_SPACE;
		String[] strings;
		int i;
		
		strings=in.split("/");
		for(i=mycommons.constants.Generic.CS_ZERO_AS_INT;i<strings.length;i++){
			rv=rv+strings[i];
		}
		
		return rv;
		
	}
	
	public static String returnYYYYMMDD(String date){
	
		String rv=mycommons.constants.Generic.CS_SPACE;
		
		if(date.length()==mycommons.constants.Date.CS_LEN_DATE_DATEFORMAT){
			rv=mycommons.routines.generic.Convert.convertDateFormatToYYYYMMDD(date);
		}else{
			rv=date;
		}
		
		return rv;
		
	}
}
