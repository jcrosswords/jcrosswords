package com.jcrosswords;

public final class Address implements Comparable<Address> {

	private final int row;
	
	private final int column;

	Address(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public int compareTo(Address another)
    {
        if (equals(another)) return 0;

        if (row == another.row)
        {
            return column - another.column;
        }

        return row - another.row;
    }
	
	
	
}
