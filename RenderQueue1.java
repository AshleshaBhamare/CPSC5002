/*
package abhamare_lab7;

public class RenderQueue {

    private static class Node {

        public RenderCommand render;
        public Node next, prev;

        public Node(RenderCommand render, Node prev, Node next) {
            this.render = render;
            this.prev = prev;
            this.next = next;
        }
    }

    // You will need to add a Node
    private Node head;
    private Node tail;

    */
/**
     * Enqueue all the elements from another queue onto this queue.
     *
     * @param other the queue with the elements to enqueue
     *//*


    public void append(RenderQueue other) {

        for (Node p = other.head; p != null; p = p.next)
            enqueue(p.render);
    }

    */
/**
     * Make a deep copy of the queue. This means
     * that you will create a new RendorQueue, and copy the contents of the current queue to
     * the new queue. This means you have to remove from the current queue and add to the new queue.
     * This likely will mean starting from the head and getting each value from the node and calling enqueue on the new queue that you will return.
     *
     * @return the new queue you created.
     *//*


    public RenderQueue copy() {
        RenderQueue theCopy = new RenderQueue();
        Node temp=head;
        while (temp!=null) {
            theCopy.enqueue(temp.render);
           temp=temp.next;
        }
        return theCopy;
    }


    */
/**
     * Remove an element from the front of the queue (oldest element in the
     * queue).
     *
     * @return oldest element's payload
     *//*


    public RenderCommand dequeue() {


        if (head == null) {
            throw new IllegalArgumentException("cannot dequeue from "
                    + "empty queue");
        }

        RenderCommand render = head.render;
        head = head.next;


        return render;

    }


    */
/**
     * Add an element to the end of the queue.
     *
     * @param render new element's payload
     *//*

    public void enqueue(RenderCommand render) {

        if (empty()) {
            tail = new Node(render, null, null);
            head = tail;

        } else {
            //Add to the end of existing link
            Node newNode= new Node(render, null, tail);
            tail.next=newNode;
            newNode.prev=tail;
            tail = newNode;
            tail.next=null;

        }

    }

    */
/**
     * You will need to examine each character of queueString, and you will
     * figure out which RendorCommand it is:
     * For instance if it is a 'F' it will be RenderCommand.FORWARD, if it is 'R' it is RendorCommand.FORWARD2. Remember there are seven RendorCommands.
     * You will need to enqueue each RendorCommand that you derive from the string into a new queue that you will return.
     *
     * @param queueString : Contains the RendorCommands in string form.
     * @return the corresponding queue
     *//*


    public static RenderQueue fromString(String queueString) {
        RenderQueue q = new RenderQueue();
        for (char c : queueString.toCharArray()) {
            // You will need some type of switch statement to change each char into a RendorCommand. You will then enqueue it
            // example: q.enqueue(RenderCommand.FORWARD);
            switch(c)
            {

                case 'F': q.enqueue(RenderCommand.FORWARD);
                case 'R': q.enqueue(RenderCommand.FORWARD2);
                case 'X': q.enqueue(RenderCommand.IGNORE);
                case '-': q.enqueue(RenderCommand.RIGHT);
                case '+': q.enqueue(RenderCommand.LEFT);
                case '[': q.enqueue(RenderCommand.PUSH);
                case ']': q.enqueue(RenderCommand.POP);


            }

        }
        return q;
    }


    */
/**
     * String representation of the queue contents.
     * Uses traditional notation for the render commands.
     *
     * @return the string representation
     *//*

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Node p = head; p != null; p = p.next)
            switch (p.render) {
                case FORWARD:
                    s.append('F');
                    break;
                case FORWARD2:
                    s.append('R');
                    break;
                case IGNORE:
                    s.append('X');
                    break;
                case RIGHT:
                    s.append('-');
                    break;
                case LEFT:
                    s.append('+');
                    break;
                case PUSH:
                    s.append('[');
                    break;
                case POP:
                    s.append(']');
                    break;
                default:
                    s.append('?');
                    break;
            }
        return s.toString();
    }


    */
/**
     * Reports if the queue has any elements.
     *
     * @return true if the queue has zero elements, false otherwise
     *//*

    public boolean empty() {
        // TODO Auto-generated method stub
        return head == null;

    }
}*/
