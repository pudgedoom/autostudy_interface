package autoframe;

public class Schedule {
	public String name;//�ճ�����
	public String location;//λ��
	public String project;//��Ŀ
	public String[] people;//������
	public int StartDay;//��ʼʱ��
	public int EndDay;//����ʱ��
	public String repeat;//�ظ�ѡ��
	public String remind;//����
	
	Schedule(String p_name,String p_location,String p_project,String[] p_people,int p_StartDay,int p_EndDay,String p_repeat,String
			p_remind){
		this.name=p_name;
		this.location=p_location;
		this.project=p_project;
		this.people=p_people;
		this.StartDay=p_StartDay;
		this.EndDay=p_EndDay;
		this.repeat=p_repeat;
		this.remind=p_remind;
	}
}
