package my.common.print;

public class PaperOrientation {
	
	private String  orientation;
	
	//constructors
	public PaperOrientation(){
		this.constructorCommon(mycommons.constants.Generic.CS_SPACE);
	}
	public PaperOrientation(String source){
		this.constructorCommon(source);
	}
	public PaperOrientation(PaperOrientation source){
		this.constructorCommon(source);
	}

	//public methods
	public PaperOrientation get(){
		return this;
	}

	/***
	public void setName(String source){
		this.name=source;
	}
	***/
	public void setOrientation(PaperOrientation source){
		this.orientation=source.toStringOrientation();
	}

	public String toStringOrientation(){
		return this.orientation;
	}

	//private methods
	private void constructorCommon(String size){
		this.orientation=size;
	}
	private void constructorCommon(PaperOrientation source){
		this.constructorCommon(source.toStringOrientation());
	}
}
