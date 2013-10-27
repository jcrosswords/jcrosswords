package com.jcrosswords;


public final class Crossword {
		
	private final int width;
	
	private final int height;
	
	private final Legend legend;

	Crossword(int width, int height, Legend legend) {
		this.width = width;
		this.height = height;
		this.legend = legend;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Legend getLegend() {
		return legend;
	}
	
}
