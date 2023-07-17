package com.example.BlogMode.util;

import com.example.BlogMode.model.Employee;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.*;

public class DataToExcelHelper {

    public static String[] HEADER={
            "empl_Id",
            "empl_Name",
            "empl_Designation",
            "empl_Email",
            "empl_Address"
    };

    public static String SHEET_NAME="employee_data";

    public static ByteArrayInputStream data_to_excel(List<Employee> list) throws IOException {
        // create work book
        Workbook workbook = new XSSFWorkbook();
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();

        try
        {

            // create sheet
            Sheet sheet = workbook.createSheet(SHEET_NAME);

            //create row -- Header row
            Row row = sheet.createRow(0);

            for(int i=0; i< HEADER.length; i++)
            {
                Cell cell = row.createCell(i);
                cell.setCellValue(HEADER[i]);
            }

            // value rows
            int rowIndex=1;
            for(Employee e:list)
            {
                Row dataRow = sheet.createRow(rowIndex);
                rowIndex++;

                dataRow.createCell(0).setCellValue(e.getEmpl_Id());
                dataRow.createCell(1).setCellValue(e.getEmpl_Name());
                dataRow.createCell(2).setCellValue(e.getEmpl_Designation());
                dataRow.createCell(3).setCellValue(e.getEmpl_Email());
                dataRow.createCell(4).setCellValue(e.getEmpl_Address());
            }
            workbook.write(byteArrayOutputStream);

            return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.out.println("failed to convert in excel");
            return null;
        }
        finally {
            workbook.close();
            byteArrayOutputStream.close();
        }

    }
}
