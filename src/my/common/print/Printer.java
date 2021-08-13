package my.common.print;

import mycommons.db.connection.DataBase;

public class Printer {
	
	String name;//the name means name of print service.
		
	//constructors
	public Printer(){
		this.constructorCommon(mycommons.constants.Generic.CS_SPACE);
	}
	public Printer(String source){
		this.constructorCommon(source);
	}
	public Printer(Printer source){
		this.constructorCommon(source);
	}

	//public methods
	public Printer get(){
		return this;
	}

	/***
	public void setName(String source){
		this.name=source;
	}
	***/
	public void setName(Printer source){
		this.name=source.toStringName();
	}
	
	public String toStringName(){
		return this.name;
	}

	//private methods
	private void constructorCommon(String printer){
		this.name=printer;
	}
	private void constructorCommon(Printer source){
		this.constructorCommon(source.toStringName());
	}

}
