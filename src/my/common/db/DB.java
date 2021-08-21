package my.common.db;

import java.util.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

import my.common.db.database.table.Table;
import my.common.db.database.table.field.Field;
import my.common.db.database.table.field.factors.*;

import my.common.db.sql.Sql;

import my.common.logging.*;
import my.common.generic.Constants;

public class DB {

	//**********************************************************************************
	//sql constants
	//**********************************************************************************
	private static final String COMMAND_CREATE_TABLE="CREATE TABLE ";
	private static final String COMMAND_INSERT_INTO="INSERT INTO ";
		
	//unicode "N"
	private static final String UNICODE_N="N";
	
	//not null
	private static final String NOT_NULL="not null";
	
	//
	private static final String NULL_ABLE="null";
	//values
	private static final String VALUES=" values ";

	//*******************************************************
	//generics
	//*******************************************************
	//fields start
	private static final String PARENTHESES_LEFT="(";
	
	//fields end
	private static final String PARENTHESES_RIGHT=")";
	
	//blank
	private static final String SPACE=Constants.CS_ONE_BLANK;
	
	//","
	private static final String FIELD_SEPARATOR_COMMA=",";
	
	//quotation mark"'"
	private static final String STRING_VALUE_QUOTATIONARK="'";
	//sql ddl field types
	private static final String ARRAY="ARRAY";
	private static final String BIGINT="BIGINT";
	private static final String BINARY="BINARY";
	private static final String BIT="BIT";
	private static final String BLOB="BLOB";
	private static final String BOOLEAN="BOOLEAN";
	private static final String CHAR="CHAR";	//***'
	private static final String CLOB="CLOB";
	private static final String DATALINK="DATALINK";
	private static final String DATE="DATE";	//***'
	private static final String DECIMAL="DECIMAL";
	private static final String DISTINCT="DISTINCT";
	private static final String FLOAT="FLOAT";
	private static final String INTEGER="INTEGER";
	private static final String JAVA_OBJECT="JAVA_OBJECT";
	private static final String LONGNVARCHAR="LONGNVARCHAR";	//***'
	private static final String LONGVARBINARY="LONGVARBINARY";
	private static final String LONGVARCHAR="LONGVARCHAR";	//***'
	private static final String NCHAR="NCHAR";	//***'
	private static final String NCLOB="NCLOB";
	private static final String NULL="NULL";
	private static final String NUMERIC="NUMERIC";
	private static final String NVARCHAR="NVARCHAR";	//***'
	private static final String OTHER="OTHER";
	private static final String REAL="REAL";
	private static final String REF="REF";
	private static final String ROWID="ROWID";
	private static final String SMALLINT="SMALLINT";
	private static final String SQLXML="SQLXML";
	private static final String STRUCT="STRUCT";
	private static final String TIME="TIME";
	private static final String TIME_WITH_TIMEZONE="TIME_WITH_TIMEZONE";
	private static final String TIMESTAMP="TIMESTAMP";
	private static final String TIMESTAMP_WITH_TIMEZONE="TIMESTAMP_WITH_TIMEZONE";
	private static final String TINYINT="TINYINT";
	private static final String VARBINARY="VARBINARY";
	private static final String VARCHAR="VARCHAR";	//***'
	
	//
	private static final String UNKNOWN="UNKNOWN";

	//**********************************************************************************
	//start create table
	//**********************************************************************************
	public static void createTable(Connection connection,Table table,ArrayList<Field> fields){
		
		//first of all. delete target table if exist.
		DeleteTable(connection, table);
		//create a table
		try{
			createTable(connection.createStatement(), table, fields);
		}catch(Exception e){
			Logging.severe("failed in delete and creating table. stop program.");
			Logging.severe(e.toString());
			System.exit(Constants.CS_Exit_ERROR_01);
		}
	}
	
