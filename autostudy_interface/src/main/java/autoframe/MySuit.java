package autoframe;

import junit.framework.TestSuite;

public class MySuit {
	public static class TestSuite1{
		public static Test suit(){
			TestSuite suite=new TestSuite("test for package1");
			suite.addTest(new JUnit4TestAdapter(AppaddScheduleCase.class));
			suite.addTest(new JUnit4TestAdapter(WebcommentCase.class));
			suite.addTest(new JUnit4TestAdapter(AppCheckCommentCase.class));
			return suite;
		}
	}
	
	public static void main(String[] args){
		junit.textui.TestRunner.run(TestSuite1.suit());
		MailUtils.sendMail(AntUtils.compress());
	}
}
