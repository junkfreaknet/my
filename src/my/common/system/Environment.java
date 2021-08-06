package my.common.system;

//
//this is a class for system environment elements for using applications.
//
public class Environment {

	private java.util.Locale localeSys;//
	
	//public methods
	public void setLocale(java.util.Locale in){
		this.localeSys=in;
	}	
	public java.util.Locale getLocale(){
		return localeSys;
	}
}

