package Lec4_ConditionalExpression;

import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap do dai ba canh cua mot tam giac:");
        System.out.print(" Canh 1: ");
        double a = scanner.nextDouble();
        System.out.print(" Canh 2: ");
        double b = scanner.nextDouble();
        System.out.print(" Canh 3: ");
        double c = scanner.nextDouble();

        if (a + b > c &&
            a + c > b &&
            b + c > a) {
            
            if (a == b && b == c) {
                System.out.println("day la tam giac deu.");
            } 
            else if (a == b || a == c || b == c) {
                System.out.println("day la tam giac can.");
            } 
            else {
                System.out.println("day la tam giac thuong.");
            }
        } else {
            System.out.println("Do dai cac canh nay khong the tao thanh mot tam giac hop le.");
        }
        scanner.close();
    }
}
