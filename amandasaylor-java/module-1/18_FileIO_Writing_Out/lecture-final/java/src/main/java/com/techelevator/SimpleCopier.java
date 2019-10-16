package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SimpleCopier {

	public static void main(String[] args) {
		
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Enter the path of a file to copy: ");
		String sourcePath = userInput.nextLine();
		File sourceFile = new File(sourcePath);
		
		
		if (sourceFile.exists() && sourceFile.isFile()) {
			
			System.out.print("Enter the path to copy to: ");
			String destPath = userInput.nextLine();
			File destFile = new File(destPath);
			
			if (destFile.exists() == false) {
				try (Scanner sourceScanner = new Scanner(sourceFile)) {
					if (destFile.createNewFile()) {
						try (PrintWriter destWriter = new PrintWriter(destFile)) {
							while (sourceScanner.hasNextLine()) {
								String line = sourceScanner.nextLine();
								destWriter.println(line);
							}	
						}
						System.out.println("Copy finished.");
					} else {
						throw new IOException();
					}
				}
				catch (FileNotFoundException e) {
					System.out.println("Source file not found!");
				}
				catch (IOException e) {
					System.out.println("Couldn't create new file!");
				}
			} else {
				System.out.println("Destination already exists!");
			}
		} else {
			System.out.println("Can't copy that!");
		}
	}

}
