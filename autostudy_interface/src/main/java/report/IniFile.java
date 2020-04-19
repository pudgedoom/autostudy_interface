package report;
import java.io.File;
import java.io.IOException;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalINIConfiguration;

import report.IFile;

public  class IniFile implements IFile
{
	//private String fileName = null;
	private String fileName = null;
	HierarchicalINIConfiguration ini =null;
	
	public void createLog(String p_fileName) {
		
		this.fileName = p_fileName;
		File file = new File(this.fileName);
		if (!file.exists())
		{
			try {
				file.createNewFile();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		try {
			ini = new HierarchicalINIConfiguration(this.fileName);
			ini.load(new File(this.fileName));	
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}


	public  void write(String section, String key, String value)
	 
	{  
		ini.setProperty(section+"."+key, value);
		
	}
	 public String read(String section, String key)
	 
	 {	
		 
		
		 return ini.getString(section+"."+key);
		
	 }
	 

	public void write(String p_info) {
		// TODO Auto-generated method stub
		
	}


	public void closeLog() {
		// TODO Auto-generated method stub
		try {
			ini.save();
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.fileName=null;
		this.ini=null;
		
	}


	public void write(String p_info1, String p_info2) {
		// TODO Auto-generated method stub
		
	}


	public String read() {
		// TODO Auto-generated method stub
		return null;
	}


	public String read(String p_info) {
		// TODO Auto-generated method stub
		return null;
	}

	
}