package com.testapp.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.testapp.model.Employee;
import com.testapp.service.EmployeeService;

public class EmployeeServiceTest {

	EmployeeService employeeService = new EmployeeService(); 
	
	//@Test
	public void addEmployeeToDbTest() {
		/* Prepare the Data for Testing */
		Employee employee  = new Employee(1,"harry","london",85000,"DEV");
		Assert.assertEquals(1, employeeService.addEmployeeToDb(employee));
	}
	
	@Test
	public void getAllEmployeesTest() {
		/* Prepare the Data for Testing */
		Employee employee1  = new Employee(1,"Harry","LONDON",86000,"TESTING");
		Employee employee2  = new Employee(4,"harry","london",85000,"DEV");
		
		List<Employee> list = new ArrayList<>();
		list.add(employee1);
		list.add(employee2);
		
		Assert.assertEquals(list,employeeService.getAllEmployees());
	}
}
