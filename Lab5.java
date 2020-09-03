
/*
 * Ashlesha Bhamare
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package abhamare_lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This program reads the file lab4.dat and inserts the elements into a linked
 * list in non-descending order. The contents of the linked list are then
 * displayed to the user in column form. Also the duplicates are removed from
 * the list and then printing on the console.
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class Lab5 {
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

        /**
         * Create a new Node in the list.
         *
         * @param data integer value in the node
         * @param next reference to the next node in the list
         */
        public Node(int data, Node next )
        {
            // Call the other constructor in the list
            this(data);
            this.next = next;
        }

        /**
         * Create a new node in the list.
         *
         * @param data integer value in the node
         */
        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private static final String FILE_NAME = "lab4.dat";

    // Reference to the first node of the list
    private Node head;

    // Reference to the end node of the list
    private Node tail;

    /**
     * Creating a list and prints the contents of the list in ascending
     * order
     *
     * @param args command line arguments
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        Lab5 lab5 = new Lab5();
        //Calling printWelcomeInfo function
        lab5.printWelcomeInfo();
        //Calling sortFileToScreen function
        lab5.sortFileToScreen();
        //Calling removeDuplicates function
        lab5.removeDuplicates();
        //Calling goodBye function
        lab5.goodBye();
    }

    /**
     * Printing the program info  to the console
     */
    private void printWelcomeInfo() {
        System.out.println("\nThis program reads the file lab4.dat and inserts "
                + "the elements into a linked list in nondescending order. \n"
                + "The contents of the linked list are then displayed to the" +
                " user " + "in column form. \n" + "Duplicates are then " +
                "removed, " + "and the " + "contents are displayed again.\n");
    }

    /**
     * Reads integers from file, stores in a sorted manner in a list and
     * prints them
     *
     * @throws FileNotFoundException
     */
    private void sortFileToScreen() throws FileNotFoundException {
        Scanner file = new Scanner(new File(FILE_NAME));
        while (file.hasNext()) {
            addToOrderedList(file.nextInt());
        }
        System.out.println("\nLinked list contents after reading:");

        file.close();
        printList();
    }

    /**
     * Adding a number from a file to the list in order.
     * 3 possibilities:
     * 1. Add at the beginning of the list
     * 2. Add in the middle of the list
     * 3. Add at the end of the list
     *
     * @param num number to be added to the list from the file
     */
    private void addToOrderedList(int num) {
        // List empty. Add first node to the list
        if (head == null) {
            head = new Node(num);
        }
        // Check if current num is lesser than head
        else if (num <= head.data) {
            head = new Node(num, head);
        } else {
            Node p = head;
            while (p.next != null && p.next.data < num) {
                p = p.next;
            }

            // Num is greater than the last node (tail) in the list
            if (p.next == null) {
                p.next = new Node(num);
                tail = p.next;
            }
            // Num is eligible to be placed in between the head and the
            // tail of the list
            else {
                p.next = new Node(num, p.next);
            }
        }

    }

    /**
     * Taking as input the linked list of integers. If any of the integers in
     * the list appears more than once, removing all but one copy of that
     * integer.
     *
     */
    private void removeDuplicates()
    {
        // Another reference to head
        Node curr = head;

        // Traverse list till the last node
        while (curr != null) {

            Node temp = curr;


            // Comparing current node with the next node and keep on deleting
            // them until it matches the current node data
            while (temp != null && temp.data == curr.data)
            {
                temp = temp.next;
            }


            // Set current node next to the next different element denoted
            // by temp
            curr.next = temp;
            curr = curr.next;
        }
        System.out.println("\nLinked list contents with no duplicates:");
        printList();
    }

    /**
     * Printing the list contents to the console
     */
    public void printList() {
        for (Node p = head; p != null; p = p.next)
            System.out.println(p.data);
    }

    /**
     * Printing the goodbye message
     */
    private void goodBye() {
        System.out.print("\nThanks for using the linked list program!\n");
    }

}
