package com.testapp.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import com.testapp.model.Employee;
import com.testapp.service.EmployeeService;
import com.testapp.utility.EmployeeUtility;

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
			 System.out.println("5. Filteration ");
			 System.out.println("0. Exit");
			 int input = sc.nextInt();
			 if(input == 0) {
				 System.out.println("Exiting.. ");
				 break; //breaks the while loop 
			 }
			 switch(input) {
			 case 1: 
				 Employee employee = EmployeeUtility.readInput();
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
				 System.out.println("Enter employee id to delete");
				 int id = sc.nextInt();
				 employee = employeeService.findEmployeeById(id);
				 if(employee == null) {
					 System.out.println("Invalid ID");
					 break;
				 }
				 System.out.println
				 	(employeeService.deleteEmployee(employee) == 1? 
				 			"Record Deleted": 
				 			"Operation Failed, Try Again"); 
				 break;
			 case 4: 
				 System.out.println("Enter employee id to edit");
				 id = sc.nextInt();
				 /* Validate ID*/
				 employee = employeeService.findEmployeeById(id);
				 if(employee == null) {
					 System.out.println("Invalid ID");
					 break;
				 }
				 /* Fetch existing record for the given ID */
				 employee = employeeService.findEmployeeById(id);
				 System.out.println("Exiting Employee Record from ID: " + id);
				 System.out.println(employee);
				 System.out.println("Lets update this record");
				 /* Read new Emmployee values to Update */
				 employee = EmployeeUtility.readInput();
				 employee.setId(id);
				 /* Update the record */
				 System.out.println(
						 employeeService.updateEmployee(employee)==1?
								 "Record Updated": 
								 "Operation Failed, Try Again");
				 break;
			 case 5:
				 System.out.println("Press 1 for filter on city");
				 System.out.println("Press 2 for filter on department");
				 int field = sc.nextInt(); //1 or 2
				 System.out.println(field == 1?"Enter City value": "Enter department value");
				 String value = sc.next();
				 Predicate<Employee> p1 = (Employee e) -> e.getCity().equalsIgnoreCase(value);
				 Predicate<Employee> p2 = (Employee e)-> e.getDepartment().equalsIgnoreCase(value);
				 List<Employee> filteredList = new ArrayList<>();
				 if(field == 1)
					 filteredList = employeeService.filterList(employeeService.getAllEmployees(),p1); 
				 else
					 filteredList =  employeeService.filterList(employeeService.getAllEmployees(),p2); 
				 
				 System.out.println("---------Filtered List-------");
				 filteredList.stream().forEach(System.out :: println);
				 break; 
			 default: 
				 break; 
			 }
		 }
	}
}
