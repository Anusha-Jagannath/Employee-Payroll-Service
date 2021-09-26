package com.employee.payroll_service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

public class FileUtilTest {
	/**
	 * method to test file exists or not
	 */
	@Test
	public void givenFileName_AsInput_ShouldReturnTrue_IfExists() {
		FileUtil util = new FileUtil();
		util.isFileExists("demo.txt");
		Assert.assertTrue(util.isFileExists("demo.txt"));

	}

	/**
	 * method to test file not exists
	 * 
	 * @throws IOException
	 */
	@Test
	public void givenFileName_AsInput_ShouldReturnFalse_IfNotExists() throws IOException {
		FileUtil util = new FileUtil();
		util.deleteFile("demo2.txt");
		Assert.assertFalse(util.isFileExists("demo2.txt"));

	}

	/**
	 * method to test directory creation
	 * 
	 * @throws IOException
	 */
	@Test
	public void givenDirectoryName_ShoulCreateDirectory_ReturnTrue() throws IOException {
		FileUtil util = new FileUtil();
		util.createDirectory("lib");
		Assert.assertTrue(Files
				.isDirectory(Paths.get("/Users/anushajs/eclipse-workspace/Yml-training/payroll-service/data/lib")));
	}

	/**
	 * method to test empty file creation
	 * 
	 * @throws IOException
	 */
	@Test
	public void givenFileName_AsInput_ShouldCreateFile_ShouldReturntrue() throws IOException {
		FileUtil util = new FileUtil();
		util.createEmptyFile("demo2.txt");
		Assert.assertTrue(Files
				.exists(Paths.get("/Users/anushajs/eclipse-workspace/Yml-training/payroll-service/data/demo2.txt")));
	}

}
