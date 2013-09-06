package connectn;

import java.io.*;

public class GameState implements Constants {
	
	
	int N=4;
	int depth = DEPTH;
	
	
	int height;
	int width;
	Board board;
	
	
	
	GameState(int height, int width, int N)
	{
		this.height = height;
		this.width = width;
		this.N = N;
		
		board = new Board(this.height, this.width);
	}


	public Board getBoard(){
		return this.board;
	}
	
	public void printBoard() throws IOException{
		int c,r;
		
		
		logger.log("\n------ Board ------");
		for( r=0; r < this.height; r++){
			String row = "|";
			for( c=0; c < this.width; c++){
				row = row+" "+this.board.board[r][c]+" |";
			}
			logger.log(row);
		}
		logger.log("------ ----- ------\n");

	}
		
		
	

}
