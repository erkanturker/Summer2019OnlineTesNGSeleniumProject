package tests.homework.practice;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelReadWrite {
    @Test
    public void excelReadWriteTest ( ) throws IOException {
        String path = "/Users/turker/Desktop/Class Notes/Java/20ExcelWriteandRead/countries.xlsx";
        FileInputStream excelFile = new FileInputStream ( path );
        Workbook workbook = WorkbookFactory.create ( excelFile );
        Sheet sheet = workbook.getSheetAt ( 0 );
        System.out.println ( sheet.getRow ( 0 ).getCell ( 0 ) );
        Cell column = sheet.getRow ( 0 ).getCell ( 2 );
        System.out.println ( column );
        if (column == null) {
            column = sheet.getRow ( 0 ).createCell ( 2 );
            column.setCellValue ( "Continent" );
        }
        Cell column2 = sheet.getRow ( 1 ).getCell ( 2 );
        System.out.println ( column );
        if(column2==null){
            column2 = sheet.getRow ( 1 ).createCell ( 2 );
            column2.setCellValue ( "Asia" );
        }

        FileOutputStream outputStream = new FileOutputStream ( path );
        workbook.write ( outputStream );

        System.out.println ( column );
        System.out.println (column2);

        /*




         */

    }
}
