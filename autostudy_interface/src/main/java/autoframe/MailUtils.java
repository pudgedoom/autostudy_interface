package autoframe;

import java.io.File;

public class MailUtils {
	
	public static void sendMail(String attachmentpath){
		EmailAttachment attachment =new EmailAttachment();
		File file=new File(attachmentpath);
		if(!f.exists()){
			DebugLogFile.type("上传的附件不存在");
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
			DebugLogFile.type("发送邮件成功");
		}catch(EmailException e){
			DebugLogFile.type("发送邮件异常"+e.toString());
		}
		
	}
	
	public static void sendMail(String[] users,String attachmentpath){
		EmailAttachment attachment=new EmailAttachment();
		File file=new File(attachment);
		if(!file.exists()){
			DebugLogFile.type("附近路径不存在");
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
			DebugLogFile.type("邮件发送成功");
			
		}catch(MailException e){
			DebugLogFile("邮件发送异常"+e.toString());
		}
	}
}
