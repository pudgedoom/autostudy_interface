package autoframe;

public class WebDriverLibExtension extends WebDriver{
	/**
	 * 1����д����
	 * 2����չ����
	 */
	
	public WebDriverLibExtension(){
		super();
	}
	
	public void newClick(){
		CommonLib.sleep(DataStore.D_Wait_ShortTime);
		DebugLogFile.type("��д�ķ���");
		
		try{
			driver.findElement(parseObject(p_id)).click();
			DebugLogFile.type(TextStore.T_ClickObject+p_id+TextStore.T_Pass);
		}catch(Exception e){
			DebugLogFile.type(TextStore.T_Exception+"newClick(String p_id"+TextStore.T_DetailInfo+e.toString());
		}
	}
	
}	
