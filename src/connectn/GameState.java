package connectn;

import java.io.*;

public class GameState {
	
	
	int N=4;
	
	char NO_PLAYER = 'x';
	char PLAYER1 = 'a';
	char PLAYER2 = 'b';
	
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
	
	public void setBoard(int x, int y, char player){
		if( player=='a')
			this.board[x][y] = PLAYER1;
		else if( player=='b')
			this.board[x][y] = PLAYER2;
	}
	
	
}