package com.techelevator;

public class Exercises {

	/*
	 Given a string name, e.g. "Bob", return a greeting of the form "Hello Bob!".
	 helloName("Bob") → "Hello Bob!"
	 helloName("Alice") → "Hello Alice!"
	 helloName("X") → "Hello X!"
	 */
	public String helloName(String name) {
		
		String greeting = ("Hello " + name + "!");
		
		return greeting;
	}

	/*
	 Given two strings, a and b, return the result of putting them together in the order abba,
	 e.g. "Hi" and "Bye" returns "HiByeByeHi".
	 makeAbba("Hi", "Bye") → "HiByeByeHi"
	 makeAbba("Yo", "Alice") → "YoAliceAliceYo"
	 makeAbba("What", "Up") → "WhatUpUpWhat"
	 */
	public String makeAbba(String a, String b) {
		
		String pallendrome = (a + b + b + a);
		return pallendrome;
	}

	/*
	 The web is built with HTML strings like "<i>Yay</i>" which draws Yay as italic text. In this example,
	 the "i" tag makes <i> and </i> which surround the word "Yay". Given tag and word strings, create the
	 HTML string with tags around the word, e.g. "<i>Yay</i>".
	 makeTags("i", "Yay") → "<i>Yay</i>"
	 makeTags("i", "Hello") → "<i>Hello</i>"
	 makeTags("cite", "Yay") → "<cite>Yay</cite>"
	 */
	public String makeTags(String tag, String word) {
		
		String htmlStuffs = ("<" + tag + ">" + word + "</" + tag + ">");
		return htmlStuffs;
	}

	/*
	 Given an "out" string length 4, such as "<<>>", and a word, return a new string where the word is in the
	 middle of the out string, e.g. "<<word>>". Note: use str.substring(i, j) to extract the String starting
	 at index i and going up to but not including index j.
	 makeOutWord("<<>>", "Yay") → "<<Yay>>"
	 makeOutWord("<<>>", "WooHoo") → "<<WooHoo>>"
	 makeOutWord("[[]]", "word") → "[[word]]"
	 */
	public String makeOutWord(String out, String word) {
		
		String confusion1 = out.substring(0, 2);
		String confusion2 = out.substring(2, 4);
		String allTheConfusion = confusion1 + word + confusion2;
		
		return allTheConfusion;

	}

	/*
	 Given a string, return a new string made of 3 copies of the last 2 chars of the original string. The string
	 length will be at least 2.
	 extraEnd("Hello") → "lololo"
	 extraEnd("ab") → "ababab"
	 extraEnd("Hi") → "HiHiHi"
	 */
	public String extraEnd(String str) {
		
	String lastTwo = str.substring((str.length() -2));
	String tripleString = (lastTwo + lastTwo + lastTwo);
	
	return tripleString;


	}

	/*
	 Given a string, return the string made of its first two chars, so the String "Hello" yields "He". If the
	 string is shorter than length 2, return whatever there is, so "X" yields "X", and the empty string ""
	 yields the empty string "". Note that str.length() returns the length of a string.
	 firstTwo("Hello") → "He"
	 firstTwo("abcdefg") → "ab"
	 firstTwo("ab") → "ab"
	 */
	public String firstTwo(String str) {
		
		if (str.length() >= 2) {
		String beginChar = str.substring(0, 2);
		return beginChar;
		}
		else if (str.length() < 2) {
		String lessThanTwoChar = str.substring(0);
		return lessThanTwoChar;
		}
		else if (str.length() < 1);
		return " ";
	}

	/*
	 Given a string of even length, return the first half. So the string "WooHoo" yields "Woo".
	 firstHalf("WooHoo") → "Woo"
	 firstHalf("HelloThere") → "Hello"
	 firstHalf("abcdef") → "abc"
	 */
	public String firstHalf(String str) {
		
		if (str.length() % 2 == 0) {
			String evenChar = str.substring(0, (str.length() / 2));
			return evenChar;
		}
		if (str.length() % 2 == 1) {
			String oddChar = str;
			return oddChar;
		}
		return null; 
	}

	/*
	 Given a string, return a version without the first and last char, so "Hello" yields "ell".
	 The string length will be at least 2.
	 withoutEnd("Hello") → "ell"
	 withoutEnd("java") → "av"
	 withoutEnd("coding") → "odin"
	 */
	public String withoutEnd(String str) {
		
		String middleLetters = str.substring(1, (str.length() - 1));
		return middleLetters;
	}

