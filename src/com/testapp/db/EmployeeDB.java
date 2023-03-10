package com.testapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.testapp.model.Employee;

public class EmployeeDB {
	/* Step 1: Define connection variables */
	String userDb= "root";
	String passDb="";
	String urlDb="jdbc:mysql://localhost:3306/myjavatestdb";
	String driver="com.mysql.cj.jdbc.Driver";
	Connection con; 
	private void dbConnect() {
		/* Step 2: Load the Driver */
		try {
			Class.forName(driver);
			//System.out.println("Driver loaded..");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		/* Establish the connection  */
		try {
			con = DriverManager.getConnection(urlDb, userDb, passDb);
			//System.out.println("Connection Est..");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int addEmployeeToDb(Employee employee) {
		dbConnect();
		String sql="insert into employee(name,city,salary,department) values (?,?,?,?)";
		int status = 0;
		try {
			/* Prepare the statement using PreparedStatement class*/
			PreparedStatement pstmt =  con.prepareStatement(sql);
			/* Set param values  */
			pstmt.setString(1, employee.getName());
			pstmt.setString(2, employee.getCity());
			pstmt.setDouble(3, employee.getSalary());
			pstmt.setString(4, employee.getDepartment());
			/*Execute the Query */
			status = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Query failed");
			 e.printStackTrace();
		}
		dbClose();
		return status; 
	}

	public List<Employee> getAllEmployees() {
		dbConnect();
		String sql="select * from employee";
		List<Employee> list = new ArrayList<>();
		try {
			PreparedStatement pstmt =  con.prepareStatement(sql);
			ResultSet rst  = pstmt.executeQuery();
			while(rst.next()) {
				Employee employee = new Employee(); //100X:1, harry
				employee.setId(rst.getInt("id"));
				employee.setName(rst.getString("name"));
				employee.setCity(rst.getString("city"));
				employee.setSalary(rst.getDouble("salary"));
				employee.setDepartment(rst.getString("department"));
				list.add(employee);
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		dbClose();
		return list;
	}
}

/* 
 Select (Fetch): pstmt.executeQuery();  
 Delete, Insert, Update: pstmt.executeUpdate()
 */








