
package my.common.file;

import java.io.File;

import my.common.file.classes.*;

//import my.common.file.*;

public class Routines {

	public static boolean isExist(Filename filename){
		
		boolean rv=true;
		
		rv=isExistCommon(filename);

		return rv;
		
	}
	public static boolean isExist(String filename){
		
		boolean rv=true;

		rv=isExistCommon(new Filename(filename));

		return rv;

	}
	//common isExist
	private static boolean isExistCommon(Filename filename){
		
		boolean rv;
		File f=filename.getFile();
		
		rv=f.exists();
		
		return rv;
		
	}
}
