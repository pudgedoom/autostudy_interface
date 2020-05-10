package autoframe;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppCheckCommentCase {
	public static MBussinessLib bl=new MBussinessLib();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		bl.newSetUp("测试成功");
		}
	
	@AfterClass
	public static void tearDownAferClass() throws Exception{
		bl.newTearDown();
	}
	
	@Before
	public void setUp() throws Exception{
		
	}
	
	@After
	public void tearDown() throws Exception{
		
	}
	
	@Test
	public void test1_login() throws Exception{
		String myCase1="验证登录";
		bl.newAssertEquals(myCase1,true,bl.login(DataStore.D_UserName,DataStore.D_Passwor));
		
	}
	
	@Test
	public static test2_checkComment() throw Exception{
		String myCase2="验证评论";
		bl.newAssertEquals(myCase2,true,bl.checkScheduleComment());
	}
	
	@Test
	public static test3_logOut() throws Exception{
		String myCase3="退出登录";
		bl.newAssertEquals(myCase3,true,bl.logOut());
	}
	
}
