package com.jcrosswords.integration;

import org.junit.Test;

import com.jcrosswords.Crossword;
import com.jcrosswords.TooLongEntryRequestedException;

/**
 * @author Ted Vinke
 */
public class CrosswordTest {

	@Test
	public void createCrossword() throws TooLongEntryRequestedException {
		Crossword crossword = new Crossword(10, 10);
		crossword.generate();
		crossword.printEntries();
	}
}
