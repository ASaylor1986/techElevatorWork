package com.techelevator;

public class FruitTree {
	
	private String typeOfFruit;
	private int piecesOfFruitLeft;
	private int startingPiecesOfFruit;
	private int numberOfPiecesToRemove;

	public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
	this.typeOfFruit = typeOfFruit;
	this.piecesOfFruitLeft = startingPiecesOfFruit - numberOfPiecesToRemove;
	}

	public String getTypeOfFruit() {
		return typeOfFruit;
	}

	public int getStartingPiecesOfFruit(int startingPiecesOfFruit) {
		return startingPiecesOfFruit;
	}
	public boolean pickFruit(int numberOfPiecesToRemove) {
		boolean pickedSomeFruit = false;
		if (numberOfPiecesToRemove <= startingPiecesOfFruit) {
			pickedSomeFruit = true;
			this.piecesOfFruitLeft = startingPiecesOfFruit - numberOfPiecesToRemove;
		}
		if (numberOfPiecesToRemove <= piecesOfFruitLeft) {
			pickedSomeFruit = true;
			this.piecesOfFruitLeft = piecesOfFruitLeft - numberOfPiecesToRemove;
		}

		return pickedSomeFruit;
	}
	public int getPiecesOfFruitLeft() {
		return piecesOfFruitLeft;
	}
	
}