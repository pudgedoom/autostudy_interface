package autoframe;

public class BuinessLibWeb {
	public void login(){
		super.newClick(ObjectStore.Login_LoginEntry);
		super.newClick(ObjectStore.Login_LoginFreeLink);
		if(newIsElementPresent(ObjectStore.Login_LoginTab_AD)){
			super.newClick(ObjectStore.Login_Login_AD);
		}
	}
	
	public void login(String p_name,String p_password){
		super.newClick(ObjectStore.Login_LoginFreeLink);
		if(newIsElementPresent(ObjectStore.Login_Login_AD)){
			super.newClick(ObjectStore.Login_Login_AD);
		}
	}
	
	public void logout(){
		super.newClick(ObjectStore.Index_user);
		super.newClick(ObjectStore.User_exit);
	}
	
	public void createTask(String p_taskname,String p_assgnto){
		super.newClick("");
		super.newClick("","");
	}
	
	public void commentSchedule(){
		super.newClick(ObjectStore.Schedule_Link);
		super.newType(ObjectStore.Schedule_comment,DataStore.D_Schedule_comment);
	}
}
