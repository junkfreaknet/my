package my.common.db;

import java.nio.charset.Charset;

import mycommons.db.SQLString;

public class Manipulate {

	//*****************************************************************
	// delete table
	//*****************************************************************
	public static void DeleteTable(mycommons.db.connection.Connection para_in_Connection,mycommons.db.Table para_in_Table){

		if(isTableExist(para_in_Connection,para_in_Table)){
			try{
				java.sql.Statement stmnt=para_in_Connection.getConnection().createStatement();
				stmnt.executeUpdate("drop table "+para_in_Table.getName());
			}catch(Exception e){
				mycommons.logging.Logging.severe("deleting table "+para_in_Table.getName()+" failed.stop this program.");
				System.exit(mycommons.constants.System.CS_EXIT_ERROR);
			}
		}


	}
	public static boolean isTableExist(mycommons.db.connection.Connection para_in_Connection,mycommons.db.Table para_in_Table){
		
		try{
			
			java.sql.DatabaseMetaData metaData=para_in_Connection.getConnection().getMetaData();
			java.sql.ResultSet rs = metaData.getTables(null, null, "%", null);
			
			while (rs.next()) {
				
				  if(para_in_Table.getName().equals(rs.getString(3))){

					  return true;
				  }
				  
			}
			
		}catch(Exception e){
			mycommons.logging.Logging.severe(e.toString());
			mycommons.logging.Logging.severe("Testing exist a table is failed.stop this program");
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
		}
		return false;
	}
	//*****************************************************************
	// insert record
	//*****************************************************************
	
	// para_to_statement ---> target db statement
	// para_to_Table ---> target table
	// xxxxxpara_fields ---> fields definitionsxxxxx
	// para_resultset_From ---> source data.
	//public static void insertRecord(java.sql.Statement para_to_Statement,mycommons.db.Table para_to_Table,java.util.ArrayList<mycommons.db.Field> para_fields,java.sql.ResultSet para_resultset_From){
	public static void insertRecord(java.sql.Statement para_to_Statement,mycommons.db.Table para_to_Table,java.sql.ResultSet para_resultset_From){	

		try{
			//mycommons.db.SQLString sql=mycommons.routines.db.Manipulate.createSQLInsertRecord(para_to_Table, para_fields, para_resultset_From);
			mycommons.db.SQLString sql=mycommons.routines.db.Manipulate.createSQLInsertRecord(para_to_Table, para_resultset_From);
			//a test
			//System.out.println(sql.toString());
			//execute sql string
			para_to_Statement.execute(sql.toString());
		}catch(Exception e){
			mycommons.logging.Logging.severe(e.toString());
			mycommons.logging.Logging.severe("Inserting  record is failed.stop this program");
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
		}
	}

