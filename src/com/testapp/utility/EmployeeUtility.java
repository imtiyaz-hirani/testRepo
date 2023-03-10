package com.testapp.utility;

import java.util.Scanner;

import com.testapp.model.Employee;

public class EmployeeUtility {
	
	public static Employee readInput() {
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
}