	/*
	 Given 2 strings, a and b, return a string of the form short+long+short, with the shorter string
	 on the outside and the longer string on the inside. The strings will not be the same length, but
	 they may be empty (length 0).
	 comboString("Hello", "hi") → "hiHellohi"
	 comboString("hi", "Hello") → "hiHellohi"
	 comboString("aaa", "b") → "baaab"
	 */
	public String comboString(String a, String b) {
		
		if (a.length() > b.length()) {
			String aIsBigger = b + a + b;
			return aIsBigger;
		}
		if (b.length() > a.length()) {
			String bIsBigger = a + b + a;
			return bIsBigger;
		}
		return null;
	}

	/*
	 Given 2 strings, return their concatenation, except omit the first char of each. The strings will
	 be at least length 1.
	 nonStart("Hello", "There") → "ellohere"
	 nonStart("java", "code") → "avaode"
	 nonStart("shotl", "java") → "hotlava"
	 */
	public String nonStart(String a, String b) {
		
		String firstWord = a.substring(1, a.length());
		String secondWord = b.substring(1, b.length());
		String catWord = firstWord.concat(secondWord);
		
		return catWord;
	}

	/*
	 Given a string, return a "rotated left 2" version where the first 2 chars are moved to the end.
	 The string length will be at least 2.
	 left2("Hello") → "lloHe"
	 left2("java") → "vaja"
	 left2("Hi") → "Hi"
	 */
	public String left2(String str) {
		
		String firstTwo = str.substring(0, 2);
		String restOfWord = str.substring(2, str.length());
		String pigLatin = restOfWord.concat(firstTwo);
		
		return pigLatin;
	}

	/*
	 Given a string, return a "rotated right 2" version where the last 2 chars are moved to the start.
	 The string length will be at least 2.
	 right2("Hello") → "loHel"
	 right2("java") → "vaja"
	 right2("Hi") → "Hi"
	 */
	public String right2(String str) {
		
		String lastTwo = str.substring((str.length() - 2), str.length());
		String firstPartWord = str.substring(0, (str.length() - 2));
		String backOnFront = lastTwo.concat(firstPartWord);
		return backOnFront;
	}

	/*
	 Given a string, return a string length 1 from its front, unless front is false, in which case
	 return a string length 1 from its back. The string will be non-empty.
	 theEnd("Hello", true) → "H"
	 theEnd("Hello", false) → "o"
	 theEnd("oh", true) → "o"
	 */
	public String theEnd(String str, boolean front) {
		
		boolean back = false;
		String lastLetter = str.substring((str.length() - 1), str.length());
		String firstLetter = str.substring(0, 1);
		
		if (back) {
			return lastLetter;
		}
		if (front) {
			return firstLetter;
		}
		return lastLetter;
	}

	/*
	 Given a string, return a version without both the first and last char of the string. The string
	 may be any length, including 0.
	 withoutEnd2("Hello") → "ell"
	 withoutEnd2("abc") → "b"
	 withoutEnd2("ab") → ""
	 */
	public String withoutEnd2(String str) {
		
		
		String lessThanThree = "";
		
		if (str.length() > 2) {
			String noFirstLast = str.substring(1, (str.length() - 1));
			return noFirstLast;
		}

		return lessThanThree;
	}

	/*
	 Given a string of even length, return a string made of the middle two chars, so the string "string"
	 yields "ri". The string length will be at least 2.
	 middleTwo("string") → "ri"
	 middleTwo("code") → "od"
	 middleTwo("Practice") → "ct"
	 */
	public String middleTwo(String str) {
		
		String inTheMiddle = str.substring(((str.length() / 2) - 1), ((str.length() / 2) + 1));
		
		return inTheMiddle;
	}

	/*
	 Given a string, return true if it ends in "ly".
	 endsLy("oddly") → true
	 endsLy("y") → false
	 endsLy("oddy") → false
	 */
	public boolean endsLy(String str) {
		
		
		if ((str.length() >= 2)) {
			char ch1 = str.charAt(str.length() - 2);
			char ch2 = str.charAt(str.length() - 1);
			if ((ch1 == 'l') && (ch2 == 'y')) {
			return true;
			}	
			else {
			return false;
			}
		}

		return false;
	}