	//private static mycommons.db.SQLString createSQLInsertRecord(mycommons.db.Table para_Table,java.util.ArrayList<mycommons.db.Field> para_Fields,java.sql.ResultSet para_ResultSet_From){	
	private static mycommons.db.SQLString createSQLInsertRecord(mycommons.db.Table para_Table,java.sql.ResultSet para_ResultSet_From){
		
		String rv=mycommons.constants.Generic.CS_SPACE;
		
		//insert command
		rv=rv+mycommons.constants.db.sql.ddl.Commands.COMMAND_INSERT_INTO;
		rv=rv+mycommons.constants.Generic.CS_ONE_BLANK+para_Table.getName()+mycommons.constants.Generic.CS_ONE_BLANK;
		
		//fields***
		//fields start
		rv=rv+mycommons.constants.db.sql.ddl.Commands.FIELDS_START;
		//fields set
		//rv=rv+mycommons.routines.db.Manipulate.createSQLInsertRecordFields(para_Fields);
		rv=rv+mycommons.routines.db.Manipulate.createSQLInsertRecordFields(para_ResultSet_From);
		//fields end
		rv=rv+mycommons.constants.db.sql.ddl.Commands.FIELDS_END;
		
		//values***
		//values start
		rv=rv+mycommons.constants.db.sql.ddl.Commands.VALUES+mycommons.constants.db.sql.ddl.Commands.FIELDS_START;
		//values set
		rv=rv+mycommons.routines.db.Manipulate.createSQLInsertRecordValues(para_ResultSet_From);
		//values end
		rv=rv+mycommons.constants.db.sql.ddl.Commands.FIELDS_END;
		
		//return
		return new mycommons.db.SQLString(rv);
	}
	private static String createSQLInsertRecordFields(java.sql.ResultSet para_ResultSet){
	
		String rv=mycommons.constants.Generic.CS_SPACE;

		try{
			java.sql.ResultSetMetaData rstMetaData=para_ResultSet.getMetaData();
			for(int i=1;i<=rstMetaData.getColumnCount();i++){
				
				rv=rv+rstMetaData.getColumnName(i);
				
				if(i==rstMetaData.getColumnCount()){
					
				}else{
					rv=rv+mycommons.constants.db.sql.ddl.Commands.FIELD_SEPARATOR;
				}
			}
		}catch(Exception e){
			mycommons.logging.Logging.severe(e.toString());
			mycommons.logging.Logging.severe("Creating sql string for insert fields is failed.stop this program");
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
		}
		return rv;
	}
	/***
	private static String createSQLInsertRecordFields(java.util.ArrayList<mycommons.db.Field> para_Fields){
		
		String rv=mycommons.constants.Generic.CS_SPACE;

		for(int i=0;i<para_Fields.size();i++){
			rv=rv+para_Fields.get(i).getName().getName();
			if(i==para_Fields.size()-1){
				
			}else{
				rv=rv+mycommons.constants.db.sql.ddl.Commands.FIELD_SEPARATOR;
			}
		}
		return rv;
		
	}
	***/
	private static String createSQLInsertRecordValues(java.sql.ResultSet para_ResultSet_From){
		
		String rv=mycommons.constants.Generic.CS_SPACE;
		
		try{
			java.sql.ResultSetMetaData rstMetaData=para_ResultSet_From.getMetaData();
			for(int i=1;i<=rstMetaData.getColumnCount();i++){
				rv=rv+mycommons.routines.db.Manipulate.createSQLInsertRecordValuesGetFieldValue(para_ResultSet_From,i);
				if(i==rstMetaData.getColumnCount()){
					
				}else{
					rv=rv+",";
				}
			}
		}catch(Exception e){
			mycommons.logging.Logging.severe(e.toString());
			mycommons.logging.Logging.severe("Creating sql string for insert values is failed.stop this program");
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);			
		}
		return rv;
	}
	/***
	private static String createSQLInsertRecordValuesGetFieldValue(java.sql.ResultSet para_ResultSet,int para_Column_Idx){
		
		String rv=mycommons.constants.Generic.CS_SPACE;
		try{
			//String buff=new String(para_ResultSet.getString(para_Column_Idx).getBytes("MS932"),"MS932");
			//.forName("Windows-31j");
			java.sql.ResultSetMetaData rstMetaData=para_ResultSet.getMetaData();
			if(mycommons.routines.db.Manipulate.isSqlValueRequiresQuotationMark(rstMetaData, para_Column_Idx,para_ResultSet.getString(para_Column_Idx))){
				rv=rv+mycommons.routines.db.Manipulate.getUnicode_N(rstMetaData, para_Column_Idx,para_ResultSet.getString(para_Column_Idx))+mycommons.constants.db.sql.ddl.Commands.VALUE_QUOTATIONARK+para_ResultSet.getString(para_Column_Idx)+mycommons.constants.db.sql.ddl.Commands.VALUE_QUOTATIONARK;
				//rv=rv+mycommons.routines.db.Manipulate.getUnicode_N(rstMetaData, para_Column_Idx,para_ResultSet.getString(para_Column_Idx))+mycommons.constants.db.sql.ddl.Commands.VALUE_QUOTATIONARK+buff+mycommons.constants.db.sql.ddl.Commands.VALUE_QUOTATIONARK;
			}else{
				rv=para_ResultSet.getString(para_Column_Idx);
			}
		}catch(Exception e){
			mycommons.logging.Logging.severe(e.toString());
			mycommons.logging.Logging.severe("Creating sql string for insert a value is failed.stop this program");
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
		}
		return rv;
	}
	***/
	
	private static String createSQLInsertRecordValuesGetFieldValue(java.sql.ResultSet para_ResultSet,int para_Column_Idx){
		
		String rv=mycommons.constants.Generic.CS_SPACE;
		try{
			java.sql.ResultSetMetaData rstMetaData=para_ResultSet.getMetaData();
			if(mycommons.routines.db.Manipulate.isSqlValueRequiresQuotationMark(rstMetaData, para_Column_Idx,para_ResultSet.getString(para_Column_Idx))){
				rv=rv+mycommons.routines.db.Manipulate.getUnicode_N(rstMetaData, para_Column_Idx,para_ResultSet.getString(para_Column_Idx))+mycommons.constants.db.sql.ddl.Commands.VALUE_QUOTATIONARK+para_ResultSet.getString(para_Column_Idx)+mycommons.constants.db.sql.ddl.Commands.VALUE_QUOTATIONARK;
			}else{
				rv=para_ResultSet.getString(para_Column_Idx);
			}
		}catch(Exception e){
			mycommons.logging.Logging.severe(e.toString());
			mycommons.logging.Logging.severe("Creating sql string for insert a value is failed.stop this program");
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
		}
		return rv;
	}
	
	private static String getUnicode_N(java.sql.ResultSetMetaData para_rstMetaData,int para_Column_Idx,String value){
		
		String rv=mycommons.constants.Generic.CS_SPACE;;
		
		if(value==null){
			return rv;
		}
		try{
			if(para_rstMetaData.getColumnType(para_Column_Idx)==java.sql.Types.CHAR){
				rv=mycommons.constants.db.sql.ddl.Commands.UNICODE_N;
			}
			/***
			if(para_rstMetaData.getColumnType(para_Column_Idx)==java.sql.Types.DATE){
				rv=true;
			}
			***/
			if(para_rstMetaData.getColumnType(para_Column_Idx)==java.sql.Types.LONGNVARCHAR){
				rv=mycommons.constants.db.sql.ddl.Commands.UNICODE_N;
			}
			if(para_rstMetaData.getColumnType(para_Column_Idx)==java.sql.Types.LONGVARCHAR){
				rv=mycommons.constants.db.sql.ddl.Commands.UNICODE_N;
			}
			if(para_rstMetaData.getColumnType(para_Column_Idx)==java.sql.Types.NCHAR){
				rv=mycommons.constants.db.sql.ddl.Commands.UNICODE_N;
			}
			if(para_rstMetaData.getColumnType(para_Column_Idx)==java.sql.Types.NVARCHAR){
				rv=mycommons.constants.db.sql.ddl.Commands.UNICODE_N;
			}
			if(para_rstMetaData.getColumnType(para_Column_Idx)==java.sql.Types.VARCHAR){
				rv=mycommons.constants.db.sql.ddl.Commands.UNICODE_N;
			}			
			
		}catch(Exception e){
			mycommons.logging.Logging.severe(e.toString());
			mycommons.logging.Logging.severe("Creating sql string for insert a value quotation mark requires is failed.stop this program");
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);			
		}		
		return rv;
	}
	private static boolean isSqlValueRequiresQuotationMark(java.sql.ResultSetMetaData para_rstMetaData,int para_Column_Idx,String value){
		
		boolean rv=false;
		
		if(value==null){
			return false;
		}
		//check field type
		try{
			if(para_rstMetaData.getColumnType(para_Column_Idx)==java.sql.Types.CHAR){
				rv=true;
			}
			if(para_rstMetaData.getColumnType(para_Column_Idx)==java.sql.Types.DATE){
				rv=true;
			}
			if(para_rstMetaData.getColumnType(para_Column_Idx)==java.sql.Types.LONGNVARCHAR){
				rv=true;
			}
			if(para_rstMetaData.getColumnType(para_Column_Idx)==java.sql.Types.LONGVARCHAR){
				rv=true;
			}
			if(para_rstMetaData.getColumnType(para_Column_Idx)==java.sql.Types.NCHAR){
				rv=true;
			}
			if(para_rstMetaData.getColumnType(para_Column_Idx)==java.sql.Types.NVARCHAR){
				rv=true;
			}
			if(para_rstMetaData.getColumnType(para_Column_Idx)==java.sql.Types.VARCHAR){
				rv=true;
			}			
			
		}catch(Exception e){
			mycommons.logging.Logging.severe(e.toString());
			mycommons.logging.Logging.severe("Creating sql string for insert a value quotation mark requires is failed.stop this program");
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);			
		}
		return rv;
	}

}

//