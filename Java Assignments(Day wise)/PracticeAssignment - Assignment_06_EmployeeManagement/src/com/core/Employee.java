package com.core;

import java.time.LocalDate;

public class Employee {

	private int empId;
	private String empName;
	private LocalDate joiningDate;
	private String phoneNumber;
	private String adharNo;

	public Employee() {
	}

	public Employee(int empId, String empName, LocalDate joiningDate, String phoneNumber, String adharNo) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.joiningDate = joiningDate;
		this.phoneNumber = phoneNumber;
		this.adharNo = adharNo;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

}
