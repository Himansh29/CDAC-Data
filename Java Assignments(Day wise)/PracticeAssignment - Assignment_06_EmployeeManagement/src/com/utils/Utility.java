package com.utils;

import static com.validation.Employeevalidation.validateAdharNo;
import static com.validation.Employeevalidation.validatePhoneNo;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.core.Employee;
import com.core.FullTimeEmployee;
import com.core.PartTimeEmployee;
import com.exception.CustomEmployeeException;

public interface Utility {

	public static Map<Integer, Employee> empMap = new HashMap<>();
	public static Scanner sc = new Scanner(System.in);

	public static int generateId() {
		return empMap.size() + 1;
	}

	public static void addFullTimeEmployee() throws CustomEmployeeException {

//		int empId, String empName, LocalDate joiningDate, String phoneNumber, String adharNo,
//		double monthlySal
		try {
			System.out.println("Enter Employee Name");
			String empName = sc.next();

			System.out.println("Enter date");
			String date = sc.next();

			System.out.println("Enter phone Number");
			String phoneNo = sc.next();
			validatePhoneNo(phoneNo);

			System.out.println("Enter adhar number");
			String adharNo = sc.next();
			validateAdharNo(adharNo);

			System.out.println("Enter full time employee sal");
			double sal = sc.nextDouble();

			int empId = generateId();

			FullTimeEmployee fteEmp = new FullTimeEmployee(empId, empName, LocalDate.parse(date), phoneNo, adharNo,
					sal);
			empMap.put(fteEmp.getEmpId(), fteEmp);

			System.out.println("Full Time Employee Added Successfully");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void addPartTimeEmployee() {

//		int empId, String empName, LocalDate joiningDate, String phoneNumber, String adharNo,
//		double monthlySal
		try {
			System.out.println("Enter Employee Name");
			String empName = sc.next();

			System.out.println("Enter date");
			String date = sc.next();

			System.out.println("Enter phone Number");
			String phoneNo = sc.next();
			validatePhoneNo(phoneNo);

			System.out.println("Enter adhar number");
			String adharNo = sc.next();
			validateAdharNo(adharNo);

			System.out.println("Enter Part Time Employee sal(Hourly)");
			double sal = sc.nextDouble();

			int empId = generateId();

			PartTimeEmployee fteEmp = new PartTimeEmployee(empId, empName, LocalDate.parse(date), phoneNo, adharNo,
					sal);
			empMap.put(fteEmp.getEmpId(), fteEmp);

			System.out.println("Part Time Employee Added Successfully");
		} catch (CustomEmployeeException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static void displayAllEmployee() {
		empMap.values().stream().forEach(i -> System.out.println(i));
	}

	public static void deleteEmployeeById() throws CustomEmployeeException {
		System.out.println("Enter Employee id to be generated");
		int id = sc.nextInt();

		if (empMap.containsKey(id)) {
			empMap.remove(id);
			System.out.println("Employee Removed successfully");
			return;
		}

		throw new CustomEmployeeException("Employee with id: " + id + "Not found");
	}

	public static void displayAllEmployeeSortedByDateOfJoining() {
		Comparator<Employee> comp = (o1, o2) -> o1.getJoiningDate().compareTo(o2.getJoiningDate());
		empMap.values().stream().sorted(comp).forEach(i -> System.out.println(i));
	}

	public static void searchEmployeeByAdharNumber() throws CustomEmployeeException {
		System.out.println();
		String Adharno = sc.next();

		for (Employee emp : empMap.values()) {
			if (emp.getAdharNo().equals(Adharno)) {
				System.out.println("Employee Found");
				System.out.println(emp);
				return;
			}
		}

		throw new CustomEmployeeException("Employee with adhar no: " + Adharno + " Doesn't exist!!");

	}
}
