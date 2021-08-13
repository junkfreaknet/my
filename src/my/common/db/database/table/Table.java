package my.common.db.database.table;

import my.common.generic.Constants;

public class Table {

	private String name;
	
	//public constructors
	public Table(){

		this.constructorCommon(Constants.CS_SPACE);
		
	}
	public Table(String in_name){

		this.constructorCommon(in_name);
		
	}
	//private constructor
	
	//table name only.
	private void constructorCommon(String in_name){
		
		this.name=in_name;
		
	}
	
	//get method
	public String getName(){
		
		return this.name;
		
	}
	public Table get(){
		
		return this;
		
	}
}
