package Lec7_STRINGS;

import java.util.Scanner;

public class Ex2_Capitalize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        String fullName = scanner.nextLine();
        scanner.close();

        String normalizedName = capitalizeName(fullName);
        System.out.println("Capitalized Name: " + normalizedName);
    }

    public static String capitalizeName(String name) {
        // 1. Loại bỏ khoảng trắng thừa ở đầu và cuối
        name = name.trim();

        // 2. Tách chuỗi thành một mảng các từ, sử dụng biểu thức chính quy để xử lý nhiều khoảng trắng
        String[] words = name.split("\\s+");
        
        // 3. Sử dụng StringBuilder để xây dựng tên đã chuẩn hóa
        StringBuilder normalized = new StringBuilder();

        // 4. Lặp qua từng từ và chuẩn hóa
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > 0) {
                // Chuyển ký tự đầu tiên thành chữ hoa
                String firstLetter = word.substring(0, 1).toUpperCase();
                // Chuyển phần còn lại thành chữ thường
                String restOfWord = word.substring(1).toLowerCase();
                // Nối lại và thêm vào StringBuilder
                normalized.append(firstLetter).append(restOfWord);
                
                // Thêm khoảng trắng giữa các từ, trừ từ cuối cùng
                if (i < words.length - 1) {
                    normalized.append(" ");
                }
            }
        }
        
        return normalized.toString();
    } 
}
