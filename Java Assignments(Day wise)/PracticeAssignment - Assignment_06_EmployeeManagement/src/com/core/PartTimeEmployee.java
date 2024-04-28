package com.core;

import java.time.LocalDate;

public class PartTimeEmployee extends Employee {

	private double hourlySal;

	public PartTimeEmployee(double hourlySal) {
		super();
		this.hourlySal = hourlySal;
	}

	public PartTimeEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PartTimeEmployee(int id, String empName, LocalDate joiningDate, String phoneNumber, String adharNo, double hourlySal) {
		super(id,empName, joiningDate, phoneNumber, adharNo);
		this.hourlySal = hourlySal;
	}

	public double getHourlySal() {
		return hourlySal;
	}

	public void setHourlySal(double hourlySal) {
		this.hourlySal = hourlySal;
	}

	@Override
	public String toString() {
		return "PartTimeEmployee [hourlySal=" + hourlySal + ", getEmpId()=" + getEmpId() + ", getEmpName()="
				+ getEmpName() + ", getJoiningDate()=" + getJoiningDate() + ", getPhoneNumber()=" + getPhoneNumber()
				+ ", getAdharNo()=" + getAdharNo() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
