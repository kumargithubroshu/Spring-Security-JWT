package com.example.BlogMode;

import com.example.BlogMode.repository.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogModeApplicationTests {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Test
	void contextLoads() {
		System.out.println("test case started");

		employeeRepo.findAll().forEach(employee -> System.out.println(employee.getEmpl_Address()));
	}

}
