package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import http.ExcelUtil;
import http.HttpUtil;

public class Test {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		InputStream excelInputstream;
		try {
			excelInputstream = new FileInputStream("F:\\test.xlsx");
			List<Map<String,Object>> list=ExcelUtil.readExcelData(excelInputstream, 0, 0, 1);
			Map<String, Object> a=list.get(0);
			System.out.println(a);
			String url=(String) a.get("url");
			System.out.println(url);
			HttpUtil.get(url);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
