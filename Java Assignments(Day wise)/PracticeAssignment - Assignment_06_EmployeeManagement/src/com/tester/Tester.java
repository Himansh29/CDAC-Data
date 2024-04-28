package com.tester;

import static com.utils.Utility.*;

public class Tester {

	public static void main(String[] args) {

		boolean flag = false;

		try {
			while (!flag) {
				System.out.println();
				System.out.println("press 1 to: Add full time employee\r\n"
						+ "Press 2 to: Add part time employee\r\n"
						+ "Press 3 to: Delete an employee by Emp Id\r\n"
						+ "Press 4 to: Search employee details by Aadhaar number\r\n"
						+ "Press 5 to: Display all employee details\r\n"
						+ "Press 6 to: Display all employee details sorted by date of joining"
						+ "\nPress 7 to exit");
						System.out.println();
				switch (sc.nextInt()) {
				case 1:
					addFullTimeEmployee();
					break;
				case 2:
					addPartTimeEmployee();
					break;
				case 3:
					deleteEmployeeById();
					break;
				case 4:
					searchEmployeeByAdharNumber();
					break;
				case 5:
					displayAllEmployee();
					break;
				case 6:
					displayAllEmployeeSortedByDateOfJoining();
					break;
				case 7:
					flag = true;
					break;
				default:
					System.out.println("INCORRECT INPUT!!!");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
