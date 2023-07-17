package com.example.BlogMode.service.Impl;

import com.example.BlogMode.model.Employee;
import com.example.BlogMode.repository.EmployeeRepo;
import com.example.BlogMode.service.EmployeeService;
import com.example.BlogMode.util.ExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public void save(MultipartFile multipartFile) {
        try {
            List<Employee> list = ExcelHelper.convertExcelToListOfEmployee(multipartFile.getInputStream());
            employeeRepo.saveAll(list);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }
}
