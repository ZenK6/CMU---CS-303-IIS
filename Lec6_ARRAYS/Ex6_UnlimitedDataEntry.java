package Lec6_ARRAYS;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex6_UnlimitedDataEntry {
    public static void main(String[] args) {
        ArrayList<Integer> n = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter numbers (enter -1 to stop):");
        
        while (true) {
            System.out.print("==> ");
            int a = scanner.nextInt();
            
            if (a == -1) {
                break;
            }
            
            n.add(a);
        }
        
        int sum = 0;
        for (int number : n) {
            sum += number;
        }
        
        System.out.println("The numbers you entered are: " + n);
        System.out.println("The sum of the numbers is: " + sum);
        
        scanner.close();
    }
}