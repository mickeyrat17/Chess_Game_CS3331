

public class Rook {
	
	private char piece_name = 'r';
	private char color;
	private int column;
	private int row;
	
	public Rook(char color, int column, int row) {
		this.color = color;
		this.column = column;
		this.row = row;
	}
	
	public boolean move_logic( int move_column, int move_row) {
		boolean move_is_logical = true;
			
		int number_of_rows_moved = Math.abs(get_row() - move_row);
		int number_of_columns_moved =Math.abs(get_column() - move_column);
		
		if(number_of_rows_moved ==0 ^ number_of_columns_moved ==0) 
			return move_is_logical;
		return !move_is_logical;
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
