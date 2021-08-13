package my.common.print;

public class PaperSize {
	
	private String  size;
	
	//constructors
	public PaperSize(){
		this.constructorCommon(mycommons.constants.Generic.CS_SPACE);
	}
	public PaperSize(String source){
		this.constructorCommon(source);
	}
	public PaperSize(PaperSize source){
		this.constructorCommon(source);
	}

	//public methods
	public PaperSize get(){
		return this;
	}

	/***
	public void setName(String source){
		this.name=source;
	}
	***/
	public void setSize(PaperSize source){
		this.size=source.toStringSize();
	}

	public String toStringSize(){
		return this.size;
	}

	//private methods
	private void constructorCommon(String size){
		this.size=size;
	}
	private void constructorCommon(PaperSize source){
		this.constructorCommon(source.toStringSize());
	}
}
