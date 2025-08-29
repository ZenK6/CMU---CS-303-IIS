package Lec7_STRINGS;

import java.util.Scanner;

public class Ex8_CountWord {
    public static int countWords(String inputString) {
        // 1. Kiểm tra nếu chuỗi rỗng hoặc null
        if (inputString == null || inputString.trim().isEmpty()) {
            return 0;
        }

        // 2. Loại bỏ khoảng trắng thừa ở đầu và cuối chuỗi
        String trimmedString = inputString.trim();

        // 3. Tách chuỗi thành một mảng các từ bằng cách sử dụng biểu thức chính quy "\\s+"
        // "\\s+" khớp với một hoặc nhiều khoảng trắng liên tiếp.
        String[] words = trimmedString.split("\\s+");

        // 4. Trả về độ dài của mảng, chính là số từ
        return words.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Sentence:");
        String input = scanner.nextLine();
        scanner.close();

        int wordCount = countWords(input);
        System.out.println("Count Word: " + wordCount);
    }
}
