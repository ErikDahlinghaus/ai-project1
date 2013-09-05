import java.io.*;

public class Player {

    public static void main (String args[]) throws Exception {
    	
    	static String PLAYER_NAME="edahling-x";
    	
        int width, height, numToWin, playerNumber, timeLimit, move;

        
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

        
        GameState state = new GameState
        
        
        int currentTurn = 0;	// first player starts
        while (true) {
            if (currentTurn == myTurn) {
                // TODO: use a mechanism for timeout(threads, java.util.Timer, ..)
            	
            	// test

                // call alpha-beta algorithm to get the move
                move = getMove();

                // send move
                System.out.println(String.valueOf(move));
                System.out.flush();
            } else {
                // read move
                move = Integer.parseInt(input.readLine());

                // check for end
                if (move < 0)
                    break;
            }

            // switch turns
            currentTurn = 1 - currentTurn;
        }
    }
    
}
