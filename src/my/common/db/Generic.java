package my.common.db;

public class Generic {
	public static java.util.ArrayList<mycommons.db.Field> getFields(java.sql.ResultSet para_in_resultset){
		
		java.util.ArrayList<mycommons.db.Field> rv=new java.util.ArrayList<mycommons.db.Field>();
		
		try{
			java.sql.ResultSetMetaData rstMD=para_in_resultset.getMetaData();
			//System.out.println("column count is "+rstMD.getColumnCount());
			for(int i=mycommons.constants.DB.RESULTSET_INDEX_START_VALUE;i<=rstMD.getColumnCount();i++){
				//System.out.println("i is "+i);
				//System.out.println("column type is "+rstMD.getColumnTypeName(i));
				mycommons.db.Field fld=new mycommons.db.Field();
				fld.setName(new mycommons.db.FieldName(rstMD.getColumnName(i)));
				fld.setType(new mycommons.db.FieldType(rstMD.getColumnType(i)));
				fld.setLength(new mycommons.db.FieldLength(rstMD.getColumnDisplaySize(i)));
				fld.setIsNullable(new mycommons.db.IsFieldNullable(rstMD.isNullable(i)));
				//System.out.println(rstMD.isNullable(i));
				//System.out.println("lengt is "+rstMD.getColumnDisplaySize(i));
				rv.add(fld);
			}
		}catch(Exception e){
			mycommons.logging.Logging.severe("failed in get result set meta data. stop program.");
			mycommons.logging.Logging.severe(e.toString());
			System.exit(mycommons.constants.System.CS_EXIT_ERROR);
		}
		return rv;
	}
}
