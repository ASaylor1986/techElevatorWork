package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	public static void main(String[] args) {
		
		File myFile = new File("input.txt");
		try (Scanner myScanner = new Scanner(myFile)) {
			
			while (myScanner.hasNextLine()) {
				String currentLine = myScanner.nextLine();
				System.out.println(currentLine);
			}
		
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}


	}

}
