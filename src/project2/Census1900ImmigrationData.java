package project2;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;

public class Census1900ImmigrationData {
	public static void main(String[] args) {
		
		/**
		 * The main() method of this program. 
		 * @param args array of Strings provided on the command line when the program is started; 
		 * the first string should be the name of the input file containing the .csv of regions. 
		 */
		// Lines 16 to 32 adapted from project1.ColorConverter.java
		//verify that the command line argument exists 
		if (args.length == 0) {
			System.err.println("Usage Error: the program expects file name as an argument.\n");
			System.exit(1);
		}
		
		File file = new File(args[0]); 
		if (!file.exists()){
			System.err.println("Error: the file "+ file.getAbsolutePath()+ 
											" does not exist.\n");
			System.exit(1);
		}
		if (!file.canRead()){
			System.err.println("Error: the file "+ file.getAbsolutePath()+
											" cannot be opened. \n");
			System.exit(1);
		}
		
		File f = new File(args[0]);
		CSV csv = null;
		try {
			csv = new CSV(new Scanner(f));
	
		} catch (FileNotFoundException e) { // taken from project1.color.java
			System.err.println("Error: the file "+ f.getAbsolutePath()+
					" cannot be opened for reading.\n");
			System.exit(2);
		}
		
		//Array containing each Origin name
		RegionList list = new RegionList();
		String[] origins = new String[] { " ", "Total foreign born","Africa","Asia (except China, Japan, and India)",
				"Atlantic Islands","Australia","Austria","Belgium","Bohemia","Canada (English) (includes Newfoundland)",
				"Canada (French) (includes Newfoundland)","Central America",
				"China","Cuba","Denmark","England","Europe (not otherwise specified)","Finland",
				"France","Germany","Greece","Holland","Hungary","India","Ireland","Italy","Japan",
				"Luxemburg","Mexico","Norway","Pacific Islands (except Phillipine Islands)",
				"Poland (Austrian)","Poland (German)","Poland (Russian)","Poland (unknown)",
				"Portugal","Roumania","Russia","Scotland","South America","Spain","Sweden","Switzerland","Turkey",
				"Wales","West Indies (except Cuba and Puerto Rico)","Other Countries","Born at Sea"};
		

		/**
		 *  Loop iterating over each row of the csv after the first 8, 
		 *  as the first 8 are non-states
		 *  Adds origin to list with corresponding name and count
		 */
		
		for(int i = 0; i < csv.getNumOfRows(); i++) {
			
			ArrayList<String> arr = csv.getNextRow();
			while(i > 8) {
				
				try {
					list.add(new Region(arr.get(0).toString()));
					
				} catch (Exception IllegalArgumentException) {
					continue;
				}
					for(int j = 1; j <= 47; j++) {
							list.get(i-9).add(new Origin(origins[j], Integer.parseInt(arr.get(j) ) ) );
					}
				break;
			}
			
			
		}

		//Interactive mode, adapted from project1.ColorConverter.java:
		
		Scanner searchQuery  = new Scanner (System.in); 
		String value = "";

		
		do {
			System.out.println("Enter one of the following instructions. \n\n"
							+ "REGION total\r\n"
							+ "REGION from ORIGIN\r\n"
							+ "REGION all\n" 
							+ "quit\r\n"
							+ "\r\n"
							+ "Replace REGION with your desired region, and ORIGIN with your desired place of origin (or its substring).\r\n"
							+ "------\r\n"
							+ "\r\n"
							+ "Enter your instruction:");
			//get query from the user
			value = searchQuery.nextLine();
			
			try {
				if(value.contains(" from ")) {
					String[] valueArr = value.split(" from ");
				
					for(int i = 0; i < list.getByName( valueArr[0].toString() ).getByName( valueArr[1].toString()).size();  i++) {
						System.out.println(list.getByName( valueArr[0].toString() ).getByName( valueArr[1].toString() ).get(i).getOriginName() + " " + list.getByName( valueArr[0].toString() ).getByName( valueArr[1].toString() ).get(i).getCount() );
					}
					continue;
				
				} else if (value.contains(" total") ) {
					String[] valueArr = value.split(" total");
				
					System.out.println(list.getByName(valueArr[0]).getRegionName() + ": Total foreign born population is " + list.getByName(valueArr[0]).getTotal() )  ;
					continue;
				
				} else if (value.contains(" all")) {
					String[] valueArr = value.split(" all");
					System.out.println(list.getByName(valueArr[0].toString() ) );
					continue;
				} else if (value.equalsIgnoreCase("quit")) { 
					break;
				} else {
					System.out.println("This is not a valid query. Try again.");
				}
				
			
			} catch (Exception NullPointerException) {
				System.out.println("No matches found. Try again.\n");
				
			}
		} while (!value.equalsIgnoreCase("quit"));     
		
		searchQuery.close();
		
		}
		
	
}

