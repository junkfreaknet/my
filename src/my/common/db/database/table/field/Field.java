package my.common.db.database.table.field;

import my.common.generic.Constants;
import my.common.db.database.table.field.factors.*;
import my.common.db.database.table.field.factors.*
;public class Field {

	private Name name;
	private Length length;
	private Type type;
	private IsNullable isNullable;
	
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
		
		this.name=in_name;
		this.type=in_type;
		this.length=in_length;
		this.isNullable=in_isnullable;
		
	}
	
	//method public
	public void setName(Name in_name){
		this.name=in_name;
	}
	public void setType(Type in_type){
		this.type=in_type;
	}
	public void setLength(Length length){
		this.length=length;
	}
	public void setIsNullable(IsNullable isnullable){
		this.isNullable=isnullable;
	}
	public void setName(String in) {
		this.name.set(in);
	}
	public void setType(String in) {
		this.type.set(in);
	}
	public void setLegth(int in) {
		this.length.set(in);
	}
	public void setIsNullable(boolean in) {
		this.isNullable.set(in);
	}
	
	//getters
	public Name getName(){
		return this.name;
	}
	public Type getType(){
		return this.type;
	}
	public Length getLength(){
		return this.length;
	}
	public IsNullable getIsNullable(){
		return this.isNullable;
	}



}
