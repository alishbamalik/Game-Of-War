
import java.util.ArrayList;

/*
 * Super abstract class of deck, hand, and playedPile
 */

/**
 *
 * @author alishbamalik
 */
abstract public class SetOfCards {
    /* members accesible by all child classes */
    protected ArrayList<Card> deck;
    protected ArrayList<Card> hand;
    protected ArrayList<Card> playedPile;
    
    /**
     * Adds a card to pile.
     * pre: card is not in pile.
     * post: card is added to pile.
     */
    abstract public void addCard(Card card);
    
    /**
     * Removes card from pile.
     * pre: card is in pile.
     * post: card is removed from pile.
     */
    abstract public void removeCard(Card card);
    
}
