package Lec4_ConditionalExpression;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Grade: ");
        double n = scanner.nextDouble();
        if (n > 9) {
            System.out.print("Excellent\n");
        } else if( n > 8) {
            System.out.print("Good\n");
        } else if(n > 6.5) {
            System.out.print("Fair\n");
        } else if(n > 5) {
            System.out.print("Average\n");
        } else System.out.print("Fail\n");
    }
}
