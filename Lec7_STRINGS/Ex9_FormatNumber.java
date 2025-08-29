package Lec7_STRINGS;

import java.util.Scanner;

public class Ex9_FormatNumber {
    public static String formatNumberString(String numberStr) {
        // Kiểm tra nếu chuỗi rỗng, null hoặc không phải là chuỗi số
        if (numberStr == null || numberStr.isEmpty() || !numberStr.matches("\\d+")) {
            return "INVALID STRING.";
        }

        StringBuilder sb = new StringBuilder(numberStr);
        int length = sb.length();
        
        // Lặp ngược từ cuối chuỗi, bỏ qua vị trí đầu tiên
        for (int i = length - 3; i > 0; i -= 3) {
            sb.insert(i, ',');
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number String:");
        String inputNumber = scanner.nextLine();
        scanner.close();

        String formattedNumber = formatNumberString(inputNumber);
        System.out.println("Formatted String: " + formattedNumber);
    }
}
