public class Chess_Board {
	

	
	private char piece_name;
	private char color;
	private int column;
	private int row;
	
	private final int MAX_ROW = 8;
	private final int MAX_COLUMN = 8;
	private final int MIN_ROW  = 1;
	private final int MIN_COLUMN = 1;
	
	private Bishop bishop;
	private King king;
	private Knight knight;
	private Pawn pawn;
	private Queen queen;
	private Rook rook;
	
	
	
	
	public Chess_Board() {
	}
	
	public boolean valid_piece_check(String curr_piece) {
		char piece_char = piece_to_char(curr_piece);
		if(piece_char == ' ')
			return false;
		set_piece_name(piece_char);
		return true;
	}
	
	private char piece_to_char(String in_piece) {
		in_piece = in_piece.replaceAll("\\s","");
		if(in_piece.equals(""))
			return ' ';
		char curr_piece = Character.toLowerCase(in_piece.charAt(0));
		
		if(curr_piece != 'p' ^ curr_piece != 'r'^ curr_piece != 'b' ^ curr_piece != 'k'^
				curr_piece != 'q' ^curr_piece != 'n')
			return curr_piece;
		
		return ' ';
	}

	public boolean valid_color_check(String curr_color) {
		char color_char = color_to_char(curr_color);
		if(color_char == ' ')
			return false;
		set_color_name(color_char);
		return true;
	}
	
	private char color_to_char(String in_color) {
		in_color = in_color.replaceAll("\\s","");
		if(in_color.equals(""))
			return ' ';
		char curr_color = Character.toLowerCase(in_color.charAt(0));
		
		if(curr_color != 'w'^ curr_color != 'b' ) 
			return curr_color;
		
		return ' ';
	}
	
	
	
	public boolean create_piece(int col, int row) {

		switch(get_piece_name()) {
			case 'p':
				this.pawn = new Pawn(this.color, col, row);
				break;
			case 'r':
				this.rook = new Rook(this.color, col, row);
				break;
			case 'b':
				this.bishop = new Bishop(this.color, col, row);
				break;
			case 'n':
				this.knight = new Knight(this.color, col, row);
				break;
			case 'k':
				this.king = new King(this.color, col, row);
				break;
			case 'q':
				this.queen = new Queen(this.color, col, row);
				break;
			default:
				return false;
				}
			return true;
		}
	
	public boolean check_move_logic(int move_col, int move_row) {
		boolean able_to_move= false;
		
		switch(get_piece_name()) {
		case 'b':
			able_to_move = this.bishop.move_logic(move_col, move_row);
			break;
		case 'k':
			able_to_move = this.king.move_logic(move_col, move_row);;
			break;
		case 'n':
			able_to_move = this.knight.move_logic(move_col, move_row);
//			System.out.println("Knight.check_move_logic(" + move_col + ", " + move_row + ")");
//			System.out.println(able_to_move);
			break;
		case 'p':
			able_to_move = this.pawn.move_logic(move_col, move_row);
			break;
		case 'q':
			able_to_move = this.queen.move_logic(move_col, move_row);
			break;
		case 'r':
			able_to_move = this.rook.move_logic(move_col, move_row);
			break;
		default:
			return false;
			}
		return able_to_move;
	}
	
	public boolean withinChessboard(int curr_col, int curr_row) {
		
		if(curr_row< MAX_ROW && curr_row>=MIN_ROW-1 &&
				curr_col < MAX_COLUMN && curr_col >=MIN_COLUMN-1) {
			return true;
		}
		
		return false;
	}
	
	public void clear_board() {
		piece_name =  '\0';
		color =  '\0';
		column = -1;
		row = -1;
		
		bishop = null;
		king = null;
		knight = null;
		pawn = null;
		queen = null;
		rook = null;
	}
	
	public char get_piece_name() {
		return this.piece_name;
	}
	
	public void set_piece_name(char curr_piece_name) {
		this.piece_name = curr_piece_name;
	}
	
	public char get_color() {
		return this.color;
	}
	
	public void set_color_name(char curr_color_name) {
		this.color = curr_color_name;
	}			
}

