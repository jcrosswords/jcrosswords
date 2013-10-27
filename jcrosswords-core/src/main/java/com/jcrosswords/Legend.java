package com.jcrosswords;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Legend {

	 private final Map<Direction, Map<Address, Clue>> items;

	    @SuppressWarnings("serial")
		Legend(Map<Direction, Map<Address, Clue>> items)
	    {
	        this.items = Collections.unmodifiableMap(new HashMap<Direction, Map<Address, Clue>>()
	        {
	            {
	                for (Direction d : Direction.values())
	                {
	                    put(d, new HashMap<Address, Clue>());
	                }
	            }
	        });
	    }

	    void add(Direction direction, Address address, Clue question)
	    {
	        if (direction == null) throw new NullPointerException();

	        items.get(direction).put(address, question);

	        // check for layout
	    }

	    public Map<Address, Clue> getByDirection(Direction direction)
	    {
	        if (direction == null) throw new NullPointerException();

	        return items.get(direction);
	    }
}
