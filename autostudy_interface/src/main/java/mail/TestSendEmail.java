package mail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;

public class TestSendEmail {
	/**
	 * 使用qq邮箱发送简单文本，带附件邮件
	 * 
	 */
	@Test
	public void sendMail(){
		MultiPartEmail email = new MultiPartEmail();
		//email.setSSL(true);
		//email.setDebug(true);
		email.setHostName("SMTP.qq.com");
		email.setSslSmtpPort("587");
		email.setAuthenticator(new DefaultAuthenticator("781188610@qq.com", "rckhgdorlhvrbbjb"));
		try {
			email.setFrom("781188610@qq.com");
			email.setSubject("test mail java");
			email.setMsg("邮件内容");
			email.addTo("280785182@qq.com");
			//附件对象
			EmailAttachment attach=new EmailAttachment();
			attach.setPath("D:\\b.html");
			attach.setDisposition(EmailAttachment.ATTACHMENT);
			//添加附件
			email.attach(attach);
			//发送邮件
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void sendMail2(){
		MultiPartEmail email =new MultiPartEmail();
		email.setHostName("smtp.qq.com");
		email.setSslSmtpPort("456");
		//添加账号和授权码
		email.setAuthenticator(new DefaultAuthenticator("781188610@qq.com", "rckhgdorlhvrbbjb"));
		try {
			email.setFrom("781188610@qq.com");
			email.setSubject("test java mail2");
			email.setMsg("neiron");
			email.addTo("280785182@qq.com");//目标邮箱地址
			
			
			EmailAttachment attach=new EmailAttachment();
			attach.setPath("D:\\b.html");
			attach.setName("user.txt");//修改附件名称
			attach.setDescription(EmailAttachment.ATTACHMENT);//添加说明
			email.attach(attach);
			
			email.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
