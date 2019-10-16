package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		
		File myAlice = new File("alices_adventures_in_wonderland.txt");
		int madHatterWordCounter = 0;
		int queenOfSentencesCounter = 0;

		try (Scanner myScanner = new Scanner(myAlice)) {	
			while(myScanner.hasNext()){
				String word = myScanner.next();
				madHatterWordCounter++;		
				if (word.endsWith(".")|| word.endsWith("?")|| word.endsWith("!")) {
					queenOfSentencesCounter++;
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		System.out.println("Word Count: " + madHatterWordCounter);
		System.out.println("Sentence Count: " + queenOfSentencesCounter);
	}

}