	private static void createTable(Statement statement,Table table,ArrayList<Field> fields){

		try{
			statement.execute(createSqlStringCreateTable(table, fields).get());
		}catch(Exception e){
			Logging.severe("failed in creating a table core. stop program.");
			Logging.severe(e.toString());
			System.exit(Constants.CS_Exit_ERROR_01);
		}
	}
	private static Sql createSqlStringCreateTable(Table table,ArrayList<Field> fields){

		String sql=Constants.CS_SPACE;
		
		//first
		sql=sql+COMMAND_CREATE_TABLE+table.getName()+PARENTHESES_LEFT;
		//fields
		for(int i=0;i<fields.size();i++){
			sql=sql+getSqlStringCreateTable_a_Field(fields.get(i));
			if(i==fields.size()-1){
				
			}else{
				sql=FIELD_SEPARATOR_COMMA;
			}
		}
		
		//end
		sql=sql+PARENTHESES_RIGHT;
		
		//at last
		Sql rv=new Sql(sql);
		return rv;
	}
	
	//generate string for a field.
	private static String getSqlStringCreateTable_a_Field(Field field){
		
		String rv=Constants.CS_SPACE;
		//name
		rv=rv+field.getName().get()+Constants.CS_ONE_BLANK;
		//type
		rv=rv+field.getType().get();
		//length
		if(isLengthRequired(field)) {
			rv=rv+PARENTHESES_LEFT+getFieldLengthAsString(field)+PARENTHESES_RIGHT;
		}else {
			rv=rv+Constants.CS_SPACE;
		}

		// "null" or "not null"
		rv=rv+Constants.CS_ONE_BLANK+getSqlStringIsNullable(field);
		
		return rv;
	}
	
	//generate length
	private static String getFieldLengthAsString(Field field){
		
		String rv=Constants.CS_SPACE;
		
		rv=rv+field.getLength().get().toString();
		
		return rv;
		
	}
	
	private static boolean isLengthRequired(Field field){
		
		boolean rv=false;

		String type=field.getType().get();
		
		if(type==NUMERIC){
			rv=true;
		}
		if(type==DECIMAL){
			rv=true;
		}
		if(type==CHAR){
			rv=true;
		}
		if(type==NCHAR){
			rv=true;
		}
		if(type==VARCHAR){
			rv=true;
		}
		if(type==NVARCHAR){
			rv=true;
		}
		return rv;
		
	}
	
	//generate "null" or "not null"
	private static String getSqlStringIsNullable(Field field){
		
		String rv=NULL_ABLE;
		
		//IsNullable isn=field.getIsNullable();
		//System.out.println(isn.getIsNullale());
		//if(field.getIsNullable().get()==ResultSetMetaData.columnNoNulls){
		//	rv=mycommons.constants.db.sql.ddl.Commands.NOT_NULL;
		//}
		if (field.getIsNullable().get()) {
		
		}else {
			rv=NOT_NULL;
		}
		return rv;
	}
	//end create table

	//**********************************************************************************
	//delete table
	//**********************************************************************************
	public static void DeleteTable(Connection connection,Table table){

		if(isTableExist(connection,table)){
			try{
				java.sql.Statement stmnt=connection.createStatement();
				stmnt.executeUpdate("drop table "+table.getName());
			}catch(Exception e){
				Logging.severe("deleting table "+table.getName()+" failed.stop this program.");
				System.exit(Constants.CS_Exit_ERROR_01);
			}
		}


	}
	
	//**********************************************************************************
	//exist check table
	//**********************************************************************************
	public static boolean isTableExist(Connection connection,Table table){
		
		try{
			
			java.sql.DatabaseMetaData metaData=connection.getMetaData();
			java.sql.ResultSet rs = metaData.getTables(null, null, "%", null);
			
			while (rs.next()) {
				
				  if(table.getName().equals(rs.getString(3))){

					  return true;
				  }
				  
			}
			
		}catch(Exception e){
			Logging.severe(e.toString());
			Logging.severe("Testing exist a table is failed.stop this program");
			System.exit(Constants.CS_Exit_ERROR_01);
		}
		return false;
	}
}
