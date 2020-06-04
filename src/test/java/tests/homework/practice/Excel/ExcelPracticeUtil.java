package tests.homework.practice.Excel;

import com.microsoft.schemas.office.office.STInsetMode;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelPracticeUtil {
    private String path;
    private Workbook workBook;
    private Sheet workSheet;


    public ExcelPracticeUtil (String path, String sheetName) {
        this.path = path;
        try {
            FileInputStream excelFile = new FileInputStream ( path );
            workBook = WorkbookFactory.create ( excelFile );
            workSheet = workBook.getSheet ( sheetName );

        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public int rowCount ( ) {
        return workSheet.getLastRowNum () + 1;
    }

    public int columnCount ( ) {
        return workSheet.getRow ( 0 ).getLastCellNum ();
    }

    public List< String > columName ( ) {
        List< String > columnNames = new ArrayList<> ();
        for (int i = 0; i < columnCount (); i++) {
            String colName = workSheet.getRow ( 0 ).getCell ( i ).toString ();
            columnNames.add ( colName );
        }

        return columnNames;
    }

    public List< Map< String, String > > getDataList ( ) {
        List< String > column = columName ();
        List< Map< String, String > > mapList = new ArrayList< Map< String, String > > ();
        for (int i = 0; i < rowCount (); i++) {
            Row row = workSheet.getRow ( i );
            Map< String, String > map = new HashMap<> ();
            for (int j = 0; j < row.getLastCellNum (); j++) {
                map.put ( column.get ( j ), row.getCell ( j ).toString () );
            }
            mapList.add ( map );
        }
        return mapList;

    }

    public List< Map< String, String > > getDataList1 ( ) {
        List< String > column = columName (); //callling coulumn name
        List< Map< String, String > > mapList = new ArrayList< Map< String, String > > (); // creating List of Map
        for (Row row : workSheet) { // iterating on row
            Map< String, String > map = new HashMap<> (); //creating map
            for (Cell cell : row) { /// iterating on row  According to our xlss file getColumnIndex can get 0 or 1
                // column.get ( cell.getColumnIndex () ),Key value it will get only get COUNTRY or CAPITAL
                //cell.toString () ); this is same diffenrt row but same cell number
                //first itarete we will strorre in the map{COUNTRY=COUNTRY, CAPITAL=CAPITAL}
                //second {COUNTRY=AFGHANISTAN, CAPITAL=KABUL}
                map.put ( column.get ( cell.getColumnIndex () ), cell.toString () );
            }
            mapList.add ( map ); //after first iteration we will add the map inside the list
        }
        return mapList;
    }


}


