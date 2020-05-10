package zip;

import java.io.File;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Expand;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

public class TestZip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		zip(new File("d:\\a.txt"),new File("d:\\a\\a.zip"));
		unzip("d:\\a\\a.zip","d:\\a\\");
	}
	
	public static void unzip(String src,String desc){
		File file=new File(src);
		if(!file.exists()){
			throw new RuntimeException(src+"文件不存在");
		}
		
		Project project=new Project();
		Expand expand=new Expand();
		expand.setProject(project);
		
		expand.setTaskType("zip");
		expand.setTaskName("zip2");
		expand.setEncoding("utf-8");
		
		expand.setSrc(file);
		expand.setDest(new File(desc));
		expand.execute();
		System.out.println("解压成功！");
	}
	
	public static void zip(File org,File dest ){
		//projetct 进出公用。fileset负责进去的处理。zip负责出去的处理及压缩。filest需要加入到zip中
		Project pro=new Project();
		FileSet fileset=new FileSet();
		if(!org.exists()){
			throw new RuntimeException(org+"文件不存在");
		}
		if(org.isFile()){
			fileset.setFile(org);
		}else if(org.isDirectory()){
			fileset.setDir(org);
		}
		fileset.setProject(pro);
		
		
		Zip zip=new Zip();
		zip.setProject(pro);
		zip.setDestFile(dest);
		zip.addFileset(fileset);
		zip.setEncoding("utf-8");
		zip.execute();
		System.out.println("压缩成功！");
	}
}
