/*
 * Ashlesha Bhamare
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package abhamare_lab8;

import java.util.EmptyStackException;
/**
 * This class implements Generic stack using array
 *
 * @author Ashlesha Bhamare
 * @version: 1.0
 */
public class GenericStack <T>
{

    private int top;                              // To hold top
    private T[] stack;                            // To hold stack
    private int stackSize;                        // Total stack size

    /**
     * Constructor to initialize stack and top
     *
     * @param capacity The capacity of the stack.
     */
    public GenericStack(int capacity)  {
        stack = (T[]) (new Object[capacity]);
        top = 0;
        stackSize = capacity;
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
    public void push(T x) throws StackOverFlowException {
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

    public T pop() throws EmptyStackException {
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
    public T peek() throws EmptyStackException {
        if (empty()) {
            throw new EmptyStackException();
        } else {
            return stack[top - 1];
        }
    }

    /**
     * Makes a deep copy of the stack
     * @return	The copied stack
     */
    public GenericStack<T> copy() throws StackOverFlowException {
        GenericStack<T> copiedStack = new GenericStack<T>(stackSize);
        for(int i = 0; i < top; i++) {
            copiedStack.push(stack[i]);
        }
        return copiedStack;
    }

    /**
     * Generates string representation of the stack
     * @return	String representation of the stack
     */
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        for(int i = 0; i < top; i++) {
            sBuilder.append(stack[i] + " ");
        }
        return sBuilder.toString();
    }

    /**
     * Checks if two stacks are equal in size and content
     * @param firstStack Stack to be compared to
     * @retun True if equal.
     */
    public boolean equals(GenericStack<?> firstStack) {
        if(top != firstStack.top) {
            return false;
        }

        for(int i = 0; i < top; i++) {
            if(!(stack[i].equals(firstStack.stack[i]))) {
                return false;
            }
        }
        return true;
    }

}
