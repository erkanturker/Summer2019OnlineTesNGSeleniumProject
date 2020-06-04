package utils;

import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {
    private Sheet workSheet;
    private Workbook workbook;
    private String path;

    public ExcelUtil (String path, String sheetName) {
        this.path = path;
        try {
            //Open Excel File
            FileInputStream excelFile = new FileInputStream ( path );
            //Acces the required test data
            workbook = WorkbookFactory.create ( excelFile );
            workSheet = workbook.getSheet ( sheetName );

            Assert.assertNotNull ( workSheet, "Worksheet: \"" + sheetName + "\" was not found" );
        } catch (Exception e) {
            throw new RuntimeException ();
        }
    }

    public ExcelUtil (String sheetName) {
        this.path = ConfigurationReader.getProperty ( "user_test_data" );
        try {
            FileInputStream excelFile = new FileInputStream ( path );
            workbook = WorkbookFactory.create ( excelFile );
            workSheet = workbook.getSheet ( sheetName );
            Assert.assertNotNull ( workSheet, "Worksheet: \"" + sheetName + "\" was not found" );

        } catch (IOException e) {
            throw new RuntimeException ();
        }

    }

    public String getCellData (int rowNum, int colNum) {
        Cell cell;
        cell = workSheet.getRow ( rowNum ).getCell ( colNum );
        String cellData = cell.toString ();
        return cellData;
    }

    public int columnCount ( ) {
        return workSheet.getRow ( 0 ).getLastCellNum ();
    }

    public int rowCount ( ) {
        return workSheet.getLastRowNum () + 1;
    }

    //this method return us data table as 2d Array
    //we need this because of data provider
    public String[][] getDataArray ( ) {

        String[][] data = new String[rowCount ()][columnCount ()];
        for (int i = 0; i < rowCount (); i++) {
            for (int j = 0; j < columnCount (); j++) {
                String value = getCellData ( i, j );
                data[i][j] = value;
            }
        }
        return data;
    }

    public List< Map< String, String > > getDataList ( ) {
        //get all columns
        List< String > columuns = getColumnsNames ();
        //this will be returned
        List< Map< String, String > > data = new ArrayList<> ();

        for (int i = 0; i < rowCount (); i++) {
            //get each row
            Row row = workSheet.getRow ( i );

            //create a map of the row using the colum and value
            //column map key, cell value --> MAp bvalue
            Map< String, String > rowMap = new HashMap<> ();

            for (Cell cell : row) {
                int columnIndex = cell.getColumnIndex ();
                rowMap.put ( columuns.get ( columnIndex ), cell.toString () );
            }
            data.add ( rowMap );
        }
        return data;
    }

    public List< String > getColumnsNames ( ) {
        List< String > columns = new ArrayList<> ();
        for (Cell cell : workSheet.getRow ( 0 )) {
            columns.add ( cell.toString () );
        }
        return columns;
    }

    public void setDataCell (String value, int rowNum, int colNum) {
        Cell cell;
        Row row;
        try {
            row = workSheet.getRow ( rowNum );
            cell = row.getCell ( colNum );

            if (cell == null) {
                cell = row.createCell ( colNum );
                cell.setCellValue ( value );
            } else {
                cell.setCellValue ( value );

            }
            FileOutputStream fileout = new FileOutputStream ( path );
            workbook.write ( fileout );
            fileout.close ();
        } catch (IOException e) {
            e.printStackTrace ();
        }

    }

    public void setCellData (String value, String columnName, int row) {
        int column = getColumnsNames ().indexOf ( columnName );
        setDataCell ( value, row, column );
    }
}


