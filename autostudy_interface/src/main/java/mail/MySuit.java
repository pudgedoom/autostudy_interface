package mail;

import com.report.html.HtmlFileGlobal;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;

public class MySuit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		junit.textui.TestRunner.run(MySuit.suit(TestSendEmail.class));
	}
	
	public static Test suit(Class name){
		HtmlFileGlobal.createLog("d:\\test.html");
		TestSuite suite=new TestSuite();
		suite.addTest(new JUnit4TestAdapter(name));
		HtmlFileGlobal.closeLog();
		return suite;
	}
}
