package com.jcrosswords;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import com.jcrosswords.dictionary.CrosswordEntry;
import com.jcrosswords.dictionary.WebsterDictionary;

public class Crossword implements Serializable {

	private static final long serialVersionUID = -3724427571358847957L;

	private LinkedList<CrosswordEntry> entries;
	private Grid grid;
	private Dictionary dictionary;
	private Strategy strategy;

	public Crossword(int x, int y) {
		this(x, y, new Configuration());
	}

	public Crossword(int x, int y, Configuration configuration) {
		this.entries = new LinkedList<CrosswordEntry>();
		this.grid = new Grid(x, y);
		this.strategy = configuration.getStrategy();
		this.dictionary = configuration.getDictionary();
	}

	public Grid getGrid() {
		return grid;
	}

	public Iterator<CrosswordEntry> getEntryIterator() {
		return entries.iterator();
	}

	public Dictionary getDictionary() {
		return dictionary;
	}

	public boolean contains(String word) {
		ListIterator<CrosswordEntry> it = entries.listIterator();
		while (it.hasNext()) {
			if (it.next().getWord().equals(word))
				return true;
		}
		return false;
	}

	public final void addEntry(CrosswordEntry entry, Strategy strategy) {
		entries.add(entry);
		strategy.updateGrid(grid, entry);
	}

	public final void generate() throws TooLongEntryRequestedException {
		CrosswordEntry e = null;
		while ((e = strategy.findEntry(this)) != null) {
			addEntry(e, strategy);
		}
	}

	public void printEntriesOld() {
		for (int y = 0; y < grid.getHeight(); y++) {
			System.out.print(y + 1 + ")  ");
			for (int x = 0; x < grid.getWidth(); x++) {
				String content = grid.getCell(x, y).getContent();
				if (content != null) {
					System.out.print(" " + content + " ");
				}
				System.out.println();
			}
		}
	}

	public void printEntries() {
		for (int y = 0; y < grid.getHeight(); y++) {
			System.out.print(y + 1 + ")  ");
			for (int x = 0; x < grid.getWidth(); x++) {
				GridCell cell = grid.getCell(x, y);
				String content = cell.getContent();
				if (content == null) {
					content = "*";
				}
				System.out.print(" " + content + " ");
			}
			System.out.println();
		}
	}

	public void printClues() {
		ListIterator<CrosswordEntry> it = entries.listIterator();
		it.next();
		while (it.hasNext()) {
			CrosswordEntry e = it.next();
			System.out.println(e.getY() + 1 + ") " + e.getClue());
		}
	}

	public static final class Configuration {
		private Dictionary dictionary;
		private Strategy strategy;

		private Configuration() {
			this.dictionary = new WebsterDictionary();
			this.strategy = new SimpleStrategy();
		}

		private Dictionary getDictionary() {
			return dictionary;
		}

		public void setDictionary(Dictionary dictionary) {
			this.dictionary = dictionary;
		}

		private Strategy getStrategy() {
			return strategy;
		}

		public void setStrategy(Strategy strategy) {
			this.strategy = strategy;
		}

	}

}
