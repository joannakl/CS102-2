package project2;

import java.util.ArrayList;

public class RegionList extends ArrayList<Region>{
	
	public RegionList() {}
	
	public Region getByName ( String keyword ) {
		
		if( (keyword == null) || keyword.isBlank() || keyword.isEmpty() ) {
			throw new IllegalArgumentException("Invalid Name");
		}	
		for(int o = 0; o < this.size(); o++) {
			if(this.get(o).getRegionName().equalsIgnoreCase(keyword) ) {
				return this.get(o);
			} 
		}
		return null;
	}
	


}
