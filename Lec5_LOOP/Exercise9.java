package Lec5_LOOP;

import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = 1;
        int sum = 0;
        int count = 0;
        
        System.out.println("Tinh trung binh cua cac so ban nhap.");
        System.out.println("Enter '0' de stop.");
        
        while (number != 0) {
            System.out.print("Enter a number: ");
            number = scanner.nextInt();
            
            if (number != 0) {
                sum += number;
                count++;
            }
        }
        
        if (count > 0) {
            double average = (double) sum / count;
            System.out.println("The average is: " + average);
        } else {
            System.out.println("No numbers were entered, so the average cannot be calculated.");
        }
        
        scanner.close();
    }
}