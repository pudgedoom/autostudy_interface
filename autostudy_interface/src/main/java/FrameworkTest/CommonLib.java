package FrameworkTest;

import java.util.Calendar;

import com.report.entry.ReportEntry;

public class CommonLib {
	public static String getCurrentTime(){
		Calendar ca=Calendar.getInstance();
		int year=ca.YEAR;
		int month=ca.MONTH;
		int day=ca.DATE;
		int hour=ca.HOUR;
		int minute=ca.MINUTE;
		int secend=ca.SECOND;
		String currentTime=String.valueOf(year)+"-"+String.valueOf(month+1)+"-"+String.valueOf(day)+"-"+String.valueOf(hour)+"-"+String.valueOf(minute)
				+"-"+String.valueOf(secend);
		return currentTime;
	}
	
	public static void sleep(int p_time){
		try{
			Thread.sleep(p_time*1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public static String readINIFile(String p_file,String p_section,String p_key){
		String iniValue=null;
		try{
			ReportEntry re=new ReportEntry();
			re.crateLog(p_file);
			iniValue=re.read(p_section,p_key);
		}catch(Exception e){
			e.printStackTrace();
		}
		return iniValue;
	}
	
	public static String[] readINIFFile(String p_file,String p_section,String p_key){
		String people=null;
		String[] peoples=null;
		try{
			ReportEntry re=new ReportEntry();
			re.crateLog(p_file);
			people=re.read(p_section,p_key);
			peoples=people.split(",");
		}catch(Exception e){
			e.printStackTrace();
		}
		return peoples;
	}
	
	public static void sendMail(String attachmentpath){
		MailUtils me=new MailUtils();
		me.sendmail(attachmentpath);
	}
	
	public static void sendMail(String[] users,String attachmentpath){
		MailUtils me=new MailUtils();
		me.sendmail(users,attachmentpath);
	}
}
