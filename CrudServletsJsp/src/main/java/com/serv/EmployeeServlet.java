package com.serv;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDao;
import com.pojo.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action != null) {
			switch (action) {
			case "edit":
				showEditForm(request, response);
				break;
			case "delete":
				deleteEmployee(request, response);
				break;
			default:
				break;
			}
		} else {
			listEmployees(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if (action != null) {
			switch (action) {
			case "add":
				addEmployee(request, response);
				break;
			case "update":
				updateEmployee(request, response);
				break;
			default:
				break;
			}
		} else {
			listEmployees(request, response);
		}
	}

	private void listEmployees(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hiiiii");
		List<Employee> employees = EmployeeDao.getAllEmployees();
		System.out.println("hello");
		System.out.println(employees);
		request.setAttribute("employees", employees);
		request.getRequestDispatcher("listEmployees.jsp").forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int empid = Integer.parseInt(request.getParameter("empid"));
		Employee employee = EmployeeDao.getEmployeeById(empid);
		request.setAttribute("employee", employee);
		request.getRequestDispatcher("editEmployee.jsp").forward(request, response);
	}

	private void addEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String empname = request.getParameter("empname");
		int empage = Integer.parseInt(request.getParameter("empage"));

		Employee employee = new Employee();
		employee.setEmpname(empname);
		employee.setEmpage(empage);
		System.out.println("adddddd");
		int status = EmployeeDao.addEmployee(employee);

		if (status > 0) {
			response.sendRedirect("EmployeeServlet");
		} else {
			request.setAttribute("message", "Failed to add employee");
			request.getRequestDispatcher("addEmployee.jsp").forward(request, response);
		}
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int empid = Integer.parseInt(request.getParameter("empid"));
		String empname = request.getParameter("empname");
		int empage = Integer.parseInt(request.getParameter("empage"));

		Employee employee = new Employee();
		employee.setEmpid(empid);
		employee.setEmpname(empname);
		employee.setEmpage(empage);

		int status = EmployeeDao.updateEmployee(employee);

		if (status > 0) {
			response.sendRedirect("EmployeeServlet");
		} else {
			request.setAttribute("message", "Failed to update employee");
			request.getRequestDispatcher("editEmployee.jsp").forward(request, response);
		}
	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int empid = Integer.parseInt(request.getParameter("empid"));
		int status = EmployeeDao.deleteEmployee(empid);

		if (status > 0) {
			response.sendRedirect("EmployeeServlet");
		} else {
			request.setAttribute("message", "Failed to delete employee");
			request.getRequestDispatcher("EmployeeServlet").forward(request, response);
		}
	}

}