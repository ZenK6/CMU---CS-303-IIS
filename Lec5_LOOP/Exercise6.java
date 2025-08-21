package Lec5_LOOP;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao day so: ");
        int number = scanner.nextInt();
        
        int sumOfDigits = 0;
        int originalNumber = number;

        while (number > 0) {
            int lastDigit = number % 10;
            sumOfDigits += lastDigit;
            number /= 10;
        }

        System.out.println("==> Total of " + originalNumber + " is: " + sumOfDigits);
        scanner.close();
    }
}