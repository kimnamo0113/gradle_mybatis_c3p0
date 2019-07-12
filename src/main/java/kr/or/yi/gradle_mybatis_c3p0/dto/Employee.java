package kr.or.yi.gradle_mybatis_c3p0.dto;

import java.util.Date;

public class Employee {
	private int eno;
	private String ename;
	private int salary;
	private Department dno;
	private int gender;
	private Date joindate;
	private Title title;
	public Employee(int eno, String ename, int salary, Department dno, int gender, Date joindate, Title title) {
		this.eno = eno;
		this.ename = ename;
		this.salary = salary;
		this.dno = dno;
		this.gender = gender;
		this.joindate = joindate;
		this.title = title;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Department getDno() {
		return dno;
	}
	public void setDno(Department dno) {
		this.dno = dno;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	public Title getTitle() {
		return title;
	}
	public void setTitle(Title title) {
		this.title = title;
	}
	
	
}
