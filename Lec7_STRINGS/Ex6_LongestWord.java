package Lec7_STRINGS;

import java.util.Scanner;

public class Ex6_LongestWord {
    public static String findLongestWord(String sentence) {
        // Tách câu thành một mảng các từ
        String[] words = sentence.split(" ");
        
        // Khởi tạo từ dài nhất với từ đầu tiên trong mảng
        String longestWord = "";

        // Lặp qua mảng từ
        for (String word : words) {
            // So sánh độ dài của từ hiện tại với từ dài nhất đã tìm thấy
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        
        return longestWord;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Sentence:");
        String sentence = scanner.nextLine();
        scanner.close();

        String longest = findLongestWord(sentence);
        System.out.println("Longest Word: " + longest);
    }
}
