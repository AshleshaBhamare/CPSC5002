/*
 * Ashlesha Bhamare
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package abhamare_p2EC;

/**
 * Merge multiple messages together.
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class mergeTheMessages
{
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

        public String word;


        /**
         * Create a new Node in the list.
         *
         * @param data integer value in the node
         * @param next reference to the next node in the list
         */
        public Node(int data, Node next, String word) {
            // Call the other constructor in the list
            this.data = data;
            this.next = next;
            this.word = word;
        }
        /**
         * Create a new node in the list.
         *
         * @param data integer value in the node
         */
        public Node(int data, String word) {
            this.data = data;
            next = null;
            this.word = word;
        }


    }
    // Reference to the first node of the list
    private Node head;
    // Array to hold the words
    private String[] words;

    /**
     * Constructor
     */
    public mergeTheMessages() {
        head = null;
    }

    /**
     * Allows the list to be printed
     * @return The string of the full message
     */
    public String toString() {
        Node ref = head;
        String s = "";
        while (ref != null) {
            s += ref.word + " ";
            ref = ref.next;
        }
        return s;
    }

    /**
     * Iterates through the words of a sentence, passing each word to be added
     * @param sentence sentence to be added
     * @param fileNumber file number to determine word positions
     */
    public void scanFile(String sentence, int fileNumber) {
        words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            addInOrder(words[i], (i*2)+fileNumber);
        }
    }

    /**
     * Adds values to list in order
     * @param word	The word to add to the node
     * @param data	The integer value to add to the node
     */
    private void addInOrder(String word, int data) {
        if (isEmpty() || data < head.data) {
            head = new Node(data, head, word);
        } else {
            Node ref = head;
            while (ref.next != null && data > ref.next.data) {
                ref = ref.next;
            }
            ref.next = new Node(data, ref.next, word);
        }
    }

    /**
     * Checks if the list is empty
     * @return	Returns true if list is empty, false otherwise
     */
    private boolean isEmpty() {
        return head == null;
    }
}
