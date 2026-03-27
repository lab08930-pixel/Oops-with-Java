package org.fileio;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import src.org.oops.utils.ConsoleInput;

public class TestFileIO {
	public static void main(String[] args) {
		int choice = 0;
		final int MENU_WRITE = 1;
		final int MENU_READ = 2;
		final int MENU_ENCRPYT = 3;
		final int MENU_DECRYPT = 4;
		final int MENU_EXIT = 5;

		do {
			System.out.println("====================================================");
			System.out.println("1. Write to File");
			System.out.println("2. Read from File");
			System.out.println("3. Encrpyt File");
			System.out.println("4. Decrpyt File");
			System.out.println("====================================================");
			System.out.println("Enter your Choice: ");
			choice = ConsoleInput.getInt();

			switch (choice) {
			case MENU_WRITE: {
								System.out.println("Enter the full file path (e.g., C:\\\\temp\\\\test.txt):");
								String pathInput = ConsoleInput.getString();
								Path filePath = Paths.get(pathInput);
								System.out.print("Enter the text you want to write to the file: ");
						        String dataInput = ConsoleInput.getString();
						        
							}	
				break;
			
			case MENU_READ:{
							System.out.println("Read Content of File is: ");
							String pathInput = ConsoleInput.getString();
							Path filePath = Paths.get(pathInput);
							try {
						        String content = FileOperation.readFromFile(Paths.get("filePath"));
						        System.out.println(content);
						    } catch (IOException e) {
						        System.err.println("UI Error: " + e.getMessage());
						    }
							}
				break; 
			case MENU_ENCRPYT:{
								System.out.println("Read Content of File is: ");
								String pathInput = ConsoleInput.getString();
								Path sourcePath = Paths.get(pathInput);
								try {
							        String content = FileOperation.ProcessData(Paths.get("filePath"),12);
							        System.out.println(content);
							    } catch (IOException e) {
							        System.err.println("UI Error: " + e.getMessage());
							    }
								}
								
								
			}break;
			//case MENU_DECRYPT:{}break;
			//case MENU_EXIT:{}break;
			}while (choice != MENU_EXIT);

		} 
}
