
import java.util.Scanner;

/*
 * War Game Project
 * Alishba Malik
 * October 24 2019
 * Starts the game
 */

/**
 * Instructions/Rules:
 * 1. Deck is divided evenly between two players
 * 2. Each player places a card from their hand, the player with the higher card wins and takes all of the cards that were played
 * 3. If there is a tie, both player place 7 cards down and then compare the last card that was put down
 * 4. If there is a tie when one of the players only has one card left, then the player with the most cards automatically wins
 */

/**
 *
 * @author alishbamalik
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String userInput;
        boolean manual = false;
        Scanner input = new Scanner(System.in);
        Game game = new Game ();
        
        /*Displaying title*/
        System.out.println("\t\t-WAR GAME-");
        
        do{
            /* prompts user to see instructions */
            System.out.print("Would you like to see the instructions/rules?(Y/N) ");
            userInput = input.next();
            
            if (userInput.equalsIgnoreCase("Y")){                   //displays instructions
                System.out.println("\nINSTRUCTIONS/RULES:");
                System.out.println("1. Deck is divided evenly between two players.");
                System.out.println("2. Each player places a card from their hand, the player with the higher card wins and takes all of the cards that were played.");
                System.out.println("3. If there is a tie, both player place 7 cards down and then compare the last card that was put down.");
                System.out.println("4. If there is a tie when one of the players only has one card left, then the player with the most cards automatically wins");
            } else if (userInput.equalsIgnoreCase("N")){            //doesnt display instructions
                break;
            } else {                                                //defaults to inccorect input
                System.out.println("Invalid input. Please try again.");
            }
        } while (!userInput.equalsIgnoreCase("Y") & !userInput.equalsIgnoreCase("N"));
        
        System.out.println();
        
        /* Prompts user if they want to play manually or automatically*/
        do {
            System.out.print("| (M)anual Game | (A)utomatic Game | ");
            userInput = input.next();
            
            if (userInput.equalsIgnoreCase("M")){                           //manual game
                manual = true;
            } else if (userInput.equalsIgnoreCase("A")){                    //automatic game
                manual = false;
            } else {
                System.out.println("Invalid Input. Please Try Again.");     //wrong input
            }
            
        } while (!userInput.equalsIgnoreCase("M") && !userInput.equalsIgnoreCase("A"));
        
        
        while (!game.endGame()){            //keeps running until one player runs out of cards
            game.play(manual);
        }

        input.close();
    }
    
}
