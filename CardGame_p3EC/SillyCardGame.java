/*
 *Ashlesha Bhamare
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package abhamare_p3EC;
import java.util.*;

/**
 * This class plays a card game using a special set of cards that contain the
 * numbers 1 to 13 and there are four copies of each card in the deck.
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class SillyCardGame {
    /**
     * Main method plays the card game
     * @param args A string array containing the command line arguments
     */
    public static void main(String[] args) throws StackOverFlowException
    {

        int playerCount;                          // To hold playerCount

        String continuePlaying = "yes";            //To hold users input

        // Queue to store all player objects
        GenericQueue<PlayerInfo> players = new GenericQueue<PlayerInfo>();

        // Creating scanner object
        Scanner keyboard = new Scanner(System.in);

        welcomeMessage();                // Calling welcome method

        while (!continuePlaying.equals("no"))
        {
            playerCount = getPlayerCount(keyboard);
            players = getPlayerNames(keyboard, playerCount);
            GameModel game = new GameModel(players, playerCount);

            // Calling playingSingleGame method
            playingSingleGame(game, keyboard);

            System.out.println("The game has finished.\n");
            System.out.print("Play again (no to quit): ");
            continuePlaying = keyboard.next();
            keyboard.nextLine();
            System.out.println();
        }
        goodbyeMessage();                     // Calling goodBye method
        keyboard.close();                         // Closing Scanner
    }
    /**
     * Prints the welcome message
     */
    private static void welcomeMessage() {
        System.out.println("\nWelcome to this Silly Card Game!"+"\nThis game " +
                "is " + "played with two people " + "and will run until one " +
                "player has " + "no cards left in their " + "hand." +
                "\nOnce that happens, " + "that player is declared the "
                                                               + "winner.\n");

    }
    /**
     * Asking for 2 - 6 players to play game
     * @param keyboard Scanner
     * @return Integer number of players
     */
    private static int getPlayerCount(Scanner keyboard) {
        int playerCount = 0;
        while(playerCount > 6 || playerCount < 2) {
            System.out.print("How many players? (Enter between 2 - 6) : ");
            playerCount = keyboard.nextInt();
            keyboard.nextLine();
        }
        return playerCount;
    }

    /**
     * This method gets players name
     * @param keyboard Scanner
     * @param playerCount Total number of players
     * @return Queue of players
     */
    private static GenericQueue<PlayerInfo> getPlayerNames(Scanner keyboard,
                                                       int playerCount) {
        String name;

        GenericQueue<PlayerInfo> players = new GenericQueue<PlayerInfo>();
        for(int i = 0; i < playerCount; i++) {
            System.out.print("Player Name? ");
            name = keyboard.next();
            players.enqueue(new PlayerInfo(name));
            keyboard.nextLine();
        }
        System.out.println();
        return players;
    }

    /**
     * This method plays a single game
     * @param game Current game object
     * @param keyboard	Scanner
     */
    private static void playingSingleGame(GameModel game, Scanner keyboard)
                                               throws StackOverFlowException {
        while(!game.getPlayers().peek().getQueue().empty()) {
            if(game.getDealStack().empty()) {
                game.refillDealStack();
            } else {
                System.out.println(game.getPlayers().peek().getName()
                        + "'s turn, cards: ");
                printTheGame(game, keyboard);
            }
        }
    }
    /**
     * Prints out the current move for the game
     * @param game Current game object
     * @param keyboard Scanner
     */
    private static void printTheGame(GameModel game, Scanner keyboard)
                                               throws StackOverFlowException {
        System.out.println(game.getPlayers().peek().getQueue());
        System.out.println("Discard pile card: " + game.getDiscardStackTop());
        System.out.println("Your current card: "
                + game.getPlayers().peek().getQueue().peek());
        System.out.print("Press RETURN to take a turn.");
        keyboard.nextLine();
        System.out.println(game.playerMove());
        System.out.println();
    }

    /**
     * Prints out the goodbye message
     */
    private static void goodbyeMessage() {
        System.out.println("\nThanks for playing this Silly Card Game!\n");
    }

}
