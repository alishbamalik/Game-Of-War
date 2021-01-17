
import java.util.ArrayList;

/*
 * Hand Class inherits from Set of Cards
 * Controls the hand of each player
 */

/**
 *
 * @author alishbamalik
 */
public class Hand extends SetOfCards{
    private Card card;
    
    /**
     * Constructor
     * pre: none
     * post: Hand object is created.
     */
    public Hand(){
        hand = new ArrayList<Card>();
    }
    
    /**
     * Adds card to hand.
     * pre: card is not in hand
     * post: card is added to hand.
     */
    public void addCard(Card card){
        hand.add(card);
    }
    
    /**
     * Removes card.
     * pre: card is still in hand.
     * post: card is removed.
     */
    public void removeCard(Card card){
        hand.remove(card);
    }
    
    /**
     * Draws card from hand.
     * pre: none
     * post: card is drawn.
     */
    public Card getTopCard(){
        return card = hand.get(0);            
    }
    
    /**
     * Returns size of hand.
     * pre: none
     * post: size of hand is returned.
     */
    public int getSize(){
        return hand.size();
    }
      
}
