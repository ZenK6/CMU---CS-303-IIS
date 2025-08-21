package Lec5_LOOP;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0 ;

        System.out.print("Nhap so lan lap: ");
        int a = scanner.nextInt();
        
        for ( int i = 1; i <= a; i++) {
            n = n + i;
        }
        
        System.out.print("==> Total: " + n);
        System.out.print("\n");
        scanner.close();
        
    }
}
