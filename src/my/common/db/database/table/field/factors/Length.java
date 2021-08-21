package my.common.db.database.table.field.factors;

import my.common.generic.Constants;

public class Length {
	
	private Integer length;
	
	//constructors
	public Length() {
		this.constructorCommon(Constants.CS_ZERO_AS_INT);
	}
	public Length(int length) {
		this.constructorCommon(length);
	}
	
	//common constructor
	private void constructorCommon(Integer length) {
		this.length=length;
	}
	//getter
	public Integer get() {
		return this.length;
	}
	//setter
	public void set(Integer in) {
		this.length=in;
	}
}
