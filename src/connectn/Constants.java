package connectn;

public interface Constants {
	
	Logger logger = new Logger();
	
	String PLAYER_NAME="edahling-x";
	static final char NO_PLAYER = ' ';
	static final char PLAYER1 = 'x';
	static final char PLAYER2 = 'o';
		
	static final int DROP = 1;
	static final int POP = 2;
	
	/*
	 * Algorithm is num4inarow*w + num3 you get the point
	 */

	static final int [] WEIGHTS = { 500, 25, 10, 1, 1, 1 };
	static final int WINS = 0;
	static final int N_STREAK = 1;
	static final int N_LESS_STREAK = 2;
	static final int N_STREAK_THREATS = 3;
	static final int N_LESS_STREAK_THREATS = 4;
	static final int WIN_THREATS = 5;
	
	int DEPTH = 4;
}
