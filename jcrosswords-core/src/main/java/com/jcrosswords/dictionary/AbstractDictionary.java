package com.jcrosswords.dictionary;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jcrosswords.Dictionary;

/**
 * @author Ted Vinke
 */
public abstract class AbstractDictionary implements Dictionary, Serializable {

	private static final long serialVersionUID = 1808807155442527639L;

	protected LinkedList<Entry> entries = new LinkedList<Entry>();

	public Entry get(String word) {
		ListIterator<Entry> i = entries.listIterator();
		while (i.hasNext()) {
			Entry c = i.next();
			if (c.getWord().equals(word)) {
				return c;
			}
		}
		return null;
	}

	public void remove(String word) {
		ListIterator<Entry> i = entries.listIterator();
		while (i.hasNext()) {
			Entry c = i.next();
			if (c.getWord().equals(word)) {
				i.remove();
			}
		}
	}

	public int getSize() {
		return entries.size();
	}

	public void add(String word, String clue) {
		System.out.println("Adding: " + word + ", clue=" + clue);
		entries.add(new Entry(word, clue));
	}

	public void addOrdered(String word, String clue) {
		if (entries.size() == 0) {
			entries.add(new Entry(word, clue));
		} else {
			ListIterator<Entry> it = entries.listIterator();
			int index = 0;
			Entry tmp = null;

			while (it.hasNext()) {
				index = it.nextIndex();
				tmp = it.next();
				if (tmp.getWord().compareToIgnoreCase(word) > 0) {
					break;
				}
			}
			if (index == 0) {
				if (tmp.getWord().compareToIgnoreCase(word) > 0) {
					entries.addFirst(new Entry(word, clue));
				} else {
					entries.add(1, new Entry(word, clue));
				}
			} else if (index + 1 == entries.size()) {
				if (tmp.getWord().compareToIgnoreCase(word) > 0) {
					entries.add(index, new Entry(word, clue));
				} else {
					entries.addLast(new Entry(word, clue));
				}
			} else {
				entries.add(index, new Entry(word, clue));
			}
		}
	}

	public LinkedList<Entry> findAll(String pattern) {
		LinkedList<Entry> tmp = new LinkedList<Entry>();
		Pattern p = Pattern.compile(pattern);
		Matcher m;
		ListIterator<Entry> i = entries.listIterator();
		while (i.hasNext()) {
			Entry c = i.next();
			m = p.matcher(c.getWord());
			if (m.find()) {
				tmp.add(c);
			}
		}
		if (tmp.size() > 0)
			return tmp;
		return null;
	}

	public Entry getRandom() {
		int pos = (int) (Math.random() * getSize());
		return entries.get(pos);
	}

	public Entry getRandom(int length) {

		LinkedList<Entry> tmp = findAll("^.{" + length + "}$");
		if (tmp != null) {
			int pos = (int) (Math.random() * tmp.size());
			return tmp.get(pos);
		}
		return null;
	}

	public Entry getRandom(String pattern) {
		LinkedList<Entry> tmp = findAll(pattern);
		if (tmp != null) {
			int pos = (int) (Math.random() * tmp.size());
			return tmp.get(pos);
		}
		return null;
	}

}
