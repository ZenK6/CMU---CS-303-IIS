package Lec6_ARRAYS;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex14_RemoveElementsFromArrayList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Nhap cac so nguyen (nhap -1 de ket thuc):");
        
        while (true) {
            System.out.print("==> ");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number == -1) {
                    break;
                }
                numbers.add(number);
            } else {
                System.out.println("Dau vao khong hop le. Vui long nhap mot so nguyen.");
                scanner.next();
            }
        }
        
        System.out.println("Danh sach ban dau: " + numbers);

        for (int i = numbers.size() - 1; i >= 0; i--) {
            int currentNumber = numbers.get(i);
            if (currentNumber > 50) {
                numbers.remove(i);
            }
        }
        
        System.out.println("Danh sach sau khi loai bo cac so lon hon 50: " + numbers);
        
        scanner.close();
    }
}