package Lec5_LOOP;

import java.util.Random;
import java.util.Scanner;

public class Exercise7 {
    public static void main(String[] args) {
        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;

        Scanner scanner = new Scanner(System.in);
        int userGuess;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've picked a number between 1 and 100. Try to guess it.");

        do {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();

            if (userGuess < secretNumber) {
                System.out.println("Your number is lower than the secret number.");
            } else if (userGuess > secretNumber) {
                System.out.println("Your number is higher than the secret number.");
            }
        } while (userGuess != secretNumber);

        System.out.println("Congratulations! You guessed correctly!");
        scanner.close();
    }
}