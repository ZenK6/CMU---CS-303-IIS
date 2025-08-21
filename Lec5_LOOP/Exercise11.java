package Lec5_LOOP;

import java.util.Random;

public class Exercise11 {
    public static void main(String[] args) {
        Random random = new Random();
        int dice1;
        int dice2;
        int rollCount = 0;

        System.out.println("Starting dice roll...");

        do {
            dice1 = random.nextInt(6) + 1;
            dice2 = random.nextInt(6) + 1;
            
            rollCount++;
            
            System.out.println("Roll " + rollCount + ": " + dice1 + " and " + dice2);
            
        } while (dice1 != dice2);

        System.out.println("You rolled doubles after " + rollCount + " tries!");
    }
}