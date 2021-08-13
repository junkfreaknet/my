package my.common.db.generic;

public class Constant {

	//connection general
	public static final String CONNECTION_PREFIX="jdbc";
	public static final String CONNECTION_SEPARATOR_COLON=":";
	public static final String CONNECTION_SEPARATOR_SEMI_COLON=";";
	public static final String CONNECTION_DOUBLE_SLASH="//";
	public static final String CONNECTION_DOUBLE_BACK_SLASH="\\";
	public static final String CONNECTION_DATABASE="database=";
	public static final String CONNECTION_USER="user=";
	public static final String CONNECTION_PASSWORD="password=";
	
	//SQL Server Class.forName value for microsoft SQL Server
	public static final String MS_SQL_SERVER_FOR_NAME="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	//SQL Server ...server name at creating connection string SQL Server
	public static final String MS_SQL_SERVER_SERVER_NAME="sqlserver";
	
	//products of database servers
	public static final String SERVER_SQLSERVER="sqlserver";
	public static final String SERVER_MYSQL="mysql";
	
	//index of resultset metadata start value
	public static final int RESULTSET_INDEX_START_VALUE=1;
	
}
