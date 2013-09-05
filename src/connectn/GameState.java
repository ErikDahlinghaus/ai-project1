package connectn;

import java.io.*;

public class GameState implements Constants {
	
	
	int N=4;
	

	
	int height;
	int width;
	char [][] board;
	
	
	
	GameState(int height, int width, int N)
	{
		this.height = height;
		this.width = width;
		this.N = N;
		
		initBoard();
	}
	
	private void initBoard(){
		
		int i,j;
		
		for( i=0; i<height; i++ ){
			for( j=0; j<width; j++ ){
				this.board[i][j] = NO_PLAYER;
			}
		}
		
	}
	

	public char [][] getBoard(){
		return this.board;
	}
	
	
	// setBoard and playMove are the same really, decide which one is better.
	public void setBoard(int x, int y, char player){
		if( player=='a')
			this.board[x][y] = PLAYER1;
		else if( player=='b')
			this.board[x][y] = PLAYER2;
	}
	
	public void playMove(int column, int type, char player){
		// Update game board, place piece in the proper column.
		int i;
		for( i=0; i<height; i++ ){
			if( this.board[i][column] != NO_PLAYER ){
				this.board[i-1][column] = player;
			}
		}
	}
	

}
