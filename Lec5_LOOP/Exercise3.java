package Lec5_LOOP;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Height: ");
        int h = scanner.nextInt();
        
        System.out.print("Enter Width: ");
        int w = scanner.nextInt();
        
        for(int i = 1; i <= h;i++){
            for(int j = 1; j <= w;j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
