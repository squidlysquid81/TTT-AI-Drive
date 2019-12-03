package ttt;
import java.util.Scanner;
//Author:  Mr. Murray

public class TTT {
//Temporary Game Board
//This DOES NOT Contain the logic to see if the game is over... this just allows
// you a skeleton code to check your AI.
//Feel free to alter this code to make your testing process easier.

    public static void main(String[] args) {
        final int MAXGAME = 100;
        Scanner kin = new Scanner(System.in);
        
        //The Simulation will follow this gameplay order:
        //Instantiate two players
        //Play 100 games (or whatever the preset max is)
        //At the beginning of EACH game:
        //Reset all players and the gameboard
        //Decide who goes first
        // - Call that player's firstPlay() method
        //*Begin game loop
        //  * copy the board
        //  * switch players
        //  * call current player's play()
        //  * update board + print the board
        //  * see if someone has won or if there are more moves left
        //*Repeat loop otherwise.
        //See if we have more games to play or if we are at max.
        
        
        //Begining actual game code:
        //Instantiate two players
        //playerOne;
        //playerTwo;

        playerOne.callX(true);
        playerTwo.callX(false);
        
        int move;
        int gamecount = 0;
        String yorn="";
        boolean simulationOver = false, gameOver, onesTurn;
        
        while(!simulationOver)
        {
            gamecount++;
            gameOver = false;
            Board.reset();
            //Players reset:
            playerOne.reset();
            playerTwo.reset();
            
            
            if(gamecount%2 == 0) //Player one goes first:
            {
                move = playerOne.firstPlay();
                Board.claim(move, playerOne.getType());
                onesTurn = true; //PlayerOne went first
            }    
            else //Player two goes first:
            {
                move = playerTwo.firstPlay();
                Board.claim(move, playerTwo.getType());
                onesTurn = false; //PlayerTwo went first
            }
        
	    Board.print();	

            while(!gameOver)
            {
                Board.copy();
                onesTurn = !onesTurn; //switch whose turn it is
                if(onesTurn)
                {
                    move = playerOne.play();
                    Board.claim(move, playerOne.getType());
                    
                }
                else //it's !onesTurn
                {
                    move = playerTwo.play();
                    Board.claim(move, playerTwo.getType());
                }
            
                Board.print();
                
                //Logic to end a game not included.  
                //In this tester version, you must manually decide when the 
                // game is over with a "yes/no continue" question.

                System.out.print("Keep playing this round? (y/n) ");
                yorn = kin.next();
                if(yorn.equalsIgnoreCase("N")||yorn.equalsIgnoreCase("no"))
                    gameOver = true;

            }//end of a single game-loop
        
            //The following allows you to end the simulation early if you wish:

            System.out.println("\nYou've played "+gamecount+" out of "+MAXGAME+" games.");
            System.out.print("Would you like to continue to a new game? (y/n) ");
            yorn = kin.next();
            if(gamecount == MAXGAME || yorn.equalsIgnoreCase("n") || yorn.equalsIgnoreCase("no"))
                simulationOver = true;

        }//end of simulation while-loop
        
    }//end of main
    
}
