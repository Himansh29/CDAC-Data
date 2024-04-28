package com.validation;

import com.exception.CustomEmployeeException;

public interface Employeevalidation {

	public static void validatePhoneNo(String phone) throws CustomEmployeeException {
		if(!phone.matches("^[0-9]{10}$")) {
			throw new CustomEmployeeException("Phone number should consist of 10 numbers");
		}
	}
	
	public static void validateAdharNo(String adharNo) throws CustomEmployeeException {
		if(!adharNo.matches("^\\d{12}$")) {
			throw new CustomEmployeeException("Adhar number should consist 12 numbers!! Adhar No Exception!!!");
		}
	}
	
}
