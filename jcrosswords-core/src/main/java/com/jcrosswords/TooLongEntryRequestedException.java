package com.jcrosswords;

/**
 * @author Ted Vinke
 */
public class TooLongEntryRequestedException extends Exception {

	private static final long serialVersionUID = -2938840187776723921L;

	public TooLongEntryRequestedException(int length) {
		super("Unable to find an entry of length: " + length);
	}
}
