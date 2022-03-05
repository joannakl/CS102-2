package project2;

import java.util.ArrayList;

public class RegionList extends ArrayList<Region>{
	/**
	 * A default constructor that creates an empty RegionList object
	 */
	public RegionList() {}
	
	/**
	 * Returns a Region object whose name matches the keyword, case insensitive.
	 * @throws IllegalArgumentException if name is blank, null, or empty
	 * @param keyword keyword Word to be searched among Origin objects
	 * @return Region matching keyword
	 */
	public Region getByName ( String keyword ) throws IllegalArgumentException {
		
		if( (keyword == null) || keyword.isBlank() || keyword.isEmpty() ) {
			throw new IllegalArgumentException("Invalid Name");
		}	
		for(int o = 0; o < this.size(); o++) {
			try {
				if(this.get(o).getRegionName().equalsIgnoreCase(keyword) ) {
					return this.get(o);
				} 
			} catch (Exception NullPointerException) {
				;
			}
		
		}
		return null;
	}


}
