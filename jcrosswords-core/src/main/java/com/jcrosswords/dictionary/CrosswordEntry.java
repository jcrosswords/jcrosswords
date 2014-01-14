package com.jcrosswords.dictionary;

import java.io.Serializable;

public class CrosswordEntry extends Entry implements Serializable {

	private static final long serialVersionUID = -5004935387115283951L;

	public enum Direction {
		HORIZONTAL, VERTICAL;
	}

	private int x;
	private int y;
	private Direction d;

	public CrosswordEntry(Entry e, int x, int y, Direction direction) {
		super(e.getWord(), e.getClue());
		this.x = x;
		this.y = y;
		this.d = direction;
	}

	public CrosswordEntry(String word, String clue, int x, int y, Direction direction) {
		super(word, clue);
		this.x = x;
		this.y = y;
		this.d = direction;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Direction getDirection() {
		return d;
	}

}
