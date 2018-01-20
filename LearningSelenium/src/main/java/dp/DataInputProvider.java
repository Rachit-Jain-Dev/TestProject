package dp;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataInputProvider {
	public static Object[][] testData;	
	
	public static Object[][] readExcelData(String sheetName) throws IOException{	
		Object[][] testData=null;
		try{
			FileInputStream fis = new FileInputStream(sheetName);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet("Sheet1");
			int rowCount = ws.getLastRowNum();
			int columnCount = ws.getRow(0).getLastCellNum();
			testData = new Object[rowCount][columnCount];
			
			for(int i=1; i<rowCount+1; i++){
				XSSFRow row = ws.getRow(i);
				for(int j=0;j<columnCount;j++){
					String cellData = row.getCell(j).getStringCellValue();
					testData[i-1][j]=cellData;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return testData; 
	}
}
