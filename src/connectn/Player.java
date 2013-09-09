package connectn;


import java.io.*;

public class Player implements Constants {

    public static void main (String args[]) throws Exception {    	
    	
    	String player_name = PLAYER_NAME;
    	
    	try{
    		player_name = args[0];
    	} catch( Exception e ){}
    	
    	try{
    		logger.init(args[1]);
    	} catch( Exception e ){}
    	
    	if( !logger.init )
    		logger.init("output.log");
    	
    	logger.log("\n\nStarting...");
    	

    	

    	
        int width, height, numToWin, playerNumber, timeLimit;
        
        // use BufferedReader for easy reading
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    	MinimaxAB alg = new MinimaxAB();

        // send player name
        System.out.println(player_name);
        System.out.flush();


        // read game config
        String inputs = input.readLine();
        
        String [] players = inputs.split(" ");
        int player = 0;
        if( players[1].contains(player_name) )
        	player = 1;
        else
        	player = 2;

        
        inputs = input.readLine();
        
        logger.log(inputs);
        
        String [] gameConfig = inputs.split(" ");
        height = Integer.parseInt(gameConfig[0]);
        width = Integer.parseInt(gameConfig[1]);
        numToWin = Integer.parseInt(gameConfig[2]);
        playerNumber = Integer.parseInt(gameConfig[3]);
        timeLimit = Integer.parseInt(gameConfig[4]);
                
//        System.err.printf("H: %d W: %d N: %d PN: %d TL: %d\n", height, width, numToWin, playerNumber, timeLimit);

        
        GameState state = new GameState(height, width, numToWin);
        
        
        boolean currentTurn = false;	// first player starts
        if(playerNumber==player)
        	currentTurn=true;
        else
        	currentTurn=false;
        
        while (true) {
            if (currentTurn) {
                // TODO: use a mechanism for timeout(threads, java.util.Timer, ..)

            	/*
            	 * Start a timer (timeLimit seconds)
            	 * n-1 seconds return something right the fuck now
            	 */
            	logger.log("I'm going to play a move");
            	
                // call alpha-beta algorithm to get the move
                //move = 
            	

            	
            	Move bestMove = alg.chooseBestMove(state);
                
                
                // Instantiate the MinimaxAB class
                // Tell it to find a move (store the move in a class wide variable)
                // When the time runs out grab the best move (so far) and use it
                
                
                String movetosend = bestMove.column+" "+bestMove.moveType;                
                logger.log(String.format("Move to send is: %s", movetosend));
                
               
                // Update our game state
                state.playMove(bestMove.column, bestMove.moveType, PLAYER1);

                
                // Send move
                System.out.println(movetosend);
                System.out.flush();
                
                logger.log("End of my turn");
            	
            } else {
                // read move
            	logger.log("It's the opponents move now... waiting...");
            	inputs = input.readLine();
            	
            	if( inputs.contains("-") ){
            		logger.log("Someone has won! %d",Integer.parseInt(inputs));
            		break;
            	}
            	
            	logger.log("Debug: Opponents Incoming move: "+inputs);
            	String [] opponentMove = inputs.split(" ");
            	

            	
            	int column = Integer.parseInt(opponentMove[0]);
            	int moveType = Integer.parseInt(opponentMove[1]);
            	
            	logger.log("Opponent move: "+column+" "+moveType);
            	
                // Update our game state
            	state.playMove(column, moveType, PLAYER2);
            	
            	logger.log("Got to the end of opponents move");
            }

            // switch turns
            currentTurn = !currentTurn;
            logger.log("\nSwitching Players");
            state.printBoard();
        }
    }
    
}
