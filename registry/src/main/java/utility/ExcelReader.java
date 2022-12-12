package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import gsh.registry.Base;

public class ExcelReader
{
	public XSSFSheet getSheet(String sheetname) throws IOException
	{
		
		File file = new File(System.getProperty("user.dir")+"\\resources\\ExcelDataProvider.xlsx");
		FileInputStream reader = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(reader);
		int noOfSheet = workbook.getNumberOfSheets();
		System.out.println(noOfSheet);
		XSSFSheet sheet=null;
		for(int i=0;i<=noOfSheet;i++)
		{
			if(workbook.getSheetName(i).equals(sheetname))
			{
				sheet = workbook.getSheetAt(i);
				break;
			}
		}
		return sheet;
	}
	public Object[][] getDataFromSheet(XSSFSheet sheet)
	{
		
		Iterator<Row> rows = sheet.rowIterator();
		int rowNos = sheet.getPhysicalNumberOfRows();
		System.out.println("row count is "+rowNos);
		Row firstRow  = rows.next();
		
		int cellNos = firstRow.getPhysicalNumberOfCells();
		System.out.println("row count is "+cellNos);
		
		Object[][] data = new Object[rowNos-1][cellNos];
		
		Iterator<Row> remainingRows = sheet.rowIterator();
		int rowcounter = 0 ;
		int colcounter = 0;
		while(remainingRows.hasNext())
		{
			Row row = remainingRows.next();
			if(row.getRowNum() == firstRow.getRowNum())
			{
				continue;
			}
			else
			{
				Iterator<Cell> cell = row.cellIterator();
				
				while(cell.hasNext())
				{
					Cell c = cell.next();
					
					if(c.getCellType() ==  CellType.NUMERIC)
					{
						System.out.println("value is "+c.getNumericCellValue());
					
						data[rowcounter][colcounter] = c.getNumericCellValue();
					}
					else
					{
						System.out.println("value is "+c.getStringCellValue());
						data[rowcounter][colcounter] = c.getStringCellValue();
					}
					colcounter++;
				}
				rowcounter++;
				colcounter=0;
			}
		}
		return data;
	}
}