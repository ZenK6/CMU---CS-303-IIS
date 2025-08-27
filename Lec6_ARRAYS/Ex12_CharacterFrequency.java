package Lec6_ARRAYS;

import java.util.Scanner;

public class Ex12_CharacterFrequency {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap mot chuoi van ban:");
        String inputString = scanner.nextLine();

        if (inputString.isEmpty()) {
            System.out.println("Chuoi khong co ky tu nao.");
            scanner.close();
            return;
        }

        int[] frequency = new int[26];

        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                // Tinh chi so (index) bang cach tru di 'a'
                int index = ch - 'a';
                // Tang gia tri tai chi so tuong ung
                frequency[index]++;
            }
        }

        System.out.println("Tan so xuat hien cua cac ky tu:");

        for (int i = 0; i < 26; i++) {
            if (frequency[i] > 0) {
                char ch = (char) ('a' + i);
                System.out.println("'" + ch + "': " + frequency[i]);
            }
        }

        scanner.close();
    }
}