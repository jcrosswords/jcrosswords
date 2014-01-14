package com.jcrosswords;

import org.junit.Before;
import org.junit.Test;

import com.jcrosswords.Grid;

public class GridTest {

	@Before
	public void setUp() {
	}

	@Test
	public void testCreatePattern() {
		Grid grid = new Grid(10, 10);
		String pattern = grid.createPattern(2, 5, 2, 4);
		System.out.println("Pattern: " + pattern);
	}

}
