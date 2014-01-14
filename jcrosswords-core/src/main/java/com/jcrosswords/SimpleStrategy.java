package com.jcrosswords;

import com.jcrosswords.dictionary.CrosswordEntry;
import com.jcrosswords.dictionary.Entry;

public class SimpleStrategy extends Strategy {

	@Override
	public CrosswordEntry findEntry(Crossword cw) throws TooLongEntryRequestedException {

		if (cw.getGrid().getVertStartCells().size() > 0) {
			Entry entry = cw.getDictionary().getRandom(cw.getGrid().getHeight());
			if (entry == null) {
				throw new TooLongEntryRequestedException(cw.getGrid().getHeight());
			}
			CrosswordEntry e = new CrosswordEntry(entry, 0, 0, CrosswordEntry.Direction.VERTICAL);
			cw.addEntry(e, this);
			for (int i = 0; i < cw.getGrid().getWidth(); i++)
				for (int j = 0; j < cw.getGrid().getHeight(); j++) {
					cw.getGrid().getCell(i, j).disableVertStart();
					cw.getGrid().getCell(i, j).disableHorizStart();
				}
			for (int i = 0; i < e.getWord().length(); i++)
				cw.getGrid().getCell(0, i).enableHorizStart();
		}

		while (cw.getGrid().getHorizStartCells().size() > 0) {
			int fromY = cw.getGrid().getHorizStartCells().getFirst().getY();
			int fromX = cw.getGrid().getHorizStartCells().getFirst().getX();
			String s = cw.getGrid().getCell(fromX, fromY).getContent();
			int maxLength = cw.getGrid().getWidth() - 1;
			int counter = 0;
			Entry entry = null;
			do {
				entry = cw.getDictionary().getRandom("^" + s + "." + "{0," + Integer.toString(maxLength) + "}$");
				if (entry == null) {
					break;
				}
				counter++;
			} while ((cw.contains(entry.getWord()) && counter < 10));
			cw.getGrid().getCell(fromX, fromY).disableHorizStart();
			if (entry != null && !cw.contains(entry.getWord()))
				return new CrosswordEntry(entry, fromX, fromY, CrosswordEntry.Direction.HORIZONTAL);
		}

		return null;
	}

	@Override
	public void updateGrid(Grid grid, CrosswordEntry entry) {
		switch (entry.getDirection()) {
		case VERTICAL:
			for (int i = 0; i < entry.getWord().length(); i++) {
				grid.getCell(entry.getX(), entry.getY() + i).setContent(entry.getWord().substring(i, i + 1));
			}
			break;
		case HORIZONTAL:
			for (int i = 1; i < entry.getWord().length(); i++) {
				grid.getCell(entry.getX() + i, entry.getY()).setContent(entry.getWord().substring(i, i + 1));
			}
			break;
		}
	}

}
