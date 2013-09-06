package connectn;

public class Move implements Constants {

	int column, moveType, value;
	char player;
	
	public Move(int column, int moveType, char player, int value) {
		this.column = column;
		this.moveType = moveType;
		this.player = player;
		this.value = value;
	}

}
