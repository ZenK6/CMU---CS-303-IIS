package Lec6_ARRAYS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ex8_SortAndSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>(); // Sử dụng ArrayList

        System.out.println("Nhap 5 so nguyen vao danh sach:");

        for (int i = 0; i < 5; i++) {
            System.out.print("Nhap so thu " + (i + 1) + ": ");
            numbers.add(scanner.nextInt());
        }

        System.out.println("Danh sach ban dau: " + numbers);

        Collections.sort(numbers);
        System.out.println("Danh sach sau khi sap xep: " + numbers);

        System.out.print("Nhap so can tim kiem: ");
        int searchNumber = scanner.nextInt();

        int foundIndex = numbers.indexOf(searchNumber);

        if (foundIndex != -1) {
            System.out.println("So " + searchNumber + " duoc tim thay tai index " + foundIndex + ".");
        } else {
            System.out.println("So " + searchNumber + " khong co trong danh sach.");
        }

        scanner.close();
    }
}