package connectn;


import java.io.*;

public class Player implements Constants {

    public static void main (String args[]) throws Exception {    	
    	
    	
        int width, height, numToWin, playerNumber, timeLimit;
        int[] move = new int[2];
        
        // use BufferedReader for easy reading
        BufferedReader input = new BufferedReader(
            new InputStreamReader(System.in));

        // send player name
        System.out.println(PLAYER_NAME);
        System.out.flush();

        // read game config
        String [] gameConfig = input.readLine().split(" ");
        height = Integer.parseInt(gameConfig[0]);
        width = Integer.parseInt(gameConfig[1]);
        numToWin = Integer.parseInt(gameConfig[2]);
        playerNumber = Integer.parseInt(gameConfig[3]);
        timeLimit = Integer.parseInt(gameConfig[4]);
        
        
        System.err.printf("H: %d W: %d N: %d PN: %d TL: %d\n", height, width, numToWin, playerNumber, timeLimit);

        
        GameState state = new GameState(height, width, numToWin);
        
        
        boolean currentTurn = false;	// first player starts
        if(playerNumber==1)
        	currentTurn=true;
        else if(playerNumber==2)
        	currentTurn=false;
        
        while (true) {
            if (currentTurn) {
                // TODO: use a mechanism for timeout(threads, java.util.Timer, ..)

            	/*
            	 * Start a timer (timeLimit seconds)
            	 * n-1 seconds return something right the fuck now
            	 */

                // call alpha-beta algorithm to get the move
                move = MinimaxAB.getMove(state);
                
                
                
                // Update our game state
                state.board.playMove(move[0], move[1], PLAYER1);

                
                
                // Send move
                String movetosend = move[0]+" "+move[1];
                System.out.println(movetosend);
                System.out.flush();
            	
            } else {
                // read move
            	String [] opponentMove = input.readLine().split(" ");
            	
            	int column = Integer.parseInt(opponentMove[0]);
            	if(column < 0 ){
            		// There was a winner
            		break;
            	}
            	int moveType = Integer.parseInt(opponentMove[1]);
            	
                // Update our game state
            	state.board.playMove(column, moveType, PLAYER2);
            }

            // switch turns
            currentTurn = !currentTurn;
        }
    }
    
}
