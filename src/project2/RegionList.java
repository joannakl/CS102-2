package project2;

import java.util.ArrayList;

public class RegionList extends Region{

	ArrayList<Region> regions;

	public RegionList(String name) {
		super(name);
		regions = new ArrayList<Region>();
	}
	
	@Override
	public Region getByName ( String keyword ) {
		
		if( (keyword == null) || keyword.isBlank() || keyword.isEmpty() ) {
			throw new IllegalArgumentException("Invalid Name");
		}	
		for(int o = 0; o < regions.size(); o++) {
			if(this.regions.get(o).getRegionName().equalsIgnoreCase(keyword) ) {
				return this.regions.get(o);
			} 
		}
		return null;
	}
	


}
