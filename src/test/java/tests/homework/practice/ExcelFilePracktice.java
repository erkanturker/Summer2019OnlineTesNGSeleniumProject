package tests.homework.practice;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelFilePracktice {
    @Test
    public void testExcelPractice() throws IOException {
        String path = "/Users/turker/Desktop/Class Notes/Java/20ExcelWriteandRead/countries.xlsx";
        FileInputStream excelFile= new FileInputStream ( path );
        Workbook workbook = WorkbookFactory.create ( excelFile );
        Sheet sheet = workbook.getSheetAt ( 0 );
        String value= sheet.getRow ( 0 ).getCell ( 0 ).toString ();
        System.out.println (value);
        int rowCount= sheet.getLastRowNum (); //it countr from 0
        System.out.println (rowCount);
        // all country names
        for (int i = 1; i <=rowCount; i++) {
            String countyCol =  sheet.getRow ( i ).getCell ( 0 ).toString ();
            System.out.println (countyCol);

        }
        System.out.println ("================================");
        // I want to print out country name and capital  afaganistah  kabul

        for (int i = 0; i <=rowCount; i++) {
            String countryCol= sheet.getRow ( i ).getCell ( 0 ).toString ();
            String capitalCol= sheet.getRow ( i ).getCell ( 1 ).toString ();
            System.out.println (countryCol+":   "+capitalCol);
        }
        System.out.println ("===================================");
        //lets put them in map
        Map<String, String>map= new HashMap<> (  );
        for (int i = 1; i <=rowCount ; i++) {
            String countryKey = sheet.getRow ( i ).getCell ( 0 ).toString ();
            String capitalValue = sheet.getRow ( i ).getCell ( 1 ).toString ();
            map.put ( countryKey, capitalValue );
        }
        System.out.println (map);
        System.out.println (map.get ( "TURKEY" ));

    }
}
