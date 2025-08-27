package Lec6_ARRAYS;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Ex11_SecondLargestElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Nhap cac so nguyen vao danh sach (nhap -1 de ket thuc):");
        
        while (true) {
            System.out.print("Nhap so: ");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number == -1) {
                    break;
                }
                numbers.add(number);
            } else {
                System.out.println("Dau vao khong hop le. Vui long nhap mot so nguyen.");
                scanner.next(); // Loai bo dau vao khong hop le
            }
        }
        
        if (numbers.size() < 2) {
            System.out.println("Danh sach phai co it nhat hai phan tu de tim so lon thu hai.");
        } else {
            // Su dung Collections.sort() de sap xep danh sach
            Collections.sort(numbers);

            // In danh sach da sap xep de de quan sat
            System.out.println("Danh sach da sap xep: " + numbers);
            
            // Tim phan tu lon thu hai
            int largest = numbers.get(numbers.size() - 1);
            int secondLargest = -1; // Khoi tao gia tri mac dinh
            
            // Duyet tu cuoi danh sach de tim phan tu lon thu hai
            for (int i = numbers.size() - 2; i >= 0; i--) {
                if (numbers.get(i) < largest) {
                    secondLargest = numbers.get(i);
                    break; // Thoat vong lap khi da tim thay
                }
            }
            
            if (secondLargest != -1) {
                System.out.println("Phan tu lon thu hai la: " + secondLargest);
            } else {
                System.out.println("Khong co phan tu lon thu hai (cac so deu bang nhau).");
            }
        }
        
        scanner.close();
    }
}