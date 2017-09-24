package com.tcs.hyd;

import java.util.List;

public class StudentBean {
	private String student_name;
	private int student_id;
	private int age;
	private List list;
	private long ContactNo;
	
	public long getContactNo() {
		return ContactNo;
	}
	public void setContactNo(long contactNo) {
		ContactNo = contactNo;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String studentName) {
		student_name = studentName;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int studentId) {
		student_id = studentId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
