package Lec5_LOOP;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter n = ");
        int n = scanner.nextInt();
        int a = 1;
        for (int i = 1; i <= n ; i++){
            a *=i;
        }
        System.out.print("The factorial of " + n + " is: " + a + "\n");
        scanner.close();
    }
}
