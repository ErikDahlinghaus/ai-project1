package connectn;

import java.io.IOException;
import java.math.*;

public class MinimaxAB implements Constants {

	Move bestMove;
	
	MinimaxAB(){}

	// Change these variables
	public Move chooseBestMove(GameState state) throws Exception {
		
		char currentPlayer = PLAYER1;
		char oppositePlayer = PLAYER2;
		int alpha = Integer.MIN_VALUE;	
		int beta = Integer.MAX_VALUE;
		
		int col = 0;
		int type = DROP;
		
		int highestValue = 0;
		
		for (col = 0; col < state.cols; col++) {
			for (type = DROP; type <= POP; type++) {
				GameState child = state.copy();
				child.playMove(col,type,currentPlayer);
				int value = alphaBetaPruning(child, 0, alpha, beta, oppositePlayer);
				logger.log("Value from move %d %d : %d", col, type, value);
				if ( value > highestValue ){
					logger.log("Highest Value: %d Last Value: %d",highestValue, value);
					// Not sure < >
					this.bestMove = child.lastMove;
					highestValue = value;
				}
			}
		}
		
		return this.bestMove;
	}
	
	public int alphaBetaPruning(GameState state, int depth, int alpha, int beta, char currentPlayer) throws Exception {
		if (depth == DEPTH) // Check for winning condition
		{
			int heur = heuristicValue(state, currentPlayer);
				logger.log("Heuristic Value: %d",heur);
			return heur;
		}
		
		if (currentPlayer == PLAYER1) {
			for (int i = 0; i < state.cols; i++) {
				for (int j = DROP; j < POP + 1; j++) {
					GameState child = state.copy();
					if (child.playMove(i, j, currentPlayer)) {
						//logger.log("Alpha");
						//child.printBoard();
						alpha = Math.max(alpha, alphaBetaPruning(child, depth + 1, alpha, beta, PLAYER2));
						if (beta <= alpha)
							break;
					}
				}
			}
			return alpha;
		} else if (currentPlayer == PLAYER2) {
			for (int i = 0; i < state.cols; i++) {
				for (int j = DROP; j < POP + 1; j++) {
					GameState child = state.copy();
					if (child.playMove(i, j, currentPlayer)) {
						//logger.log("Beta");
						//child.printBoard();
						beta = Math.min(beta, alphaBetaPruning(child, depth + 1, alpha, beta, PLAYER1));
						if (beta <= alpha)
							break;
					}
				}
			}
			return beta;
		}
		
		logger.log("We are getting to this unreachable code -- uhhhhhhhhh");
		return 0; // Should be unreachable code
	}


	public int heuristicValue(GameState state, char player) throws IOException
	{
		/*
		 * Simple heuristic to evaluate board configurations
         * Heuristic is:
         * winning-streaks*weight(wins) +
         * winning-1-streaks*weight(winning-1) +
         * winning-2-streaks*weight(winning-2) -
         * opposing-winning-2-streaks*weight(winning-2-threat) -
         * opposing-winning-1-streaks*weight(winning-2-threat) -
         * opposing-winning-streaks*weight(winning-threat)
		 */
		
		char oppositePlayer = (player == PLAYER1) ? PLAYER2 : PLAYER1;
		
		int value = 0;
		
		logger.log("0 Value of Heuristic: %d", value);
		
		value += WEIGHTS[WINS] * checkForStreak(state, player, state.N);
		logger.log("1 Value of Heuristic: %d", value);
		value += WEIGHTS[N_STREAK] * checkForStreak(state, player, state.N-1);
		logger.log("2 Value of Heuristic: %d", value);
		value += WEIGHTS[N_LESS_STREAK] * checkForStreak(state, player, state.N-2);
		logger.log("3 Value of Heuristic: %d", value);
		value -= WEIGHTS[N_LESS_STREAK_THREATS] * checkForStreak(state, oppositePlayer, state.N-2);		
		logger.log("4 Value of Heuristic: %d", value);
		value -= WEIGHTS[N_STREAK_THREATS] * checkForStreak(state, oppositePlayer, state.N-1);
		logger.log("5 Value of Heuristic: %d", value);
		value -= WEIGHTS[WIN_THREATS] * checkForStreak(state, oppositePlayer, state.N);
		logger.log("6 Value of Heuristic: %d", value);

		return value;
	}
	
	
	private int checkForStreak(GameState state, char player, int streak){
		
		int count = 0;
		int row, col;
		
		for( row=0; row<state.rows; row++ ){
			for( col=0; col<state.cols; col++ ){
				if( state.board[row][col] == player ){
					count += verticalStreak(state, row, col, streak);
					count += horizonalStreak(state, row, col, streak);
					count += diagonalStreak(state, row, col, streak);
				}
			}
		}
		return count;
	}

	
	
	private int verticalStreak(GameState state, int r, int c, int streak ){
		int count = 0;
		
		int row;
		for( row=r; row<state.rows; row++ ){
			if( state.board[row][c] == state.board[r][c] ){
				count++;
			} else {
				break;
			}
		}
		return (count > streak) ? 1 : 0 ;	
	}
	
	private int horizonalStreak(GameState state, int r, int c, int streak ){
		int count = 0;
		
		int col;
		for( col=c; col<state.cols; col++ ){
			if( state.board[r][col] == state.board[r][c] ){
				count++;
			} else {
				break;
			}
		}
		return (count > streak) ? 1 : 0 ;	
	}
	
	private int diagonalStreak(GameState state, int r, int c, int streak ){
		int total = 0;
		int count = 0;
		
		int row = r;
		int col = c;
		for( col=c; col<state.cols; col++ ){
			if( row < state.rows ){
				if( state.board[row][col] == state.board[r][c] ){
					count++;
				} else {
					break;
				}
				row++;
			}
		}
		total += (count > streak) ? 1 : 0 ;	
		
		count = 0;
		row = r;
		col = c;
		for( col=c; col<state.cols; col++ ){
			if( row >= 0 ){
				if( state.board[row][col] == state.board[r][c] ){
					count++;
				} else {
					break;
				}
				row--;
			}
		}
		total += (count > streak) ? 1 : 0 ;	

		return total;		
	}

}
