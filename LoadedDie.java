package abhamare_lab2;

import java.util.Random;
/**
 * The LoadedDie class simulates a six-sided die, with loadedNumber and
 * count how many times per 100 rolls come up with the loaded number.
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class LoadedDie
{
    final int NUMBER_OF_SIDES = 6;               // Number of sides
    private int value;                          // The die's value
    private int loadedNumber;                   // To hold loadedNumber
    private int moreTimesPerHundred;            // To hold moreTimesPerHundred
    private Random random;                      // To hold random

    /**
     * The constructor performs an initial roll of the die.
     *
     * @param loadedNumber which number should come up more often
     * @param moreTimesPerHundred how many times per 100 rolls to come up with
     * the loaded number (instead of uniform random)
     */
    public LoadedDie(int loadedNumber, int moreTimesPerHundred)
    {
        this.loadedNumber = loadedNumber;
        this.moreTimesPerHundred = moreTimesPerHundred;
        random= new Random();

        // Calling roll method
        roll();
    }

    /**
     * The roll method simulates the rolling of the die.
     * It will typically set this die's value to a random value
     * with uniform distribution between 1 and 6. Occasionally,
     * it will a priori return the favored value (with frequency
     * determined by the moreTimesPerHundred argument that was passed
     * to the constructor).
     */
    public int roll()
    {
        int range = 99;

        //get random number between 0 and 99
        if (random.nextInt(range) < moreTimesPerHundred)
        {
            value = loadedNumber;
        }
        else
        {
            // Get a random value for the die between 1 to 6.
            value = 1 + random.nextInt(NUMBER_OF_SIDES);
        }
      return value;
    }



    /**
     * getValue method
     *
     * @return The value of the die.
     */
    public int getValue()
    {
        return value;
    }

}
