package Lec5_LOOP;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap vao bang cuu chuong muon hien: ");
        
        int n = scanner.nextInt();
        
        for (int i = 1; i <= 10; i++){
            System.out.print("==>" + n + "*" + i + " = " + n*i + "\n" );
        }
        
        scanner.close();
       
    }
    
}
