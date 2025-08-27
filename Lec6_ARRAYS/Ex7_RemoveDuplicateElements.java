package Lec6_ARRAYS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ex7_RemoveDuplicateElements {

    public static ArrayList<Integer> removeDuplicates(ArrayList<Integer> originalList) {
        ArrayList<Integer> uniqueList = new ArrayList<>();
        for (Integer element : originalList) {
            if (!uniqueList.contains(element)) {
                uniqueList.add(element);
            }
        }
        return uniqueList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> inputList = new ArrayList<>();

        System.out.println("Enter number ('-1' to stop) :");

        while (true) {
            System.out.print("==>: ");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number == -1) {
                    break;
                }
                inputList.add(number);
            } else {
                System.out.println("KHONG HOP LE.");
                scanner.next();
            }
        }

        scanner.close();

        if (inputList.isEmpty()) {
            System.out.println("DONT HAVE NUMBER.");
        } else {
            System.out.println("ENTERED LIST: " + inputList);
            ArrayList<Integer> uniqueList = removeDuplicates(inputList);
            System.out.println("SORT LIST: " + uniqueList);
        }
    }
}