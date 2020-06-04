package tests.homework.practice.Excel;

import java.util.*;

public class ExcelPracticewithOOP {
    public static void main (String[] args) {
        String path = "/Users/turker/Desktop/Class Notes/Java/20ExcelWriteandRead/countries.xlsx";
        ExcelPracticeUtil excel = new ExcelPracticeUtil ( path, "Sheet1" );

       // System.out.println (excel.getDataList ());
        //System.out.println (excel.getDataList1 ());

        for (Map<String,String>map:excel.getDataList ()) {
            System.out.println (map.get ( "COUNTRY" )+": "+map.get ( "CAPITAL" ));
        }



        /*
        List< Map<String,String> >listOfMaps= new ArrayList< Map<String,String>> ( );
        Map<String,String >map1=new HashMap<> (  );
        map1.put ("Country","Turkey"  );
        map1.put ( "Capital","Ankara" );
        Map<String,String >map2=new HashMap<> (  );
        map2.put ("Country","France"  );
        map2.put ( "Capital","Paris" );
        Map<String,String >map3=new HashMap<> (  );
        map3.put ("Country","Germany"  );
        map3.put ( "Capital","Munich" );
        listOfMaps.addAll ( Arrays.asList (map1,map2,map3) );
        System.out.println (listOfMaps);
        System.out.println (listOfMaps.get ( 0 ).get ( "Country" ));
        for (int i = 0; i <listOfMaps.size () ; i++) {
            Map<String,String> myMap =listOfMaps.get ( i );
            System.out.println ("Data For Map"+(i+1));
            for (Map.Entry<String ,String> entrySet:myMap.entrySet ()) {
                System.out.println ("Key: "+entrySet.getKey ()+" , Value: "+entrySet.getValue ());

            }
        }


         */


    }
}
