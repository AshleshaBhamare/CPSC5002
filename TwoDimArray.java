package abhamare_lab1;

import java.util.Scanner;                // Needed for the Scanner class
import java.util.Random;

/**
 * This is the program that creates a two-dimensional array of integers
 * according to the user's request.
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class TwoDimArray
{
    /**
     * This prompts user for the size of a 2d square array of integers,
     * then creates the square array, fills it with random numbers and then
     * prints it out along with sums in both directions and along the
     * sum of diagonal elements.
     *
     * @param args A string array containing the command line arguments.
     */
    public static void main(String[] args)
    {
        String input;                          // To hold input
        char repeat;                           // To hold 'y' or 'n'

        // Create a Scanner object to read input.
        Scanner keyboard = new Scanner(System.in);

        // Printing welcome message.
        welcomeMessage();

        do {
            int num = 0;                          // To hold num

            do
            {
                System.out.print("How many rows (something between 1 " +
                                                               "and 10)? ");
                num = keyboard.nextInt();

            } while (num < 1 || num > 10);

           // Calling twoDimArray function
            twoDimArray(num);

            System.out.print("\n\nGo again? ");
            input = keyboard.next();
            repeat = input.charAt(0);
        } while (repeat == 'Y' || repeat == 'y' );

         // Printing goodBy message.
         goodByMessage();

         // Closing Scanner object.
         keyboard.close();
    }

    /**
     * Prints welcomeMessage
     */
    public static void welcomeMessage()
    {
        System.out.println("\nThis program asks for the size of a 2d square " +
                "array of integers, then\n" + "creates the square array, " +
                "fills it with random numbers, then " + "prints it\nout " +
                "along " + "with sums in both directions and along " +
                "the diagonals.\n");
    }

    /**
     * This method create two dimensional array using random numbers and
     * print the sum of rows and columns along with sum of diagonal elements.
     *
     * @param num entered by user.
     */
    public static void twoDimArray(int num)
    {

        int[][] array = new int[num][num];            // Initializing array

        // Creating random object
        Random rand = new Random();

        for (int row = 0; row < num; row++ )
        {
               for (int col = 0; col < num; col++)
            {
                array[row][col] = rand.nextInt(99);
            }
        }

        int total = 0;                            // To hold total
        int rowNum = 1;                           // To hold rowNum
        int[] rowSum = new int[num];              // Initializing rowSum

        for (int i = 0; i < num; i++)
        {
            // Calling calculateSumOfRow function
            total = calculateSumOfRows(array, rowNum);
            rowSum[i] = total;
            rowNum++;
        }

        // Printing the sum of each row
        for (int row = 0; row < num; row++ )
        {
            System.out.println();

            for (int col = 0; col < num; col++)
            {
               System.out.print( "\t " +array[row][col] + "\t" );
                //System.out.println("%-4s %1d", " ", array[row][col]);
            }
            System.out.print("=  " + rowSum[row]  );
        }
        System.out.println();

        int secondTotal;                         // To hold secondTotal

        // Calling calculateSumOfSecondDiagonalElements function
        // and printing the sum
        secondTotal = calculateSumOfSecondDiagonalElements(array);
        System.out.print(secondTotal);

        // printing the sum of Columns
        for (int i = 1; i <= num; i++)
        {
            System.out.print("\t" +calculateSumOfColumns(array,i) + "\t");
        }

        int firstTotal;                          // To hold firstTotal

        // Calling calculateSumOfFirstDiagonalElements function
        // and printing the sum
        firstTotal = calculateSumOfFirstDiagonalElements(array);
        System.out.print("   " + firstTotal);

    }

    /**
     * Calculate the sum of rows in the Array and return the total for
     * each row.
     *
     * @param array takes an int array
     * @param rowNum takes an value of an integer
     * @return Returns the sum of each row.
     */
    public static int calculateSumOfRows(int[][] array,int rowNum)
    {

        int rowTotal = 0;                      // To hold total
        for (int row = 0; row < rowNum; row++) {
            rowTotal = 0;

            for (int col = 0; col < array[row].length; col++) {
                rowTotal += array[row][col];
            }

        }
        return rowTotal;
    }
    /**
     * Calculate the sum of columns in the Array and return the total for
     * each column.
     *
     * @param array takes an int array
     * @param colNum takes an value of an integer
     * @return Returns the sum of each column.
     */
    public static int calculateSumOfColumns(int[][] array,int colNum)
    {
        int colTotal = 0;                       // To hold colTotal

        for (int col = 0; col < colNum; col++)
        {
            colTotal = 0;
            for (int row = 0; row < array.length; row++)
            {
                colTotal += array[row][col];
            }
        }
        return colTotal;
    }
    /**
     * Calculate the sum of first diagonal elements in the Array
     * and return the total.
     *
     * @param array takes an int array
     * @return Returns the sum of first diagonal elements
     */
    public static int calculateSumOfFirstDiagonalElements(int[][] array)
    {
        int firstTotal = 0;                       // To hold firstTotal

        for (int row = 0; row < array.length; row++)
        {
            firstTotal += array[row][row];
        }
        return firstTotal;
    }
    /**
     * Calculate the sum of second diagonal elements in the Array
     * and return the total.
     *
     * @param array takes an int array
     * @return Returns the sum of second diagonal elements
     */
    public static int calculateSumOfSecondDiagonalElements(int[][] array)
    {
        int secondTotal = 0;                     // To hold secondTotal

        for (int row = 0; row < array.length; row++)
        {
            for (int col = array[row].length - 1; col >= 0; col--)
            {
                  secondTotal += array[row][col];
                  row++;
            }
        }
        return secondTotal;
    }
    /**
     * Prints goodbye message
     */
    public static void goodByMessage()
    {
        System.out.println("\n\nThanks for playing TwoDimArray!\n");
    }

}
