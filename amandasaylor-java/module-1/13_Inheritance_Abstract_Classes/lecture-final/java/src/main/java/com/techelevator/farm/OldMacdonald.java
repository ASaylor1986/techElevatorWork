package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OldMacdonald {
	public static void main(String[] args) {
		
		Cow bossie = new Cow();
		bossie.sleep();
		
		Pig wilbur = new Pig();
		wilbur.sleep();
		
		Cat shadow = new Cat();
		shadow.sleep();
		
		
		Singable[] farmStuff = new Singable[] {shadow, bossie, new Chicken(), wilbur, new Tractor()};
		
		for(Singable stuff : farmStuff) {
			String name = stuff.getName();
			String sound = stuff.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a "+name+", ee, ay, ee, ay, oh!");
			System.out.println("With a "+sound+" "+sound+" here");
			System.out.println("And a "+sound+" "+sound+" there");
			System.out.println("Here a "+sound+" there a "+sound+" everywhere a "+sound+" "+sound);
			if (stuff.getAd() != null) {
				System.out.println(stuff.getAd());
			}
			System.out.println();
		}
		

		
		
		
	}
}