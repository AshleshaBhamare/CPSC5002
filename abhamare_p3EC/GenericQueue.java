/*
 *Ashlesha Bhamare
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package abhamare_p3EC;
/**
 * This class implement a Generic queue using linked list
 *
 * @author Ashlesha Bhamare
 * @version: 1.0
 */
public class GenericQueue <T> {

    /**
     * Node class for holding doubly linked list node details
     */
    private class Node {

        T value;                                    // To hold value
        Node next;                          // to hold next
        Node prev;                          // to hold prev

        /**
         * Constructor to initialize stack and top
         *
         * @param value of the node
         * @param prev holding prev node
         * @param next hold next node
         */
         Node( T value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
        /**
         * Constructer
         * @param val	Value of the node
         */
        Node(T val) {
            this(val, null, null);
        }
    }

    private Node front = null;
    private Node rear = null;

    /**
     * Constructor
     */
    public GenericQueue() {
        front = null;
        rear = null;
    }

    /**
     * Add an element to the end of the queue.
     *
     * @param s The value to be added to the queue.
     */
    public void enqueue(T s) {
        if (rear != null) {
            Node newNode=new Node(s, null, rear);
            rear.next =newNode;
            newNode.prev=rear;
            rear=newNode;
            rear.next=null;

        }
        else {
            rear = new Node(s, null, null);
            front = rear;
        }
    }
    /**
     * Remove an element from the front of the queue
     *
     * @return item at front of queue.
     */
    public T dequeue() {
        if (empty()) {
            throw new IllegalArgumentException("The queue is empty");
        } else {
            T value = front.value;
            front = front.next;

            if (front == null) {
                rear = null;
            }
            return value;
        }
    }
    /**
     * Reports if the queue has any elements.
     *
     * @return true if the queue has zero elements, false otherwise
     */
    public boolean empty() {

        return front == null;

    }

    /**
     * The method peek returns value at the front of the queue.
     * @return item at front of queue.
     */
    public T peek() {
        if (empty()) {
            throw new IllegalArgumentException("The queue is empty");
        } else {
            return front.value;
        }
    }

    /**
     * String representation of the queue contents.
     *
     * @return the string representation
     */
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("");

        Node p = front;
        sBuilder.append(" | ");
        while (p != null) {
            sBuilder.append(p.value + " | ");
            p = p.next;
        }
        return sBuilder.toString();
    }

    /**
     * Make a deep copy of the queue.
     *
     * @return the new queue you created.
     */
    public GenericQueue<T> copy() {
        GenericQueue<T> copied = new GenericQueue<T>();
        Node temp = front;
        while(temp != null) {
            copied.enqueue(temp.value);
            temp = temp.next;
        }
        return copied;
    }

    /**
     * Appends a copy of the rule's right side onto the end of the output
     * queue
     * @param in Queue rule object
     */
    public void append(GenericQueue<?> in) {
        GenericQueue<T> tempCopy = (GenericQueue<T>) in.copy();
        Node temp = tempCopy.front;
        while(temp != null) {
            enqueue(temp.value);
            temp = temp.next;
        }
    }

    /**
     * Checks if two queues are equal both in size and content
     * @param in Queue to be compared to
     * @return	true if equal, false otherwise
     */
    public boolean equals(GenericQueue<?> in) {
        GenericQueue<T> tempCopy = (GenericQueue<T>) in.copy();
        Node temp = tempCopy.front;
        Node temp2 = front;
        if(size() != in.size()) {
            return false;
        }

        while(temp != null) {
            if(!temp.value.equals(temp2.value)) {
                return false;
            } else {
                temp = temp.next;
                temp2 = temp2.next;
            }
        }
        return true;
    }
    /**
     * Traverses and finds the size of the queue
     *
     * @return	Integer size of the queue
     */
    public int size() {
        Node temp = front;
        int counter = 0;
        while(temp != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
    }

}
