
package my.common.file.classes;

import java.io.File;

public class Filename {

	private File file;

	//constructors
	public Filename(String filename){
		
		constructorCommon(filename);
	}
	public Filename(String parent,String filename){
		
		constructorCommon(parent+File.separator+filename);
		
	}

	//constructor common	
	private void constructorCommon(String filename){
		
		this.file=new File(filename);
		
	}
	//public methods
	//public void setName(String filename){
	//	this.name=filename;
	//}
	public String getName(){

		return this.file.getName();
	}
	public String getAbsolutePath(){
		
		return this.file.getAbsolutePath();
		
	}
	public File getFile(){
		
		return this.file;
		
	}
	
}
