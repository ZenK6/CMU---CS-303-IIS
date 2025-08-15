package Lec3_variable;
//Triển khai một chương trình sử dụng useDelimiter() để thay đổi dấu phân cách đầu vào thành dấu phẩy (,) 
//và xử lý danh sách các số được phân tách bằng dấu phẩy do người dùng nhập vào.
import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap mot chuoi so cach nhau boi dau phay: ");

        String input = scanner.nextLine(); 
        Scanner lineScanner = new Scanner(input);
        
        lineScanner.useDelimiter(",");

        int tong = 0;
        System.out.println("==>:");

        while (lineScanner.hasNextInt()) {
            int number = lineScanner.nextInt();
            System.out.println(number);
            tong += number;
        }

        System.out.println("--------------------");
        System.out.println("==> Total : " + tong);

        lineScanner.close();
        scanner.close();
    }
}