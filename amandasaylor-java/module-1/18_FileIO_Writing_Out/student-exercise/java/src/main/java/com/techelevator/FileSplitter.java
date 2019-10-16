package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileSplitter {
	
	private static String getNextFileName(File inputFile, int counter) {
		String fileName = inputFile.getName();
		String fileSub = fileName.substring(fileName.lastIndexOf('.'));
		String originName = fileName.substring(0, fileName.lastIndexOf('.'));		
		
		return originName + "-" + counter + fileSub;
	}

	public static void main(String[] args) {
		
		try (Scanner userInput = new Scanner(System.in)) {
			System.out.println("Where is the input file (please include the path to the file)?");
			String sourcePath = userInput.nextLine();
			
			try {
				File fileToRead = getFileAtPath(sourcePath);
				
				System.out.println("How many lines of text (max) should there be in the split files?");
				int linesPerFile = 0;
				boolean isPossible = false;
				
				while (!isPossible) {
					try {
						linesPerFile = userInput.nextInt();
						if (linesPerFile > 0) {
							isPossible = true;
						}
					} catch (InputMismatchException ex) {
						System.out.println("Cannot accept input, that was not a valid number. Please try again.");
					} finally {
						userInput.nextLine();
					}
				}
				try (Scanner stuffToPutInNewFiles = new Scanner(fileToRead)) {
					int fileCount = 1;
					while (stuffToPutInNewFiles.hasNextLine()) {
						String newFileInfo = getNextFileName(fileToRead, fileCount);
						File generatedFile = new File(fileToRead.getParentFile(), newFileInfo);
						try (PrintWriter fileOutput = new PrintWriter(generatedFile)) {
							for (int i = 0; i < linesPerFile; i++) {
								if (stuffToPutInNewFiles.hasNextLine()) {
									fileOutput.println(stuffToPutInNewFiles.nextLine());
								} else {
									break;
								}
							}
						}
						
						fileCount++;
					}
				}
				
			} catch (IOException ex) {
				System.out.println("Unable to complete request.");
				System.exit(1);
			}
		}
	}
	
	private static File getFileAtPath(String filePath) throws IOException {
		File myFile = new File(filePath);
		
		if (!myFile.exists()) {
			throw new FileNotFoundException("There was no file at " + filePath);
		}
		
		if (!myFile.isFile()) {
			throw new IOException(filePath + " is not a file.");
		}
		
		return myFile;
	}
	


}
