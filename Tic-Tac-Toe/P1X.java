package abhamare_p1;

import java.util.Scanner;

/**
 * P1 plays a tic tac toe game
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class P1X
{

    private final static int X_WINNER = 1;             // To hold X_WINNER
    private final static int O_WINNER = 2;             // To hold O_WINNER
    private final static int TIE = 0;                  // To hold TIE
    private final static char YES = 'y';               // To hold input
    public static final int MIN_BOARD_SIZE = 3;        // To hold MIN_BOARD_SIZE
    private static int xWinCount = 0;                  // To hold xWinCount
    private static int oWinCount = 0;                  // To hold oWinCount
    private static int tieCount = 0;                   // To hold tieCount
    private static TicTacToeX board;                   // To hold board
    private static final int MAX_BOARD_SIZE = 25;      // To hold board

    /**
     * This function plays a tic tac toe game for 3x3 board
     *
     * @param args command line arguments
     */


    public static void main(String[] args)
    {
        // Creating Scanner Object
        Scanner keyboard = new Scanner(System.in);
        char response;
        int board_size = 0;

        Boolean validInputFlag = false;

        // Calling Welcome function
        welcome();

        int winner;                                 // Tp hold winner
        do {

            while (validInputFlag == false)
            {
                System.out.print("Please enter board size for the board. " +
                        "   \nEnter an odd number for column (or rows): ");
                board_size = keyboard.nextInt();

                if (board_size >= MIN_BOARD_SIZE &&
                                         board_size <= MAX_BOARD_SIZE)
                {
                    if (board_size % 2 != 0)
                    {
                        validInputFlag = true;
                    }

                }
            }


            board = new TicTacToeX(board_size, board_size);
            board.printBoard();

            winner = playGame(board, keyboard, board_size);

            if (winner == X_WINNER)
            {
                xWinCount++;
            }
            else if (winner == O_WINNER)
            {
                oWinCount++;
            }
            else if (winner == TIE)
            {
                tieCount++;
            }

            board.gameStatus(xWinCount, oWinCount, tieCount);
            validInputFlag=false;           // Resetting the flag for new game

            System.out.print("Do you want to play again? ");
            response = keyboard.nextLine().toLowerCase().charAt(0);
        } while (response == YES);

        // Calling goodBy function
        goodbye();

        keyboard.close();                          // Closing Scanner
    }

    /**
     * Plays the game and returns who was the winner. -1 represents no winner
     * and game in progress
     *
     * @param board 2D matrix representing the object of TicTacToe
     * @param keyboard for input from console
     * @param board_size size oh board.
     * @return int representing who is the winner 0 is tie, 1 is X and 2 is O,
     * -1 is no winner
     */
    private static int playGame(TicTacToeX board, Scanner keyboard,
                                                         int board_size)
    {

        char c;                                     // To hold c
        int row;                                    // To hold row
        int col;                                    // To hold col
        int winner = -1;                            // Initialize winner to -1
        int max_loop = board_size*board_size;       // to hold max_loop

        for (int i = 0; i < max_loop; i++)
        {
            if (i % 2 == 0)
            {
                c = 'X';
            }
            else
            {
                c = 'O';
            }

            do {

                System.out.println(c + ", it is your turn.");

                System.out.print("Which row? ");
                row = keyboard.nextInt();


                keyboard.nextLine();

                System.out.print("Which column? ");
                col = keyboard.nextInt();

                if (col > (board_size-1) || col < 0 || row > board_size - 1 ||
                                                                    row < 0)
                {
                    System.out.println("Bad location, try again...");
                    board.printBoard();
                }


            } while ((col > (board_size-1) || col < 0) ||
                                     (row > (board_size - 1) || row < 0));

            keyboard.nextLine();

            // If the row and col is already taken then retry
            if (!board.setCharOnBoard(row, col, c))
            {
                i--;
            }

            // check if its a tie only when the board is fully filled
            if (i == 8 && board.checkTie() == 0) {
                System.out.println("No winner - it was a tie!");
                winner = TIE;
            }

            // Check for winner
            if (board.checkWinner(c) == 1 || board.checkWinner(c) == 2)
            {

                if (board.checkWinner(c) == 1) {
                    winner = X_WINNER;
                } else {
                    winner = O_WINNER;
                }

                return winner;
            }
            board.printBoard();
        }

        return winner;
    }

    /**
     * Print welcome message
     */
    public static void welcome()
    {
        System.out.println("\nWelcome to TicTacToe!\n\n");
    }

    /**
     * Print good bye message
     */
    public static void goodbye()
    {
        System.out.println("\nThank you for playing TicTacToe!\n");
    }
}
