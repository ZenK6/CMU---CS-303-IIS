package Lec5_LOOP;

import java.util.Scanner;

public class Exercise8 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number from 1 to 10: ");
        int n = scanner.nextInt();
        
        while( n < 1 || n > 10){
            System.out.print("Invalid number, please try again: ");
            n = scanner.nextInt();
        }
        
        System.out.print("You entered the number " + n + "\n");
        scanner.close();
    }   
}
