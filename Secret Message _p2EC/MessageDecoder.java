
/*
 * Ashlesha Bhamare
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package abhamare_p2EC;

import java.io.File;
import java.io.*;
import java.util.Scanner;

/**
 * Converting a scrambled message file into plain text.
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class MessageDecoder {

    /**
     * Node class representing a single node in the list
     */
    private class Node {

        /**
         * Integer value in the linked list node.
         */
        public int data;

        /**
         * Reference to the next node in the list.
         */
        public Node next;

        public char letter;

        /**
         * Create a new Node in the list.
         *
         * @param data integer value in the node
         * @param next reference to the next node in the list
         */
        public Node(int data, Node next, char letter) {
            // Call the other constructor in the list
            this.data = data;
            this.next = next;
            this.letter = letter;
        }

        /**
         * Create a new node in the list.
         *
         * @param data integer value in the node
         */
        public Node(int data, char letter) {
            this.data = data;
            next = null;
            this.letter = letter;
        }
    }
    // Reference to the first node of the list
    private Node head;


    /**
     * Constructor
     */
    public MessageDecoder()
    {
        head = null;
    }

    /**
     * Allows the message to be printed
     * @return The string of the full message
     */
    public String getPlainTextMessage()
    {
        Node ref = head;
        String message = "";
        while (ref != null) {
            message += ref.letter;
            ref = ref.next;
        }
        return message;
    }

    /**
     * Checks if the file is malformed, file is formatted correctly, If yes
     * then the file is processed.
     * @param file	name of the file
     * @return returns true if file is valid, false if malformed
     * @throws FileNotFoundException throws exception if file not found
     */
    public boolean scanFile(String file) throws FileNotFoundException
    {
        File dataFile = new File(file);
        Scanner inputFile = new Scanner(dataFile);

        while(inputFile.hasNextLine()) {
            String line = inputFile.nextLine();

            // Checking if the number is negative or not a number
            if (line.length() <= 2 || !Character.isDigit(line.charAt(2))) {
                inputFile.close();
                return false;
            }

            char c = line.charAt(0);
            int item = Integer.valueOf((line.substring(2,line.length())));

            addsInOrder(c, item);

            // Checking that two nodes does not have the same values after
            // creating the list
            Node ref = head;
            while (ref.next != null) {
                if (ref.data == ref.next.data) {
                    inputFile.close();
                    return false;
                } else {
                    ref = ref.next;
                }
            }
        }
        inputFile.close();
        return true;
    }

    /**
     * Adding the values to list in order
     * @param letter The letter to add to the node
     * @param data The value to add to the node
     */
    private void addsInOrder(char letter, int data) {

        if (isEmpty() || data < head.data) {
            head = new Node(data, head, letter);
        } else {
            Node ref = head;
            while (ref.next != null && data > ref.next.data) {
                ref = ref.next;
            }
            ref.next = new Node(data, ref.next, letter);
        }
    }

    /**
     * Checks if the list is empty
     * @return	Returns true if list is empty.
     */
    private boolean isEmpty()
    {
        return head == null;
    }


}