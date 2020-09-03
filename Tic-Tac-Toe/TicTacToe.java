package abhamare_p1;

/**
 * Represents the tic tac toe game board
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class TicTacToe
{
    char[][] board;                                 // To hold board

    private int maxRows;                            // To hold maxRows
    private int maxColumns;                         // To hold maxColumns

    // Represents how many blocks are filled on the board
    private int currentSizeOfBoard;

    /**
     * Parameterized constructor to initialize the board
     *
     * @param maxRows    maximum rows on the board
     * @param maxColumns maximum columns on the board
     */
    public TicTacToe(int maxRows, int maxColumns)
    {
        this.maxRows = maxRows;
        this.maxColumns = maxColumns;
        board = new char[maxRows][maxColumns];
        currentSizeOfBoard = 0;
    }

    /**
     * Sets the particular cell on the board
     *
     * @param row index for the row
     * @param col index for the column
     * @param c   player either X or O
     * @return true if char is successfully set false otherwise
     */
    public boolean setCharOnBoard(int row, int col, char c)
    {
        if (board[row][col] == '\u0000')
        {
            board[row][col] = c;
            currentSizeOfBoard++;
            return true;
        }
        else
        {
            System.out.println("Bad location, try again...");
            return false;
        }
    }

    /**
     * Prints the board in the asked format
     */
    public void printBoard()
    {
        System.out.println();
        for (int row = 0; row < maxRows; row++)
        {
            System.out.printf("%4d", row);
        }
        System.out.println();
        for (int row = 0; row < maxRows; row++)
        {
            System.out.printf("%2d", row);
            for (int col = 0; col < maxColumns; col++)
            {
                System.out.print(" " + board[row][col]);
                System.out.printf("%2s", "|");

            }
            System.out.println("\n  ------------");
        }

    }

    /**
     * Prints the game status
     *
     * @param xWinCount: Count of number of times X has won
     * @param oWinCount: Count of number of times O has won
     * @param tieCount:  Count of number of times there was a tie
     */
    public void gameStatus(int xWinCount, int oWinCount, int tieCount)
    {
        System.out.println("\n\nGame Stats");
        System.out.println("X has won " + xWinCount + " games.");
        System.out.println("O has won " + oWinCount + " games.");
        if (tieCount > 0)
        {
            System.out.println("There have been " + tieCount + " tie games.");
        }
    }

    /**
     * Returns the winner for the current game
     *
     * @param c X or O
     * @return 2 if O is the winner, 1 if X is the winner, -1 when no winner
     */
    public int checkWinner(char c)
    {
        // TODO Auto-generated method stub
        int winner = -1;
        if (checkRows(c) || checkCols(c) || checkLeftDiagonal(c)
                || checkRightDiagonal(c))
        {
            if (c == 'O')
            {
                winner = 2;
            }
            else
            {
                winner = 1;
            }
        }
        return winner;
    }

    /**
     * Checks whether any column has a winning combination
     *
     * @param c character to check as a winner
     * @return true means column has a winning combination false otherwise
     */
    private boolean checkCols(char c)
    {

        for (int col = 0; col < maxColumns; col++)
        {
            boolean flag = true;
            for (int row = 0; row < maxRows; row++)
            {
                if (board[row][col] != c)
                {
                    flag = false;
                }
            }
            if (flag)
            {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks whether any left diagonal has a winning combination
     *
     * @param c character to check as a winner
     * @return true means left diagonal has a winning combination false
     * otherwise
     */
    private boolean checkLeftDiagonal(char c)
    {
        for (int row = 0, col = 0; row < maxRows && col < maxColumns;
             row++, col++) {
            if (board[row][col] != c)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks whether any right diagonal has a winning combination
     *
     * @param c character to check as a winner
     * @return true means right diagonal has a winning combination false
     * otherwise
     */
    private boolean checkRightDiagonal(char c)
    {
        for (int row = 0, col = maxColumns - 1; row < maxRows && col >= 0;
             row++, col--) {
            if (board[row][col] != c)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks whether any row has a winning combination
     *
     * @param c character to check as a winner
     * @return true means row has a winning combination false otherwise
     */
    private boolean checkRows(char c)
    {

        for (int row = 0; row < maxRows; row++)
        {
            boolean flag = true;
            for (int col = 0; col < maxColumns; col++)
            {
                if (board[row][col] != c)
                {
                    flag = false;
                }
            }
            if (flag)
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks for a tie
     *
     * @return 0 if it was a tie -1 otherwise
     */
    public int checkTie()
        {
        int tie = -1;

        if (checkWinner('X') == -1 && checkWinner('O') == -1 &&
                currentSizeOfBoard == 9) {
            tie = 0;
        }
        return tie;
    }
}
