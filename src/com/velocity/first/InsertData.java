package com.velocity.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertData {

	public static void main(String[] args) {
		// Calling the JDBC
		InsertData data = new InsertData();
		data.inserData();

	}

	public void inserData() {
		try {
			// Step1 : Load the driver class : Translator
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step2 : Establish the connection : Road
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

			// Step3 : Create the statement
			Statement statement = con.createStatement();

			// Step4: Prepare the SQL query
			String sqlQuery = "insert into user(lastName,firstName,address,city,salary)"
					+ "values('patil','mahesh','Shivne','Pune',100000)";

			// Step5 : Submit and Exceute
			// statement.execute(sqlQuery);
			int i = statement.executeUpdate(sqlQuery);

			System.out.println("Excuted successfully " + i);

			// Close the resource
			statement.close();
			con.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
