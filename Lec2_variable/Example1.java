package Lec2_variable;

public class Example1 {
    public static void main(String[] args) {
        int x = 1;
        int y = x++ + ++x + ++x + x++;
        final double PI = 3.14;
         System.out.println("PI = " + PI);
         System.out.println("x = " + x);
         System.out.println("y = " + y);
    }
}
