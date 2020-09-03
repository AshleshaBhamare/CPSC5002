package abhamare_lab2;

import java.util.Scanner;

/**
 * This is a program in which we have two competitors, one is the computer
 * while other is a user. Both of them roll a dice and depending on their
 * value of dice, the winner is decided. At the end, the winner is declared
 * with the
 * number of wins.
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class DiceGame {
    /**
     * This function calls the rollDie method for both the computer and the
     * user, while generating a random number and comparing those with each
     * value of computer and the user. Asks the user if they want to repeat
     * the program.
     *
     * @param args A string of arrays containing command line argument.
     */
    public static void main(String[] args) {
        final int ROLL_COUNT = 10;                  // To hold ROLL_COUNT
        String choice = "yes";                      // To hold choice

        // To create scanner object
        Scanner keyboard = new Scanner(System.in);

        // Calling welcome function
        welcome();

        do {
            // Calling playDiceGameFunction
            playDiceGame(ROLL_COUNT, keyboard);

            System.out.print("\nReady to play? (no to quit) ");
            choice = keyboard.nextLine();


        } while (!choice.equals("no"));

        // Calling goodBy function
        goodBy();

        // Closing Scanner
        keyboard.close();
    }

    /**
     * A function which displays a welcome message on the console.
     */
    public static void welcome() {
        System.out.println("\nThis is a game of you versus the computer. " +
                "We will each\n" + "have one die. We roll our own die " +
                "and the " + "higher number\n" + "wins. We roll ten times " +
                "and the one " + "with the higher number\n" + "of wins is " +
                "the " + "grand winner.\n");
    }

    /**
     * A function who has a value of die for both the computer and the user. It
     * calculates who is the winner by comparing the value of dice and the number of
     * wins.
     *
     * @param rollCount Final number of times the program operates
     * @param keyboard   For Scanner input.
     */
    public static void playDiceGame(int rollCount, Scanner keyboard)
    {
        LoadedDie computer = new LoadedDie(6,
                                              30);
        LoadedDie user = new LoadedDie(1,
                                                       30);
        int userDieCounter = 0;                   // To hold userDieCounter
        int computerDieCounter = 0;               // To hold computerDieCounter

        for (int i = 1; i <= rollCount; i++) {
            System.out.println("\nRoll " + i + " of " + rollCount + ":");

            System.out.println("I rolled a " +  computer.roll());

            System.out.print("Ready to roll? (Press ENTER when ready) ");
            keyboard.nextLine();

            System.out.println("You rolled a " + user.roll());
            System.out.println();

            if (computer.getValue() > user.getValue()) {
                computerDieCounter++;
            } else if (computer.getValue() < user.getValue()) {
                userDieCounter++;
            } else {

                // Case when both roll the same outcome. Discard this
                // iteration and repeat
                i--;
            }
        }

        System.out.println("I won " + computerDieCounter + " times.");
        System.out.println("You won " + userDieCounter + " times.");

        if (computerDieCounter > userDieCounter) {
            System.out.println("Grand winner is me!");
        } else if (computerDieCounter < userDieCounter) {
            System.out.println("Grand winner is you!");
        } else {
            System.out.println("It's a Tie");
        }
    }

    /**
     * A goodbye message which displays a thank you message on the console.
     */
    public static void goodBy() {
        System.out.println("\nThanks for playing!\n");
    }
}
