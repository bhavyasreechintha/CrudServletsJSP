<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Employees</title>
</head>
<body>
	<h2>Employee List</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
			<th>Action</th>
		</tr>
		<c:forEach var="employee" items="${employees}">
			<tr>
				<td>${employee.empid}</td>
				<td>${employee.empname}</td>
				<td>${employee.empage}</td>
				<td><a
					href="EmployeeServlet?action=edit&empid=${employee.empid}">Edit</a>
					<a href="EmployeeServlet?action=delete&empid=${employee.empid}"
					onclick="return confirm('Are you sure you want to delete this employee?')">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="addEmployee.jsp">Add Employee</a>
</body>
</html>
