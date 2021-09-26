package com.employee.payroll_service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Create an Employee Payroll Service to Read from the console and Write
 * Employee Payroll to a console
 */
public class EmployeePayrollService {

	static List<EmployeePayroll> list = new ArrayList<EmployeePayroll>();
	String path = "/Users/anushajs/eclipse-workspace/Yml-training/payroll-service/data/employee.txt";

	/**
	 * method to read employee details such as employee id, name, salary
	 */
	public void readEmployeeDetails() {

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
	private void printEmployeeDetails() {

		System.out.println("Writing employee details to console :\n" + list);
	}

	/**
	 * UC-4 Create an Employee Payroll Service to store Employee Payroll into a File named employee.txt
	 * 
	 * @param employeeList
	 */
	public void writeToFile(List<EmployeePayroll> employeeList) {
		final StringBuffer empBuffer = new StringBuffer();
		employeeList.forEach(new Consumer<EmployeePayroll>() {
			public void accept(EmployeePayroll employee) {
				String employeeDataString = employee.toString().concat("\n");
				empBuffer.append(employeeDataString);
			}
		});

		try {
			Files.write(Paths.get(path), empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * UC-5 Ability for Employee Payroll Service to print the Employee Payroll
	 * method to display the data from employee.txt
	 *
	 */
	public void printData() {
		try {
			Files.lines(new File(path).toPath()).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * UC-5 Ability for Employee Payroll Service to show number of
	 * 
	 * Entries - Using File IO Count method to return no of entries in the
	 * employee.txt file
	 * 
	 * @return
	 * @throws IOException
	 */
	public long countLines() throws IOException {
		long entries = 0;
		entries = Files.lines(new File(path).toPath()).count();
		return entries;
	}

}
