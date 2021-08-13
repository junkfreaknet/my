package my.common.generic.routines;

public class Core {
	
	//
	// Convert9ToSomeDigit9
	// it converts integer value to string value by length of string.
	//
	
	public static String convert9ToSomeDigit9(int in,int len){
		
		String rv=mycommons.constants.Generic.CS_SPACE;
		
		//WHEN�?NPUT VALUE IS LAGER THAN ((10 ^ "int len") - 1 
		// OR
		//WHEN�?RGUMENT OF LENGTH IS 0
		//WE RETURN THE SAME VALUE AS ARGUMENT "int in" AS STRING
		if(in>(Math.pow(mycommons.constants.Generic.CS_10_AS_INT,len))-1){
			rv=convertNumberToString(in);
			return rv;
		}
		if(len==mycommons.constants.Generic.CS_ZERO_AS_INT){
			rv=convertNumberToString(in);
			return rv;
		}
		
		//Normal,Converting goes on.
		rv=convertNumberToString(in,len);
		return rv;
		
	}
	
	private static String convertNumberToString(int in){
		
		String rv=String.valueOf(in);
		int len=rv.length();
		
		rv=convertNumberToString(in,len);
		
		return rv;
		
	}
	
	private  static String convertNumberToString(int in,int len){
		
		String rv=mycommons.constants.Generic.CS_SPACE;
		
		int i;
		int nokori,amari;
		
		String buff=String.valueOf(in);
		String buffZero=mycommons.constants.Generic.CS_SPACE;
		
		//when input value is zero
		if(in==mycommons.constants.Generic.CS_ZERO_AS_INT)
		{

			for(i=mycommons.constants.Generic.CS_ZERO_AS_INT;i<len;i++)
			{
				rv=rv+mycommons.constants.Generic.CS_ZERO_AS_STRING;
			}

		}else
		{
			//NORMAL�?hen input value is not zero
				
			nokori=in;
			buff=mycommons.constants.Generic.CS_SPACE;
				
			//step 1.
			while(nokori!=mycommons.constants.Generic.CS_ZERO_AS_INT)
			{
					
				amari=nokori%mycommons.constants.Generic.CS_10_AS_INT;
				buff=buff+String.valueOf(amari);
				nokori=nokori/mycommons.constants.Generic.CS_10_AS_INT;
	
			}
			
			//step 2
			buff=reverseString(buff);
			
			//step 3
			if(len==buff.length()){

				rv=buff;

			}else
			{
				for(i=len-buff.length();i!=mycommons.constants.Generic.CS_ZERO_AS_INT;i--)
				{
					buffZero=buffZero+mycommons.constants.Generic.CS_ZERO_AS_STRING;

				}

				rv=buffZero+buff;
			}
		}
		
		return rv;
		
	}
	
	private  static String reverseString(String in){
		
		String rv=mycommons.constants.Generic.CS_SPACE;
		int i;

		for(i=in.length();i!=mycommons.constants.Generic.CS_ZERO_AS_INT;i--){

			rv=rv+in.substring(i-mycommons.constants.Generic.CS_1_AS_INT, i);

		}
		
		return rv;
		
	}

}
