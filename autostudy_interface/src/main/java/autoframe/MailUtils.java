package autoframe;

import java.io.File;

public class MailUtils {
	
	public static void sendMail(String attachmentpath){
		EmailAttachment attachment =new EmailAttachment();
		File file=new File(attachmentpath);
		if(!f.exists()){
			DebugLogFile.type("�ϴ��ĸ���������");
			return ;
		}
		attachment.setPath(attachmentpath);
		attachment.setDispostion(EmailAttchment.ATTACHMENT);
		attachment.setName(file.getname());
		
		MultilPartEmail email=new MultilPartEmail();
		email.setHostName(Integer.parseInt(MailStore.host));
		email.setSmtpPort(Integer.parseInt(MailStore.port));
		email.setSSLOnConnect(true);
		email.setAuthenticator(new DefaultAuthenticator(MailStore.user,MailStore.pwd));
		
		try{
			email.addTo(MailStore.users);
			email.setFrom(MailStore.from);
			email.setSubject(MailStore.subject);
			email.setMsg(MailStore.message);
			email.attach(attachment);
			email.send();
			DebugLogFile.type("�����ʼ��ɹ�");
		}catch(EmailException e){
			DebugLogFile.type("�����ʼ��쳣"+e.toString());
		}
		
	}
	
	public static void sendMail(String[] users,String attachmentpath){
		EmailAttachment attachment=new EmailAttachment();
		File file=new File(attachment);
		if(!file.exists()){
			DebugLogFile.type("����·��������");
			return ;
		}
		
		attachment.setPath(attachmentpath);
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setName(file.getName());
		
		MultiPartEmail email=new MultiPartEmail();
		email.setHostName(MailStore.host);
		email.setPort(MailStore.port);
		email.setSSLOnConnect(true);
		email.setAuthenticator(new DefaultAuthenticator(MailStore.user,MailStore.pwd));
		try{
			email.addTo(users);
			email.setFrom(MailStore.from);
			email.setSubject(MailStore.subject);
			email.msg(MailStore.message);
			email.attach(attachment);
			email.send();
			DebugLogFile.type("�ʼ����ͳɹ�");
			
		}catch(MailException e){
			DebugLogFile("�ʼ������쳣"+e.toString());
		}
	}
}
