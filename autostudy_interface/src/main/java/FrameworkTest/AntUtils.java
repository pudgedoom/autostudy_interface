package FrameworkTest;

import java.io.File;

import javax.management.RuntimeErrorException;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

public class AntUtils {
	public static String compress(){
		File zipFile=new File(DataStore.D_Zip_path);
		File srcdir=new File(DataStore.D_Zip_sourcepath);
		if(!srcdir.exists()){
			throw new RuntimeException(DataStore.D_Zip_sourcepath+"不存在");
			
		}
		Project pro=new Project();
		FileSet fileset=new FileSet();
		fileset.setProject(pro);
		
		if(srcdir.isDirectory()){
			fileset.setDir(srcdir);
			fileset.setIncludes("*.*");
		}else{
			fileset.setFile(srcdir);
		}
		Zip zip =new Zip();
		zip.setProject(pro);
		zip.setDestFile(zipFile);
		zip.setEncoding("gbk");
		zip.addFileset(fileset);
		zip.execute();
		
		return DataStore.D_Zip_path;
	}
}
