package Lec5_LOOP;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        int n = scanner.nextInt();
        
        int a = 1;
        for(int i=1; i <= n ; i++){
            for (int j = 1; j <= a;j++){
                System.out.print(j);
            }
            System.out.print("\n");
            a++;
        }
    }
}
