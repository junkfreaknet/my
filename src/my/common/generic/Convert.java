
package my.common.generic;

//import my.common.generic.constants;
import my.common.date.Date;

public class Convert {
	
	public static String convert9ToSomeDigit9(String in,int len){
	
		String rv=Constants.CS_SPACE;

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
		rv=convert9ToSomeDigit9(Integer.valueOf(in), len);

		return rv;
	
	}
	
	public static String convert9ToSomeDigit9(int in,int len){
		
		String rv=Constants.CS_SPACE;
		
		rv=convert9ToSomeDigit9(in, len);
		
		return rv;
		
	}
	//
	//convert yyyymmdd --->yyyy/mm/dd
	//
	public static String convertYYYYMMDDToDateFormat(String in){
		
		String rv=Constants.CS_SPACE;
		int posStart,posEnd;
		
		//set year
		posStart=Constants.CS_ZERO_AS_INT;
		posEnd=Date.CS_LEN_DATE_Year_4;
		rv=in.substring(posStart, posEnd);
		//System.out.println("year "+String.valueOf(posStart)+","+String.valueOf(posEnd)+","+rv);
		
		//set month
		posStart=posStart+Date.CS_LEN_DATE_Year_4;
		posEnd=posStart+Date.CS_LEN_DATE_Month;
		rv=rv+"/"+in.substring(posStart, posEnd);
		//System.out.println("month "+String.valueOf(posStart)+","+String.valueOf(posEnd)+","+rv);
		//set day
		posStart=posStart+Date.CS_LEN_DATE_Month;
		posEnd=posStart+Date.CS_LEN_DATE_Day;
		rv=rv+"/"+in.substring(posStart, posEnd);		
		//System.out.println("day "+String.valueOf(posStart)+","+String.valueOf(posEnd)+","+rv);
		
		return rv;
		
	}
	public static String convertDateFormatToYYYYMMDD(String in){
		
		String rv=Constants.CS_SPACE;
		String[] strings;
		int i;
		
		strings=in.split("/");
		for(i=Constants.CS_ZERO_AS_INT;i<strings.length;i++){
			rv=rv+strings[i];
		}
		
		return rv;
		
	}
	
	public static String returnYYYYMMDD(String date){
	
		String rv=Constants.CS_SPACE;
		
		if(date.length()==Date.CS_LEN_DATE_DATEFORMAT){
			rv=convertDateFormatToYYYYMMDD(date);
		}else{
			rv=date;
		}
		
		return rv;
		
	}
	public static String convertNumberToString(int in){
		
		String rv=String.valueOf(in);
		int len=rv.length();
		
		rv=convertNumberToString(in,len);
		
		return rv;
		
	}
	
	public  static String convertNumberToString(int in,int len){
		
		String rv=Constants.CS_SPACE;
		
		int i;
		int nokori,amari;
		
		String buff=String.valueOf(in);
		String buffZero=Constants.CS_SPACE;
		
		//when input value is zero
		if(in==Constants.CS_ZERO_AS_INT)
		{

			for(i=Constants.CS_ZERO_AS_INT;i<len;i++)
			{
				rv=rv+Constants.CS_ZERO_AS_STRING;
			}

		}else
		{
			//NORMAL�?hen input value is not zero
				
			nokori=in;
			buff=Constants.CS_SPACE;
				
			//step 1.
			while(nokori!=Constants.CS_ZERO_AS_INT)
			{
					
				amari=nokori%Constants.CS_10_AS_INT;
				buff=buff+String.valueOf(amari);
				nokori=nokori/Constants.CS_10_AS_INT;
	
			}
			
			//step 2
			buff=reverseString(buff);
			
			//step 3
			if(len==buff.length()){

				rv=buff;

			}else
			{
				for(i=len-buff.length();i!=Constants.CS_ZERO_AS_INT;i--)
				{
					buffZero=buffZero+Constants.CS_ZERO_AS_STRING;

				}

				rv=buffZero+buff;
			}
		}
		
		return rv;
		
	}
	
	private  static String reverseString(String in){
		
		String rv=Constants.CS_SPACE;
		int i;

		for(i=in.length();i!=Constants.CS_ZERO_AS_INT;i--){

			rv=rv+in.substring(i-Constants.CS_1_AS_INT, i);

		}
		
		return rv;
		
	}

}
