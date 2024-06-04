<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"  %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Employee</title>
</head>
<body>
    <h2>Add Employee</h2>
    <form action="EmployeeServlet" method="post">
        <input type="hidden" name="action" value="add">
        Name: <input type="text" name="empname" required><br>
        Age: <input type="number" name="empage" required><br>
        <input type="submit" value="Add Employee">
    </form>
    <br>
    <a href="EmployeeServlet">Back to Employee List</a>
</body>
</html>