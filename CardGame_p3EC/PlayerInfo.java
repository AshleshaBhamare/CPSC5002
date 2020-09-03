/*
 *Ashlesha Bhamare
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package abhamare_p3EC;
/**
 * This Class stores information about a player, including current hand and
 * name of the player
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class PlayerInfo {

    private String playerName;                       // name of the player
    private GenericQueue<Integer> hand;              // hand of cards

    /**
     * Constructor
     * @param name player's name
     */
    public PlayerInfo(String name) {
        this.playerName = name;
        hand = new GenericQueue<Integer>();
    }
    /**
     * Copy constructor
     * @param object2 player to be copied
     */
    public PlayerInfo(PlayerInfo object2) {
        playerName = object2.playerName;
        hand = object2.hand;
    }
    /**
     * Get method for the name of the player
     * @return Player's name
     */
    public String getName() {
        return playerName;
    }
    /**
     * Get method for the hand of the player
     * @return Player's hand (queue)
     */
    public GenericQueue<Integer> getQueue() {
        return hand;
    }

}
