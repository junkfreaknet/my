package my.common.db.database.table.field.factors;

import my.common.generic.Constants;

public class Type {

	private String type;
	
	//constructors
	public Type() {
		this.constructorCommon(Constants.CS_SPACE);
	}
	public Type(String type) {
		this.constructorCommon(type);
	}
	//common constructor
	private void constructorCommon(String type) {
		this.type=type;
	}
	//getter
	public String get() {
		return this.type;
	}
}
