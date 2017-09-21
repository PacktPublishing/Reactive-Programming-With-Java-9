package com.packt.ch02.pojo;

public class Student {

	private String name;
	private int rollNo;
	private int total_marks;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public int getTotal_marks() {
		return total_marks;
	}

	public void setTotal_marks(int total_marks) {
		this.total_marks = total_marks;
	}

	public Student() {
		// TODO Auto-generated constructor stub
		this.name = "no name";
		this.rollNo = 0;
		this.total_marks = 0;
	}

	public Student(String name, int rollNo, int total_marks) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.rollNo = rollNo;
		this.total_marks = total_marks;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "\t" + rollNo + "\t" + total_marks;
	}


	
}
