package Lec5_LOOP;

import java.util.Scanner;
//PRIME NUMBER LA SO NGUYEN TO
public class Exercise12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n ( n > 1 ) : ");
        int N = scanner.nextInt();

        if (N <= 1) {
            System.out.println(N + " is not a prime number.");
            scanner.close();
            return;
        }

        boolean SNT = true;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                SNT = false;
                break;
            }
        }

        if (SNT) {
            System.out.println(N + " is a prime number.");
        } else {
            System.out.println(N + " is not a prime number.");
        }

        scanner.close();
    }
}
