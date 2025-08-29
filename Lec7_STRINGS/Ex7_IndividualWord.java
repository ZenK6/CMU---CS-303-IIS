package Lec7_STRINGS;

import java.util.Scanner;

public class Ex7_IndividualWord {
    public static String createAcronym(String phrase) {
        // Kiểm tra nếu cụm từ rỗng hoặc null
        if (phrase == null || phrase.isEmpty()) {
            return "";
        }

        // Tách cụm từ thành một mảng các từ
        String[] words = phrase.split("\\s+");
        
        // Sử dụng StringBuilder để xây dựng từ viết tắt
        StringBuilder acronym = new StringBuilder();

        // Lặp qua từng từ trong mảng
        for (String word : words) {
            // Kiểm tra xem từ có rỗng không (ví dụ: do có nhiều khoảng trắng)
            if (!word.isEmpty()) {
                // Lấy ký tự đầu tiên của từ và chuyển thành chữ hoa
                acronym.append(Character.toUpperCase(word.charAt(0)));
            }
        }
        
        return acronym.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Sentence:");
        String inputPhrase = scanner.nextLine();
        scanner.close();

        String resultAcronym = createAcronym(inputPhrase);
        System.out.println("Output: " + resultAcronym);
    }
}
