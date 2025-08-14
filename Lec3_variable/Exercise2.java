package Lec3_variable;
//Chương trình nhập tên và tuổi, sau đó in ra một câu

import java.util.Scanner;

public class Exercise2 {
       public static void main(String[] args) {
           Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String ten = scanner.nextLine();

        System.out.print("Enter Age: ");
        int tuoi = scanner.nextInt();

        System.out.println("Hello " + ten + ", You are " + tuoi + " Years old.");
        scanner.close();
    } 
}
