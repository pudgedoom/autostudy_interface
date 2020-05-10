package autoframe;

public class M1BussinessLib extends BussinessLibWeb{
	//设置账户个人资料
	public void setUserInfo(){
		super.newClick(ObjectStore.Index_user);
		super.newClick(ObjectStore.User_account);
		super.newClick(ObjectStoreMoudule1.Account_userinfo);
		super.newClick(ObjectStoreMoudule1.User_name,DataStore.D_User_name);
	}
}
