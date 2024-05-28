package com.velocity.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PreparedStatementDemo {

	public static void main(String[] args) {
		PreparedStatementDemo demo = new PreparedStatementDemo();
		// demo.inserData("Avinash", "23rfghj");
		// demo.updateData("Vishal", "56yghnl", "1");
		// demo.deleteData("2");
		demo.selectData2();
	}

	public void inserData(String user, String pwd) {
		try {
			// Step1 : Load the driver class : Translator
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step2 : Establish the connection : Road
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

			// Step3: Prepare the SQL query
			String sqlQuery = "insert into employee(username,password)" + "values(?,?)";

			// Step4 : Create the prepared-statement
			PreparedStatement pStmt = con.prepareStatement(sqlQuery);
			pStmt.setString(1, user);
			pStmt.setString(2, pwd);

			// Step5 : Submit and Exceute
			int i = pStmt.executeUpdate();

			System.out.println("Excuted successfully " + i);

			// Close the resource
			pStmt.close();
			con.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void updateData(String user, String pwd, String id) {
		try {
			// Step1 : Load the driver class : Translator
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step2 : Establish the connection : Road
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

			// Step3: Prepare the SQL query
			String singlesUpdateQuery = "update employee set username =? where id = ?";
			String multiUpdateQuery = "update employee set username = ?, password =? where id = ?";

			// Step4 : Create the prepared-statement
			PreparedStatement pStmt = con.prepareStatement(multiUpdateQuery);
			pStmt.setString(1, user);
			pStmt.setString(2, pwd);
			pStmt.setString(3, id);

			// Step5 : Submit and Exceute
			int i = pStmt.executeUpdate();

			System.out.println("Excuted successfully " + i);

			// Close the resource
			pStmt.close();
			con.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteData(String id) {
		try {
			// Step1 : Load the driver class : Translator
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step2 : Establish the connection : Road
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

			// Step3: Prepare the SQL query
			String deleteQuery = "delete from employee where id = ?";

			// Step4 : Create the prepared-statement
			PreparedStatement pStmt = con.prepareStatement(deleteQuery);
			pStmt.setString(1, id);

			// Step5 : Submit and Exceute
			int i = pStmt.executeUpdate();

			System.out.println("Excuted successfully " + i);

			// Close the resource
			pStmt.close();
			con.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void selectData() {
		try {
			// Step1 : Load the driver class : Translator
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step2 : Establish the connection : Road
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

			// Step3: Prepare the SQL query
			String Query = "select * from employee";

			// Step4 : Create the prepared-statement
			PreparedStatement pStmt = con.prepareStatement(Query);

			// Step5 : Submit and Exceute
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				System.out.println("ID ::" + rs.getInt(1));
				System.out.println("Name ::" + rs.getString(2));
				System.out.println("Password::" + rs.getString(3));
			}

			// Close the resource
			pStmt.close();
			con.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void selectData2() {
		try {
			// Step1 : Load the driver class : Translator
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Step2 : Establish the connection : Road
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

			// Step3: Prepare the SQL query
			String Query = "select * from employee";

			// Step4 : Create the prepared-statement
			PreparedStatement pStmt = con.prepareStatement(Query);

			// Step5 : Submit and Exceute
			ResultSet rs = pStmt.executeQuery();
			List<Employee> employees = new ArrayList<Employee>();
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setPassword(rs.getString(3));
				employees.add(employee);
			}
			System.out.println(employees);
			// Close the resource
			pStmt.close();
			con.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
