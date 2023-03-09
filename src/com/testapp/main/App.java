package com.testapp.main;

import com.testapp.db.EmployeeDB;

public class App {
	public static void main(String[] args) {
		EmployeeDB empDB = new EmployeeDB();
		empDB.dbConnect();
	}
}
