package com.testapp.service;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.testapp.db.EmployeeDB;
import com.testapp.model.Employee;

public class EmployeeService {
	EmployeeDB db = new EmployeeDB();
	public int addEmployeeToDb(Employee employee) {
		 
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
	
	public List<Employee> filterList(List<Employee> list, Predicate<Employee> p1) {
		return list.stream().filter(p1).collect(Collectors.toList());
	}
}



