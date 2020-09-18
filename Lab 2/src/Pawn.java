
public class Pawn {
	
	private char piece_name = 'p';
	private char color;
	private int column;
	private int row;
	
	public Pawn(char color, int column, int row) {
		this.color = color;
		this.column = column;
		this.row = row;
	}
	public boolean move_logic( int move_column, int move_row) {
		boolean possibleMove = true;
		int move_direction = find_move_direction();
		
		if(move_column == get_column() && move_row == get_row() + move_direction) 
			return possibleMove;
		
		return !possibleMove;
	}
	
	public int find_move_direction() {
		if(this.color == 'b')
			return -1;
		return 1;
	}

	public int get_column() {
		return this.column;
	}
	
	public int get_row() {
		return this.row;
	}
	
	public void set_column(char curr_column) {
		this.column = curr_column;
	}
	
	public void set_row(int curr_row) {
		this.row = curr_row;
	}
}
