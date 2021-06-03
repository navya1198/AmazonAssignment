package reusableComponents;

import java.io.File;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperations {

	
	String filePath;
	Sheet sheet;
	
	public ExcelOperations(String sheetName)
	{
		try {
			filePath =System.getProperty("user.dir")+"//TestData.xlsx";
				//	PropertiesOperations.getPropertyValueByKey("testDataLocation");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		File testDataFile = new File(filePath);
		Workbook wb = null;
		try {
			wb=WorkbookFactory.create(testDataFile);
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		sheet=wb.getSheet(sheetName);
	}
	
	public HashMap<String,String> getTestDataInMap(int rowNum)
	{
		HashMap<String,String> hm=new HashMap<String,String>();
		for(int i=0; i<sheet.getRow(0).getLastCellNum(); i++)
		{
			sheet.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
			hm.put(sheet.getRow(0).getCell(i).toString(), sheet.getRow(rowNum).getCell(i).toString());
			
		}
		
		return hm;
		
	}
	
	public int getRowCount()
	{
		return sheet.getLastRowNum();
	}
	public int getColCount()
	{
		return sheet.getRow(0).getLastCellNum();
	}
	
}
