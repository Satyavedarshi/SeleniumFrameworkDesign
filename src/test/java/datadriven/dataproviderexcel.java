package datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataproviderexcel {
	
	@Test(dataProvider="DriveTest")
	public void dataprovidercalls(String name, String message, String id) {
		System.out.println(name + " " + message + " " + id);
	}
	
	
	@DataProvider(name="DriveTest")
	public Object[][] getData() throws IOException {
		
		DataFormatter df = new DataFormatter();
		FileInputStream fis1 = new FileInputStream("/Users/saramise/Downloads/testdata.xlsx");
		XSSFWorkbook databook = new XSSFWorkbook(fis1);
		Object[][] data = {};

		int noofsheets = databook.getNumberOfSheets();

		for(int i=0;i<noofsheets;i++) {
			if(databook.getSheetName(i).equalsIgnoreCase("greets")) {
				XSSFSheet datasheet = databook.getSheetAt(i);

				int rowcount = datasheet.getPhysicalNumberOfRows();

				XSSFRow firstrow = datasheet.getRow(0);
				int colcount = firstrow.getLastCellNum();
				System.out.println(rowcount);
				System.out.println(colcount);

				data = new Object[rowcount][colcount];

				for(int eachrow=1;eachrow<rowcount;eachrow++) {
					XSSFRow rowdata = datasheet.getRow(eachrow);
					//System.out.println("Loop through rows");

					for(int eachcol=0;eachcol<colcount;eachcol++) {
						//System.out.println("Loop through columns");
						data[eachrow][eachcol] = df.formatCellValue(rowdata.getCell(eachcol));
						//System.out.println("Cellvalue is - " + data[eachrow][eachcol]);
					}
				}

				break;
			}
		}
		return data;
		
		}
	}
