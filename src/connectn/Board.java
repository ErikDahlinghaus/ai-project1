package connectn;

public class Board implements Constants {
	
	int height;
	int width;
	char [][] board;
	
	int position, type, value;
	
	// move, type, value
	
	
	
	Board(int height, int width)
	{
		this.height = height;
		this.width = width;		
		initBoard();
	}
	
	private void initBoard(){
		
		int i,j;
		board = new char[this.height][this.width];
		
        System.err.printf("H: %d W: %d\n", this.height, this.width);
		
		for( i=0; i<this.height; i++ ){
			for( j=0; j<this.width; j++ ){
				this.board[i][j] = NO_PLAYER;
			}
		}
		
	}
	
	public Board copy(){
		
		// Perform deep copy
		Board newboard = new Board(this.height, this.width);
		
		int i,j;
		for( i=0; i<this.height; i++ ){
			for( j=0; j<this.width; j++ ){
				newboard.board[i][j] = this.board[i][j];
			}
		}
		return newboard;
	}
	
	public void playMove(int column, int type, char player){
		// Update game board, place piece in the proper column.
		int i;
		
		switch(type){
		
		case DROP:
			for( i=this.height-1; i>0; i-- ){
				if( this.board[0][column-1] != NO_PLAYER ){
					System.err.println("You can't play here, column is full...");
					return;
				}
				if( this.board[i][column-1] == NO_PLAYER ){
					this.board[i][column-1] = player;
				}
			}
			break;
			
		case POP:
			if( this.board[this.height-1][column-1] == player ){
				for( i=this.height-1; i>0; i-- ){
					// Out of bounds?
					//this.board[i][column-1] = this.board[i+1][column-1];
				}
				this.board[0][column-1] = NO_PLAYER;
			} else {
				// this is not a valid move
			}
			break;
		
		}
		

	
	
	}

}
