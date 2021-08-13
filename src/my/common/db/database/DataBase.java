package my.common.db.database;

import my.common.generic.Constants;

public class DataBase {

	private String name;
	
	//constructors
	public DataBase() {
		this.constructorCommon(Constants.CS_SPACE);
	}
	public DataBase(String name) {
		this.constructorCommon(name);
	}
	//construcor common
	private void constructorCommon(String name) {
		this.name=name;
	}
}
