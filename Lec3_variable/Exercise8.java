package Lec3_variable;
//Create a program that uses next() to read multiple words from a user and prints each word on a separate line.
import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter: :");
        String tu1 = scanner.next();
        String tu2 = scanner.next();
        String tu3 = scanner.next();
        System.out.println("Word-1: " + tu1);
        System.out.println("Word-2: " + tu2);
        System.out.println("Word-3: " + tu3);
        scanner.close();
    }
}
