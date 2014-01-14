package com.jcrosswords;

import com.jcrosswords.dictionary.CrosswordEntry;

/**
 * @author Ted Vinke
 */
public abstract class Strategy {
	public abstract CrosswordEntry findEntry(Crossword cw) throws TooLongEntryRequestedException;

	public abstract void updateGrid(Grid grid, CrosswordEntry e);
}
