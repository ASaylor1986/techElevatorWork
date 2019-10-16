package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class QuizMaker {
	
	static Scanner myScanner = new Scanner(System.in);

		public static void main(String[] args) {
			int questionsAsked = 0;
			int correctAnswers = 0;
			
			List <QuizQuestions> testList = new ArrayList<>();
			
			System.out.println("Where is the quiz file? ");
			String sourcePath = myScanner.nextLine();
			File myFile = new File(sourcePath);
			
			try (Scanner myScanner = new Scanner(myFile)) { 
				while (myScanner.hasNextLine()) {
					String questionString = myScanner.nextLine();
					QuizQuestions currentQuestion = new QuizQuestions(questionString);
					testList.add(currentQuestion);
				}
			}
			catch (FileNotFoundException e){
				System.out.println("File not found!");
			}
			for (QuizQuestions question : testList) {
				System.out.println(question.getQuestion());
				int counter = 0;
				for (String answer : question.getAnswers()) {
					counter++;
					System.out.println(counter +". " + answer);
				}
			
				
				String questionAnswer = myScanner.nextLine();
				
				int intQuestionAnswer = Integer.parseInt(questionAnswer);
				
				if (intQuestionAnswer == question.getCorrectAnswersIndex()) {
					System.out.println("Your answer: " + questionAnswer);
					System.out.println("Correct!");
					correctAnswers++;
				}
				else {
					System.out.println("Your answer: " + questionAnswer);
					System.out.println("Sorry that isn't correct!");
				}
				questionsAsked++;
								
			}
			System.out.println("You got " +correctAnswers + " answer(s) correct out of the total " +questionsAsked + " questions asked.");



		}

}
