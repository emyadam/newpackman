package nl.tudelft.jpacman.board;


public class UnitProduct {
	private Square square;

	/**
	* Returns the square this unit is currently occupying. Precondition: <code>hasSquare()</code>.
	* @return  The square this unit is currently occupying.
	*/
	public Square getSquare(Unit unit) {
		assert invariant(unit);
		assert square != null;
		return square;
	}

	/**
	* Tests whether the square this unit is occupying has this unit listed as one of its occupiers.
	* @return  <code>true</code> if the square this unit is occupying has this unit listed as one of its occupiers, or if this unit is currently not occupying any square.
	*/
	public boolean invariant(Unit unit) {
		return square == null || square.getOccupants().contains(unit);
	}

	/**
	* Occupies the target square iff this unit is allowed to as decided by {@link Square#isAccessibleTo(Unit)} .
	* @param target The square to occupy.
	*/
	public void occupy(Square target, Unit unit) {
		assert target != null;
		if (square != null) {
			square.remove(unit);
		}
		square = target;
		target.put(unit);
		assert invariant(unit);
	}

	/**
	* Leaves the currently occupying square, thus removing this unit from the board.
	*/
	public void leaveSquare(Unit unit) {
		if (square != null) {
			square.remove(unit);
			square = null;
		}
		assert invariant(unit);
	}

	/**
	* Returns whether this unit is currently on  a square.
	* @return  True iff the unit is occupying a square at the moment.
	*/
	public boolean hasSquare() {
		return square != null;
	}
}