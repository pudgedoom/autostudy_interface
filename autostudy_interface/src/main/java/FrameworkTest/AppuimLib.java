package FrameworkTest;

import com.report.entry.ReportEntry;

public class AppuimLib {
	public static Logger logger=new Logger(DataStore.D_DebugLogger);
	public static AndrioiDriver driver;
	ReportEntry re=new ReportEntry();
	private FileHandler fileHandler=null;
	
	public void newStep(String p_Name) throws Exception{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability("platformName",DataStore.D_Andriod_platformName);
		capabilities.setCapability("deviceName",DataStore.D_Andriod_deviceName);
		capabilities.setCapability("noReset",DataStore.D_Andriod_noReset);
		capabilities.setCapability("appPackage",DataStore.D_Andriod_appPackage);
		capabilities.setCapability("appActivity",DataStore.D_Andriod_appActivity);
		capabilities.setCapability("unicodeKeyboard",DataStore.D_Andriod_chinainput);
		capabilities.setCapability("resetKeyboard",DataStore.D_Andriod_chiainput);
		try{
			driver=new AndriodDriver<MobileElement>(new URL(DataStore.D_Andriod_hubURL),capabilities);
			
		}catch(Exception e){
			driver.quit);
			DebugLogFile.type("lauch andriod driver fail !"+e.toString());
		}
		if(driver!=null){
			File file=new File("D:\\report\");
		}
		if(!file.exists()){
			file.mkdir();
		}
		String path=System.getProperty("user.dir");
		File source=new File(path+"\\css\\demo_report_style.css");
		FileUtils.copyFileToDirectory(source,file,true);
		re.createLog("D:\\report\\"+p_Name+".html");		
	}
	
		
	public void newtearDown() throws Exception{
		driver.quit();
		re.closeLog();
	}
	
	private String myUiScrollable(String uiSelector){
		return "new UiScorollable (new UiSelector().scrollable(true).instance(0)).srcollIntoView("+uiSelctor+".instance(0));";
	}
	
	public String scrollToByText(String text){
		String uiScrollables =myUiScrollable("new UiSelector().descriptionContains(\""+text+"\")")+myUiScrollable("new UiSelector().textContains(\""+
	text+"\")");
	}
	
	public By parseObject(String p_object){
		String newObject=null;
		
		if(p_object.startsWith(".//")||p_object.startsWith("//")){
			return By.xpath(p_object);
		}
		if(p_object.startsWith("xpath=")){
			newObject=p_object.substring(p_object.indexOf("=")+1);
			return By.xpath(newObject);
		}
		if(p_object.startsWith("id=")){
			newObject=p_object.substring(p_object.indexOf("=")+1);
			return By.id(newObject);
		}
		if(p_object.startsWith("class=")){
			newObject=p_object.substring(p_object.indexOf("=")+1);
			return By.className(newObject);
		}
		if(p_object.startsWith("name=")){
			newObject=p_object.substring(p_object.indexOf("=")+1);
			return By.name(newObject);
		}else{
			return null;
		}
	}
	
	public void newClick(String p_id){
		try{
			driver.findElement(parseObject(p_id)).click();
			DebugLogFile.type(TextStore.T_ClickObject+p_id+TextStore.T_Pass);
		}
		catch(Exception e){
			DebugLogFile.type(TextStore.T_Exception+"newClick(String p_id)"+TextStore.T_DetailInfo+e.toString());
		}
	}
	
	public void newType(String p_id,String p_text){
		try{
			driver.findElement(parseObject(p_id)).clear();
			driver.findElement(parseObject(p_id)).sendKeys(p_text);
			DebugLogFile.type(TextStore.T_put+p_text+TextStore.T_To+pid+TextStore.T_Pass);
		}catch(Exception e){
			DebugLogFile.type(TextStore.T_Exception+"newType"+TextStore.T_DetailInfo+e.toString());
		}
	}
	
	public void newSelect(String p_id,String p_text){
		try{
			Select select=new Select(driver.findElement(parseObject(p_id)));
			select.selectByVisibleText(p_text);
			DebugLogFile.type(TextStore.T_SelectListValue+p_id+"内容是："+p_id+TextStore.T_Pass);
		}catch(Exception e){
			DebugLogFile.type(TextStore.T_Exception+"newSelect"+TextStore.T_DetailInfo+e.toString());
		}
	}
	
	
	public boolean newisDisplayed(String p_id){
		return driver.findElement(parseObject(p_id)).isDisplayed();
	}
	
	public boolean newisSelected(String p_id){
		return driver.findElementByAndriondUIAutomator(scrollToByText(p_id)).isSelected();
	}
	
	public void newscrollTo(String p_id){
		driver.scrollTo(p_id);
	}
	public void newVerifyEquals(String p_message,Object p_expected,Object p_actual) throws Exception{
		if(p_exception.equals(p_actual)){
			re.write(p_message,p_excepted.toString(),p_actual.toString());
			DebugLogFile.type(TextStore.T_Verify+"newVerifyEquals"+"通过");
		}else{
			re.write(p_message,p_expected.toString(),p_actual.toString());
			DebugLogFile.type(TextStore.T_Verify +"newVerifyEquals" + "不通过，继续执行");
		}
	}
	
	public void newAssertEquals(String p_message,Object p_expected,Object p_actual)throws Exception {
		if(p_excepted.equals(p_actual)){
			re.write(p_message,p_excepted.toString(),p_actual.toString());
			DebugLogFile.type(TextStore.T_Verify+"newAssertEquals"+"通过");
			
		}else{
			re.write(p_message,p_excepted.toString(),p_actuals.toString());
			re.closeLog();
			driver.quit();
			DebugLogFile.type(TextStore.T_Verify+"newAssertEqauls"+"不通过,退出执行！");
		}
	}
}
