package Lec3_variable;
//Viết một chương trình sử dụng nextLine() để đọc toàn bộ câu từ người dùng và in ra
import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String cauVan = scanner.nextLine();
        System.out.println("=>: " + cauVan);
        scanner.close();
    }
} 
