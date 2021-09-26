package com.employee.payroll_service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class EmployeePayrollServiceTest {
	/**
	 * readData_FromConsole method is used to test reading employee data from
	 * console
	 */
	@Test
	public void readData_FromConsole() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		employeePayrollService.readEmployeeDetails();

	}

	/**
	 * printData_ToConsole method is used to test printing employee data to console
	 */
	@Test
	public void printData_ToConsole() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		employeePayrollService.printData();

	}

	/**
	 * method to test writing data to employee.txt by counting no of lines
	 * 
	 * @throws IOException
	 */
	@Test
	public void given3EmployeeDetails_WhenWrittenToFile_ShouldMatchEntries() throws IOException {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		EmployeePayroll employee = new EmployeePayroll(101, "Ragu", 10000);
		EmployeePayroll employee1 = new EmployeePayroll(102, "Sam", 20000);
		EmployeePayroll employee2 = new EmployeePayroll(103, "Mark", 30000);
		List<EmployeePayroll> list = new ArrayList<EmployeePayroll>();
		list.add(employee);
		list.add(employee1);
		list.add(employee2);
		employeePayrollService.writeToFile(list);
		employeePayrollService.printData();
		long entries = employeePayrollService.countLines();
		Assert.assertEquals(3, entries);
	}

	/**
	 * method to test display employee.txt data by counting no of lines
	 */
	@Test
	public void givenFileName_ShoulReadFile_DisplayFileContentAsOutput() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		long entries = employeePayrollService.readEmployeeFile();
		Assert.assertEquals(3, entries);

	}
}
