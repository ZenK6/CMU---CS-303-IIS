package Lec6_ARRAYS;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex10_ConcatenateArrayLists {

    public static ArrayList<Integer> concatenate(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        // Tạo một ArrayList mới để chứa kết quả.
        ArrayList<Integer> resultList = new ArrayList<>();

        // Thêm tất cả các phần tử từ danh sách đầu tiên vào danh sách kết quả.
        resultList.addAll(list1);

        // Thêm tất cả các phần tử từ danh sách thứ hai vào cuối danh sách kết quả.
        resultList.addAll(list2);

        // Trả về danh sách đã được nối.
        return resultList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập dữ liệu cho danh sách đầu tiên
        System.out.println("Nhap cac so nguyen cho danh sach dau tien (nhap -1 de ket thuc):");
        ArrayList<Integer> list1 = readIntegersFromUser(scanner);

        // Nhập dữ liệu cho danh sách thứ hai
        System.out.println("Nhap cac so nguyen cho danh sach thu hai (nhap -1 de ket thuc):");
        ArrayList<Integer> list2 = readIntegersFromUser(scanner);

        // Nối hai danh sách lại với nhau
        ArrayList<Integer> combinedList = concatenate(list1, list2);

        System.out.println("Danh sach thu nhat: " + list1);
        System.out.println("Danh sach thu hai: " + list2);
        System.out.println("Danh sach sau khi noi: " + combinedList);

        scanner.close();
    }

    public static ArrayList<Integer> readIntegersFromUser(Scanner scanner) {
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            System.out.print("==> ");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number == -1) {
                    break;
                }
                list.add(number);
            } else {
                System.out.println("Dau vao khong hop le. Vui long nhap mot so nguyen.");
                scanner.next();
            }
        }
        return list;
    }
}