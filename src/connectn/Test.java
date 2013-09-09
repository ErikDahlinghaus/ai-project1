package connectn;

import java.io.IOException;

public class Test implements Constants {
	
	
	static GameState state = new GameState(6,7,4);
	
	static Logger logger = new Logger("test.log");
	
	static MinimaxAB alg = new MinimaxAB();
	
	
	public static void runTests() throws Exception{
		
		logger.log("===================================");
		logger.log("Running drop tests...");
		logger.log( dropTest() ? "Drop tests have passed" : "Drop tests have failed" );		
		logger.log("===================================");

		logger.log("Checking heuristic...");
		state.printBoard(logger);
		logger.log("-----------------------------------");
		logger.log("Streaks of four? "+alg.checkForStreak(state, PLAYER1, 4));
		logger.log("Streaks of three? "+alg.checkForStreak(state, PLAYER1, 3));
		logger.log("Streaks of two? "+alg.checkForStreak(state, PLAYER1, 2));
		logger.log("Is a win? "+alg.isWinCondition(state));
		logger.log("-----------------------------------");
		logger.log("Heuristic value is "+alg.heuristicValue(state, PLAYER1) );		
		logger.log("===================================");
		
		logger.log("Running pop tests...");
		logger.log( popTest() ? "Pop tests have passed" : "Pop tests have failed" );		
		logger.log("===================================");		
		
	}
	
	public static boolean dropTest() throws Exception{
		

		logger.log("-----------------------------------");
		
		logger.log("Drop test 1 running");
		if( ! state.playMove(0, DROP, PLAYER1) )
			return false;
		state.printBoard(logger);
		logger.log("Drop test 1 passed");

		logger.log("-----------------------------------");
		
		logger.log("Drop test 2 running");
		if( ! state.playMove(0, DROP, PLAYER2) )
			return false;				
		state.printBoard(logger);
		logger.log("Drop test 2 passed");
		
		logger.log("-----------------------------------");
		
		logger.log("Drop test 3 running");
		if( ! state.playMove(0, DROP, PLAYER1) )
			return false;				
		state.printBoard(logger);
		logger.log("Drop test 3 passed");
		
		logger.log("-----------------------------------");

		logger.log("Drop test 4 running");
		if( ! state.playMove(0, DROP, PLAYER2) )
			return false;						
		state.printBoard(logger);
		logger.log("Drop test 4 passed");

		logger.log("-----------------------------------");
		
		logger.log("Drop test 5 running");
		if( ! state.playMove(0, DROP, PLAYER1) )
			return false;				
		state.printBoard(logger);
		logger.log("Drop test 5 passed");

		logger.log("-----------------------------------");		
		
		logger.log("Drop test 6 running");
		if( ! state.playMove(0, DROP, PLAYER2) )
			return false;				
		state.printBoard(logger);
		logger.log("Drop test 6 passed");

		logger.log("-----------------------------------");		
		
		logger.log("Drop test 7 running");
		if( state.playMove(0, DROP, PLAYER2) )
			return false;				
		state.printBoard(logger);
		logger.log("Drop test 7 passed");
		
		logger.log("-----------------------------------");
		
		logger.log("Drop test 8 running");
		if( ! state.playMove(1, DROP, PLAYER1) )
			return false;
		state.printBoard(logger);
		logger.log("Drop test 8 passed");
		
		logger.log("-----------------------------------");
		
		logger.log("Drop test 9 running");
		if( ! state.playMove(2, DROP, PLAYER1) )
			return false;
		state.printBoard(logger);
		logger.log("Drop test 9 passed");

		logger.log("-----------------------------------");
		
		logger.log("Drop test 10 running");
		if( ! state.playMove(3, DROP, PLAYER1) )
			return false;
		state.printBoard(logger);
		logger.log("Drop test 10 passed");

		logger.log("-----------------------------------");
				
		return true;
	}
	
	
	public static boolean popTest() throws Exception{
		

		logger.log("-----------------------------------");
		
		logger.log("Pop test 1 running");
		if( ! state.playMove(0, POP, PLAYER1) )
			return false;
		state.printBoard(logger);
		logger.log("Pop test 1 passed");

		logger.log("-----------------------------------");
		
		logger.log("Pop test 2 running");
		if( ! state.playMove(0, POP, PLAYER2) )
			return false;				
		state.printBoard(logger);
		logger.log("Pop test 2 passed");
		
		logger.log("-----------------------------------");
		
		logger.log("Pop test 3 running");
		if( ! state.playMove(0, POP, PLAYER1) )
			return false;				
		state.printBoard(logger);
		logger.log("Pop test 3 passed");
		
		logger.log("-----------------------------------");

		logger.log("Pop test 4 running");
		if( ! state.playMove(0, POP, PLAYER2) )
			return false;						
		state.printBoard(logger);
		logger.log("Pop test 4 passed");

		logger.log("-----------------------------------");
		
		logger.log("Pop test 5 running");
		if( ! state.playMove(0, POP, PLAYER1) )
			return false;				
		state.printBoard(logger);
		logger.log("Pop test 5 passed");

		logger.log("-----------------------------------");		
		
		logger.log("Pop test 6 running");
		if( ! state.playMove(0, POP, PLAYER2) )
			return false;				
		state.printBoard(logger);
		logger.log("Pop test 6 passed");

		logger.log("-----------------------------------");		
		
		logger.log("Pop test 7 running");
		if( state.playMove(1, POP, PLAYER2) )
			return false;				
		state.printBoard(logger);
		logger.log("Pop test 7 passed");

		logger.log("-----------------------------------");	
		
		logger.log("Pop test 8 running");
		if( ! state.playMove(1, POP, PLAYER1) )
			return false;				
		state.printBoard(logger);
		logger.log("Pop test 8 passed");

		logger.log("-----------------------------------");	
		
		logger.log("Pop test 9 running");
		if( ! state.playMove(2, POP, PLAYER1) )
			return false;				
		state.printBoard(logger);
		logger.log("Pop test 9 passed");

		logger.log("-----------------------------------");	
		
		logger.log("Pop test 10 running");
		if( ! state.playMove(3, POP, PLAYER1) )
			return false;				
		state.printBoard(logger);
		logger.log("Pop test 10 passed");

		logger.log("-----------------------------------");					
		
		
		
		return true;
	}
	
	
	

}
