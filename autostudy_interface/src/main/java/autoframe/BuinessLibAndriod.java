package autoframe;

import java.util.concurrent.TimeUnit;

public class BuinessLibAndriod extends AndroidDriverLibExtension {
	public boolean login(String P_UserName,String P_UserPass){
		try{
			super.newDisplayed(ObjectStoreMoudule1.Index_update);
			super.newClick(ObjectStoreMoudule1.Index_update);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			super.newisDisplayed(ObjectStoreMoudule1.Index_rest);
			super.newClick(ObjectStoreMoudule1.Index_rest);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void setSchedule(){
		driver.manager.timeouts.implicitlWait(10,TimeUnit.SECONDS);
		super.newClick(ObjectStoreMoudule1.Schedule_new);
		super.newClick(ObjectStoreMoudule1.Schedule_Schedule);
		for(int i=0;i<DataStore.D_Schedule_peoples.length;i++){
			if(!driver.findElementByAndriodUIAutomator(scorllToByText(DataStore.D_Schedule_peoples[i])).isSelected()){
				driver.findElementByAndriodUIAutomator(scorllToByText(DataStore.D_Schedule_peoples[i])).click();
			}
		}
	}
	
	public boolean checkScheduleComment(){
		super.newClick(ObjectStoreMoudule1.Schedule_check_all);
		super.newClick(ObjectStoreMoudule1.Schedule_check_day);
		return super.newisDisplayed(ObjectStoreMouduel1.Schedule_check_comment);
	}
	
	public boolean checkSchedule(){
		super.newClick(ObjectStoreMoudule1.Schedule_check_all);
		return super.newisDisplayed(ObjectStoreMoudule1.Schedule_projectname);
	}
	
	public void toHome(Andriod driver){
		driver.findElement(By.className("android.widget.ImageButton")).click();
	}
	
	public void logout(){
		super.newClick(ObjectStoreMoudule1.back);
		l
	}
}
