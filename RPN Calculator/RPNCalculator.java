/*
 * Ashlesha Bhamare
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package abhamare_lab6;

import java.util.Scanner;
/**
 * This class gets the postfix expression from the console and prints the
 * evaluation
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class RPNCalculator {
    /**
     * Gets the postfix expression from the console and prints the evaluation
     *
     * @param args command line args
     * @throws IllegalArgumentException
     */
    public static void main(String[] args) throws IllegalArgumentException {

        String input;                              // To hold input
        double answer;                             // To hold answer

        // Creating scanner object
        Scanner keyboard = new Scanner(System.in);

        System.out.println("RPN Calculator");

        System.out.println("\n(blank line to quit)");

        // Keep asking for postfix expressions until user enters blank line
        do {
            System.out.print("calc> ");
            input = keyboard.nextLine();

            if(input.length() == 0) {
                System.out.print("\nBye!\n");
                return;
            }

            RPN rpn = new RPN(input);

            answer = rpn.evaluateExpression();

            System.out.println(answer);
        }
        while(input.length() > 0);

        keyboard.close();                    // closing scanner
    }
}
