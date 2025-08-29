package Lec7_STRINGS;

import java.util.Arrays;
import java.util.Scanner;

public class Ex4_Anagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String1:");
        String s1 = scanner.nextLine();
        System.out.println("Enter String2:");
        String s2 = scanner.nextLine();
        scanner.close();

        if (areAnagrams(s1, s2)) {
            System.out.println("This is Anagrams.");
        } else {
            System.out.println("This isn't Anagrams.");
        }
    }

    public static boolean areAnagrams(String s1, String s2) {
        // 1. Loại bỏ khoảng trắng và chuyển thành chữ thường để so sánh không phân biệt chữ hoa/thường
        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();

        // 2. Kiểm tra độ dài. Nếu khác nhau, chúng không thể là Anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        // 3. Chuyển chuỗi thành mảng ký tự
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();

        // 4. Sắp xếp cả hai mảng
        Arrays.sort(array1);
        Arrays.sort(array2);

        // 5. So sánh hai mảng đã sắp xếp
        // Nếu hai mảng đã sắp xếp giống nhau, chúng là Anagrams
        return Arrays.equals(array1, array2);
    }
}
