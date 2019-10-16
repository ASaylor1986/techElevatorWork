package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileReader {

	public static void main(String[] args) {
		
		List <String> lineList = new ArrayList<>();

		File myFile = new File("input.txt");
	
		try (Scanner myScanner = new Scanner(myFile)){ // this is try with resources
		
			while (myScanner.hasNextLine()) {
			lineList.add(myScanner.nextLine());

			}
		}
		catch (FileNotFoundException e){
			System.out.println("File not found!");
		}
		
		Collections.shuffle(lineList);
		for (String line : lineList) {
		System.out.println(line);
		}
	}

}
