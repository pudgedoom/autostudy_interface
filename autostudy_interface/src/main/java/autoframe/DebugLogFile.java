package autoframe;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class DebugLogFile {
	public static Logger  logger=Logger.getLogger(DataStore.D_DebugLogger);
	public static FileHandler filehandler=null;
	public static String path=DataStore.D_Logpath+File.separator+"Debug.log";
	
	public static void type(String p_info){
		try{
			filehandler=new FileHandler(path,true);
			filehandler.setFormatter(new SimpleFormatter());
			
		}catch(SecurityException e){
			logger.severe(e.toString());
			e.printStackTrace();
		}catch(IOException e){
			logger.severe(e.toString());
			e.printStackTrace();
		}
		logger.addHandler(filehandler);
		logger.info(p_info);
		filehandler.close();
		
	}
}
