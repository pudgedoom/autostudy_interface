package report;

public interface IFile {

	void write(String p_info); //�ļ���дһ�仰
	void createLog(String p_info);
	void closeLog();
	void write(String p_info1,String p_info2); //����properties�ļ���дkey��value
	void write(String p_info1,String p_info2,String p_info3); //����ini�ļ���дsection��key��value
	String read(); //���ļ�ȫ������
	String read(String p_info);//��properties�ļ��ļ���ͨ��key��value
	String read(String p_info1,String p_info2);//��ini�ļ���ͨ��section��key��value
}
