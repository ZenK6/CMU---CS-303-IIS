package Lec3_variable;
//Phát triển một chương trình yêu cầu người dùng nhập tên đầy đủ (nhiều từ) và in lại cho họ
import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter FullName: ");
        String hoTen = scanner.nextLine();
        System.out.println("FullName: " + hoTen );
        scanner.close();
    }
}
