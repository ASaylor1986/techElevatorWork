package com.techelevator;

public class QuizQuestions {
	private String question;
	private String[] answers = new String[4];
	private String answersInAString;
	private int correctAnswerIndex;

	public QuizQuestions(String questionAndAnswers) {
		String[] questionParts = questionAndAnswers.split("\\|");
		question = questionParts[0];
		for (int i = 1; i < questionParts.length; i++) {
			String ans = questionParts[i];
			if (ans.endsWith("*")) {
				correctAnswerIndex = i;
				ans = ans.substring(0, ans.length()-1);
			}
			answers[i-1] = ans;
			answersInAString = answers[i-1];
		}
	}
	public String getQuestion() {
		return question;
	}
	public String[] getAnswers() {
		return answers;
	}
	public int getCorrectAnswersIndex() {
		return correctAnswerIndex;
	}

	public String getAnswersInAString() {
		return answersInAString;
	}
}
