package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {
	
	static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
	

		System.out.println("Enter the path of the file to search: ");
		String sourcePath = userInput.nextLine();
		File sourceFile = new File(sourcePath);
		
		System.out.println("What is the search word you are looking for?");
		String searchString = userInput.nextLine();
		
		System.out.println("Should the search be case sensitive? (Y/N) ");
		String answer = userInput.nextLine();
		
		int counter = 0;

		if (sourceFile.exists() && sourceFile.isFile()) {
			try (Scanner sourceScanner = new Scanner(sourceFile)) {


					while (sourceScanner.hasNextLine()) {
						String line = sourceScanner.nextLine();
						//System.out.println(line);
						counter++;
						if (answer.equals("Y")) {
							if (line.contains(searchString)) {
								System.out.println(counter +") " +line);
							} 	
						} else {
							if (line.toLowerCase().contains(searchString.toLowerCase())) {
								System.out.println(counter +") " +line);
							} 	
						}
					}
			} catch (FileNotFoundException e) {
				System.out.println("Source file not found!");
			}

		} 
	else {
			System.out.println("The file to search does not exist, or is not a file!");
		}
	}	
}

//alices_adventures_in_wonderland.txt
