package com.jcrosswords.dictionary;

/**
 * Webster's New International Dictionary, Second Edition.
 * <p>
 * Single words - 234,936 entries before filtering.
 * 
 * @author Ted Vinke
 */
public class WebsterDictionary extends InputstreamDictionary {

	private static final long serialVersionUID = 2418374772575454870L;

	private static final String FILE_NAME = "/dictionary/webster/web2.txt";

	public WebsterDictionary() {
		super(WebsterDictionary.class.getResourceAsStream(FILE_NAME));
	}

}
