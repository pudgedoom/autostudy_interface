package autoframe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppAddScheduleCase {
	public static  MBussinessLib bl=new MBussinessLib();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bl.newStep("测试启动");
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		bl.newtearDown();
	}
	@Before
	public void setUp() throws Exception{
		
	}
	@After
	public void tearDown() throws Exception{
		
	}
	@Test
	public void test1_login() throws Exception{
		String myCase1="验证登录"；
		bl.newAssertEquals(mycase1,true,bl.login(DataStore.D_Username,DataStore.D_Password));
	}
	@Test
	public void test2_addSchedule() throws Exception{
		String myCase2="添加日程";
		bl.setSchedule();
		bl.newAssertEquals(myCase2,true,bl.checkSchedule);
		
	}
	@Test
	public void test3_logOut() throws Exception{
		String myCase3="退出登录";
		bl.logOut();
	}
}
