package connectn;

import java.math.*;

public class MinimaxAB implements Constants {

	// best move at each depth of the tree
	Move[] bestMoves = null;
	int depth = 0;
	
	MinimaxAB(){

	}

	public Move chooseBestMove(GameState state, int depth, int alpha, int beta, char currentPlayer) {
		Move bestMove;
		
		int highestValue;
		
		for (int i = 0; i < state.cols; i++) {
			for (int j = DROP; j < POP; j++) {
				GameState child = state.copy();
				child.makeMove(somemove)
				int value = alphaBetaPruning();
				if value > highest value
					bestMove = child.lastmove
			}
		}
		
		return bestMove;
	}
	
	public int alphaBetaPruning(GameState state, int depth, int alpha, int beta, char currentPlayer) throws Exception {
		if (depth == DEPTH)
			return heuristicValue(state, currentPlayer);
		
		if (currentPlayer == PLAYER1) {
			for (int i = 0; i < state.cols; i++) {
				for (int j = DROP; j < POP + 1; j++) {
					GameState child = state.copy();
					if (child.playMove(i, j, currentPlayer)) {
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
						beta = Math.min(beta, alphaBetaPruning(child, depth + 1, alpha, beta, PLAYER1));
						if (beta <= alpha)
							break;
					}
				}
			}
			return beta;
		}
		
		return 0; // Should be unreachable code
	}


	public int heuristicValue(GameState state, char player)
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
		
		value += WEIGHTS[WINS] * checkForStreak(state, player, state.N);
		value += WEIGHTS[N_STREAK] * checkForStreak(state, player, state.N-1);
		value += WEIGHTS[N_LESS_STREAK] * checkForStreak(state, player, state.N-2);
		value -= WEIGHTS[N_LESS_STREAK_THREATS] * checkForStreak(state, oppositePlayer, state.N-2);		
		value -= WEIGHTS[N_STREAK_THREATS] * checkForStreak(state, oppositePlayer, state.N-1);
		value -= WEIGHTS[WIN_THREATS] * checkForStreak(state, oppositePlayer, state.N);

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
			if( state.board[row][state.cols-1] == state.board[r][c] ){
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
			if( state.board[state.rows-1][col] == state.board[r][c] ){
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
