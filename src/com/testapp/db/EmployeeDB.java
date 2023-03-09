package com.testapp.db;

public class EmployeeDB {
	/* Step 1: Define connection variables */
	String userDb= "root";
	String passDb="";
	String urlDb="jdbc:mysql://localhost:3306/myjavatestdb";
	String driver="com.mysql.cj.jdbc.Driver";
	
	public void dbConnect() {
		/* Step 2: Load the Driver */
		try {
			Class.forName(driver);
			System.out.println("Driver loaded..");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
