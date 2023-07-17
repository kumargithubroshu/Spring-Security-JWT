package com.example.BlogMode.service.Impl;

import com.example.BlogMode.model.Employee;
import com.example.BlogMode.repository.EmployeeRepo;
import com.example.BlogMode.service.ExcelService;
import com.example.BlogMode.util.DataToExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public ByteArrayInputStream getActualData() throws IOException {
        List<Employee> employeeList = employeeRepo.findAll();
        ByteArrayInputStream byteArrayInputStream = DataToExcelHelper.data_to_excel(employeeList);
        return byteArrayInputStream;
    }
}