	/*
	 Given a string and an int n, return a string made of the first and last n chars from the string. The
	 string length will be at least n.
	 nTwice("Hello", 2) → "Helo"
	 nTwice("Chocolate", 3) → "Choate"
	 nTwice("Chocolate", 1) → "Ce"
	 */
	public String nTwice(String str, int n) {

		if (n == 1) {
			String letterOne = str.substring(0, 1);
			String letterTwo = str.substring((str.length() - 1), str.length());
			String twoLetters = letterOne.concat(letterTwo); 
			return twoLetters;
		}
		if (n >= 2) {
			String firstNString = str.substring(0, n);
			String lastNString = str.substring((str.length() - n), str.length());
			String newNString = firstNString.concat(lastNString);
			return newNString;
		}
		return "";
	}

	/*
	 Given a string and an index, return a string length 2 starting at the given index. If the index is
	 too big or too small to define a string length 2, use the first 2 chars. The string length will be
	 at least 2.
	 twoChar("java", 0) → "ja"
	 twoChar("java", 2) → "va"
	 twoChar("java", 3) → "ja"
	 */
	public String twoChar(String str, int index) {
		
		if ((index <= 0) || (index >= str.length() - 1)) {
			String firstTwo = str.substring(0, 2);
			return firstTwo;
		}
		if (index == (str.length() - 2)) {
			String lastTwo = str.substring(index);
			return lastTwo;
		}
		else if (index < (str.length() - 2)) {
			String chosenOnes = str.substring(index, (index + 2));
			return chosenOnes;
		}
		return "";
	}

	/*
	 Given a string of odd length, return the string length 3 from its middle, so "Candy" yields "and".
	 The string length will be at least 3.
	 middleThree("Candy") → "and"
	 middleThree("and") → "and"
	 middleThree("solving") → "lvi"
	 */
	public String middleThree(String str) {
		
		if (str.length() % 2 != 0) {
			String middleThree = str.substring(((str.length() - 3) /2), (str.length() - ((str.length() - 3) / 2)));
			return middleThree;
		}
		return null;
	}

	/*
	 Given a string, return true if "bad" appears starting at index 0 or 1 in the string, such as with
	 "badxxx" or "xbadxx" but not "xxbadxx". The string may be any length, including 0. Note: use .equals()
	 to compare 2 strings.
	 hasBad("badxx") → true
	 hasBad("xbadxx") → true
	 hasBad("xxbadxx") → false
	 */
	public boolean hasBad(String str) {
		int badLetters = str.indexOf("bad");
		
		if (badLetters == 1 || badLetters == 0) {
			String threeLetters = str.substring(badLetters, badLetters + 3);
			if (threeLetters.contentEquals("bad")) {
				return true;
			}
		}
	return false;
	}

	/*
	 Given a string and a non-negative int n, return a larger string that is n copies of the original string.
	 stringTimes("Hi", 2) → "HiHi"
	 stringTimes("Hi", 3) → "HiHiHi"
	 stringTimes("Hi", 1) → "Hi"
	 */
	public String stringTimes(String str, int n) {
		
		String multiWord = "";
		
		for (int i = 0; i < n; i ++) {
			multiWord += str; 
		}
		return multiWord;
	}

	/*
	 Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or
	 whatever is there if the string is less than length 3. Return n copies of the front;
	 frontTimes("Chocolate", 2) → "ChoCho"
	 frontTimes("Chocolate", 3) → "ChoChoCho"
	 frontTimes("Abc", 3) → "AbcAbcAbc"
	 */
	public String frontTimes(String str, int n) {
		String frontLetters = "";
		
		for (int i = 0; i < n; i ++) {
			if (str.length() < 3) {
				String firstLetters = str.substring(0);
				frontLetters += firstLetters; 
				
			}
			if (str.length() >= 3) {
				String threeLetters = str.substring(0, 3);
				frontLetters += threeLetters;
				
			}
		}
		return frontLetters;
	}

	/*
	 Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".
	 countXX("abcxx") → 1
	 countXX("xxx") → 2
	 countXX("xxxx") →
	 */
	public int countXX(String str) {
		int counter = 0;
		
		for (int i = 0; i < str.length() - 1; i ++) {
				if ((str.charAt(i) == ('x')) && (str.charAt(i + 1) == ('x'))) {
				counter ++;	
				}
			}
		return counter;
		}


