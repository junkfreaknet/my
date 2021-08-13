package my.common.print;

public class Sheet {
	
	private String  name;
	
	//constructors
	public Sheet(){
		this.constructorCommon(mycommons.constants.Generic.CS_SPACE);
	}
	public Sheet(String source){
		this.constructorCommon(source);
	}
	public Sheet(Sheet source){
		this.constructorCommon(source);
	}

	//public methods
	public Sheet get(){
		return this;
	}

	/***
	public void setName(String source){
		this.name=source;
	}
	***/
	public void setName(Sheet source){
		this.name=source.toStringName();
	}

	public String toStringName(){
		return this.name;
	}

	//private methods
	private void constructorCommon(String size){
		this.name=size;
	}
	private void constructorCommon(Sheet source){
		this.constructorCommon(source.toStringName());
	}
}
