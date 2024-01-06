package datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class datadriven {
	
	public ArrayList<String> getData(String testcasename) throws IOException {
		FileInputStream fis = new FileInputStream("/Users/saramise/Downloads/testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		ArrayList<String> testcases = new ArrayList<String>();
		
		int noofsheets = workbook.getNumberOfSheets();
		
		for (int i=0;i<noofsheets;i++) {
			System.out.println(workbook.getSheetName(i));
			
			if (workbook.getSheetName(i).equalsIgnoreCase("datasheet")) {
				XSSFSheet datasheet = workbook.getSheetAt(i);
				
				Iterator<Row> rowiter = datasheet.iterator();
				Row firstrow = rowiter.next();
				Iterator<Cell> celliter = firstrow.cellIterator();
				
				int col = 0;
				while(celliter.hasNext()) {
					Cell ce = celliter.next();
					System.out.println(ce.getStringCellValue());
					if(ce.getStringCellValue().equalsIgnoreCase("testcases")) {
						break;
					}
					else {
						col++;
					}
					
				}
				System.out.println(col);
				
				while(rowiter.hasNext()) {
					Row ro = rowiter.next();
					if(ro.getCell(col).getStringCellValue().equalsIgnoreCase(testcasename)) {
						Iterator<Cell> rowcelliter = ro.cellIterator();
						while(rowcelliter.hasNext()) {
							Cell cellval = rowcelliter.next();
							if(cellval.getCellType()==CellType.STRING) {
								testcases.add(cellval.getStringCellValue());
							}
							else {
								testcases.add(NumberToTextConverter.toText(cellval.getNumericCellValue()));
							}
							
						}
					}
				}
				
			}
		}
		return testcases;
	}

}
