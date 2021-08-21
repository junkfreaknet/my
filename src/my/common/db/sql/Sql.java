package my.common.db.sql;

public class Sql {

	String sqlstring;
	
	//constructors
	public Sql(String in_sqlstring) {
		this.sqlstring=in_sqlstring;
	}
	
	//getter
	public String get() {
		return sqlstring;
	}
}
