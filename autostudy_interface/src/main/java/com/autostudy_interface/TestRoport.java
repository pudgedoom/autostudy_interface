package com.autostudy_interface;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import report.HtmlReportFormatter;

public class TestRoport {
	private final static String HTML_HEADER = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"
			+ "<html xmlns=\"http://www.w3.org/1999/xhtml\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gbk\">"
			+ "<META HTTP-EQUIV=\"CACHE-CONTROL\" CONTENT=\"NO-CACHE\">"
			+ "<META HTTP-EQUIV=\"PRAGMA\" CONTENT=\"NO-CACHE\">"
			+ "<link rel=\"stylesheet\" href=\"demo_report_style.css\"/>"
			+ "<html><head><title>测试报告</title></head>"
			+ "<body>"
			+ "<div class=\"page_title\"><center>"
			+ "<h1>测试报告</h1></center></div>"
			+ "<div class=\"statistics\"><table id=\"statistics_table\" class=\"sortable\" align=\"center\" border=\"0\"  style=\"width:100%;\"><tr>"
			+ "<th><b>序号</b></th>"
			+ "<th><b>用例描述</b></th>"
			+ "<th><b>期待结果</b></th>"
			+ "<th><b>实际结果</b></th>"
			+ "<th><b>执行时间</b></th>" + "<th><b>状态</b></th>" + "</tr>";
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger=Logger.getLogger("abc");
		try {
			FileHandler filehandler=new FileHandler("D:\\aaa.html");
			filehandler.setEncoding("gbk");//改成这个中文就正常了
			filehandler.setFormatter(new HtmlReportFormatter());
			logger.addHandler(filehandler);//忘记加这个。。。。。。。。。。。。。。。！！！！
			logger.info("来咯");
	

		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
