package project3;

public class PossibleLocationsQueue implements PossibleLocations {

	private static int frontIndex, backIndex, capacity;
	private static Location[] locations;
	
	/**
	 * 
	 * @param c
	 */
	PossibleLocationsQueue(int totalCapacity) {
		frontIndex = 0;
		backIndex = 0;
		capacity = totalCapacity;
		locations = new Location[capacity];
	}

    /**
    * Add a Location object to this collection.
    * @param s object to be added
    * @throws NullPointerException if the given location is null
    */
	public void add(Location s) throws NullPointerException {
		// check locations is full or not
		if (s == null) {
			throw new NullPointerException("Location is null");
		}
		// insert element at the backIndex
		else {
			locations[backIndex] = s;
			backIndex++;
		}
		return;
	}

    /**
     * Remove the next object from this collection. The specific
     * item returned is determined by the underlying structure
     * by which this collection is represented.
     * @return the next object, or null if set is empty
     */
	public Location remove() {
		// return null if the set is empty
		if (this.isEmpty()) {
			return null;
		}
		
		else {
			for (int i = frontIndex; i < backIndex - 1; i++) {
				locations[i] = locations[i + 1];
			}

			// store 0 at backIndex indicating there's no element
			if (backIndex < capacity)
				locations[backIndex] = null;

			// decrement backIndex
			backIndex--;
		}
		return locations[frontIndex];
	}

	
    /**
     * Determines if this collection is empty or not.
     * @return  true, if set is empty, false, otherwise.
     */
	public boolean isEmpty() {
		return(frontIndex == backIndex ? true: false);
	}

}