	/*
	 Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".
	 doubleX("axxbb") → true
	 doubleX("axaxax") → false
	 doubleX("xxxxx") → true
	 */
	public boolean doubleX(String str) {

		if (str.contains("x")) {
			int firstX = str.indexOf("x");
			if (firstX != str.length() - 1 && str.charAt(firstX) == str.charAt(firstX + 1)) {
				return true;
			}
		}
		return false;
		}

	/*
	 Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".
	 stringBits("Hello") → "Hlo"
	 stringBits("Hi") → "H"
	 stringBits("Heeololeo") → "Hello"
	 */
	public String stringBits(String str) {
		String evenOnly = "";

		for (int i = 0; i <= str.length() - 1; i++) {
			if ((i) % 2 == 0) {
				char evenLetters = str.charAt(i);
				evenOnly += evenLetters; 
			}
		}
		return evenOnly;
	}

	/*
	 Given a non-empty string like "Code" return a string like "CCoCodCode".
	 stringSplosion("Code") → "CCoCodCode"
	 stringSplosion("abc") → "aababc"
	 stringSplosion("ab") → "aab"
	 */
	public String stringSplosion(String str) {
		String oneMoreEachTime = "";

		for (int i = 0; i <= str.length() - 1; i++) {
			String dividedWord = str.substring(0, (i + 1));
			oneMoreEachTime += dividedWord;
			
		}
		return oneMoreEachTime;
	}

	/*
	 Given a string, return the count of the number of times that a substring length 2 appears in the string and
	 also as the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring).
	 last2("hixxhi") → 1
	 last2("xaxxaxaxx") → 1
	 last2("axxxaaxx") → 2
	 */
	public int last2(String str) {
		int counter = 0;
		
		
		for (int i = 0; i < str.length() - 2; i ++) {
			char nextToLast = str.charAt(str.length() - 2);
			char lastLetter = str.charAt(str.length() - 1);
			if ((str.charAt(i)==nextToLast) && (str.charAt(i + 1)== (lastLetter))){
				counter ++;

			}
		}
		return counter;
	}

	/*
	 Given a string, return a version where all the "x" have been removed. Except an "x" at the very start or end
	 should not be removed.
	 stringX("xxHxix") → "xHix"
	 stringX("abxxxcd") → "abcd"
	 stringX("xabxxxcdx") → "xabcdx"
	 */
	public String stringX(String str) {
		String noXInString = str.replace("x", "");
		String xOnlyOnEnds = ("x" + noXInString + "x");
		
		if (str.length() == 1) {
			if (str.charAt(0) == ('x')) {
				return "x";
			}
		}
		for (int i = 0; i < str.length() - 1;) {
			
			if (str.charAt(0) == ('x') && (str.charAt(str.length() - 1) == ('x'))) {
				return xOnlyOnEnds;
			}
			
			else {
				return noXInString;
			}
		}
		return "";
	}

	

	/*
	 Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".
	 altPairs("kitten") → "kien"
	 altPairs("Chocolate") → "Chole"
	 altPairs("CodingHorror") → "Congrr"
	 */
	public String altPairs(String str) {
		
		
		if (str.length() < 3) {
			String onlyOne = str.substring(0, 2);
			return onlyOne;
		}
		else if ((str.length() <= 8)) {
			String justTwo = str.substring(0, 2) + str.substring(4, 6);
			return justTwo;
		}
		else if (str.length() == 10) {
			String allThreeLessThan11 = str.substring(0, 2) + str.substring(4, 6) + str.substring(8) + str.substring(9); 
			return allThreeLessThan11;
		}
		else if (str.length() >= 8) {
			String allThreeLessThan10 = str.substring(0, 2) + str.substring(4, 6) + str.substring(8);
			return allThreeLessThan10;
		}


return null;
	}

	/*
	 Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak" are removed, but
	 the "a" can be any char. The "yak" strings will not overlap.
	 stringYak("yakpak") → "pak"
	 stringYak("pakyak") → "pak"
	 stringYak("yak123ya") → "123ya"
	 */
	public String stringYak(String str) {
		
		if (str.contains("yak")) {
			String badWord = "yak" + "";
			String newString = str.replaceAll(badWord, "");
			return newString;
		}
		return null;
	}

}
