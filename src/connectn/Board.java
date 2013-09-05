package connectn;

public class Board implements Constants {
	
	int height;
	int width;
	char [][] board;
	
	
	
	Board(int height, int width)
	{
		this.height = height;
		this.width = width;		
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
