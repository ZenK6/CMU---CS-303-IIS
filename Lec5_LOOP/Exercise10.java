package Lec5_LOOP;

import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chieu cao h cua tam giac: ");
        int h = scanner.nextInt();

        // Vong lap ngoai cho cac dong
        for (int i = 1; i <= h; i++) {

            // In khoang trang dau dong
            for (int j = 1; j <= h - i; j++) {
                System.out.print(" ");
            }

            // In cac dau sao va khoang trang ben trong
            if (i == 1) {
                System.out.print("*");
            } else if (i == h) {
                // In dong cuoi cung dac
                for (int k = 1; k <= 2 * h - 1; k++) {
                    System.out.print("*");
                }
            } else {
                // In cac dong giua rong
                System.out.print("*");
                for (int k = 1; k <= 2 * i - 3; k++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            
            System.out.println();
        }
        
        scanner.close();
    }
}