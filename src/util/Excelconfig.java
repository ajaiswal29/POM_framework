package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelconfig {

	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public Excelconfig(String excelpath) {

		try {

			File file = new File(excelpath);

			FileInputStream fis = new FileInputStream(file);

			workbook = new XSSFWorkbook(fis);

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public String getData(int sheetnumber, int row, int col) {

		XSSFSheet sheet = workbook.getSheetAt(sheetnumber);
		String data = sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}

}
