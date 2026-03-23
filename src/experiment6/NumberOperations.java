package experiment6;
import java.util.Scanner;

public class NumberOperations {
    public static void main(String[] args) {
        
        // Create Scanner object for user input
        Scanner sc = new Scanner(System.in);
        
        // Take input from user
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        // Display square of the number
        int square = num * num;
        System.out.println("\nSquare of " + num + " is: " + square);
        
        // Display multiplication table
        System.out.println("\nMultiplication Table of " + num + ":");
        for(int i = 1; i <= 10; i++) {
            System.out.println(num + " x " + i + " = " + (num * i));
        }
        
        // Close scanner
        sc.close();
    }
}