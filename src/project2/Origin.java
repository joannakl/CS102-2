package project2;

public class Origin implements Comparable<Origin>{
	String originName;
	int count;
	/**
	 * Constructs a new Origin with specified count and name
	 * @param originName name of Origin
	 * @param count Number of people originating from origin
	 * @throws IllegalArgumentException if count is less than 0
	 */
	public Origin(String originName, int count) throws IllegalArgumentException {
		if(count < 0) {
			throw new IllegalArgumentException("Invalid Size");
		}
		this.originName = originName; this.count = count;
		
	} 
	/**
	 * Returns the name of the Origin
	 * @return String of the name of the Origin
	 */
	public String getOriginName() {
		return originName;
	} 
	/**
	 * Returns count of Origin
	 * @return count of origin
	 */
	public int getCount() {
		return count;
	}
	
	/** Compares this object with the specified object for order. 
	 * @param o the object to be compared
	 * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
	 */
	@Override
	public int compareTo(Origin o) {
		if(this.count < o.getCount()) {
			return -1;
		} else if(this.count > o.getCount()) {
			return 1;
		} else {
			return originName.compareTo(o.getOriginName());
		}
	} 
	/**
	 * Indicates whether some object obj is "equal to" this one.
	 * Two Origin objects considered equal if their names and counts are the same.
	 * @return true if this object is the same as the o argument
	 */
	@Override
	public boolean equals(Object o) {
		if(o instanceof Origin) {
			if(this.compareTo((Origin) o) == 0) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Returns the string representation of this Origin.
	 * @returns the string representation of this Origin object 
	 */
	@Override
	public String toString() {
		return (originName + " " + count);
	}
}
