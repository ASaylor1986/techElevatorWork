package com.techelevator;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;


public class RomanNumeralsTest {
	
	private RomanNumerals converter;
	
	@Before
	public void setup() {
		converter = new RomanNumerals();
	}
	
	
	@Test
	public void number_one_converts_to_roman_numeral() {
		String romanNumeral = converter.convert(1);
		Assert.assertEquals("I", romanNumeral);
	}
	
	@Test
	public void numbers_up_to_three_convert_to_roman_numerals() {
		Assert.assertEquals("II", converter.convert(2));
		Assert.assertEquals("III", converter.convert(3));
	}
	
	
	@Test
	public void multiples_of_one_thousand_convert_to_roman_numerals() {
		Assert.assertEquals("M", converter.convert(1000));
		Assert.assertEquals("MM", converter.convert(2000));
		Assert.assertEquals("MMM", converter.convert(3000));
	}
	
	@Test
	public void one_thousand_one_converts_to_roman_numeral() {
		Assert.assertEquals("MI", converter.convert(1001));
	}
	
	@Test
	public void multiples_of_one_hundred_convert_to_roman_numerals() {
		Assert.assertEquals("C", converter.convert(100));
		Assert.assertEquals("CC", converter.convert(200));
		Assert.assertEquals("CCC", converter.convert(300));
	}
	
	@Test
	public void multiples_of_ten_convert_to_roman_numerals() {
		Assert.assertEquals("X", converter.convert(10));
		Assert.assertEquals("XX", converter.convert(20));
		Assert.assertEquals("XXX", converter.convert(30));
	}
	
	@Test
	public void numbers_that_arent_weird_convert_to_roman_numerals() {
		Assert.assertEquals("XI", converter.convert(11));
		Assert.assertEquals("CCCXII", converter.convert(312));
		Assert.assertEquals("MCCIII", converter.convert(1203));
	}
	
	@Test
	public void numbers_that_involve_fives_convert_to_roman_numerals() {
		Assert.assertEquals("V", converter.convert(5));
		Assert.assertEquals("XV", converter.convert(15));
		Assert.assertEquals("VIII", converter.convert(8));
		Assert.assertEquals("L", converter.convert(50));
		Assert.assertEquals("D", converter.convert(500));
		Assert.assertEquals("DLV", converter.convert(555));
		
	}
	
	@Test
	public void numbers_that_are_weird_convert_to_roman_numerals() {
		Assert.assertEquals("IV", converter.convert(4));
		Assert.assertEquals("IX", converter.convert(9));
		Assert.assertEquals("MCM", converter.convert(1900));
		
		Assert.assertEquals("MMDCCXIV", converter.convert(2714));
	}
	

}
