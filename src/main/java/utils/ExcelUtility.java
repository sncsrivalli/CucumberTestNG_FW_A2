package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	private Workbook wb;
	Sheet sheet;
	DataFormatter df;
	
	public void excelInit(String excelPath, String sheetName) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheet(sheetName);
		df = new DataFormatter();
	}
	
	public Map<String, String> readFromExcel(String expectedTest){
		Map<String, String> map = new HashMap<String, String>();
		int requiredRowNum = 0;
		
		for(int i = 0; i <= sheet.getLastRowNum(); i++) {
			String actualTest = df.formatCellValue(sheet.getRow(i).getCell(1));
			if(actualTest.equalsIgnoreCase(expectedTest)) {
				requiredRowNum = i;
				break;
			}
		}
		
		for(int i = requiredRowNum; i <= sheet.getLastRowNum(); i++) {
			if(df.formatCellValue(sheet.getRow(i).getCell(2)).equals("####")) 
				break;
			
			map.put(df.formatCellValue(sheet.getRow(i).getCell(2)), 
					df.formatCellValue(sheet.getRow(i).getCell(3)));
		}
		return map;
	}
	
	public void closeWorkbook() {
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
