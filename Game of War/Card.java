/*
 * Card Class implements comparable interface
 * 52 card objects in deck 
 */

/**
 *
 * @author alishbamalik
 */
public class Card implements Comparable{
    private int value;
    private char suit;
    
    /**
     * Constructor
     * pre: none
     * post: card object has been made.
     */
    public Card(int v, char s){
        value = v;
        suit = s;
    }
    
    /**
     * Returns suit of the card.
     * pre: none
     * post: Suit of the card is returned.
     */
    public char getSuit(){
        return suit;
    }
    
    /**
     * Returns value of the card.
     * pre: none
     * post: Value of card is returned.
     */
    public int getValue(){
        return value;
    }
    
    /**
     * Displays value and suit of the card.
     * pre: none
     * post: Value and suit of the card is displayed.
     */
    public String toString(){
        String s;
        s = "Card: " + getValue() + " of " + getSuit();
        return s;
    }
    
    /**
     * Compares two cards
     * pre: none
     * post: Returns 0 if cards are the same, -1 if smaller or 1 if greater
     */
    public int compareTo(Object c){
        Card card = (Card)c;
        if (getValue() > card.getValue()){          //if object is greater
            return 1;
        } else if (getValue() < card.getValue()){   //if object is smaller
            return -1;
        } else {                                    //if both cards are the same in value then its a tie
            return 0;
        }
    }
}
