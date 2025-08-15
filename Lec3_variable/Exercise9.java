package Lec3_variable;
//Viết một chương trình minh họa sự cố khi sử dụng nextInt() theo sau là nextLine() 
//và khắc phục bằng cách thêm nextLine() để xử lý ký tự xuống dòng.
import java.util.Scanner;

public class Exercise9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter age: ");
        int tuoi = scanner.nextInt();
        scanner.nextLine(); //dòng này để khắc phục vấn đề tự xuống dòng
        System.out.print("Enter FullName: ");
        String ten = scanner.nextLine();

        System.out.println("=>Age: " + tuoi);
        System.out.println("=>FullName: " + ten);
        scanner.close();
    }
}
