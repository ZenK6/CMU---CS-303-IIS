package Lec7_STRINGS;

import java.util.Scanner;

public class Ex3_StringCompression {

    public static String compressString(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        StringBuilder compressedString = new StringBuilder();
        int count = 1;

        for (int i = 0; i < input.length(); i++) {
            // Kiểm tra xem ký tự hiện tại có giống ký tự tiếp theo không
            if (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                count++;
            } else {
                // Khi ký tự thay đổi, nối ký tự trước đó và số lần lặp của nó
                compressedString.append(input.charAt(i));
                compressedString.append(count);
                // Đặt lại bộ đếm cho ký tự mới
                count = 1;
            }
        }

        return compressedString.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String:");
        String input = scanner.nextLine();
        scanner.close();

        String compressed = compressString(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + compressed);
    }
}