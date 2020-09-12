import java.util.Scanner;

public class Chess_Game {
	
	public static boolean can_move(char curr_piece, int move_row, int move_column) {
		boolean curr_move_possible = false;

		switch(curr_piece) {
			case 'p':
				curr_move_possible = Pawn.ableToMove(move_row, move_column);
				break;
			case 'r':
				curr_move_possible = Rook.ableToMove(move_row, move_column);
				break;
			case 'b':
				curr_move_possible = Bishop.ableToMove(move_row, move_column);
				break;
			case 'n':
				curr_move_possible = Knight.ableToMove(move_row, move_column);
				break;
			case 'k':
				curr_move_possible = King.ableToMove(move_row, move_column);
				break;
			case 'q':
				curr_move_possible = Queen.ableToMove(move_row, move_column);
				break;
		}
		return curr_move_possible;
	}
	
	public static char piece_to_char(String in_piece) {
		in_piece = in_piece.replaceAll("\\s","");
		char curr_piece = Character.toLowerCase(in_piece.charAt(0));
		
		if(curr_piece != 'p' ^ curr_piece != 'r'^ curr_piece != 'b' ^ curr_piece != 'k'^
				curr_piece != 'q' ^curr_piece != 'n' )
			return curr_piece;
		
		return ' ';
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Which piece would you like to move?");
		System.out.println("p = pawn");
		System.out.println("r = rook");
		System.out.println("n = knight");
		System.out.println("b = bishop");
		System.out.println("q = queen");
		System.out.println("k = king");
		
		String input_piece = in.nextLine();
		char in_piece_char = piece_to_char(input_piece);
		
		
		System.out.println("Where would you like to move the piece?");
		System.out.println("Format: column letter, row");
		
		String input_move = in.nextLine();
		String[] move_col_and_row = input_move.trim().split("\\s*,\\s*");
	}

}
