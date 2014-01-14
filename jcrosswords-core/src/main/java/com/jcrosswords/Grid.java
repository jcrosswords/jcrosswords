package com.jcrosswords;

import java.io.Serializable;
import java.util.LinkedList;

public class Grid implements Serializable {

	private GridCell[][] board;

	public Grid(int x, int y) throws Error {
		if (x <= 0 || y <= 0)
			throw new Error("Podano nieprawidłowy wymiar planszy: " + x + ", " + y);
		board = new GridCell[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				board[i][j] = new GridCell(i, j);
			}
		}
	}

	public int getWidth() {
		return board.length;
	}

	public int getHeight() {
		return board[0].length;
	}

	public GridCell getCell(int x, int y) {
		if (x >= getWidth()) {
			throw new IllegalArgumentException("Position x of " + x + " is beyond board width " + getWidth());
		}
		if (y >= getHeight()) {
			throw new IllegalArgumentException("Position y of " + y + " is beyond board height " + getHeight());
		}
		return board[x][y];
	}

	public void setCell(int x, int y, GridCell c) {
		if (x > getWidth()) {
			throw new IllegalArgumentException("Position x of " + x + " is beyond board width " + getWidth());
		}
		if (y > getHeight()) {
			throw new IllegalArgumentException("Position y of " + y + " is beyond board height " + getHeight());
		}
		board[x][y] = c;
	}

	public LinkedList<GridCell> getStartCells() {
		LinkedList<GridCell> startCells = new LinkedList<GridCell>();
		for (int i = 0; i < getWidth(); i++) {
			for (int j = 0; j < getHeight(); j++) {
				if (board[i][j].isHorizStart() || board[i][j].isVertStart()) {
					startCells.add(board[i][j]);
				}
			}
		}
		return startCells;
	}

	public LinkedList<GridCell> getHorizStartCells() {
		LinkedList<GridCell> startCells = new LinkedList<GridCell>();
		for (int i = 0; i < getWidth(); i++) {
			for (int j = 0; j < getHeight(); j++) {
				if (board[i][j].isHorizStart()) {
					startCells.add(board[i][j]);
				}
			}
		}
		return startCells;
	}

	public LinkedList<GridCell> getVertStartCells() {
		LinkedList<GridCell> startCells = new LinkedList<GridCell>();
		for (int i = 0; i < getWidth(); i++) {
			for (int j = 0; j < getHeight(); j++) {
				if (board[i][j].isVertStart()) {
					startCells.add(board[i][j]);
				}
			}
		}
		return startCells;
	}

	public String createPattern(int fromX, int fromY, int toX, int toY) {
		if (fromX == toX) {
			String pattern = new String();
			// int l = toY - fromY;
			pattern = "^";
			for (int i = fromY; i < toY; i++) {
				if (board[fromX][i].getContent() != null) {
					pattern += board[fromX][i].getContent();
				} else {
					pattern += ".";
				}
			}
			pattern += "$";
			return pattern;
		} else if (fromY == toY) {
			String pattern = new String();
			// int l = toX - fromX;
			pattern = "^";
			for (int i = fromX; i < toX; i++) {
				if (board[i][fromY].getContent() != null) {
					pattern += board[i][fromY].getContent();
				} else {
					pattern += ".";
				}
			}
			pattern += "$";
			return pattern;
		}

		return null;
	}

}
