package my.common.generic.routines;

public class Compare {

	//compare integer 
	//
	public static boolean isEqual(int i,int j){
		
		boolean rv=false;
		
		Integer a=i;
		Integer b=j;
		int result;
		result=a.compareTo(b);
		if(result==0){
			rv=true;
		}
		return rv;
	}
}
