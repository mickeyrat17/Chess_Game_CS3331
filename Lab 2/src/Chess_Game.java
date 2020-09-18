import java.util.Scanner;

public class Chess_Game {
	
	//convert column letter to int
	private static  int column_to_int(String column) {
		if(column.equals(""))
			return ' ';
		int column_int = Character.toLowerCase(column.charAt(0)) - 'a';
		
		return column_int;
	}
	//yes or no as boolean
	public static boolean option_selected(char curr_input) {
		if(curr_input == 'y')
			return true;
		return false;
	}
	
	private static char check_yes_no(String curr_input) {
		if(curr_input.equals(""))
			return ' ';
		char input_char = Character.toLowerCase(curr_input.charAt(0)); 
		if(input_char == 'y' || input_char == 'n') 
			return input_char;
		return ' ';
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Chess_Board chess_board = new Chess_Board();
		
		
		//Keep playing as long as the user adds new pieces
		boolean game_on = true;
		while(game_on) {
			System.out.println();
			System.out.println("Which piece would you like to move?");
			System.out.println("p = pawn");
			System.out.println("r = rook");
			System.out.println("n = knight");
			System.out.println("b = bishop");
			System.out.println("q = queen");
			System.out.println("k = king");
			
			//iterate until user enters a valid piece
			boolean valid_piece = false;
			while(!valid_piece) {
				String input_piece = in.nextLine();
				valid_piece = chess_board.valid_piece_check(input_piece);
				if(!valid_piece) {
					System.out.println("This is not a valid piece letter or name.  Please try again.");
				}
				else {
					System.out.println("You chose: " + chess_board.get_piece_name());
				}
			}
			
			System.out.println();
			System.out.println("What color is the piece?");
			System.out.println("b = black");
			System.out.println("w = white");
			
			boolean valid_color = false;
			while(!valid_color) {
				String input_piece = in.nextLine();
				valid_color = chess_board.valid_color_check(input_piece);
				if(!valid_color) {
					System.out.println("This is not a valid piece color.  Please try again.");
					continue;
				}
				else {
					System.out.println("You chose: " + chess_board.get_color());
				}
			}
			
			System.out.println();
			System.out.println("Where is the piece located?");
			System.out.println("Format: column letter, row");
			System.out.println("Ex: h, 4");
		
			//checks if the piece location is on the board
			boolean piece_on_board = false;
			while(!piece_on_board) {
				String input_piece_location = in.nextLine();
				String[] piece_location = input_piece_location.trim().split("\\s*,\\s*");
				
				int curr_col = column_to_int(piece_location[0]);
				int curr_row;
				if(piece_location[0].equals(""))
					curr_row =-1;
				else{
					curr_row = Integer.parseInt(piece_location[1])-1;
				}
				
				piece_on_board = chess_board.withinChessboard(curr_col, curr_row);
				if(!piece_on_board) {
					System.out.println("The specified location is not on the chess board.  Please enter another location.");
					continue;
				}
				else {
					chess_board.create_piece(curr_col, curr_row);
				}
			}
				
			
			//checks if the entered move is on the board
			boolean move_on_board = false;
			while(!move_on_board) {
				System.out.println();
				System.out.println("Where would you like to move the piece?");
				System.out.println("Format: column letter, row");
				System.out.println("Ex: b, 5");	
				
				String input_piece_move = in.nextLine();
				String[] piece_move = input_piece_move.trim().split("\\s*,\\s*");
				
				
				int move_col = column_to_int(piece_move[0]);
				int move_row;
				if(piece_move[0].equals(""))
					move_row =-1;
				else{
					move_row = Integer.parseInt(piece_move[1])-1;
				}
				
				move_on_board = chess_board.withinChessboard(move_col,move_row);
				
				if(!move_on_board) {
					System.out.println("The specified move is not on the chess board.  Please enter another location.");
					continue;
				}
				else {
					boolean able_to_move = false;
					
				while(!able_to_move) {
					able_to_move = chess_board.check_move_logic(move_col, move_row);
					if(able_to_move)
						System.out.println("You are ALLOWED to move that piece to that location.");
					else
						System.out.println("You CAN'T move this piece to that location.");
					
					System.out.println();
					System.out.println("Would you like to enter a new move location?");
					System.out.println("y = yes");
					System.out.println("n = no");
					
					boolean move_again = false;
					while(!move_again) {
						String another_move = in.nextLine();
						char another_move_char = check_yes_no(another_move);
						
						if(another_move_char == ' ') {
							System.out.println("This is NOT a valid response.  Please try again.");
							continue;
						}
						else {
							if(!option_selected(another_move_char)) {
								System.out.println();
								able_to_move = true;
								move_again = true;
							}		
							else {
								move_again = true;
								able_to_move = true;
								move_on_board = false;
								
								}
							}		
						}	
					}	
				}
			}
			
			//checks if user wants to check the moves of another piece
			boolean new_piece = false;
			while(!new_piece) {
				System.out.println();
				System.out.println("Would you like to enter a new piece?");
				System.out.println("y = yes");
				System.out.println("n = no");
				
				String another_piece = in.nextLine();
				char another_piece_char = check_yes_no(another_piece);
				
				if(another_piece_char == ' ') {
					System.out.println("This is NOT a valid response.  Please try again.");
					continue;
				}
				
				if(!option_selected(another_piece_char)) {
					System.out.println();
					new_piece = true;
					game_on = false;
				}
				else {
					new_piece = true;
					chess_board.clear_board();
				}
			}
			
		}
		in.close();
	}
}
