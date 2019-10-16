package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTest {
	
	private NonStart omitChar = new NonStart();
	
	@Test
	public void it_doesnt_like_any_name_i_pick() {
		
		String helloThere = omitChar.getPartialString("Hello", "There");

		String javaCode = omitChar.getPartialString("java", "code");

		String hotLava = omitChar.getPartialString("shotl", "java");

		String noA = omitChar.getPartialString("", "There");
		
		String noB = omitChar.getPartialString("java", "");
		
		

		
		
		Assert.assertEquals("ellohere", helloThere);
		Assert.assertEquals("avaode", javaCode);
		Assert.assertEquals("hotlava", hotLava);
		Assert.assertEquals("here", noA);
		Assert.assertEquals("ava", noB);
		
	}

}