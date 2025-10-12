package SELENIUM_;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class SMPS_SEL_ExcelData {
    public static void main(String[] args) throws IOException {
    // TO print id and password from excel
        //1. Create object of workbook
        FileInputStream fis = new FileInputStream("C:\\Users\\sujit\\Downloads\\exelfilename.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        //2.Create object of sheet and allocate respective sheet
        XSSFSheet sheet=null;
        int numsheet = workbook.getNumberOfSheets();
        for (int i=0;i<numsheet;i++){
            if(workbook.getSheetName(i).equalsIgnoreCase("Student")){
                sheet = workbook.getSheetAt(i);
                break;
            }
        }

        //fetch data from sheet we have to use 2 iterator
        Iterator<Row> itrow = sheet.iterator();
        while (itrow.hasNext()){
            Row row = itrow.next();
            Iterator itcell = row.cellIterator();
            while (itcell.hasNext()){
               Cell c =(Cell) itcell.next();
                switch (c.getCellType()) {
                    case STRING -> System.out.print(c.getStringCellValue() + "\t");
                    case NUMERIC -> {
                        double value = c.getNumericCellValue();
                        // Print as integer if whole number, otherwise as decimal
                        if (value == (int) value) System.out.print((int) value + "\t");
                        else System.out.print(value + "\t");
                    }
                    case BOOLEAN -> System.out.print(c.getBooleanCellValue() + "\t");
                    default -> System.out.print("\t");
                }
            }
                System.out.println();
            }
        }



    }