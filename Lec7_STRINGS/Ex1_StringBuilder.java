package Lec7_STRINGS;

import java.util.Scanner;

public class Ex1_StringBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Sentence:");
        String sentence = scanner.nextLine();
        scanner.close();

        String reversedSentence = reverseWordsInSentence(sentence);
        System.out.println("Reversed Sentence: " + reversedSentence);
    }

    public static String reverseWordsInSentence(String sentence) {
        // Tách câu thành một mảng các từ
        String[] words = sentence.split(" ");
        
        // Sử dụng StringBuilder để xây dựng câu mới
        StringBuilder reversed = new StringBuilder();

        // Lặp qua mảng các từ từ cuối về đầu
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            // Thêm khoảng trắng sau mỗi từ, trừ từ cuối cùng
            if (i > 0) {
                reversed.append(" ");
            }
        }

        // Chuyển StringBuilder thành chuỗi và trả về
        return reversed.toString();
    }
}
