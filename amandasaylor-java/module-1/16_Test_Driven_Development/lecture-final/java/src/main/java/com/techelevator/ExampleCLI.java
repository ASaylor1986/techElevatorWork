package com.techelevator;

import java.util.Random;
import java.util.Scanner;

import com.techelevator.view.Menu;

public class ExampleCLI {

	private static final String MAIN_MENU_OPTION_PICK = "Pick a number to convert";
	private static final String MAIN_MENU_OPTION_ENTER = "Enter a number to convert";
	private static final String MAIN_MENU_OPTION_RANDOM = "Convert a random number";
	private static final String MAIN_MENU_OPTION_QUIT = "Quit this program";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_PICK, 
			 											MAIN_MENU_OPTION_ENTER,
			 											MAIN_MENU_OPTION_RANDOM,
			 											MAIN_MENU_OPTION_QUIT };

	private Menu menu;

	public ExampleCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		boolean finished = false;
		while (finished == false) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_PICK)) {
				
				int selectedValue = (Integer) menu.getChoiceFromOptions(new Integer[] {10, 100, 1000, 1985});
				
				RomanNumerals converter = new RomanNumerals();
				String roman = converter.convert(selectedValue);
				
				System.out.println("****");
				System.out.println(selectedValue + " converted to " + roman);
				System.out.println("****");
				
				
			} else if (choice.equals(MAIN_MENU_OPTION_ENTER)) {
				
				Scanner input = new Scanner(System.in);
				System.out.print("Please enter a number: ");
				int inputValue = input.nextInt();
				
				RomanNumerals converter = new RomanNumerals();
				String roman = converter.convert(inputValue);
				
				System.out.println("****");
				System.out.println(inputValue + " converted to " + roman);
				System.out.println("****");
				
				
			} else if (choice.equals(MAIN_MENU_OPTION_RANDOM)) {
				
				Random rand = new Random();
				int r = rand.nextInt(RomanNumerals.MAX_INPUT) + 1;
				RomanNumerals converter = new RomanNumerals();
				String roman = converter.convert(r);
				
				System.out.println("****");
				System.out.println(r + " converted to " + roman);
				System.out.println("****");
				
			} else if (choice.equals(MAIN_MENU_OPTION_QUIT)) {
				finished = true;
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		ExampleCLI cli = new ExampleCLI(menu);
		cli.run();
	}
}
