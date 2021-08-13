package my.common.db.sqlstrings;

import my.commons.generic.Constants;

public class Commands {

	//sql ddl commands
	public static final String COMMAND_CREATE_TABLE="CREATE TABLE ";
	public static final String COMMAND_INSERT_INTO="INSERT INTO ";
	
	//*******************************************************
	//generics
	//*******************************************************
	//fields start
	public static final String PARENTHESES_LEFT="(";
	
	//fields end
	public static final String PARENTHESES_RIGHT=")";
	
	//blank
	public static final String SPACE=Constants.CS_ONE_BLANK;
	
	//","
	public static final String FIELD_SEPARATOR_COMMA=",";
	
	//quotation mark"'"
	public static final String STRING_VALUE_QUOTATIONARK="'";
	
//*********************************************************************************************
	
	//unicode "N"
	public static final String UNICODE_N="N";
	
	//not null
	public static final String NOT_NULL="not null";
	
	//values
	public static final String VALUES=" values ";
}