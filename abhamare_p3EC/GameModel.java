/*
 *Ashlesha Bhamare
 * CPSC 5002, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package abhamare_p3EC;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class plays a card game where the users card is compared
 * to the top of the discardStack
 *
 * @author Ashlesha Bhamare
 * @version 1.0
 */
public class GameModel
{

    private int playerCount;                       // To hold playerCount

    // Stack to holds the discard pile
    private GenericStack<Integer> discardStack = new GenericStack<Integer>(52);

    // Stack to holds the cards left to deal
    private GenericStack<Integer> dealStack = new GenericStack<Integer>(52);

    // Arraylist to holds cards
    private ArrayList<Integer> cards = new ArrayList<>();

    // To hold all players in the game
    private GenericQueue<PlayerInfo> players = new GenericQueue<PlayerInfo>();

    /**
     * Constructor
     * @param players Queue of current players
     * @param playerCount Total number of players
     */
    public GameModel(GenericQueue<PlayerInfo> players, int playerCount)
                                             throws StackOverFlowException {
        this.players = players;
        this.playerCount = playerCount;
        generateDeck();
        dealInitialHand();
    }

    /**
     * Gets the deal stack
     * @return Deal stack
     */
    public GenericStack<Integer> getDealStack() {
        return dealStack;
    }

    /**
     * Gets queue of all players
     * @return Queue of players
     */
    public GenericQueue<PlayerInfo> getPlayers() {
        return players;
    }

    /**
     * Gets the top of discard stack
     * @return Top of the discard stack
     */
    public int getDiscardStackTop() {
        return discardStack.peek();
    }

    /**
     * This performs 1st move for the current player
     * @return	Message for the move the player made
     */
    public String playerMove() throws StackOverFlowException
    {
        PlayerInfo currentPlayer = players.peek();

        if(currentPlayer.getQueue().peek() > discardStack.peek()) {
            discardStack.push(currentPlayer.getQueue().dequeue());
            if(checkWinner(currentPlayer)) {
                return "You have won the game!";
            } else {
                players.dequeue();
                players.enqueue(currentPlayer);
                return "Your card is HIGHER, turn is over";
            }
        } else if(currentPlayer.getQueue().peek() == discardStack.peek())
        {
            discardStack.push(currentPlayer.getQueue().dequeue());
            currentPlayer.getQueue().enqueue(dealStack.pop());
            if(checkWinner(currentPlayer)) {
                return "You have won the game!";
            } else {
                players.dequeue();
                players.enqueue(currentPlayer);
                return "Your card is equal, pick up 1 card";
            }
        } else if(currentPlayer.getQueue().peek() < discardStack.peek()
                && dealStack.size() == 1) {
            discardStack.push(currentPlayer.getQueue().dequeue());
            currentPlayer.getQueue().enqueue(dealStack.pop());
            refillDealStack();
            currentPlayer.getQueue().enqueue(dealStack.pop());
            if(checkWinner(currentPlayer)) {
                return "You have won the game!";
            } else {
                players.dequeue();
                players.enqueue(currentPlayer);
                return "Your card is LOWER, pick up 2 cards";
            }
        } else {
            discardStack.push(currentPlayer.getQueue().dequeue());
            currentPlayer.getQueue().enqueue(dealStack.pop());
            currentPlayer.getQueue().enqueue(dealStack.pop());
            if(checkWinner(currentPlayer)) {
                return "You have won the game!";
            } else {
                players.dequeue();
                players.enqueue(currentPlayer);
                return "Your card is LOWER, pick up 2 cards";
            }
        }
    }
    /**
     * Checking if either player has won on the turn
     * @param currentPlayer Which players hand to check
     * @return true if winner, false if not
     */
    private boolean checkWinner(PlayerInfo currentPlayer) {
        return currentPlayer.getQueue().empty();
    }
    /**
     * Refills the deal stack by flipping the discard stack when the deal stack
     * is empty
     */
    public void refillDealStack() throws StackOverFlowException {
        int discardTop = discardStack.pop();
        while(!discardStack.empty()) {
            dealStack.push(discardStack.pop());
        }
        discardStack.push(discardTop);
    }


    /**
     * Generates all cards of the deck
     * @return All of the cards
     */
    private ArrayList<Integer> generateAllCards() {
        for(int i = 0; i < 4; i++) {
            for(int j = 1; j < 14; j++) {
                cards.add(j%14);
            }
        }
        return cards;
    }
    /**
     *	Takes all the cards and shuffles them into the stack, and generates
     *	the deck of the cards
     */
    private void generateDeck() throws StackOverFlowException {
        cards = generateAllCards();
        shuffleDeck(cards);
        for(int i = 0; i < cards.size(); i++) {
            this.dealStack.push(cards.get(i));
        }
    }
    /**
     * Shuffles the cards
     * <a href="https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle">
     * Fisher-Yates algorithm</a>
     * @param cards deck to shuffle
     */
    private void shuffleDeck(ArrayList<Integer> cards) {
        Random rand = new Random();
        for (int i = cards.size(); i > 1; i--) {
            int j = rand.nextInt(i);
            int temp = cards.get(i - 1);
            cards.set(i - 1, cards.get(j));
            cards.set(j, temp);
        }
    }

    /**
     * This method Deals the initial hand to the players
     */
    private void dealInitialHand() throws StackOverFlowException {
        PlayerInfo currentPlayer;
        for(int i = 0; i < playerCount * 7; i++) {
            currentPlayer = players.dequeue();
            currentPlayer.getQueue().enqueue(dealStack.pop());
            players.enqueue(currentPlayer);
        }
        discardStack.push(dealStack.pop());
    }

}