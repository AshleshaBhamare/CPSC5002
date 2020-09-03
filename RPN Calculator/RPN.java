/*
 * Ashlesha Bhamare
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package abhamare_lab6;

import java.util.Scanner;
/**
 * RPN Evaluates and Validates a postfix expressions using stack
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class RPN {

    private String expression;                    // To hold Expression
    private ArrayStack stack;                     // To hold Array of Stack
    private Scanner scan;                         // To hold Scanner

    /**
     * Constructor to initialize expression, Stack and scanner.
     * @param expression Postfix expression
     */
    public RPN(String expression)  {
        this.expression = expression;
        stack = new ArrayStack(10);
        scan = new Scanner(expression);
    }

    /**
     * Evaluates the postfix expression
     * @return result of the expression string
     */
    public double evaluateExpression()
    {
        double result = 0.0;                     // To hold result

        // Checking if the expression has enough operators
        if (!validPostfixExpression(expression)) {
            throw new IllegalArgumentException("not enough operators!");
        }

        // Scanning each string from expression separated by a space
        while (scan.hasNext()) {
            // It's an operand
            if (scan.hasNextDouble()) {
                stack.push(Double.parseDouble(scan.next()));
            }

            else {
                performTheOperations(scan.next());
            }
        }
        result = stack.pop();
        return result;
    }

    /**
     * Validates whether the expression is correct
     * @param exp postfix expression
     * @return true if it is a valid expression
     */
    private boolean validPostfixExpression(String exp) {
        int operandCount = 0;
        int operatorCount = 0;
        Scanner scan = new Scanner(exp);

        while (scan.hasNext()) {
            if (scan.hasNextDouble()) {
                operandCount++;
            } else {
                operatorCount++;
            }
            scan.next();
        }

        scan.close();

        if((operandCount - operatorCount) <= 1) {
            return true;
        }

        return false;
    }

    /**
     * Performs different operations like add, subtract, multiply, divide
     * @param operator to be applied on operands
     */
    private void performTheOperations(String operator) {

        if (stack.size() < 2) {
            throw new IllegalArgumentException("too many operators!");
        }

        double a = stack.pop();
        double b = stack.pop();

        switch (operator) {
            case "+":
                stack.push(a + b);
                break;
            case "-":
                stack.push(b - a);
                break;
            case "*":
                stack.push(a * b);
                break;
            case "/":
                stack.push(b / a);
                break;
            default:
                throw new IllegalArgumentException("Unknown operator: "
                                                                + operator);
        }
    }
}
