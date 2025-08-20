package Lec4_ConditionalExpression;

import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        double n = scanner.nextDouble();

        double GTTuyetDoi = (n >= 0) ? n : -n;
        // toan tu 3 ngoi
        // style name = (dieukien) ? dung : sai ;
        // VD: Int a = (n > 0) > "n la gia tri duong" : "n la gia tri am" ;

        System.out.println("The absolute value is " + GTTuyetDoi);

        scanner.close();
    }
}