package com.techelevator;

public class HomeworkAssignment {

	private int totalMarks;
	private int possibleMarks;
	private String submitterName;
	private String letterGrade;
	


	public HomeworkAssignment(int possibleMarks) {
		this.possibleMarks = possibleMarks;
	}

	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	
	public int getPossibleMarks() {
		return possibleMarks;
	}
	public String getSubmitterName() {
		return submitterName;
	}
	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
	}
	
	public String getLetterGrade() {
		double gradePercentage;
		gradePercentage = (double)totalMarks/(double)possibleMarks * 100;
		if (gradePercentage >= 90) {
			this.letterGrade = "A";
		}
		if (gradePercentage >= 80 && gradePercentage <90) {
			this.letterGrade = "B";
		}	
		if (gradePercentage >= 70 && gradePercentage < 80) {
			this.letterGrade = "C";
		}
		if (gradePercentage >= 60 && gradePercentage < 70) {
			this.letterGrade = "D";
		}
		if (gradePercentage < 60) {
			this.letterGrade = "F";
		}
		return letterGrade;
	}

	}	
