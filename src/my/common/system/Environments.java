package my.common.system;

//
//this is a class for system environment elements for using applications.
//
public class Environments {

	private static java.util.Locale localeSys;//
	
	//public methods
	public static void initialize() {
		//set initial some values for application
		
		localeSys=Defaults.LOCALE;
		
	}
	public static void setLocale(java.util.Locale in){
		localeSys=in;
	}	
	public static java.util.Locale getLocale(){
		return localeSys;
	}
}

