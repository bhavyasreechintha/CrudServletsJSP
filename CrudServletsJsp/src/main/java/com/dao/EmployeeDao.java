package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Employee;

public class EmployeeDao {







	
	public static Connection getConection() {
		 Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "80104384");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;

	}
	

public static List<Employee> getAllEmployees() {
    List<Employee> employees = new ArrayList<>();

    try {
    	Connection con = getConection();
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

        while (rs.next()) {
            Employee employee = new Employee();
            employee.setEmpid(rs.getInt("empid"));
            employee.setEmpname(rs.getString("empname"));
            employee.setEmpage(rs.getInt("empage"));
            employees.add(employee);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return employees;
}


public static Employee getEmployeeById(int empid) {
    Employee employee = null;

    try (Connection con = getConection();
         PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE empid = ?")) {

        ps.setInt(1, empid);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                employee = new Employee();
                employee.setEmpid(rs.getInt("empid"));
                employee.setEmpname(rs.getString("empname"));
                employee.setEmpage(rs.getInt("empage"));
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return employee;
}

public static int addEmployee(Employee employee) {
    int status = 0;

    try {Connection con = getConection();
    		PreparedStatement ps = con.prepareStatement("INSERT INTO employee (empname, empage) VALUES (?, ?)");
    		ps.setString(1, employee.getEmpname());
    		ps.setInt(2, employee.getEmpage());
        status = ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return status;
}

public static int updateEmployee(Employee employee) {
    int status = 0;

    try (Connection con = getConection();
         PreparedStatement ps = con.prepareStatement("UPDATE employee SET empname=?, empage=? WHERE empid=?")) {

        ps.setString(1, employee.getEmpname());
        ps.setInt(2, employee.getEmpage());
        ps.setInt(3, employee.getEmpid());

        status = ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return status;
}

public static int deleteEmployee(int empid) {
    int status = 0;

    try (Connection con = getConection();
         PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE empid=?")) {

        ps.setInt(1, empid);

        status = ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return status;
}
}