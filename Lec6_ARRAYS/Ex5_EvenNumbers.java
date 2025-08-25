package Lec6_ARRAYS;

import java.util.Scanner;

public class Ex5_EvenNumbers {

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
    
    public static int[] filterEvenNumbers(int[] numbers) {
        
        int evenCount = 0;
        for (int element : numbers) {
            if (element % 2 == 0) {
                evenCount++;
            }
        }
        
        int[] evenArray = new int[evenCount];
        int currentIndex = 0; 

        for (int element : numbers) {
            if (element % 2 == 0) {
                evenArray[currentIndex] = element;
                currentIndex++;
            }
        }

        return evenArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("n > 0.");
            scanner.close();
            return;
        }
        
        int[] a = new int[n];
        
        for ( int i = 0; i < n ; i++){
            System.out.print("Enter element " + (i+1) + ": ");
            a[i] = scanner.nextInt();
        }
        
        scanner.close();

        int[] result = filterEvenNumbers(a);
        
        System.out.print("Input: ");
        printArray(a);
        System.out.println(); // Xuống dòng
        
        System.out.print("Output: ");
        printArray(result);
        System.out.println();
    }
}