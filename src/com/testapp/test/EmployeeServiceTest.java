package com.testapp.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.testapp.db.EmployeeDB;
import com.testapp.model.Employee;
import com.testapp.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class EmployeeServiceTest {

	EmployeeService employeeService = new EmployeeService();
	
	@Before
	public void init() {}
	//@Test
	public void addEmployeeToDbTest() {
		/* Prepare the Data for Testing */
		Employee employee  = new Employee(4,"hermione","london",95000,"DEV");
		
		Assert.assertEquals(1, employeeService.addEmployeeToDb(employee));
	}
	
//	@Test
	public void getAllEmployeesTest() {
		/* Prepare the Data for Testing */
		Employee employee1  = new Employee(1,"Harry","LONDON",86000,"TESTING");
		Employee employee2  = new Employee(4,"harry","london",85000,"DEV");
		
		List<Employee> list = new ArrayList<>();
		list.add(employee1);
		list.add(employee2);
		
		Assert.assertEquals(list,employeeService.getAllEmployees());
	}
	
	@Test
	public void filterListTest() {
		Employee employee1  = new Employee(1,"Harry","LONDON",86000,"TESTING");
		Employee employee2  = new Employee(2,"hermione","kent",95000,"DEV");
		Employee employee3  = new Employee(3,"ronald","london",75000,"DEV");
		List<Employee> list = Arrays.asList(employee1,employee2,employee3);
		
		List<Employee> expectedList = Arrays.asList(employee1,employee3);
		Assert.assertEquals(expectedList, 
				employeeService.filterList(
						list, 
						(e)->e.getCity().equalsIgnoreCase("london")));
		
		expectedList = Arrays.asList(employee2);
		Assert.assertEquals(expectedList, 
				employeeService.filterList(
						list, 
						(e)->e.getCity().equalsIgnoreCase("kent")));
		
		expectedList = Arrays.asList(employee2,employee3);
		Assert.assertEquals(expectedList, 
				employeeService.filterList(
						list, 
						(e)->e.getDepartment().equalsIgnoreCase("DEV")));
		
		expectedList = Arrays.asList(employee2);
		Assert.assertNotEquals(expectedList, 
				employeeService.filterList(
						list, 
						(e)->e.getDepartment().equalsIgnoreCase("DEV")));
		
		Assert.assertNotNull(employeeService.filterList(
						list, 
						(e)->e.getDepartment().equalsIgnoreCase("DEV")));
		
		Assert.assertNotNull(employeeService.filterList(
				list, 
				(e)->e.getDepartment().equalsIgnoreCase("ADMIN")));
		
		Assert.assertEquals(0, employeeService.filterList(
				list, 
				(e)->e.getDepartment().equalsIgnoreCase("ADMIN")).size());
		
		Assert.assertNotEquals(0, employeeService.filterList(
				list, 
				(e)->e.getDepartment().equalsIgnoreCase("TESTING")).size());
	}
}









