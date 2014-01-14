package com.jcrosswords.dictionary;

import java.io.Serializable;

public class Entry implements Serializable {

	private static final long serialVersionUID = -2945146153800975015L;

	private String word;
	private String clue;

	public Entry(String word, String clue) {
		this.word = word;
		this.clue = clue;
	}

	public String getWord() {
		return word;
	}

	public String getClue() {
		return clue;
	}

}
