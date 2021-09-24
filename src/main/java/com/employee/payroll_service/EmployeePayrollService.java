package com.employee.payroll_service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Create an Employee Payroll Service to Read from the console and Write
 * Employee Payroll to a console
 */
public class EmployeePayrollService {

	static List<EmployeePayroll> list = new ArrayList<EmployeePayroll>();

	public static void main(String[] args) {
		readEmployeeDetails();
		printEmployeeDetails();

	}

	/**
	 * method to read employee details such as employee id, name, salary
	 */
	private static void readEmployeeDetails() {

		Scanner scanner = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee id ");
		int empId = scanner.nextInt();

		System.out.println("Enter employee name");
		String empName = sc.nextLine();

		System.out.println("Enter employee salary");
		float empSalary = sc.nextFloat();

		EmployeePayroll employee = new EmployeePayroll(empId, empName, empSalary);
		employee.setEmpId(empId);
		employee.setEmpName(empName);
		employee.setSalary(empSalary);
		list.add(employee);
	}

	/**
	 * method to print employee details to console
	 */
	private static void printEmployeeDetails() {

		System.out.println("Writing employee details to console :\n" + list);
	}

}
