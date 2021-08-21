package my.common.db.database.table.field.factors;

import my.common.generic.Constants;

public class IsNullable {

	private boolean isnullable;
	
	//constructors
	public IsNullable() {
		this.constructorCommon(Constants.CS_BOOLEAN_FALSE);
	}
	public IsNullable(boolean isnullable) {
		this.constructorCommon(isnullable);
	}
	//common constructor
	private void constructorCommon(boolean isnullable) {
		this.isnullable=isnullable;
	}
	//getter
	public boolean get() {
		return this.isnullable;
	}
	//setter
	public void set(boolean in) {
		this.isnullable=in;
	}
}
