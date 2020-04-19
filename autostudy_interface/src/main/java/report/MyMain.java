package report;

public class MyMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ReportEntry re=new ReportEntry();
//		re.crateLog("d://config2.ini");
//		re.write("URL", "url","www.google.com");
//		System.out.println(re.read("URL", "url"));
//		re.closeLog();
		
		re.crateLog("d://config2.properties");
		re.write("url", "www.163.com");
		re.write("user", "kevin");
		System.out.println(re.read("url"));
		System.out.println(re.read("user"));
		re.closeLog();
	
		
	}

}
