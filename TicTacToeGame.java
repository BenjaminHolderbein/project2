import java.util.*;

public class TicTacToeGame

{

	public static void main(String[] args) {
		System.out.println("Welcome to Tic-Tac-Toe!");
		System.out.println("This is just like regular Tic-Tac-Toe where you want to get an entire row, column or diagonal line of your symbol in a row before your opponent.");
		System.out.println("Except theres a twist, you can play on any size board that you want to!");
		System.out.println("There will be two players, you will each enter youre name and thenyou will each be assigned your symbol.");
		System.out.println("The game will show you a cooardinate grid that you can use to make your moves.");
		System.out.println("Enter your guess as 2 numbers seperated by a space.");
		System.out.println("Have fun!");
		Random rand = new Random();
		Scanner scnr = new Scanner(System.in);
		Player playerX;
		Player playerO;
		if (rand.nextInt(2) == 0) {
			System.out.print("Enter your name: ");
			playerX = new Player(scnr.next(), XOPiece.XO.X);
			System.out.print("Enter next name: ");
			playerO = new Player(scnr.next(), XOPiece.XO.O);
		} else {
			System.out.print("Enter your name: ");
			playerO = new Player(scnr.next(), XOPiece.XO.O);
			System.out.print("Enter next name: ");
			playerX = new Player(scnr.next(), XOPiece.XO.X);
		}

		SquareBoard board;
		boolean win;
		boolean draw;
		boolean play = true;
		String input;
		int row;
		int column;
		int draws=0;
		int size;
		while (play) {
			System.out.println("What size board would you like to play on?: ");
			size=scnr.nextInt();
			board = new SquareBoard(size);
			board.printBoardCoordinates();
			win = false;
			draw = false;
			while (!(win || draw)) {
				System.out.print(playerX.getName() + "'s move: ");
				row = scnr.nextInt();
				column = scnr.nextInt();
				while (!board.setPiece(XOPiece.XO.X, row, column)) {
					System.out.print("Square already taken, try again:");
					row = scnr.nextInt();
					column = scnr.nextInt();
				}
				System.out.println(board);
				win = board.checkWin();
				draw = board.checkDraw();
				if (win) {
					System.out.println(playerX.getName() + " wins!");
					playerX.win();
				} else if (draw) {
					System.out.println("It's a draw.");
					draws++;
				} else {
					System.out.print(playerO.getName() + "'s move: ");
					row = scnr.nextInt();
					column = scnr.nextInt();
					while (!board.setPiece(XOPiece.XO.O, row, column)) {
						System.out.print("Square already taken, try again:");
						row = scnr.nextInt();
						column = scnr.nextInt();
					}
					System.out.println(board);
					win = board.checkWin();
					draw = board.checkDraw();
					if (win) {
						System.out.println(playerO.getName() + " wins!");
						playerO.win();
					} else if (draw) {
						System.out.println("It's a draw.");
						draws++;
					}
				}
			}
			System.out.print("Do you want to play again? (y/n): ");
			input = scnr.next();
			if (input.equals("n")) {
				play = false;
			}
		}
		System.out.println("Total games played: "+(draws+playerX.getWins()+playerO.getWins()));
		System.out.println(playerX.getName()+"'s wins: "+(playerX.getWins()));
		System.out.println(playerO.getName()+"'s wins: "+(playerO.getWins()));
	}
}