package my.common.db.database.table.field;

import my.common.generic.Constants;
import my.common.db.database.table.field.factors.*;

public class Field {

	private String name;
	private Integer length;
	private String type;
	private Boolean isNullable;
	
	//private mycommons.db.FieldTypeSQL typeSQL;

	
	//constructors
	public Field(){
		
		this.constructorCommon(new Name(),new Type(),new Length(),new IsNullable());
	}
	public Field(Name name,Type type,Length length,IsNullable isnullable){
		this.constructorCommon(name, type,length,isnullable);
	}

	//constructor common
	private void constructorCommon(Name in_name,Type in_type,Length in_length,IsNullable in_isnullable){
		
		this.name=in_name.get();
		this.type=in_type.get();
		this.length=in_length.get();
		this.isNullable=in_isnullable.get();
		
	}
	
	//method public
	public void setName(String name){
		this.name=name;
	}
	public void setType(String type){
		this.type=type;
	}
	public void setLength(int length){
		this.length=length;
	}
	public void setIsNullable(boolean isnullable){
		this.isNullable=isnullable;
	}
	
	//getters
	public String getName(){
		return this.name;
	}
	public String getType(){
		return this.type;
	}
	public int getLength(){
		return this.length;
	}
	public boolean getIsNullable(){
		return this.isNullable;
	}


}
