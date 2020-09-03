/*
 *Ashlesha Bhamare
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package abhamare_lab7;
/**
 * This class has all the methods required to implement a queue for
 * l system rendering
 *
 * @author Ashlesha Bhamare
 * @version: 1.0
 */
public class RenderQueue {

    /**
     * Node class for holding doubly linked list node details
     */
    private static class Node {

        public RenderCommand render;               // To hold render
        public Node next;                          // to hold next
        public Node prev;                          // to hold prev

        /**
         * Constructor to initialize stack and top
         *
         * @param  render to hold render command
         * @param prev holding prev node
         * @param next hold next node
         */
        public Node(RenderCommand render, Node prev, Node next) {
            this.render = render;
            this.prev = prev;
            this.next = next;
        }
    }

    // will need to add a Node
    private Node head;
    private Node tail;	
		
    /**
     * Enqueue all the elements from another queue onto this queue.
     * @param other the queue with the elements to enqueue
     */
	public void append(RenderQueue other) {

        for (Node p = other.head; p != null; p = p.next)
            enqueue(p.render);		
	}

    /**
     * Make a deep copy of the queue. This means
     * that you will create a new RendorQueue, and copy the contents of the
     * current queue to the new queue. This means you have to remove from the
     * current queue and add to the new queue. This likely will mean starting
     * from the head and getting each value from the node and calling enqueue
     * on the new queue that you will return.
     *
     * @return the new queue you created.
     */
	public RenderQueue copy() {		
        RenderQueue theCopy = new RenderQueue();

        Node temp=head;
        while (temp!=null) {
            theCopy.enqueue(temp.render);
            temp=temp.next;
        }
        return theCopy;
	}

    /**
     * Remove an element from the front of the queue (oldest element in the 
     * queue).
     *
     * @return oldest element's payload 
     */
	public RenderCommand dequeue() {

        if (head == null) {
            throw new IllegalArgumentException("cannot dequeue from "
                    + "empty queue");
        }
        
        RenderCommand render = head.render;
        head=head.next;
        if(head==null)
            tail=null;

        return render;
	}

    /**
     * Add an element to the end of the queue.
     *
     * @param render new element's payload
     */	
	public void enqueue(RenderCommand render) {
        if (empty()) {
            tail = new Node(render, null, null);
            head = tail;

        } else {

            Node newNode= new Node(render, null, tail);
            tail.next=newNode;
            newNode.prev=tail;
            tail = newNode;
            tail.next=null;
        }
	}

	/**
    * You will need to examine each character of queueString, and you will
    * figure out which RendorCommand it is:
    * For instance if it is a 'F' it will be RenderCommand.FORWARD, if it is 'R'
    * it is RendorCommand.FORWARD2. Remember there are seven RendorCommands.
    * You will need to enqueue each RendorCommand that you derive from then
    *  string into a new queue that you will return.
    *
    * @param queueString : Contains the RendorCommands in string form.
    * @return the corresponding queue
    */
	public static RenderQueue fromString(String queueString) {
        RenderQueue q = new RenderQueue();
        for(char c: queueString.toCharArray()) {
            switch(c)
            {
                case 'F': q.enqueue(RenderCommand.FORWARD);break;
                case 'R': q.enqueue(RenderCommand.FORWARD2);break;
                case 'X': q.enqueue(RenderCommand.IGNORE);break;
                case '-': q.enqueue(RenderCommand.RIGHT);break;
                case '+': q.enqueue(RenderCommand.LEFT);break;
                case '[': q.enqueue(RenderCommand.PUSH);break;
                case ']': q.enqueue(RenderCommand.POP);break;
            }
        }
        return q;
	}

    /**
     * String representation of the queue contents.
     * Uses traditional notation for the render commands.
     * @return the string representation
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Node p = head; p != null; p = p.next)
            switch(p.render) {
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

	/**
     * Reports if the queue has any elements.
     *
     * @return true if the queue has zero elements, false otherwise
     */	
	public boolean empty() {
		// TODO Auto-generated method stub
        return head == null;		

	}

}
