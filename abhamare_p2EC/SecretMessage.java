
/*
 * Ashlesha Bhamare
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package abhamare_p2EC;

import java.io.IOException;
import java.util.ArrayList;
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
    private static final String SURE = "sure";
    private static final String OKAY = "okay";

    /**
     * Main method for decoding and interleaving of secret messages
     * @param args A string array containing the command line arguments
     * @throws IOException throws exception on IO error
     */
    public static void main(String[] args) throws IOException
    {
        char response;                            // To hold response
        String input;                             // To hold input
        String addAnotherFile;                    // To hold addAnotherFile
        ArrayList<String> names;                  // To hols list of names
        int totalFiles;                           // To hold totalFiles
        String[] decoded;                         // To store decoded sentences

        // Calling printInfo function
        printInfo();

        // To create scanner object
        Scanner keyboard = new Scanner(System.in);

        do
        {
            addAnotherFile = "yes";
            totalFiles = 0;
            names = new ArrayList<String>();
            String fileName = toFindFile(keyboard);
            MessageDecoder decode = new MessageDecoder();

            if(!decode.scanFile(fileName))
            {
                System.out.println("File is malformed, please try again.");
                decode = new MessageDecoder();
            }
            else {
                while (!addAnotherFile.isEmpty()) {
                    addAnotherFile = toFindNextFile(keyboard);
                    names.add(addAnotherFile);
                    totalFiles++;
                }

                // Creating an array to hold decoded sentences
                decoded = new String[totalFiles];
                // Adding original decoded sentence to an array
                decoded[0] = decode.getPlainTextMessage();
                for(int i = 0; i < names.size() - 1; i++) {
                    decode = new MessageDecoder();
                    if(!decode.scanFile(names.get(i))) {
                        throw new IllegalArgumentException("One or more files "
                                + "are malformed, please try again.");
                    } else {
                        decode = new MessageDecoder();
                        decode.scanFile(names.get(i));
                        decoded[i + 1] = decode.getPlainTextMessage();
                    }
                }

                mergeTheMessages merge = new mergeTheMessages();

                for (int i = 0; i < decoded.length; i++) {
                    merge.scanFile(decoded[i], i + 1);
                }

                System.out.println("\nPlain text: " + merge);

            }

            System.out.print("\nWould you like to try again? (no to exit): ");
            input = keyboard.nextLine().toLowerCase();
            response = input.charAt(0);

        } while (response == YES || input.equals(SURE) || input.equals(OKAY));

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

    public static String toFindNextFile(Scanner keyboard)
    {
        System.out.print("Enter another secret file name (or blank): ");
        String file = keyboard.nextLine();
        if(file.isEmpty()) {
            return "";
        }
        boolean validFile = isValidFile(file);
        while(!validFile) {
            System.out.print("Enter another secret file name (or blank): ");
            file = keyboard.nextLine();
            validFile = isValidFile(file);
        }
        return file;
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
                "contents of the " + "message before it was encoded.\n" +
                "The user can enter multiple files and the decoded \n" +
                "result words will become interleaved.\n");
    }

    /**
     * Print good bye message
     */
    public static void goodByeMessage()
    {
        System.out.println("\nThank you for using the message decoder.\n");
    }

}
