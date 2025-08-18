package Lec4_ConditionalExpression;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Age: ");
        int n = scanner.nextInt();
        if (n < 12) {
            System.out.print("Child!!\n");
        } else if( n < 19) {
            System.out.print("Teenager\n");
        } else if(n < 59) {
            System.out.print("Adult\n");
        } else System.out.print("Senior");
    }
}
