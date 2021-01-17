
import java.util.Scanner;

/*
 * Game class
 * Contains engine to play game
 */

/**
 *
 * @author alishbamalik
 */
public class Game {
    public Deck deck;
    public Hand handPlayer1;
    public Hand handPlayer2;
    public PlayedPile playedPilePlayer1;
    public PlayedPile playedPilePlayer2;
    private int round;
    
    /**
     * Plays game
     * pre: none
     * post: game object is created
     */
    public Game(){
        deck = new Deck();
        handPlayer1 = new Hand();                    
        handPlayer2 = new Hand();   
        playedPilePlayer1 = new PlayedPile();
        playedPilePlayer2 = new PlayedPile();
        round = 0;
        
        /*Distributes cards to players*/
        for(int i = 0; i < 26; i++){
            handPlayer1.addCard(deck.getTopCard());                            //distributing card to player 1
            deck.removeCard(deck.getTopCard());                                      //removing card from deck
            
            handPlayer2.addCard(deck.getTopCard());                            //distributing card to player 2
            deck.removeCard(deck.getTopCard());                                      //removing card from deck
        }
    }
    
    /**
     * Plays one round of the game
     * pre: none
     * post: one round is played
     */
    public void play(boolean m){
        final boolean manual = m;
        String userInput;
        Scanner input = new Scanner(System.in);
        
        /*keeping track of round*/
        round += 1;
        System.out.println("\n----------Round "+ round + "-----------");

        
        /* automatic game */
        if (manual == true){ 
            do {
                /*prompts player 1 to draw a card*/ System.out.print("\n| Player 1 (D)raw a card | ");
                userInput = input.next();

                if (userInput.equalsIgnoreCase("D")){
                    playedPilePlayer1.addCard(handPlayer1.getTopCard());    //top card from hand pile is shifted to played pile
                    handPlayer1.removeCard(handPlayer1.getTopCard());       //top card is removed from hand
                } else {                                                    
                    System.out.println("Invalid Move.");
                }
            } while(!userInput.equalsIgnoreCase("D"));

            do {
                /*prompts player 2 to draw a card*/
                System.out.print("| Player 2 (D)raw a card | ");
                userInput = input.next();

                if (userInput.equalsIgnoreCase("D")){
                    playedPilePlayer2.addCard(handPlayer2.getTopCard());    //top card from hand pile is shifted to played pile
                    handPlayer2.removeCard(handPlayer2.getTopCard());       //top card is removed from hand
                } else {
                    System.out.println("Invalid Move. Please Try Again.");
                }
            } while(!userInput.equalsIgnoreCase("D"));
        
        /* manual game */    
        } else if (manual == false){
            
            /* shifting card from hand to play pile for player 1 */
            playedPilePlayer1.addCard(handPlayer1.getTopCard());    //top card from hand pile is shifted to played pile
            handPlayer1.removeCard(handPlayer1.getTopCard());       //top card is removed from hand
            
            /* shifting card from hand to play pile for player 2 */
            playedPilePlayer2.addCard(handPlayer2.getTopCard());    //top card from hand pile is shifted to played pile
            handPlayer2.removeCard(handPlayer2.getTopCard());       //top card is removed from hand
        }
        
        /* compares the cards drawn*/
        Card player1Card = playedPilePlayer1.getDrawnCard();        //temporary variable for drawn card of player 1
        Card player2Card = playedPilePlayer2.getDrawnCard();        //temporary variable for drawn card of player 2
        
        /*Displays cards drawn*/
        System.out.println("\nPlayer 1 Drew - " + player1Card);
        System.out.println("Player 2 Drew - " + player2Card);
        
        int comparedResult = player1Card.compareTo(player2Card);    //comparing cards
        
        if (comparedResult == 1){                                   //player 1 wins
            System.out.println("PLAYER 1 WINS!");
            System.out.println("----------------------------");
            for (int i = 0; i < playedPilePlayer1.getSize(); i++){
                handPlayer1.addCard(playedPilePlayer1.getCard(i));              //adds player 1 pile to player 1 hand
            }
               
            playedPilePlayer1.clearList();                                      //removes cards from player 1 pile
              
            for (int i = 0; i < playedPilePlayer2.getSize(); i++){
                handPlayer1.addCard(playedPilePlayer2.getCard(i));              //adds player 2 pile to player 1 hand
            }
            
            playedPilePlayer2.clearList();                                      //removes cards from player 2 pile
            
            /* displaying hand amounts for player 1*/
            System.out.println("PLAYER 1");
            System.out.println("Hand Pile: " + handPlayer1.getSize());
            
            /* displaying hand amounts for player 2 */
            System.out.println("\nPLAYER 2");
            System.out.println("Hand Pile: " + handPlayer2.getSize());
            
        } else if (comparedResult == -1){                           //player 2 wins
            System.out.println("PLAYER 2 WINS!");
            System.out.println("----------------------------");
            
            for (int i = 0; i < playedPilePlayer2.getSize(); i++){
                handPlayer2.addCard(playedPilePlayer2.getCard(i));              //adds player 2 pile to player 2 hand
            }
            
            playedPilePlayer2.clearList();                                      //removes cards from player 2 pile
            
            for (int i = 0; i < playedPilePlayer1.getSize(); i++){
                handPlayer2.addCard(playedPilePlayer1.getCard(i));              //adds player 1 pile to player 2 hand
            }
            
            playedPilePlayer1.clearList();                                      //removes cards from player 1 pile
            
            /* displaying hand amounts for player 1*/
            System.out.println("PLAYER 1");
            System.out.println("Hand Pile: " + handPlayer1.getSize());
            
            /* displaying hand amounts for player 2 */
            System.out.println("\nPLAYER 2");
            System.out.println("Hand Pile: " + handPlayer2.getSize());
            
        } else {                                                    //defaults to tie
            System.out.println("\nIt's a Tie!");
            
            /* its a tie but this is a players last card*/
            if ((handPlayer1.getSize() == 0) || (handPlayer2.getSize() == 0)){        //player 1 runs out of cards
                boolean tiedEndGame = true; //temporary variable    
                endGame(tiedEndGame); //calls method specific to this case 
            } else {                                                                //both players still have cards in hand
                /*printing war*/
                System.out.println("                                 _____");
                System.out.println("\\        /\\         /    /\\     |     |   |");
                System.out.println(" \\      /  \\       /    /__\\    |_____|   |");
                System.out.println("  \\    /    \\     /    /    \\   | \\       |");
                System.out.println("   \\  /      \\   /    /      \\  |  \\     ");
                System.out.println("    \\/        \\ /    /        \\ |   \\     o");
                System.out.println("_____________________________________________");
                System.out.println();
                tie(); 
            }
        }
    }
    
