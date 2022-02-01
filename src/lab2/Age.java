package lab2;
import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your age (a positive integer): ");
        try {
        	double num = in.nextDouble();
        } catch (Exception InputMismatchException) {
        	System.out.println("Invalid input: Enter a *POSITIVE* *INTEGER*");
        	System.exit(0);
        }
        double num = in.nextDouble();
        if(num < 1 || (num % 1 != 0) ) {
        	System.out.print("Invalid input: Age not a positive integer");
        	System.exit(0);
        }else if (num > 200) {
        	System.out.print("Invalid input: Honestly you're too old to be on a computer");
        	System.exit(0);
        }
        System.out.println("Enter your name: ");
        String name = in.next();
        System.out.println(name + " is  " + num + " years old." );
        in.close();
    }
} 
// 