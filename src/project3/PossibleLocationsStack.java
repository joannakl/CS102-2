package project3;


class PossibleLocationsStack implements PossibleLocations {
	
	Node top;
	private class Node {
		Location data; 
		Node link;
	}

	public PossibleLocationsStack() {
		this.top = null;
	}
	
    /**
    * Add a Location object to this collection.
    * @param s object to be added
    * @throws NullPointerException if the given location is null
    */
	
	public void add(Location s) throws NullPointerException { 
		
		if(s == null) {
			throw new NullPointerException("Given location is null");
		}
		
		Node temp = new Node();

		temp.data = s;

		temp.link = top;

		top = temp;
	}


	public boolean isEmpty() {
		return top == null;
	}

    /**
     * Remove the next object from this collection. The specific
     * item returned is determined by the underlying structure
     * by which this collection is represented.
     * @return the next object, or null if set is empty
     */
	public Location remove() { 
		Node temp = new Node();
	
		if (top == null) {
			System.out.print("\nStack Underflow");
			return null;
		}

		temp.data = top.data;
		temp.link = top.link;
		top = (top).link;
		return temp.data;
	}

    /**
     * Returns the string representation of this collection.
     * The string representation consists of a list of the collection's
     * elements in the order they would be removed and returned by future
     * calls to remove(). The elements should be enclosed in square brackets (`"[]"`).
     * Adjacent elements are separated by the characters `", "` (comma and space).
     * @return the string representation of this collection
     */
	public String toString() {
		
		StringBuilder string = new StringBuilder();
		
		if (top == null) {
			return ("Empty Stack");
		} else {
			Node temp = top;
			while (temp != null) {
				string.append(temp.data + "\n");
				temp = temp.link;
			}
		}
		return string.toString();
	}




}
	// main class
	

