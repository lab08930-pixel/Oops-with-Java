package org.fileio;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class FileOperation {
	public static String readFromFile(Path filePath) throws IOException {
	    File file = filePath.toFile();
	    
	
	    if (!file.exists()) {
	        throw new IOException("File not found at: " + filePath.toString());
	    }

	    try (FileInputStream fileStream = new FileInputStream(file)) {
	        int size = (int) file.length();
	        byte[] data = new byte[size];
	        
	   
	        int bytesRead = fileStream.read(data);
	        
	        if (bytesRead == -1 && size > 0) {
	            throw new IOException("Could not read data from file.");
	        }

	        return new String(data);
	    }
	   }
	public static String writeToFile(String data, Path filePath) throws IOException {

	    File file = filePath.toFile();

	    try (FileOutputStream fileStream = new FileOutputStream(file)) {

	        byte[] bytesToWrite = data.getBytes();
	        fileStream.write(bytesToWrite);
	        return filePath.toString();
	        
	    } catch (IOException e) {
	        throw new IOException("Could not write to file at: " + filePath.toString(), e);
	    }
	}

	public static void directoryMarked() {
		File objFile = new File("E:\\Oops with Java\\INPUT.txt");

		File[] arrFiles = objFile.listFiles();
		for (File singleEntry : arrFiles) {
			if (singleEntry.isDirectory()) {
				System.out.println("[" + singleEntry.getName() + "]");
			} else {
				System.out.println(singleEntry.getName());
			}

		}
	}

	public static void listDirectory() {
		File objFile = new File("E:\\Oops with Java\\INPUT.txt");
		if (objFile.isDirectory()) {
			String[] contents = objFile.list();
			for (String entry : contents) {
				System.out.println(entry);
			}
		}
	}
	//babaM34
	public static String ProcessData(Path sourcePath, int key)throws IOException
	{
			String data = readFromFile(sourcePath);
	        StringBuilder encrypted = new StringBuilder();

	        for (int i = 0; i < data.length(); i++) {
	            char ch = data.charAt(i);
	            char shifted = ch; // Default: don't change it (for spaces, symbols, etc.)

	            if (Character.isUpperCase(ch)) {
	                shifted = (char) ((ch - 'A' + key % 26 + 26) % 26 + 'A');
	            } 
	            else if (Character.isLowerCase(ch)) {
	                shifted = (char) ((ch - 'a' + key % 26 + 26) % 26 + 'a');
	            } 
	            else if (Character.isDigit(ch)) {
	             
	                shifted = (char) ((ch - '0' + key % 10 + 10) % 10 + '0');
	            }

	            encrypted.append(shifted);
	        }
	        
	        return encrypted.toString();
	   
	}
	
}
	

