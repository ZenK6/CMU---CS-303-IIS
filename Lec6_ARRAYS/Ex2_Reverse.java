package Lec6_ARRAYS;

import java.util.Scanner;

public class Ex2_Reverse {
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static void reverseArray(int[] numbers) {
        int length = numbers.length;
        
        for (int i = 0; i < length / 2; i++) {
            
            int oppositeIndex = length - 1 - i;
            
            int temp = numbers[i];
            
            numbers[i] = numbers[oppositeIndex];
            
            numbers[oppositeIndex] = temp;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
            
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
            
        if (n <= 0) {
            System.out.println(" n > 0.");
            scanner.close();
            return;
        }
            
        int[] a = new int[n];
            
        for ( int i = 0; i < n ; i++){
            System.out.print("Enter " + (i+1) +"'s number: ");
            a[i] = scanner.nextInt();
        }
        
        System.out.print("Input: ");
        printArray(a);
        System.out.println();
            
        reverseArray(a);
        
        System.out.print("Output: ");
        printArray(a);
        System.out.println();
            
        scanner.close();
    }
}