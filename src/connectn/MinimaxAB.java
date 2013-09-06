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
		
		for (int i = 0; i < state.width; i++) {
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
	
	public int alphaBetaPruning(GameState state, int depth, int alpha, int beta, char currentPlayer) {
		if (depth == DEPTH)
			return heuristicValue(state);
		
		if (currentPlayer == PLAYER1) {
			for (int i = 0; i < state.width; i++) {
				for (int j = DROP; j < POP + 1; j++) {
					GameState child = state.copy();
					if (child.board.playMove(i, j, currentPlayer)) {
						alpha = Math.max(alpha, alphaBetaPruning(child, depth + 1, alpha, beta, PLAYER2));
						if (beta <= alpha)
							break;
					}
				}
				alphaValueAtTopLevel[] = alpha;
			}
			return alpha;
		} else if (currentPlayer == PLAYER2) {
			for (int i = 0; i < state.width; i++) {
				for (int j = DROP; j < POP + 1; j++) {
					GameState child = state.copy();
					if (child.board.playMove(i, j, currentPlayer)) {
						beta = Math.min(beta, alphaBetaPruning(child, depth + 1, alpha, beta, PLAYER1));
						if (beta <= alpha)
							break;
					}
				}
			}
			return beta;
		}
	}
	
//	public static Move getMove(GameState state) {
//		bestMove = search(state, depth);
//		
//		return bestMove;
//	}
	
//	public static Move search(GameState state, int depth){
//
//		//		int column=0, type=DROP;
//		//		int[] move = new int[2];
//
//		// Know about N (connect N)
//
//		// type of move (drop or pop)
//		int moveType = DROP;
//		// array of the board with the best move at each level in the tree
//		Board[] bestBoard;
//		// board that is being used to test moves
//		Board testingBoard;
//		// best move that we can play, for the first level only
//		Move bestMove = new Move();
//		// the current player (switches depending on the depth of the tree)
//		int currentPlayer = PLAYER1;
//
//		// array of ints containing the BEST value at each level in the tree
//		// meaning highest for our player, lowest for the opposing player
//		// currentBestValue[i] is the best value for level i in the tree
//		int[] currentBestValue;
//		// current value at the current level in the tree that is being looked at
//		int currentValue = 0;
//
//		//		// levels of the tree
//		//		for (int i = 0; i < DEPTH; i++) {
//		//			// save the best board at each level of the tree
//		//			bestBoard[i] = state.board.copy();
//		//			// columns of the board
//		//			for (int j = 0; j < state.width; j++) {
//		//				// test drops, then pops
//		//				for (moveType = 1; moveType <= 2; moveType++) {
//		//					testingBoard.playMove(j, moveType, PLAYER1);
//		//					// find out the value of this move
//		//					currentValue = getHeuristicValue(testingBoard);
//		//					
//		//					// FOR PLAYER1 ONLY
//		//					if (currentPlayer == PLAYER1) {
//		//						// if the value we just got is greater than the highest value in the array
//		//						// of values for this level in the tree, replace it, and save the move
//		//						if (currentValue > currentBestValue[i]) {
//		//							currentBestValue[i] = currentValue;
//		//							bestMove.column = j;
//		//							bestMove.moveType = moveType;
//		//							bestBoard[i] = testingBoard.copy();
//		//							
//		//						}
//		//					} else if (currentPlayer == PLAYER2) {
//		//						if (currentValue < currentBestValue[i]) {
//		//							currentBestValue[i] = currentValue;
//		//							bestBoard[i] = testingBoard.copy();
//		//						}
//		//					}
//		//					// reset the board to where it was
//		//					testingBoard = state.board.copy();
//		//				}
//		//			}
//		//			
//		//			if (currentPlayer == PLAYER1)
//		//				currentPlayer = PLAYER2;
//		//			else if (currentPlayer == PLAYER2)
//		//				currentPlayer = PLAYER1;
//		//		}
//
//		int depth = 0;
//		
//		// columns
//		for (int i = 0; i < state.width; i++) {
//			// save the best board at each level of the tree
//			// bestBoard[i] = state.board.copy();
//
//			for (moveType = 1; moveType <= 2; moveType++) {
//				testingBoard.playMove(j, moveType, PLAYER1);
//				// find out the value of this move
//				currentValue = getHeuristicValue(testingBoard);
//
//				// FOR PLAYER1 ONLY
//				if (currentPlayer == PLAYER1) {
//					// if the value we just got is greater than the highest value in the array
//					// of values for this level in the tree, replace it, and save the move
//					if (currentValue > currentBestValue[i]) {
//						currentBestValue[i] = currentValue;
//						bestMove.column = j;
//						bestMove.moveType = moveType;
//						bestBoard[i] = testingBoard.copy();
//
//					}
//				} else if (currentPlayer == PLAYER2) {
//					if (currentValue < currentBestValue[i]) {
//						currentBestValue[i] = currentValue;
//						bestBoard[i] = testingBoard.copy();
//					}
//				}
//				// reset the board to where it was
//				testingBoard = state.board.copy();
//			}
//
//			if (currentPlayer == PLAYER1)
//				currentPlayer = PLAYER2;
//			else if (currentPlayer == PLAYER2)
//				currentPlayer = PLAYER1;
//		}
//
//		//		move[0] = (int )(Math.random() * state.width + 1);
//		//		move[1] = DROP;
//
//		return move;
//
//	}

	public int getHeuristicValue(Board board) {
		return 0;
	}

	//	  public int checkHorizontally(){
	//		  int max1=0;
	//			 int max2=0;
	//			 boolean player1_win=false;
	//			 boolean player2_win=false;
	//			 //check each row, horizontally
	//			 for(int i=0;i<this.height;i++){
	//				 max1=0;
	//				 max2=0;
	//				for(int j=0;j<this.width;j++){
	//					if(board[i][j]==PLAYER1){
	//						max1++;
	//						max2=0;
	//						if(max1==N)
	//							 player1_win=true;
	//					}
	//					else if(board[i][j]==PLAYER2){
	//						max1=0;
	//						max2++;
	//						if(max2==N)
	//							 player2_win=true;
	//					}
	//					else{
	//						max1=0;
	//						max2=0;
	//					}
	//				}
	//			 } 
	//			 if (player1_win && player2_win)
	//				 return this.TIE;
	//			 if (player1_win)
	//				 return this.PLAYER1;
	//			 if (player2_win)
	//				 return this.PLAYER2;
	//			 
	//			 return this.NOCONNECTION;
	//	  }
	//
	//	  public int checkVertically(){
	//		  //check each column, vertically
	//		  int max1=0;
	//		  int max2=0;
	//		  boolean player1_win=false;
	//		  boolean player2_win=false;
	//			 
	//			 for(int j=0;j<this.width;j++){
	//				 max1=0;
	//				 max2=0;
	//				for(int i=0;i<this.height;i++){
	//					if(board[i][j]==PLAYER1){
	//						max1++;
	//						max2=0;
	//						if(max1==N)
	//							 player1_win=true;
	//					}
	//					else if(board[i][j]==PLAYER2){
	//						max1=0;
	//						max2++;
	//						if(max2==N)
	//							player2_win=true;
	//					}
	//					else{
	//						max1=0;
	//						max2=0;
	//					}
	//				}
	//			 } 
	//			 if (player1_win && player2_win)
	//				 return this.TIE;
	//			 if (player1_win)
	//				 return this.PLAYER1;
	//			 if (player2_win)
	//				 return this.PLAYER2;
	//			 
	//			 return this.NOCONNECTION;
	//	  }
	//	  
	//	   public int checkDiagonally1(){
	//		 //check diagonally y=-x+k
	//		   int max1=0;
	//		   int max2=0;
	//		   boolean player1_win=false;
	//		   boolean player2_win=false;
	//		   int upper_bound=height-1+width-1-(N-1);
	//		   
	//			 for(int k=N-1;k<=upper_bound;k++){			
	//				 max1=0;
	//				 max2=0;
	//				 int x,y;
	//				 if(k<width) 
	//					 x=k;
	//				 else
	//					 x=width-1;
	//				 y=-x+k;
	//				 
	//				while(x>=0  && y<height){
	//					// System.out.println("k: "+k+", x: "+x+", y: "+y);
	//					if(board[height-1-y][x]==PLAYER1){
	//						max1++;
	//						max2=0;
	//						if(max1==N)
	//							 player1_win=true;
	//					}
	//					else if(board[height-1-y][x]==PLAYER2){
	//						max1=0;
	//						max2++;
	//						if(max2==N)
	//							player2_win=true;
	//					}
	//					else{
	//						max1=0;
	//						max2=0;
	//					}
	//					x--;
	//					y++;
	//				}	 
	//				 
	//			 }
	//			 if (player1_win && player2_win)
	//				 return this.TIE;
	//			 if (player1_win)
	//				 return this.PLAYER1;
	//			 if (player2_win)
	//				 return this.PLAYER2;
	//			 
	//			 return this.NOCONNECTION;
	//	   }
	//		 
	//	   public int checkDiagonally2(){
	//		 //check diagonally y=x-k
	//		   int max1=0;
	//		   int max2=0;
	//		   boolean player1_win=false;
	//		   boolean player2_win=false;
	//		   int upper_bound=width-1-(N-1);
	//		   int  lower_bound=-(height-1-(N-1));
	//		  // System.out.println("lower: "+lower_bound+", upper_bound: "+upper_bound);
	//			 for(int k=lower_bound;k<=upper_bound;k++){			
	//				 max1=0;
	//				 max2=0;
	//				 int x,y;
	//				 if(k>=0) 
	//					 x=k;
	//				 else
	//					 x=0;
	//				 y=x-k;
	//				while(x>=0 && x<width && y<height){
	//					// System.out.println("k: "+k+", x: "+x+", y: "+y);
	//					if(board[height-1-y][x]==PLAYER1){
	//						max1++;
	//						max2=0;
	//						if(max1==N)
	//							 player1_win=true;
	//					}
	//					else if(board[height-1-y][x]==PLAYER2){
	//						max1=0;
	//						max2++;
	//						if(max2==N)
	//							player2_win=true;
	//					}
	//					else{
	//						max1=0;
	//						max2=0;
	//					}
	//					x++;
	//					y++;
	//				}	 
	//				 
	//			 }	 //end for y=x-k
	//			 
	//			 if (player1_win && player2_win)
	//				 return this.TIE;
	//			 if (player1_win)
	//				 return this.PLAYER1;
	//			 if (player2_win)
	//				 return this.PLAYER2;
	//			 
	//			 return this.NOCONNECTION;
	//	   }

}
