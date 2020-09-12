

public class Rook {
	
	private String piece_name;
	private String color;
	private char column;
	private int row;
	
	public Rook() {
		
	}
	
	public Rook(String piece_name, String color, char column, int row) {
		this.piece_name = piece_name;
		this.color = color;
		this.column = column;
		this.row = row;
	}
	
	

	public char get_column() {
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
