package abhamare_lab3;

import abhamare_lab3.*;

import java.util.Random;
import java.util.Scanner;

/**
 * This program generates a random number between a given range and asks
 * user to guess a number.
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 *
 */
public class GuessGame
{
    private int startRange;                         // To hold startRange
    private int endRange;                           // To hold endRange
    private int count;                              // To hold count
    private int target;                             // To hold target

    /**
     * This constructor sets the initial value of the start and end of
     * the range.
     *
     * @param start starting range of number.
     * @param end ending range of a number.
     */
    public GuessGame(int start, int end)
    {
        startRange = start;
        endRange = end;
        count = 0;
    }

    /**
     * This function displays the number of times required for guessing a
     * number.
     */
    public void displayStatistics()
    {
        System.out.println("You guessed " + count + " times.");
        count = 0;                    // Reseting the guess count
    }

    /**
     * This function creates a random number between the given range.
     *
     * @param min Start range for generating random number.
     * @param max End range for generating random number.
     */
    public void newTarget(int min, int max)
    {
        int num;                                   // To hold num
        // creating random object
        Random rand = new Random();

        num = rand.nextInt(max - min + 1) + min;
        target = num;
    }

    /**
     * This is a getter function which returns the target value.
     *
     * @return The number to be guessed.
     */
    public int getTarget()
    {
        return target;
    }

    /**
     * This function prompts user to guess the number. If the number is
     * greater than the target, it displays a too high and if the number is
     * small than target, it displays a too low message on console.
     *
     * @param num the number to be guessed.
     * @param start the start range.
     * @param end the end range.
     * @param keyboard for input from the user.
     * @return boolean is the number equal to or not equal to the target
     * number.
     */
    public boolean guess(int num, int start, int end, Scanner keyboard )
    {
        int guessNumber;                            // To hold guessNumber
        do {
            System.out.print("Guess a number between " + start + " and " + end +
                    ": ");
            guessNumber = keyboard.nextInt();
            keyboard.nextLine();
        } while(guessNumber < start || guessNumber > end);

        displayHint(num, guessNumber);

        if (num != guessNumber)
        {
            count++;
            return false;
        }
        return true;
    }

    /**
     * This function displays on the console if the number is too high or too low,
     * by comparing the number with the target value.
     *
     * @param num the target number.
     * @param guessNumber the number guessed by the user.
     */
    private void displayHint(int num, int guessNumber)
    {
        if (num < guessNumber)
        {
            System.out.println(guessNumber + " is too high.");
        }
        else if (num > guessNumber)
        {
            System.out.println(guessNumber + " is too low.");
        }
        else
        {
            System.out.println("That's correct!");
        }
    }

    /**
     * This function returns the start range.
     *
     * @return startRange the start range of the number.
     */
    public int getRangeMinimum()
    {
        return startRange;
    }

    /**
     * This function returns the end range.
     *
     * @return endRange the end range of the number.
     */
    public int getRangeMaximum()
    {
        return endRange;
    }


}
