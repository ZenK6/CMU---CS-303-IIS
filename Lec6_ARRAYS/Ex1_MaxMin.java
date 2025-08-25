package Lec6_ARRAYS;

import java.util.Scanner;

public class Ex1_MaxMin {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
            
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("So luong phan tu phai lon hon 0.");
            scanner.close();
            return;
        }
        
        int[] a = new int[n];
            
        for ( int i = 0; i < n ; i++){
            System.out.print("Enter " + (i+1) +"'s number: ");
            a[i] = scanner.nextInt();
        }
            
        int max = a[0];
        int min = a[0];
            

        for ( int i = 1; i < n ; i++){ 
            if(a[i] > max){
                max = a[i];
            }
            
            if(a[i] < min){
                min = a[i];
            }
        }
            
        System.out.println("Max: "+max);
        System.out.println("Min: "+min);
        
        scanner.close();
    }
}