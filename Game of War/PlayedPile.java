
import java.util.ArrayList;

/*
 * Played Pile class inherits from set of cards
 * Controls cards that have been played
 */

/**
 *
 * @author alishbamalik
 */
public class PlayedPile extends SetOfCards{
    private Card card;
    
    /**
     * constructor
     * pre: none
     * post: played pile object is created.
     */
    public PlayedPile(){
        playedPile = new ArrayList<Card>();
    }
    
    /**
     * Adds card to played pile array list
     * pre: card is not in pile
     * post: card has been added to players played pile
     */
    public void addCard(Card card){
        playedPile.add(card);
    }
    
    /**
     * Removes card.
     * pre: card is still in pile.
     * post: card is removed.
     */
    public void removeCard(Card card){
        playedPile.remove(card);
    }
    
    /**
     * Returns drawn card.
     * pre: none
     * post: most recently drawn card is returned.
     */
    public Card getDrawnCard(){
        return card = playedPile.get(playedPile.size()-1);     //gets the last element in the played pile
    }
    
    /**
     * Returns size of played pile.
     * pre: none
     * post: size of played pile is returned.
     */
    public int getSize(){
        return playedPile.size();
    }
    
    /**
     * Returns card at a given spot.
     * pre: none
     * post: card is returned
     */
    public Card getCard(int index){
        return playedPile.get(index);
    }
    
    /**
     * Clears played pile array list
     * pre: array list contains elements
     * post: array list is cleared
     */
    public void clearList(){
        playedPile.clear();
    }
}
