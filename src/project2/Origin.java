package project2;

public class Origin implements Comparable<Origin>{
	String originName;
	int count;
	public Origin(String originName, int count) throws IllegalArgumentException {
		if(count < 0) {
			throw new IllegalArgumentException("Invalid Size");
		}
		this.originName = originName; this.count = count;
		
	} 
	public String getOriginName() {
		return originName;
	} 
	public int getCount() {
		return count;
	}
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
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Origin) {
			if(this.compareTo((Origin) o) == 0) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return (originName + " " + count);
	}
}
