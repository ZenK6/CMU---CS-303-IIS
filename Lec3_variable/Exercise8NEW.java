package Lec3_variable;

import java.util.Scanner;

public class Exercise8NEW {

    public static void main(String[] args) {
        Scanner fullLineScanner = new Scanner(System.in);
        System.out.println("Enter:");
        
        String inputLine = fullLineScanner.nextLine();
        
        Scanner wordScanner = new Scanner(inputLine);
        
        System.out.println("==> LIST :");
        
        while (wordScanner.hasNext()) {
            String word = wordScanner.next();
            System.out.println(word);
        }
        
        wordScanner.close();
        fullLineScanner.close();
    }
}
