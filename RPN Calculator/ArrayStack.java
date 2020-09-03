/*
 * Ashlesha Bhamare
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package abhamare_lab6;

import java.util.EmptyStackException;
/**
 * This class implements stack using array
 *
 * @author Ashlesha Bhamare
 * @version: 1.0
 */
public class ArrayStack {

    private int top;                              // To hold top
    private double[] stack;                       // To hold stack

    /**
     * Constructor to initialize stack and top
     *
     * @param capacity The capacity of the stack.
     */
    public ArrayStack(int capacity)  {
        stack = new double[capacity];
        top = 0;
    }

    /**
     *The size method
     *
     * @return size of the stack
     */
    public int size()
    {
        return top;
    }

    /**
     * The empty method checks for an empty stack.
     *
     * @return true if stack is empty.
     */
    public boolean empty()
    {
        return top == 0;
    }

    /**
     * The push method pushes a value onto the stack.
     *
     * @param x The value to push onto the stack.
     * @exception StackOverflowException When the stack is full.
     */
    public void push(double x) {
        if (top == stack.length) {
            throw new StackOverFlowException();
        }
        else {
            stack[top] = x;
            top++;
    }

    }

    /**
     * The pop method pops a value off the stack.
     *
     * @return The value popped.
     * @exception EmptyStackException When the stack is empty.
     */

    public double pop() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            top--;
            return stack[top];
        }
    }

    /**
     * The peek method returns the value at the top of the stack.
     *
     * @return value at top of the stack.
     * @exception EmptyStackException When the stack is empty.
     */

    public double peek() {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            return stack[top - 1];
        }

    }


}
