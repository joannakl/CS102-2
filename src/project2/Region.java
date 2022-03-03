package project2;

import java.util.ArrayList;

public class Region {
	String name;
	ArrayList<Origin> origins = new ArrayList<Origin>();
	public Region (String name) throws IllegalArgumentException {
		if( (name == null) || name.isBlank() || name.isEmpty()) {
			throw new IllegalArgumentException("Invalid Name");
		}	
	}

	public boolean add(Origin origin) throws IllegalArgumentException {
		if(origin == null) {
			throw new IllegalArgumentException("Invalid Name");
		}
		for(int o = 0; o < origins.size(); o++) {
			if(origin.getOriginName().equals(origins.get(o).getOriginName())) {
				return true;
			} 
		}
		return false;
			
	} 

	public ArrayList<Origin> getByName( String keyword ) {
		ArrayList<Origin> keywordList = new ArrayList<Origin>();
		if( (keyword == null) || keyword.isBlank() || keyword.isEmpty() ) {
			throw new IllegalArgumentException("Invalid Name");
		}	
		for(int o = 0; o < origins.size(); o++) {
			if(origins.get(o).getOriginName().contains(keyword) ) {
				keywordList.add(origins.get(o));
			} 
		}
		return keywordList;
	}
	
	
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
	
	public String getRegionName() {
		return name;
	}

	public String toString() {
		StringBuilder msg = new StringBuilder();
		msg.append("REGION: foreign born populatiom ");
		for(int o = 0; o < origins.size(); o++) {
			msg.append(origins.get(o).getOriginName() + " " + origins.get(o).getCount());
		}
		return msg.toString();
	}
}
	
