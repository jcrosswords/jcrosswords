package com.jcrosswords;

import org.junit.Before;
import org.junit.Test;

import com.jcrosswords.Crossword;

public class CrosswordTest {

	@Before
	public void setUp() {
	}

	@Test
	public void createCrossword() {
		Crossword crossword = new Crossword(10, 10);
	}

}
