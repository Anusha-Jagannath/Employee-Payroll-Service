package com.employee.payroll_service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {

	private final static String HOME = "/Users/anushajs/eclipse-workspace/Yml-training/payroll-service/data";

	/**
	 * method to check whether file exists or not
	 * 
	 * @param filename
	 * @return true if file exists else returns false
	 */
	public boolean isFileExists(final String filename) {
		String path = HOME + "/" + filename;
		if (Files.exists(Paths.get(path)))
			return true;
		else
			return false;
	}

	/**
	 * method to delete the file
	 * 
	 * @param filename
	 * @throws IOException
	 */
	public void deleteFile(final String filename) throws IOException {
		String path = HOME + "/" + filename;
		Files.delete(Paths.get(path));
	}

	/**
	 * method to create directory
	 * 
	 * @param directory name
	 * @throws IOException
	 */
	public void createDirectory(String directoryName) throws IOException {
		String path = HOME + "/" + directoryName;
		Files.createDirectory(Paths.get(path));
	}

	/**
	 * method to create empty file
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public void createEmptyFile(String fileName) throws IOException {
		File file = new File("demo1.txt");
		file.createNewFile();
		System.out.println("File: " + file);
	}

	public void listFilesDirectories(String path) throws IOException {

		// System.out.println(Files.list(Paths.get(path)));

		File dir = new File(path);
		File[] files = dir.listFiles();

		if (files != null && files.length > 0) {
			for (File file : files) {
				// Check if the file is a directory
				if (file.isDirectory()) {
					// We will not print the directory name, just use it as a new
					// starting point to list files from
					listFilesDirectories(file.getAbsolutePath());
				} else {
					// We can use .length() to get the file size
					System.out.println(file.getName() + " (size in bytes: " + file.length() + ")");
				}
			}
		}

	}

}
