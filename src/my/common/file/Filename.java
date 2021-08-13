package my.common.file;

import java.io.File;

public class Filename {

	//private String absolute_path;
	//private String relative_path;
	private String name;
	private File file;
	//private String nameAbsolute;
	
	//constructors
	public Filename(String filename){
		
		constructorCommon(filename);
	}
	public Filename(String parent,String filename){
		
		//this.name=parent+File.separator+filename;
		constructorCommon(parent+File.separator+filename);
		
	}

	//constructor common	
	private void constructorCommon(String filename){
		
		this.name=filename;
		this.file=new File(filename);
		
	}
	//public methods
	public void setName(String filename){
		this.name=filename;
	}
	public String getName(){
		//return this.name;
		return this.file.getName();
	}
	public String getAbsolutePath(){
		
		return this.file.getAbsolutePath();
		
	}
	public File getFile(){
		
		return this.file;
		
	}
	
}
