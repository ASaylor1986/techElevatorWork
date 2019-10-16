package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.println("What word would you like to search? ");
		String searchWord = userInput.nextLine();
		
		System.out.println("What word would you like to replace? ");
		String replacementWord = userInput.nextLine();
		
		System.out.println("Enter the path of the file to search: ");
		String sourcePath = userInput.nextLine();
		
		File sourceFile = new File(sourcePath);
		
		if (sourceFile.exists() && sourceFile.isFile()) {
			File destFile = new File("copy_" + sourceFile.getName());
			try (Scanner sourceScanner = new Scanner(sourceFile)) {
				if (destFile.createNewFile() || destFile.exists()) {
					try (PrintWriter destWriter = new PrintWriter(destFile)){
						while (sourceScanner.hasNextLine()) {
							String line = sourceScanner.nextLine();
							if (line.contains(searchWord)) {
								String newLine = line.replace(searchWord, replacementWord);
								destWriter.println(newLine);
							} else {
								destWriter.println(line);
							}
						}
						System.out.println("Your new files have been created.");
					}
				}	
			} catch (FileNotFoundException e) {
				System.out.println("Source file not found!");
			} catch (IOException e) {
				System.out.println("Can't create new file.");
			}
		}
		else {
			System.out.println("The file to search does not exist, or is not a file!");
		}
	}

}
