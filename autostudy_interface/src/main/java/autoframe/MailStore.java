package autoframe;

public class MailStore {
	public static final String mailconfigfilepath="./mailconfig.ini";
	public static final String host=CommonLib.readINIFile(mailconfigfilepath,"server","host");
	public static final String port=CommonLib.readINIFile(mailconfigfilepath,"server","port");
	public static final String user=CommonLib.readINIFile(mailconfigfilepath,"Authenticator","user");
	public static final String pwd=CommonLib.readINIFile(mailconfigfilepath,"Authenticator","pwd");
	public static final String from=CommonLib.readINIFile(mailconfigfilepath,"MailContent","from");
	public static final String fromname=CommonLib.readINIFile(mailconfigfilepath,"MailConten","fromname");
	public static final String[] users=CommonLib.readINIFile(mailconfigfilepath,"To","to");
	public static final String subject="附件测试";
	public static final String message="自动化测试已经结束请查看测试邮件";
	public static final String attachmentpath="";
	public static final String attachmentname="";

}
