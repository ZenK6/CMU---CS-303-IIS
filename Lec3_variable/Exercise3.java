package Lec3_variable;
//Chương trình nhập hai số nguyên và in ra tổng

import java.util.Scanner;

public class Exercise3 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

        System.out.print("Enter INT1: ");
        int so1 = scanner.nextInt();

        System.out.print("Enter INT2: ");
        int so2 = scanner.nextInt();

        int tong = so1 + so2;
        System.out.println("Total: " + tong);
        scanner.close();
    }
}
