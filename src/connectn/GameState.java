package connectn;

import java.io.*;

public class GameState implements Constants {
	
	
	int N=4;
	int height;
	int width;
	Board board;
	
	
	
	GameState(int height, int width, int N)
	{
		this.height = height;
		this.width = width;
		this.N = N;
		
		board = new Board(height, width);
	}


	public Board getBoard(){
		return this.board;
	}
	

}