package Lec6_ARRAYS;

import java.util.Scanner;

public class Ex3_CountOccurrences {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("n > 0.");
            scanner.close();
            return;
        }

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        System.out.print("\nEnter number X to find: ");
        int x = scanner.nextInt();

        int count = 0;

        for (int element : arr) {
            if (element == x) {
                count++;
            }
        }
        
        System.out.print("Input: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + (i < n - 1 ? ", " : ""));
        }
        
        System.out.println("Number to find X: " + x);
        System.out.println("Output: The number " + x + " appears " + count + " times.");

        scanner.close();
    }
}