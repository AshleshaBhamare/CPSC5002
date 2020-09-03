package abhamare_lab3;

import abhamare_lab3.*;
import java.util.Scanner;

/**
 * This program allows the user to guess a number between a range decided by the
 * user. If the guess is too high or too low, the program will display an output
 * respectively.
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 *
 */
public class Lab3
{
    /**
     * This program prompts user to guess a number between a given range and
     * displays whether the number is too high or too low. And if the number is
     * correct to the target number, it displays that the value is correct.
     *
     * @param args A String containing arguments from command line.
     */
    public static void main(String[] args)
    {
        final int MIN_RANGE = 1000;               // To hold MIN_RANGE
        final int MAX_RANGE = 2000;               // To hold MAX_Range
        boolean flag = false;                     // To hold flag
        String choice = "yes";                    // To hold choice

        // To create scanner object
        Scanner keyboard = new Scanner(System.in);
        // Calling welcome function
        welcome();

        GuessGame game = new GuessGame(MIN_RANGE, MAX_RANGE);
        do
        {
            game.newTarget(game.getRangeMinimum(), game.getRangeMaximum());

            int target;
            do {
                target = game.getTarget();
                flag = game.guess(target, game.getRangeMinimum(),
                                            game.getRangeMaximum(), keyboard);
            } while (!flag);

            game.displayStatistics();

            System.out.print("\nReady to play? (no to quit) ");
            choice = keyboard.nextLine();
            System.out.println();
        } while (!choice.equals("no"));

        // Calling goodBy function
        goodBy();

        keyboard.close();                        // Closing Scanner
    }

    /**
     * This function displays a welcome message on the console.
     */
    public static void welcome()
    {
        System.out.println("This is a guessing game where you will guess a " +
                "number\n" + "and I tell you if it is too low or too high" +
                ".\n\n");
    }

    /**
     * This function displays a thank you message on the console.
     */
    public static void goodBy()
    {
        System.out.println("Thanks for playing!\n");
    }
}
