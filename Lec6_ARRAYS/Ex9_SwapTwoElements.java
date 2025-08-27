package Lec6_ARRAYS;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex9_SwapTwoElements {

    // Phương thức hoán đổi hai phần tử trong ArrayList
    public static void swap(ArrayList<Integer> arrList, int index1, int index2) {
        if (arrList == null || index1 < 0 || index1 >= arrList.size() || index2 < 0 || index2 >= arrList.size()) {
            System.out.println("Cac chi so khong hop le hoac danh sach rong.");
            return;
        }

        int temp = arrList.get(index1);
        arrList.set(index1, arrList.get(index2));
        arrList.set(index2, temp);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> myArrayList = new ArrayList<>();

        System.out.println("Nhap cac so nguyen vao danh sach (nhap -1 de ket thuc):");

        while (true) {
            System.out.print("Nhap so: ");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number == -1) {
                    break;
                }
                myArrayList.add(number);
            } else {
                System.out.println("Dau vao khong hop le. Vui long nhap mot so nguyen.");
                scanner.next(); 
            }
        }

        System.out.println("Danh sach ban dau: " + myArrayList);

        if (myArrayList.size() < 2) {
            System.out.println("Khong the hoan doi vi danh sach khong du phan tu.");
        } else {
            System.out.print("Nhap chi so dau tien can hoan doi (tu 0 den " + (myArrayList.size() - 1) + "): ");
            int index1 = scanner.nextInt();

            System.out.print("Nhap chi so thu hai can hoan doi (tu 0 den " + (myArrayList.size() - 1) + "): ");
            int index2 = scanner.nextInt();
            
            swap(myArrayList, index1, index2);
            
            System.out.println("Danh sach sau khi hoan doi: " + myArrayList);
        }

        scanner.close();
    }
}