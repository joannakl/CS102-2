package lab2;

import java.util.Scanner;

public class Age {
	public static boolean charInStr(String str, String[] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(str.contains(arr[i])) {
				return true;
			} 
		}
		return false;
		
	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your age (a positive integer): ");
        int num = 0;
        String ageLine;
        try {
        	ageLine = in.nextLine();
        	num = Integer.parseInt(ageLine);
        } catch (Exception InputMismatchException) {
        	System.out.println("Invalid input: Enter *A* *POSITIVE* *INTEGER*");
        	System.exit(0);
        }
        if(num < 1 || (num % 1 != 0) ) {
        	System.out.print("Invalid input: Age not a positive integer");
        	System.exit(0);
        } else if (num > 200) {
        	System.out.print("Invalid input: Too old, be younger");
        	System.exit(0);
        } else if (num < 10) {
        	System.out.print("Invalid input: Parental supervision required");
        	System.exit(0);
        }
        System.out.print("Enter your name: ");
        String name = in.nextLine();
        if(charInStr(name, new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"})){
        	System.out.print("Invalid input: Digit in name");
        	System.exit(0);
        }
        System.out.println(name + " is  " + num + " years old." );
        in.close();
    }
} 
// 