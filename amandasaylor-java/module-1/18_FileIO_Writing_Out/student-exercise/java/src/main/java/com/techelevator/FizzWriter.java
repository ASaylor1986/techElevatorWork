package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class FizzWriter {

	public static void main(String[] args) {

		File createdFile = new File("FizzBuzz.txt");
		
		try {
			if (createdFile.createNewFile() || createdFile.exists()) {
				try (PrintWriter destWriter = new PrintWriter(createdFile)) {
					for (int i = 1; i <=300; i++) {
						if (i%3 == 0 && i%5 == 0) {
							destWriter.println("FizzBuzz");
						}
						else if (i%3 == 0 || String.valueOf(i).contains("3")==true) {
							destWriter.println("Fizz");
						}
						else if(i%5 == 0 || String.valueOf(i).contains("5")==true) {
							destWriter.println("Buzz");
						}
						else if (i%3!=0 && i%5!=0 && String.valueOf(i).contains("3")==false && String.valueOf(i).contains("5")==false){
							destWriter.println(i);
						}
						
					}
					System.out.println("FizzBuzz.txt has been created.");
				}
			}
			
		} catch (IOException e) {
			System.out.println("Can't create new file.");
		}
	}

}
