package com.testapp.main;

import java.util.List;
import java.util.Scanner;

import com.testapp.model.Employee;
import com.testapp.service.EmployeeService;

public class App {
	public static void main(String[] args) {
		 EmployeeService employeeService = new EmployeeService(); 
		 Scanner sc = new Scanner(System.in); 
		 while(true) {
			 System.out.println("=========MENU=========");
			 System.out.println("1. Add Employee");
			 System.out.println("2. Fetch all employee");
			 System.out.println("3. Delete Employee");
			 System.out.println("4. Update employee");
			 System.out.println("0. Exit");
			 int input = sc.nextInt();
			 if(input == 0) {
				 System.out.println("Exiting.. ");
				 break; //breaks the while loop 
			 }
			 switch(input) {
			 case 1: 
				 Employee employee = employeeService.readInput();
				 System.out.println
				 	(employeeService.addEmployeeToDb(employee) == 1? 
				 			"Record Inserted": 
				 			"Operation Failed, Try Again"); 
				 break; 
			 case 2: 
				 List<Employee> list = employeeService.getAllEmployees();
				 list.stream().forEach(System.out :: println);
				 break;
			 case 3: 
				 break;
			 case 4: 
				 break;
			 default: 
				 break; 
			 }
		 }
	}
}
