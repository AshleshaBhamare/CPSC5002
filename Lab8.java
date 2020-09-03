/*
 *Ashlesha Bhamare
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package abhamare_lab8;
import java.sql.SQLOutput;

/**
 * This class demonstrates the working of GenericStack and GenericQueue classes,
 * each with two different data type arguments for each.
 *
 * @author Ashlesha Bhamare
 * @version: 1.0
 */
public class Lab8 {
    /**
     * To test the methods creating in GenericStack and GenericQueue classes
     * using string and double datatype.
     *
     * @param args A string array containing the command line arguments
     */
    public static void main(String[] args) throws StackOverFlowException {
        String str;

        // Testing String stack
        GenericStack<String> stack = new GenericStack<String>(5);
        System.out.println("Stack of Strings");

        // Testing empty method
        System.out.println("Stack is Empty: (True) " + stack.empty());
        // Testing push method
        str = "Pushing onto the stack.";
        System.out.println(str);

        stack.push("John");
        stack.push("Milli");
        stack.push("Ashley");
        stack.push("Grammy");
        stack.push("Betty");

        // Testing toString method
        System.out.println("Testing toString method: " + stack);

        // Testing size method
        System.out.println("Size of Stack is: " + stack.size());
        // Testing peek method
        str = "Value at top of the stack is: ";
        System.out.println(str + stack.peek());

        // Testing equals and copy method
        GenericStack <String> stack1 = new GenericStack<>(6);
        System.out.println("Testing Empty and NonEmpty stack: (False)"
                                            + stack1.equals(stack));
        stack1 = stack.copy();
        System.out.println("Stack1: " + stack1);

        System.out.println("Testing stack and stack1 equals: (True) "
                + stack1.equals(stack));

        // Testing pop method and printing the values
        str = "Popping and printing all values:";
        System.out.println(str);
        while (!stack.empty())
            System.out.print(stack.pop() + " ");

        System.out.println();

        System.out.println("**********************************************");
        // Testing double stack
        GenericStack<Double> stack2 = new GenericStack<Double>(4);

        System.out.println("Stack of Doubles");

        // Testing empty method
        System.out.println("Stack is Empty: (True) " + stack.empty());

        // Testing push method
        stack2.push(34.67);
        stack2.push(19.45);

        // Testing toString method
        System.out.println("Testing toString method: " + stack2);

        // Testing size method
        System.out.println("Size of Stack is: " + stack2.size());

        // Testing peek method
        str = "Value at top of the stack is: ";
        System.out.println(str + stack2.peek());

        // Testing equals and copy method
        GenericStack <Double> stack3 = new GenericStack<>(4);
        System.out.println("Testing Empty and NonEmpty stack: (False) "
                + stack3.equals(stack2));
        stack3 = stack2.copy();
        System.out.println("Stack3: " + stack2);

        System.out.println("Testing stack2 and stack3 equals: (True) "
                + stack3.equals(stack2));

        // Testing pop method and printing the values
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());

        System.out.println("***********************************************");
        // Testing queue for Strings
        GenericQueue<String> queue = new GenericQueue<String>();
        // Testing Empty method
        System.out.println("Queue Empty: (True): " + queue.empty());
        // pushing 4 strings to queue
        queue.enqueue("Alfonso");
        queue.enqueue("Bob");
        queue.enqueue("Carol");
        queue.enqueue("Anny");

        // Tests toString method
        System.out.println(queue);

        // Testing size method
        System.out.println("Size of Queue is: " + queue.size());

        // Testing peek method
        str = "Value at top of the Queue is: ";
        System.out.println(str + queue.peek());

        // Copy and Equals method
        GenericQueue <String> queue1 = new GenericQueue<>();
        queue1 = queue.copy();
        System.out.println("queue1: " + queue1);

        System.out.println("queue and queue1 are equals: (True): "
                                                 + queue.equals(queue1));
        // Test dequeue method
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);

        System.out.println();
        // Testing queue for Doubles
        GenericQueue <Double> queue2 = new GenericQueue<>();
        // Testing Empty method
        System.out.println("Queue Empty: (True): " + queue2.empty());
        // pushing 4 Numbers to queue
        queue2.enqueue(23.67);
        queue2.enqueue(12.89);
        queue2.enqueue(67.90);

        // Tests toString method
        System.out.println(queue2);

        // Testing size method
        System.out.println("Size of Queue is: " + queue2.size());

        // Testing peek method
        str = "Value at top of the Queue is: ";
        System.out.println(str + queue2.peek());

        // Testing equals and copy method
        GenericQueue <Double> queue3 = new GenericQueue<>();
        System.out.println("Testing Empty and NonEmpty queue: (False) "
                + queue3.equals(queue2));
        queue3 = queue2.copy();
        System.out.println("queue3: " + queue2);

        System.out.println("Testing queue2 and queue3 equals: (True) "
                + queue3.equals(queue2));

        // Test dequeue method
        queue2.dequeue();
        System.out.println(queue2);

    }
}
