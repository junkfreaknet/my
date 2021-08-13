package my.common.logging;

public class Logging {

	public static void info(String msg){
		java.util.logging.Logger logger=java.util.logging.Logger.getLogger("logger");
		logger.info(msg);
	}
	public static void severe(String msg){
		java.util.logging.Logger logger=java.util.logging.Logger.getLogger("logger");
		logger.severe(msg);
	}
/***
	public static java.util.logging.FileHandler getFileHandler(String nameHandler){
		
		java.util.logging.FileHandler rv=null;
		
		try{
			rv=new java.util.logging.FileHandler(nameHandler);
		}catch(Exception e){
			System.out.println("failed creating logging handler to file. ");
			System.exit(0);
		}finally{

		}
		return rv;
	}
***/
}
