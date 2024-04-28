package com.core;

import java.time.LocalDate;

public class FullTimeEmployee extends Employee {

	private double monthlySal;

	public FullTimeEmployee() {
		super();
	}

	public FullTimeEmployee(int id, String empName, LocalDate joiningDate, String phoneNumber, String adharNo,
			double monthlySal) {
		super(id, empName, joiningDate, phoneNumber, adharNo);
		this.monthlySal = monthlySal;
	}

	public FullTimeEmployee(double monthlySal) {
		super();
		this.monthlySal = monthlySal;
	}

	public double getMonthlySal() {
		return monthlySal;
	}

	public void setMonthlySal(double monthlySal) {
		this.monthlySal = monthlySal;
	}

	@Override
	public String toString() {
		return "FullTimeEmployee [monthlySal=" + monthlySal + ", getEmpId =" + getEmpId() + ", getEmpName ="
				+ getEmpName() + ", getJoiningDate =" + getJoiningDate() + ", getPhoneNumber =" + getPhoneNumber()
				+ ", getAdharNo =" + getAdharNo() + ", getClass =" + getClass() + ", hashCode =" + hashCode()
				+ ", toString =" + super.toString() + "]";
	}

}
