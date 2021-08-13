package my.common.db.database.table.field.factors;

import my.common.generic.Constants;

public class Length {
	
	private int length;
	
	//constructors
	public Length() {
		this.constructorCommon(Constants.CS_ZERO_AS_INT);
	}
	public Length(int length) {
		this.constructorCommon(length);
	}
	
	//common constructor
	private void constructorCommon(int length) {
		this.length=length;
	}
	//getter
	public int get() {
		return this.length;
	}
}
