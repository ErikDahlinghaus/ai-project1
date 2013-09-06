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
		
//        System.err.printf("H: %d W: %d\n", this.height, this.width);
		
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
	
	public boolean playMove(int column, int type, char player)  throws Exception {
		// Update game board, place piece in the proper column.
		int i;
		boolean isValid = true;
		
		logger.log("Attempting to play move... Column: %d Type: %d Player: %c",column, type, player);
		
		
		switch(type){
		
		case DROP:
			for( i=this.height-1; i>=0; i-- ){
				if( this.board[0][column] != NO_PLAYER ){
//					System.err.println("You can't play here, column is full...");
					isValid = false;
					return isValid;
				}
				if( this.board[i][column] == NO_PLAYER ){
					this.board[i][column] = player;
					break;
				}
			}
			
//			for( i=0; i < this.height; i++){
//				for( int j=0; j < this.width; j++){
//					System.err.print(this.board[i][j]);
//				}
//				System.err.println("\n");
//			}
			break;
			
		case POP:
			if( this.board[this.height-1][column] == player ){
				for( i=this.height-1; i>0; i-- ){
					this.board[i][column] = this.board[i-1][column];
				}
				this.board[0][column] = NO_PLAYER;
			} else {
				isValid = false;
				return isValid;
			}
			break;
		
		}
		
		return isValid;
	
	
	}

}
