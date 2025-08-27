package Lec6_ARRAYS;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Ex13_MergeSortedArrayLists {

    public static ArrayList<Integer> mergeSortedLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap cac so nguyen cho danh sach thu nhat da sap xep (nhap -1 de ket thuc):");
        ArrayList<Integer> list1 = readIntegersFromUser(scanner);
        Collections.sort(list1);
        System.out.println("Danh sach 1: " + list1);

        System.out.println("Nhap cac so nguyen cho danh sach thu hai da sap xep (nhap -1 de ket thuc):");
        ArrayList<Integer> list2 = readIntegersFromUser(scanner);
        Collections.sort(list2);
        System.out.println("Danh sach 2: " + list2);

        ArrayList<Integer> mergedList = mergeSortedLists(list1, list2);

        System.out.println("Danh sach sau khi noi: " + mergedList);

        scanner.close();
    }

    public static ArrayList<Integer> readIntegersFromUser(Scanner scanner) {
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            System.out.print("==> ");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number == -1) {
                    break;
                }
                list.add(number);
            } else {
                System.out.println("Dau vao khong hop le. Vui long nhap mot so nguyen.");
                scanner.next();
            }
        }
        return list;
    }
}
