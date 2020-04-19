package report;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

//import java.util.logging.SimpleFormatter;

public class HtmlReportFormatter extends Formatter {

	
	private int i=0;
	private long setStartTime; // log��ʼʱ��
	private long setEndTime; // log����ʱ�� 

	private final String HTML_HEADER = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">"
			+ "<html xmlns=\"http://www.w3.org/1999/xhtml\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gbk\">"
			+ "<META HTTP-EQUIV=\"CACHE-CONTROL\" CONTENT=\"NO-CACHE\">"
			+ "<META HTTP-EQUIV=\"PRAGMA\" CONTENT=\"NO-CACHE\">"
			+ "<link rel=\"stylesheet\" href=\"demo_report_style.css\"/>"
			+ "<html><head><title>���Ա���</title></head>"
			+ "<body>"
			+ "<div class=\"page_title\"><center>"
			+ "<h1>���Ա���</h1></center></div>"
			+ "<div class=\"statistics\"><table id=\"statistics_table\" class=\"sortable\" align=\"center\" border=\"0\"  style=\"width:100%;\"><tr>"
			+ "<th><b>���</b></th>"
			+ "<th><b>��������</b></th>"
			+ "<th><b>�ڴ����</b></th>"
			+ "<th><b>ʵ�ʽ��</b></th>"
			+ "<th><b>ִ��ʱ��</b></th>" + "<th><b>״̬</b></th>" + "</tr>";
	
	private int recordStep() {
		i = i + 1;
		return i;
	}

	public String format(LogRecord rec) {
		StringBuffer buf = new StringBuffer(1000);
		// Bold any levels >= WARNING
		buf.append("<div class=\"statistics\">");
		buf.append("<tr>");
		buf.append("<td>");
		buf.append(recordStep());
		buf.append("</td>");
		buf.append("<td>");
		// buf.append(calcDate(rec.getMillis()));
		// buf.append(' ');
		buf.append(formatMessage(rec));
		buf.append('\n');
		buf.append("</td>");
		buf.append("<td>");
		buf.append(RecordStore.expected);
		buf.append("</td>");
		buf.append("<td>");
		buf.append(RecordStore.actual);
		buf.append("</td>");
		buf.append("<td>");
		buf.append(HtmlUtil.getCalcDate(rec.getMillis()));
		buf.append("</td>");
		buf.append("<td>");
		if (RecordStore.result.matches("Pass")||RecordStore.result.matches("PASS")) {
			//RecordStore.result.equalsIgnoreCase(anotherString) //���Դ�Сд
			RecordStore.p_pass = RecordStore.p_pass + 1;
			buf.append("<b>");
			buf.append("<font color=Green>");
			buf.append(RecordStore.result);
			buf.append("</font>");
			buf.append("</b>");
		} else if (RecordStore.result.matches("Fail")||RecordStore.result.matches("FAIL")) {
			RecordStore.p_fail = RecordStore.p_fail + 1;
			buf.append("<b>");
			buf.append("<font color=Red>");
			buf.append(RecordStore.result);
			buf.append("</font>");
			buf.append("</b>");
		
			/*	
			//��report�мӽ�ͼ�󣬶����html�ļ���ʽ
			buf.append("<tr>");
			buf.append("<td>");
			buf.append("</td>");
			buf.append("<td>");
			buf.append("<a href=getScreenShotPath()><img src=getScreenShotPath() height=\"150\" /></a>");
			buf.append("</td>");
			buf.append("<td>");
			buf.append("</td>");
			buf.append("<td>");
			buf.append("</td>");
			buf.append("<td>");
			buf.append("</td>");
			buf.append("<td>");
			buf.append("</td>");
			buf.append("</tr>");
			
		*/
		}
		else{
			buf.append("<b>");
			// buf.append("<font color=Black>");
			buf.append("");
			buf.append("</b>");
			
		}
		buf.append("</td>");
		buf.append("</tr>");
		buf.append("</div>\n");
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return buf.toString();
	}

	
	public String getHead(Handler h)

	{
		this.setStartTime = System.currentTimeMillis();
		System.out.println("starttime: "+this.setStartTime);
		return HTML_HEADER;
	}


	public String getTail(Handler h)

	{
		this.setEndTime = System.currentTimeMillis();
		System.out.println("endtime: "+this.setEndTime);
		String HTML_Tail;
		int p_total = RecordStore.p_pass + RecordStore.p_fail;
		//System.out.println(p_total);
		if (p_total > 0)
			if (RecordStore.p_fail > 0)
				// return HTML_Tail;
				HTML_Tail = "</table></PRE>" + "<br>&nbsp;��ʼʱ��   ��"+ HtmlUtil.getCalcDate(this.setStartTime) 
				        + "<br>&nbsp;����ʱ��      ��"+ HtmlUtil.getCalcDate(this.setEndTime) 
				        + "<br>&nbsp;����ʱ��      ��"+ HtmlUtil.getDeltaTime(this.setEndTime, this.setStartTime)
						+ "<br>&nbsp;ִ������      ��" + p_total 
						+"<br>&nbsp;�����ɹ�         ��"+ RecordStore.p_pass
						+ "<br>&nbsp;<font color=Red>����ʧ��      ��"+ RecordStore.p_fail + "</font>" 
						+ "<br>&nbsp;�ɹ���(%) ��"+ HtmlUtil.getPercnet(RecordStore.p_pass, p_total)
						+ "<br>&nbsp;<font color=Red>ʧ����(%) ��"+ HtmlUtil.getPercnet(RecordStore.p_fail, p_total) + "</font>" 
						+ "<br><br>"
						+ "</BODY></HTML>";
			else
				HTML_Tail = "</table></PRE>" + "<br>&nbsp;��ʼʱ��   ��"
						+ HtmlUtil.getCalcDate(this.setStartTime) + "<br>&nbsp;����ʱ��   ��"
						+ HtmlUtil.getCalcDate(this.setEndTime) + "<br>&nbsp;����ʱ��   ��"
						+ HtmlUtil.getDeltaTime(this.setEndTime, this.setStartTime)
						+ "<br>&nbsp;ִ������      ��" + p_total 
						+ "<br>&nbsp;�����ɹ�      ��"+ RecordStore.p_pass 
						+ "<br>&nbsp;����ʧ��      ��" + RecordStore.p_fail
						+ "<br>&nbsp;�ɹ���(%) ��" + HtmlUtil.getPercnet(RecordStore.p_pass, p_total)
						+ "<br>&nbsp;ʧ����(%) ��" + HtmlUtil.getPercnet(RecordStore.p_fail, p_total)
						+ "<br><br>"
						+ "</BODY></HTML>";
		else
			HTML_Tail = "</table></PRE>" + "<br>&nbsp;����ִ���쳣��" + "<br><br>"
					+ "</BODY></HTML>";

		return HTML_Tail;
	}

	

}
