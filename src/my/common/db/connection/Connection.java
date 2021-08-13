package my.common.db.connection;

//import java.sql.Connection;
//import java.sql.*;
//import my.common.db.generic.Constant;

public class Connection {

	private String host;//"host name" or "ip address"
	private String dbName;
	private String userName;
	private String passWord;
	private String forName;
	
	private String serverType;
	
	public Connection(String servertype,String host,String dbname,String username,String password,String forname){
		
		this.constructorCommon(servertype,host,dbname,username,password,forname);
	}
	private void constructorCommon(String servertype,String host,String dbname,String username,String password,String forname) {
		
		this.host=host;
		this.dbName=dbname;
		this.userName=username;
		this.passWord=password;
		this.forName=forname;
		
		this.serverType=servertype;
		
	}
	public String getURL() {
		return "jdbc:" + this.serverType + ":" + this.host + "//" + this.dbName;
 	}
	
	//	USAGE
	//
	//	.when create class
	//	Connection cnctn=new Connection(server type,host name,database name,user name,password,forname);
	//
	//	.when connect to db
	//	try{
	//		java.sql.conection dbcnctn=java.sql.DriverManager(cnctn.getURL(),cncth.username,cnctn.password);
	//	}cahch(sqlexcdption e){
	//	}
}
