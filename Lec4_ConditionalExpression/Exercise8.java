package Lec4_ConditionalExpression;

import java.util.Scanner;

public class Exercise8 {
    public static int quadrant(double x, double y) {
        if (x > 0 && y > 0) {
            return 1;
        } else if (x < 0 && y > 0) {
            return 2;
        } else if (x < 0 && y < 0) {
            return 3;
        } else if (x > 0 && y < 0) {
            return 4;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter two numbers for coordinates (x, y): \n");
        System.out.print(" [x] => ");
        double x = scanner.nextDouble();
        System.out.print(" [y] => ");
        double y = scanner.nextDouble();
        System.out.print("The quadrant is in the " + quadrant(x, y));
        System.out.print(" quadrant \n");
        scanner.close();
    }
}