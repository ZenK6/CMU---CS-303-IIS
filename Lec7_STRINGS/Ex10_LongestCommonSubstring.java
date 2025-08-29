package Lec7_STRINGS;

import java.util.Scanner;

public class Ex10_LongestCommonSubstring {

    public static String findLongestCommonSubstring(String str1, String str2) {
        // Đảm bảo str1 là chuỗi ngắn hơn để tối ưu hóa vòng lặp
        if (str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        String longestCommon = "";
        
        // Vòng lặp ngoài để duyệt qua tất cả các điểm bắt đầu của chuỗi con
        for (int i = 0; i < str1.length(); i++) {
            // Vòng lặp trong để tạo tất cả các chuỗi con có thể
            for (int j = i + 1; j <= str1.length(); j++) {
                String substring = str1.substring(i, j);
                
                // Kiểm tra xem chuỗi con có tồn tại trong chuỗi thứ hai không
                if (str2.contains(substring)) {
                    // Nếu chuỗi con hiện tại dài hơn chuỗi con dài nhất đã tìm thấy
                    if (substring.length() > longestCommon.length()) {
                        longestCommon = substring;
                    }
                }
            }
        }
        
        return longestCommon;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String1:");
        String s1 = scanner.nextLine();
        System.out.println("Enter String2:");
        String s2 = scanner.nextLine();
        scanner.close();

        String longest = findLongestCommonSubstring(s1, s2);
        System.out.println("Longest Common Substring: " + longest);
    }
}
