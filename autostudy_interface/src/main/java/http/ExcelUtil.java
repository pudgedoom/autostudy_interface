package http;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.DateUtil;
public class ExcelUtil {
	
	/**
	 * 1、读取excle头
	 * 2、读取excel内容
	 * 
	 */
	
	public static List<String> readExcelHeader(InputStream excelInputStream,
			int sheetNumber,
			int headerNumber,
			int rowStart) 
					throws IOException,InvalidFormatException{
		//要返回的数据
		List<String> headers=new ArrayList<String>();
		//生成工作表
		Workbook workbook=WorkbookFactory.create(excelInputStream);
		Sheet sheet=workbook.getSheetAt(sheetNumber);
		Row header = sheet.getRow(headerNumber);
		DataFormatter dataformatter=new DataFormatter();
		for(int i=0;i<header.getLastCellNum();i++){
			//获取单元格
			Cell cell=header.getCell(i);
			headers.add(dataformatter.formatCellValue(cell));
		}
				
		return headers;
}
	
	public static List<Map<String,Object>> readExcelData(InputStream excelInputstream,
			int sheetNumber,
			int headerNumber,
			int rowStart)throws IOException,InvalidFormatException{
			
		//需要的变量以及要返回的数据
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        List<String> headers = new ArrayList<String>();
        //生成工作表
        Workbook workbook = WorkbookFactory.create(excelInputstream);
        Sheet sheet = workbook.getSheetAt(sheetNumber);
        Row header = sheet.getRow(headerNumber);
        //最后一行数据
        int rowEnd = sheet.getLastRowNum();
        DataFormatter dataFormatter = new DataFormatter();
        //获取标题信息
        for (int i = 0; i <header.getLastCellNum(); ++i) {
            Cell cell = header.getCell(i);
            headers.add(dataFormatter.formatCellValue(cell));
        }
        //获取内容信息
        for (int i = rowStart; i <=rowEnd; ++i) {
            Row currentRow = sheet.getRow(i);
            if (Objects.isNull(currentRow)) {
                continue;
            }
            Map<String, Object> dataMap = new HashMap<>();
            for (int j = 0; j < currentRow.getLastCellNum(); ++j) {
                //将null转化为Blank
                Cell data = currentRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                if (Objects.isNull(data)) {     //感觉这个if有点多余
                    dataMap.put(headers.get(j), null);
                } else {
                    switch (data.getCellType()) {   //不同的类型分别进行存储
                        case STRING:
                            dataMap.put(headers.get(j), data.getRichStringCellValue().getString());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(data)) {
                                dataMap.put(headers.get(j), data.getDateCellValue());
                            } else {
                                dataMap.put(headers.get(j), data.getNumericCellValue());
                            }
                            break;
                        case FORMULA:
                            dataMap.put(headers.get(j), data.getCellFormula());
                            break;
                        case BOOLEAN:
                            dataMap.put(headers.get(j), data.getBooleanCellValue());
                            break;
                        default:
                            dataMap.put(headers.get(j), null);
                    }
                }
                
            }result.add(dataMap);
        }
        return result;
		
	}
	
	public static void main(String[] args) throws InvalidFormatException, IOException{
		InputStream input=new FileInputStream("F:\\test.xlsx");
		List<String> list=readExcelHeader(input,0,0,1);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		InputStream input2=new FileInputStream("F:\\test.xlsx");
		List<Map<String, Object>> arr=readExcelData(input2,0,0,1);
		for (int i = 0; i < list.size()-1; i++) {
			System.out.println(arr.get(i));
		}
	}
	
}