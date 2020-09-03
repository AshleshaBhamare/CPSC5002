
/*
 * Ashlesha Bhamare
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package abhamare_p2;

import java.io.IOException;
import java.util.Scanner;
import java.io.*;

/**
 * This program asks a user for for the name of a file,
 * check to see that the file exists and contains some data. Reads the file(s),
 * decodes the message(s) and display the words for the user. Ask user
 * to repeat this as many times as they want.
 *
 * @author Ashlesha Bhamare
 *  @version 1.0
 */
public class SecretMessage
{
    private static final char YES = 'y';            // To hold input

    /**
     * Main method for decoding and interleaving of secret messages
     * @param args A string array containing the command line arguments
     * @throws IOException throws exception on IO error
     */
    public static void main(String[] args) throws IOException {

        // Calling printInfo function
        printInfo();

        char response;                    // To hold response

        // To create scanner object
        Scanner keyboard = new Scanner(System.in);
        do
        {
            String fileName = toFindFile(keyboard);
            MessageDecoder decode = new MessageDecoder();

            if(!decode.scanFile(fileName))
            {
                System.out.println("File is malformed, please try again.");
                decode = new MessageDecoder();

            }

            System.out.println("Decoded: " + decode.getPlainTextMessage());

            System.out.print("\nWould you like to try again? (no to exit): ");
            response = keyboard.nextLine().toLowerCase().charAt(0);

        } while (response == YES);

        // Calling goodByeMessage function
        goodByeMessage();

        keyboard.close();                           // Closing scanner
    }

    /**
     * Checking if the file is valid, if not then asking the user for a valid
     * file name again
     * @param keyboard Scanner object
     * @return name of the valid file
     */
    public static String toFindFile(Scanner keyboard)
    {
        String fileName;                          // To hold fileName

        System.out.print("Enter secret file name: ");
        fileName = keyboard.nextLine();

        boolean validFile = isValidFile(fileName);

        while(!validFile)
        {
            System.out.print("Enter secret file name: ");
            fileName = keyboard.nextLine();
            validFile = isValidFile(fileName);
        }

        return fileName;
    }
    /**
     * Checks to see that the user-specified file name refers to a valid
     * file on the disk and not a directory. Displays an error message to the
     * user if that is not the case.
     * @param fileName file name string to check
     * @return true if file exists on disk and is not a directory
     */
    private static boolean isValidFile(String fileName) {
        File path = new File(fileName);
        boolean isValid = path.exists() && !path.isDirectory();
        if (!isValid) {
            System.out.println("Please enter valid filename.");
            return false;
        }
        return true;
    }

    /**
     * Print the welcome Information
     */
    public static void printInfo()
    {
        System.out.println("\nThis program reads an encoded message from a " +
                "file " + "supplied by the user and\n" + "displays the " +
                "contents of the " + "message before it was encoded.\n");
    }

    /**
     * Print good bye message
     */
    public static void goodByeMessage()
    {
        System.out.println("\nThank you for using the message decoder.\n");
    }

}
