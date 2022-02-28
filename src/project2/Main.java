package project2;
import java.io.*;  
import java.util.Scanner;  

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("C:/Users/josck/Documents/GitHub/CS102/src/project2/census1900_immigrant_data.csv"));  
		System.out.print(sc.nextLine());
		Origin o = new Origin(sc.next(), 3);   //sets the delimiter pattern  
		System.out.println(o.getOriginName());
		sc.close();  //closes the scanner 
	}
}
