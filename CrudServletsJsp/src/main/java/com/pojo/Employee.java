package com.pojo;

public class Employee {
	private int empid;
    private String empname;
    private int empage;
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empage=" + empage + "]";
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public int getEmpage() {
		return empage;
	}
	public void setEmpage(int empage) {
		this.empage = empage;
	}
}
