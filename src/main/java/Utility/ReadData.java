package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {

	
		public static String readPropertyFile(String value) throws Exception
		{
			Properties p = new Properties();
			FileInputStream file=new FileInputStream("C:\\Users\\Ruchita\\eclipse-workspace\\Project17Sep\\TestData\\config.properties");
			p .load(file);
			return p.getProperty(value);
		}
		public static String excelData(int row, int cell) throws Exception
		{
			
			FileInputStream file=new FileInputStream("C:\\Users\\Ruchita\\eclipse-workspace\\Project17Sep\\TestData\\Data.xlsx");
			Sheet excel = WorkbookFactory .create(file).getSheet("Sheet1");
			String value = excel.getRow(row).getCell(cell).getStringCellValue();
			return value;
		}

	

	

}
