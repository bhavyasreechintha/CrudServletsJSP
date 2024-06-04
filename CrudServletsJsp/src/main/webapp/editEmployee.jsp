<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>
</head>
<body>
    <h2>Edit Employee</h2>
    <form action="EmployeeServlet" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="empid" value="${employee.empid}">
        Name: <input type="text" name="empname" value="${employee.empname}" required><br>
        Age: <input type="number" name="empage" value="${employee.empage}" required><br>
        <input type="submit" value="Update Employee">
    </form>
    <br>
    <a href="EmployeeServlet">Back to Employee List</a>
</body>
</html>