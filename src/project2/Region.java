package project2;

import java.util.ArrayList;

public class Region {
	String name;
	int totalForeign = 0;
	
	ArrayList<Origin> origins = new ArrayList<Origin>();
	/**
	 * Constructs a new Region with the specified name
	 * @param name name of region
	 * @throws IllegalArgumentException if name is blank, null, or empty
	 */
	public Region (String name) throws IllegalArgumentException {
		if( (name == null) || name.isBlank() || name.isEmpty()) {
			throw new IllegalArgumentException("Invalid Name");
		}
		this.name = name;
	}
	
	/**
	 * Adds an Origin object to the list of places of origin associated with it
	 * @param origin origin to be added
	 * @return true if successful, false if unsuccessful due to origin already being associated with region
	 * @throws IllegalArgumentException if origin is null
	 */
	public boolean add(Origin origin) throws IllegalArgumentException {
		
		if(origin == null) {
			throw new IllegalArgumentException("Invalid Name");
		}
		
		for(int o = 0; o < 100; o++) {
			try {
				if(origin.getOriginName().equals(origins.get(o).getOriginName())) {
					continue;
				} else if(origin.getOriginName().toLowerCase().equals(origins.get(o).getOriginName().toLowerCase())) {
					break;
				} 
			} catch (Exception IndexOutOfBoundsException) {
				origins.add(origin);
				return true;
			}
			
		}
		return false;
			
	} 

	/**
	 * Retrieves a list of Origin objects based on the provided keyword.
	 * @param keyword Word to be searched among Origin objects
	 * @return Array of origins containing the keyword in origin.name
	 */
	public ArrayList<Origin> getByName( String keyword ) throws IllegalArgumentException {
		ArrayList<Origin> keywordList = new ArrayList<Origin>();
		
		if( (keyword == null) || keyword.isBlank() || keyword.isEmpty() ) {
			throw new IllegalArgumentException("Invalid Name");
		}
		
		for(int o = 0; o < 100; o++) {
			
			try { 
				if(origins.get(o).getOriginName().toLowerCase().contains(keyword.toLowerCase())) {
					keywordList.add(origins.get(o));
				} else {
					
					continue;
				}			
			} catch (Exception IndexOutOfBoundsException) {
				
				break;
			}
		}
		return (keywordList.size() == 0 ? null : keywordList );
	}
	
	/**
	 * Two Region objects are the same if they have identical names, case insensitive
	 * @param o Object to be compared
	 */
	@Override
	public boolean equals(Object o) {
		if(o instanceof Region) {
			Region r = (Region) o;
			if(this.name.equals(r.getRegionName())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns region name
	 * @return String region name
	 */
	public String getRegionName() {
		return name;
	}
	
	/**
	 * Returns total foreign born in the region
	 * @return total foreign born
	 */
	public int getTotal() {
		return this.totalForeign = this.getByName("Total foreign born").get(0).getCount();
	}
	@Override
	/**
	 *  Returns a multi-line String matching the following pattern

  		REGION: foreign born population
  		PLACE1  NUM1
  		PLACE2  NUM2
		(in which the PLACE1, PLACE2, are all places of origin with a non-zero count and NUM1,NUM2, are the corresponding counts)
	 
	 *@return a string in the above format
	 */
	public String toString() {
		
		
		StringBuilder msg = new StringBuilder();
		
		msg.append(this.name.toUpperCase() + " foreign born population ");
		for(int o = 0; o < 47; o++) {
			
			msg.append(origins.get(o).getOriginName() + " " + origins.get(o).getCount() + "\n");
			
		}
		return msg.toString();
	}
}
	
