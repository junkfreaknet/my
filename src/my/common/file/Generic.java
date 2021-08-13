package my.common.file;

import java.io.File;

public class Generic {

	public static boolean isExist(mycommons.routines.file.Filename filename){
		
		boolean rv=true;
		
		rv=isExistCommon(filename);

		return rv;
		
	}
	public static boolean isExist(String filename){
		
		boolean rv=true;

		rv=isExistCommon(new mycommons.routines.file.Filename(filename));

		return rv;

	}
	//common isExist
	private static boolean isExistCommon(mycommons.routines.file.Filename filename){
		
		boolean rv;
		File f=filename.getFile();
		
		rv=f.exists();
		
		return rv;
		
	}
}
