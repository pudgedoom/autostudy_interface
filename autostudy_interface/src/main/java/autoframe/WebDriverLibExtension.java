package autoframe;

public class WebDriverLibExtension extends WebDriver{
	/**
	 * 1、重写方法
	 * 2、扩展方法
	 */
	
	public WebDriverLibExtension(){
		super();
	}
	
	public void newClick(){
		CommonLib.sleep(DataStore.D_Wait_ShortTime);
		DebugLogFile.type("重写的方法");
		
		try{
			driver.findElement(parseObject(p_id)).click();
			DebugLogFile.type(TextStore.T_ClickObject+p_id+TextStore.T_Pass);
		}catch(Exception e){
			DebugLogFile.type(TextStore.T_Exception+"newClick(String p_id"+TextStore.T_DetailInfo+e.toString());
		}
	}
	
}	
