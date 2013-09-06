package connectn;

import java.io.*;

public class GameState implements Constants {
	
	
	int N=4;
	int depth = DEPTH;
	Move lastMove;
	
	int rows;
	int cols;
	char [][] board;
	
	
	
	GameState(int height, int width, int N)
	{
		this.rows = height;
		this.cols = width;
		this.N = N;
		
		initBoard();
	}
	

	private void initBoard(){
		
		int i,j;
		board = new char[this.rows][this.cols];
		
//        logger.log("H: %d W: %d\n", this.height, this.width);
		
		for( i=0; i<this.rows; i++ ){
			for( j=0; j<this.cols; j++ ){
				this.board[i][j] = NO_PLAYER;
			}
		}		
	}
	
	public GameState copy(){
		
		// Perform deep copy
		GameState newstate = new GameState(this.rows, this.cols, this.N);
		
		int i,j;
		for( i=0; i<this.rows; i++ ){
			for( j=0; j<this.cols; j++ ){
				newstate.board[i][j] = this.board[i][j];
			}
		}
		return newstate;
	}

	public boolean playMove(int column, int type, char player)  throws Exception {
		// Update game board, place piece in the proper column.
		int i;
		boolean isValid = true;
		
		logger.log("Attempting to play move... Column: %d Type: %d Player: %c",column, type, player);
		
		this.lastMove = new Move(column, type, player, 0);
		
		switch(type){
		
		case DROP:
			for( i=this.rows-1; i>=0; i-- ){
				if( this.board[0][column] != NO_PLAYER ){
					isValid = false;
					return isValid;
				}
				if( this.board[i][column] == NO_PLAYER ){
					this.board[i][column] = player;
					break;
				}
			}
			break;
			
		case POP:
			if( this.board[this.rows-1][column] == player ){
				for( i=this.rows-1; i>0; i-- ){
					this.board[i][column] = this.board[i-1][column];
				}
				this.board[0][column] = NO_PLAYER;
			} else {
				isValid = false;
				return isValid;
			}
			break;
		
		}
		
		if ( isValid ){
			this.printBoard();
		}
		
		return isValid;
	}

	
	public void printBoard() throws IOException{
		int c,r;
		
		
		logger.log("\n------ Board ------");
		for( r=0; r < this.rows; r++){
			String row = "|";
			for( c=0; c < this.cols; c++){
				row = row+" "+this.board[r][c]+" |";
			}
			logger.log(row);
		}
		logger.log("------ ----- ------\n");

	}
		
		
	

}
