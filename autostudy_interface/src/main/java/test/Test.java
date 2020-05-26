package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import autoframe.DebugLogFile;
import http.ExcelUtil;
import http.HttpUtil;

public class Test {

	public static void main(String[] args) throws InvalidFormatException, IOException {

			exe("E:\\自动化学习\\http请求模板.xlsx");

		
	}
	
	public static void exe(String filename){
		InputStream excelInputstream = null;
		try {
			excelInputstream = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Map<String, Object>> list = null;
		try {
			list = ExcelUtil.readExcelDataSheetName(excelInputstream,"mc测试");
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!list.isEmpty()){
			for(int i=0;i<list.size();i++){
				Map<String, Object> a=list.get(i);
				String method=(String) a.get("get/post");
				if(method.equals("get")){//用例不能有空行或者残缺不全的行否则报空指针
					System.out.println(a);
					String url=(String) a.get("url");
					System.out.println(url);
					HttpUtil.get(url);
				}else if(a.get("get/post").equals("post")){
					System.out.println("post执行");
				}else{
					System.out.println("get/post文本框为空请填写");
					DebugLogFile.type("get/post文本框为空请填写");
				}
			}
			
		}else{
			System.out.println("用例为空，请检查！");
		}
		

	}

}
