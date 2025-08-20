package Lec4_ConditionalExpression;

import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Three Number:\n");
        System.out.print(" [1] => ");
        double a = scanner.nextDouble();
        System.out.print(" [2] => ");
        double b = scanner.nextDouble();
        System.out.print(" [3] => ");
        double c = scanner.nextDouble();

        if (a >= b && a >= c) {
            System.out.println(a + " is Maximum number\n");
        } else if (b >= a && b >= c) {
            System.out.println(b + " is Maximum number\n");
        } else {
            System.out.println(c + " is Maximum number\n");
        }
        
        scanner.close();
    }
}