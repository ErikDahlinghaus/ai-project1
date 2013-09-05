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
	
	private initBoard(){
		
		int i,j;
		
		for( i=0; i<height; i++ ){
			for( j=0; j<width; j++ ){
				this.board[i][j] = NO_PLAYER;
			}
		}
		
	}
	
	
	
	
}