    /**
     * When two cards are the same
     * pre: none
     * post: 4 cards are placed down as war
     */
    public void tie(){
        /* "face down 4 cards" */
        for (int i = 0; i < 6; i++){
            /* player one has one card left*/
            if (handPlayer1.getSize() == 1){
                System.out.println("Player 1 has one card left!");
                return;
            /* player two has one card left*/    
            } else if (handPlayer2.getSize() == 1){
                System.out.println("Player 2 has one card left!");
                return;
            }
            
            /*places card "face down"*/
            playedPilePlayer1.addCard(handPlayer1.getTopCard());                //adding card to player 1 played pile
            handPlayer1.removeCard(handPlayer1.getTopCard());                   //removing card from player 1 hand
            
            playedPilePlayer2.addCard(handPlayer2.getTopCard());                //adding card to player 2 played pile
            handPlayer2.removeCard(handPlayer2.getTopCard());                   //removing card from player 2 hand
            System.out.println((i+2) + " Cards in total have been placed faced down for each player!");
            
            /* displaying hand amounts for player 1*/
            System.out.println("PLAYER 1");
            System.out.println("Hand Pile: " + handPlayer1.getSize());
            
            /* displaying hand amounts for player 2 */
            System.out.println("\nPLAYER 2");
            System.out.println("Hand Pile: " + handPlayer2.getSize() + "\n");
        }
        
    } 
     
    /**
     * Returns true if player2 wins the whole game, false if player1 wins
     * pre: none
     * post: true or false is returned
     */
     public boolean endGame(){
         if(handPlayer1.getSize() == 0 ){                   //player 1 runs out of cards then player 2 wins
             System.out.println("\n---------GAME OVER----------");
             System.out.println("WINNER: Player 2");
             return true;
         } else if (handPlayer2.getSize() == 0) {           //player 2 runs out of cards then player 1 wins
             System.out.println("\n---------GAME OVER----------");
             System.out.println("WINNER: Player 1");
             return true;
         } else {                                           //defaults to no player having run out of cards
             return false;
         }
     }
     
     /**
      * end game method for when a player has one card left and its a tie with the other players card
      * pre:none
      * post: continues to the regular endgame
      */
     public void endGame(boolean t){
         boolean gameEnded = t;      //just used as a note to say that the game ended on a tie
     }
}
