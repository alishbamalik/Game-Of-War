
import java.util.ArrayList;
import java.util.Collections;

/*
 * Deck class inherits from set of cards
 * contains 52 card objects to create initial deck
 */

/**
 *
 * @author alishbamalik
 */
public class Deck extends SetOfCards {
    private Card card;
    
    /**
     * Constructor
     * pre: none
     * post: deck object has been created 
     */
    public Deck (){
        deck = new ArrayList<Card>();
        
        /*add 52 cards to deck*/
        for (int i = 2; i < 15; i++){           //cards are numbered 2 to 15 with no jack, queens or kings (only numerical values)
            card = new Card(i, 'D');            //adding diamonds suit
            deck.add(card);
            card = new Card(i, 'H');            //adding hearts suit
            deck.add(card);
            card = new Card(i, 'S');            //adding spades suit
            deck.add(card);
            card = new Card(i, 'C');            //adding clubs suit
            deck.add(card);
        }
        
        shuffleDeck();          //shuffles deck
    }
    
    /**
     * Shuffle deck of cards
     * pre: cards are organized.
     * post: Cards are shuffled.
     */
    private void shuffleDeck(){
        Collections.shuffle(deck);
    }
    
    /**
     * Adds cards to deck.
     * pre: card is not in deck.
     * post: Card is added to deck.
     */
    public void addCard(Card card){
        hand.add(card);
    }
    
    /**
     * Removes card 
     * pre: card is still in deck.
     * post: card is removed
     */
    public void removeCard(Card card){
        deck.remove(card);
    }
    
    /**
     * Draws card from deck.
     * pre: none
     * post: card is drawn.
     */
    public Card getTopCard(){
        return card = deck.get(0);             
    }
    
    /**
     * Checks if deck is empty.
     * pre: none
     * post: true returned if desk is empty, false returned if desk is not empty
     */
    public boolean isEmpty(){
        boolean empty = true;
        for (int i = 0; i < deck.size();i++){
            if (deck.get(i) == null){
                empty = true;
            } else {
                empty = false;
                break;
            }
        }
        return empty;
    }
    
    
}
