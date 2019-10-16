package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

	public static void main(String[] args) {
		
		File myFile = new File("input.txt");
		try (Scanner myScanner = new Scanner(myFile)) {
			
			while (myScanner.hasNext()) {
				String currentLine = myScanner.next();
				System.out.print(currentLine);
			}
		
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}


	}

}
