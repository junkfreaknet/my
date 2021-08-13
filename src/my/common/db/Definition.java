package my.common.db;

public class Definition {
	
	//****************************************************************
	//create table
	//****************************************************************
	public static void createTable(mycommons.db.connection.Connection para_Connection,mycommons.db.Table para_Table,java.util.ArrayList<mycommons.db.Field> para_Fields){
		
		//first of all. delete target table if exist.
		mycommons.routines.db.Manipulate.DeleteTable(para_Connection, para_Table);
		//create a table
		try{
			mycommons.routines.db.Definition.createTable(para_Connection.getConnection().createStatement(), para_Table, para_Fields);
		}catch(Exception e){
			mycommons.logging.Logging.severe("failed in delete and creating table. stop program.");
			mycommons.logging.Logging.severe(e.toString());
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);			
		}
	}
	public static void createTable(java.sql.Statement para_statement,mycommons.db.Table para_table,java.util.ArrayList<mycommons.db.Field> para_fields){

		try{
			mycommons.db.SQLString sqlobj=mycommons.routines.db.Definition.createSqlStringCreateTable(para_table, para_fields);
			para_statement.execute(sqlobj.toString());
		}catch(Exception e){
			mycommons.logging.Logging.severe("failed in creating a table. stop program.");
			mycommons.logging.Logging.severe(e.toString());
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
		}
	}	
	
	//****************************************************************
	//generate a "create table " SQL string
	//****************************************************************
	private static mycommons.db.SQLString createSqlStringCreateTable(mycommons.db.Table para_in_table,java.util.ArrayList<mycommons.db.Field> para_in_fields){

		String sql=mycommons.constants.Generic.CS_SPACE;
		
		//first
		sql=sql+mycommons.constants.db.sql.ddl.Commands.COMMAND_CREATE_TABLE+para_in_table.getName()+mycommons.constants.db.sql.ddl.Commands.FIELDS_START;
		//fields
		for(int i=0;i<para_in_fields.size();i++){
			sql=sql+createSqlStringCreateTable_a_Field(para_in_fields.get(i));
			if(i==para_in_fields.size()-1){
				
			}else{
				sql=sql+mycommons.constants.db.sql.ddl.Commands.FIELD_SEPARATOR;
			}
		}
		//end
		sql=sql+mycommons.constants.db.sql.ddl.Commands.FIELDS_END;
		//at last
		mycommons.db.SQLString rv=new mycommons.db.SQLString(sql);
		return rv;
	}
	//generate string for a field.
	private static String createSqlStringCreateTable_a_Field(mycommons.db.Field para_in_field){
		
		String rv=mycommons.constants.Generic.CS_SPACE;
		//name
		rv=rv+para_in_field.getName().getName()+mycommons.constants.db.sql.ddl.Commands.SPACE;
		//type
		rv=rv+para_in_field.getTypeSQL().getTypeSQLString(para_in_field.getType());
		//length
		rv=rv+createSqlStringCreateTable_a_Field_Length(para_in_field);
		// "null" or "not null"
		rv=rv+mycommons.constants.Generic.CS_ONE_BLANK+createSqlStringCreateTable_Not_Null(para_in_field);
		
		return rv;
	}
	//generate "null" or "not null"
	private static String createSqlStringCreateTable_Not_Null(mycommons.db.Field para_in_field){
		
		String rv=mycommons.constants.Generic.CS_SPACE;
		mycommons.db.IsFieldNullable isn=para_in_field.getIsNullable();
		//System.out.println(isn.getIsNullale());
		if(para_in_field.getIsNullable().getIsNullale()==java.sql.ResultSetMetaData.columnNoNulls){
			rv=mycommons.constants.db.sql.ddl.Commands.NOT_NULL;
		}
		return rv;
	}
	//generate length
	private static String createSqlStringCreateTable_a_Field_Length(mycommons.db.Field para_in_field){
		
		String rv=mycommons.constants.Generic.CS_SPACE;
		
		if (isLengthRequired(para_in_field)){
			rv=rv+mycommons.constants.db.sql.ddl.Commands.LENGTH_LEFT+para_in_field.getLength().getLength()+mycommons.constants.db.sql.ddl.Commands.LENGTH_RIGHT;
		}
		return rv;
		
	}
	private static boolean isLengthRequired(mycommons.db.Field para_in_field){
		
		boolean rv=false;

		String type=para_in_field.getTypeSQL().getTypeSQLString(para_in_field.getType());
		
		if(type==mycommons.constants.db.sql.ddl.FieldTypes.NUMERIC){
			rv=true;
		}
		if(type==mycommons.constants.db.sql.ddl.FieldTypes.DECIMAL){
			rv=true;
		}
		if(type==mycommons.constants.db.sql.ddl.FieldTypes.CHAR){
			rv=true;
		}
		if(type==mycommons.constants.db.sql.ddl.FieldTypes.NCHAR){
			rv=true;
		}
		if(type==mycommons.constants.db.sql.ddl.FieldTypes.VARCHAR){
			rv=true;
		}
		if(type==mycommons.constants.db.sql.ddl.FieldTypes.NVARCHAR){
			rv=true;
		}
		return rv;
		
	}
}
