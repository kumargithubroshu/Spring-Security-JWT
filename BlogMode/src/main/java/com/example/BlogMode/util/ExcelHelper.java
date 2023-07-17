package com.example.BlogMode.util;

import com.example.BlogMode.model.Employee;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    // this method checks file is excl or not
    public static boolean checkExcelFormat(MultipartFile multipartFile)
    {
        String contentType = multipartFile.getContentType();

        if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    // Convert Excel to list of employee
    public static List<Employee> convertExcelToListOfEmployee(InputStream inputStream)
    {
        List<Employee> list=new ArrayList<>();
        try {

            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
            XSSFSheet data = xssfWorkbook.getSheet("Data");
            int rowNumber=0;
            Iterator<Row> rowIterator = data.iterator();

            while (rowIterator.hasNext())
            {
                Row row= rowIterator.next();
                if (rowNumber==0)
                {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellIterator= row.iterator();
                int cell_id=0;

                Employee employee=new Employee();

                while(cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    switch (cell_id)
                    {
                        case 0:
                            employee.setEmpl_Id((int)cell.getNumericCellValue());
                            break;
                        case 1:
                            employee.setEmpl_Name(cell.getStringCellValue());
                            break;
                        case 2:
                            employee.setEmpl_Designation(cell.getStringCellValue());
                            break;
                        case 3:
                            employee.setEmpl_Email(cell.getStringCellValue());
                            break;
                        case 4:
                            employee.setEmpl_Address(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cell_id++;
                }
                list.add(employee);
            }


        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return list;
    }

}
