package my.common.db.database.table.field.factors;

import my.common.generic.Constants;

public class Name {
	
	private String name;
	
	//constructors
	public Name() {
		this.constructorCommon(Constants.CS_SPACE);
	}
	public Name(String name) {
		this.constructorCommon(name);
	}
	
	//constructor common
	private void constructorCommon(String name) {
		this.name=name;
	}
	//getter
	public String get() {
		return this.name;
	}
}
