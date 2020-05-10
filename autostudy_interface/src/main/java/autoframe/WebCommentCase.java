package autoframe;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WebCommentCase {
	public static MBussinessLib bl=new MBussinessLib();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		bl.newSetUp();
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
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
		String myCase1="µÇÂ¼²âÊÔ";
		bl.login(DataStore.D_Username,DataStore.D_Password);
		bl.newAssertEquals(myCase1,true,bl.newIsElementPresent(ObjectStore.CreateTask_Button));
	}
	@Test
	public void test2_commentSchedule() throws Exception{
		String myCase2="Ìí¼ÓÆÀÂÛ";
		bl.commentSchedule();
		bl.newAssertEquals(myCase2,true,bl.newIsTextElementPresent(DataStore.D_schedule_comment));
		
	}
	@Test
	public void test3_logout() throws Exception{
		String myCase3="ÍË³öµÇÂ¼";
		bl.logout();
		bl.newAsserEquals(myCase3,true,bl.newIsElementPresent(ObjectStore.Login_LoginFreeLink));
	}
}
