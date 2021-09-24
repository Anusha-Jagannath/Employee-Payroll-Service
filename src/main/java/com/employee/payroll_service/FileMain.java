package com.employee.payroll_service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * program to demonstrate File Operations like - Check File Exists - Delete File
 * and Check File Not Exist - Create Directory - Create Empty File - List Files,
 * Directories as well as Files with extensions
 *
 */
public class FileMain {
	static String path = "/Users/anushajs/eclipse-workspace/Yml-training/payroll-service/data";

	public static void main(String[] args) throws IOException {
		FileUtil fileUtil = new FileUtil();
		// checking whether file exists or not
		System.out.println(fileUtil.isFileExists("demo.txt"));

		// deleting the file and checking whether file exists or not
		fileUtil.deleteFile("demo1.txt");
		System.out.println(fileUtil.isFileExists("demo1.txt"));

		// creating a directory
		fileUtil.createDirectory("lib");

		// create a empty file
		fileUtil.createEmptyFile("demo2.txt");

		// list directories and files
		fileUtil.listFilesDirectories(path);

		//watch service example
		Path dir = Paths.get(path);
		new Java8WatchServiceExample(dir).processEvents();
	}
}
