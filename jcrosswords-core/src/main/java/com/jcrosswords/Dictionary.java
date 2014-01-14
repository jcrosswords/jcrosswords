package com.jcrosswords;

import com.jcrosswords.dictionary.Entry;

/**
 * @author Ted Vinke
 */
public interface Dictionary {

	public Entry getRandom();

	public Entry getRandom(int length);

	public Entry getRandom(String pattern);

}
