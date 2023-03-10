package com.testapp.service;

import java.util.List;
import java.util.Scanner;

import com.testapp.db.EmployeeDB;
import com.testapp.model.Employee;

public class EmployeeService {

	public Employee readInput() {
		Employee employee = new Employee(); 
		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter Name");
		employee.setName(sc.next());
		System.out.println("Enter City");
		employee.setCity(sc.next());
		System.out.println("Enter Salary");
		employee.setSalary(Double.parseDouble(sc.next()));
		System.out.println("Enter Department");
		employee.setDepartment(sc.next());
		
		return employee;
	}

	public int addEmployeeToDb(Employee employee) {
		 EmployeeDB db = new EmployeeDB();
		 return db.addEmployeeToDb(employee);
		
	}

	public List<Employee> getAllEmployees() {
		EmployeeDB db = new EmployeeDB();
		
		return db.getAllEmployees();
	}

	public Employee findEmployeeById(int id) {
		EmployeeDB db = new EmployeeDB();
		
		return db.findEmployeeById(id);
	}

	public int deleteEmployee(Employee employee) {
		EmployeeDB db = new EmployeeDB();
		
		return db.deleteEmployee(employee.getId());
	}

	public int updateEmployee(Employee employee) {
		 
		return new EmployeeDB().updateEmployee(employee);
	}

	 

}



