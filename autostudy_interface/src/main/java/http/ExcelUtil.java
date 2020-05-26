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
	 * 1����ȡexcleͷ
	 * 2����ȡexcel����
	 * 
	 */
	
	public static List<String> readExcelHeader(InputStream excelInputStream,
			int sheetNumber,
			int headerNumber,
			int rowStart) 
					throws IOException,InvalidFormatException{
		//Ҫ���ص�����
		List<String> headers=new ArrayList<String>();
		//���ɹ�����
		Workbook workbook=WorkbookFactory.create(excelInputStream);
		Sheet sheet=workbook.getSheetAt(sheetNumber);
		Row header = sheet.getRow(headerNumber);
		DataFormatter dataformatter=new DataFormatter();
		for(int i=0;i<header.getLastCellNum();i++){
			//��ȡ��Ԫ��
			Cell cell=header.getCell(i);
			headers.add(dataformatter.formatCellValue(cell));
		}
				
		return headers;
}
	
	public static List<Map<String,Object>> readExcelDataSheetNum(InputStream excelInputstream,
			int sheetNumber,
			int headerNumber,
			int rowStart)throws IOException,InvalidFormatException{
			
		//��Ҫ�ı����Լ�Ҫ���ص�����
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        List<String> headers = new ArrayList<String>();
        //���ɹ�����
        Workbook workbook = WorkbookFactory.create(excelInputstream);
        Sheet sheet = workbook.getSheetAt(sheetNumber);
        Row header = sheet.getRow(headerNumber);
        //���һ������
        int rowEnd = sheet.getLastRowNum();
        DataFormatter dataFormatter = new DataFormatter();
        //��ȡ������Ϣ
        for (int i = 0; i <header.getLastCellNum(); ++i) {
            Cell cell = header.getCell(i);
            headers.add(dataFormatter.formatCellValue(cell));
        }
        //��ȡ������Ϣ
        for (int i = rowStart; i <=rowEnd; ++i) {
            Row currentRow = sheet.getRow(i);
            if (Objects.isNull(currentRow)) {
                continue;
            }
            Map<String, Object> dataMap = new HashMap<String, Object>();
            for (int j = 0; j < currentRow.getLastCellNum(); ++j) {
                //��nullת��ΪBlank
                Cell data = currentRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                if (Objects.isNull(data)) {     //�о����if�е����
                    dataMap.put(headers.get(j), null);
                } else {
                    switch (data.getCellType()) {   //��ͬ�����ͷֱ���д洢
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
	
	public static List<Map<String,Object>> readExcelDataSheetName(InputStream excelInputstream,
			String  name
			)throws IOException,InvalidFormatException{
		//��Ҫ�ı����Լ�Ҫ���ص�����
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        List<String> headers = new ArrayList<String>();
        //���ɹ�����
        Workbook workbook = WorkbookFactory.create(excelInputstream);
        Sheet sheet = workbook.getSheet(name);
        Row header = sheet.getRow(0);
        //���һ������
        int rowEnd = sheet.getLastRowNum();
        DataFormatter dataFormatter = new DataFormatter();
        //��ȡ������Ϣ
        for (int i = 0; i <header.getLastCellNum(); ++i) {
            Cell cell = header.getCell(i);
            headers.add(dataFormatter.formatCellValue(cell));
        }
        //��ȡ������Ϣ
        for (int i = 1; i <=rowEnd; ++i) {
            Row currentRow = sheet.getRow(i);
            if (Objects.isNull(currentRow)) {
                continue;
            }
            Map<String, Object> dataMap = new HashMap<String, Object>();
            for (int j = 0; j < currentRow.getLastCellNum(); ++j) {
                //��nullת��ΪBlank
                Cell data = currentRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                if (Objects.isNull(data)) {     //�о����if�е����
                    dataMap.put(headers.get(j), null);
                } else {
                    switch (data.getCellType()) {   //��ͬ�����ͷֱ���д洢
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
		InputStream input=new FileInputStream("E:\\自动化学习\\http请求模板.xlsx");
//		List<String> list=readExcelHeader(input,0,0,1);
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		InputStream input2=new FileInputStream("F:\\test.xlsx");
		List<Map<String, Object>> arr=readExcelDataSheetName(input,"mc测试");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
	
}