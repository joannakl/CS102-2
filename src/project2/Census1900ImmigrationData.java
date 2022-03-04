package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import project1.Color;
import project1.ColorList;

public class Census1900ImmigrationData {
	public static void main(String[] args) {
		// Lines 7 to 22 taken from ColorConverter.java
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
		Scanner regionScanner = null;
		File f = new File(args[0]);
		try {
			CSV csv = new CSV(new Scanner(f));
			regionScanner = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.err.println("Error: the file "+ f.getAbsolutePath()+
					" cannot be opened for reading.\n");
			System.exit(2);
		}
		
		ColorList list = new ColorList(); 
		String line = null; 
		Scanner parseLine = null; 
		String colorName = null;
		String hexValue = null; 
		Color current = null;
		while (regionScanner.hasNextLine()) {
			try { 
				line = regionScanner.nextLine(); 
				parseLine = new Scanner(line);
				parseLine.useDelimiter(", "); 
				colorName = parseLine.next();
				hexValue = parseLine.next();
			}
			catch (NoSuchElementException ex ) {
				//caused by an incomplete or miss-formatted line in the input file
				System.err.println(line);
				continue; 	
			}
			try {
				current = new Color (hexValue.trim(), colorName.trim());
				list.add(  current  ); 
			}
			catch (IllegalArgumentException ex ) {
				//ignore this exception and skip to the next line 
			}
		}
		
	}
}
