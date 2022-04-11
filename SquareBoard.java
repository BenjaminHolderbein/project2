public class SquareBoard {
	private XOPiece[][] board;

	/**
	  * Constructor that creates an n x n board of
	  * XOPieces and each XOPiece is set to an initial Token
	  */ 
	public SquareBoard(int n) 
	{
		board=new XOPiece[n][n];
		for(int i=0;i<board.length;i++){//i=row
			for(int j=0;j<board.length;j++){//j=column
				board[i][j]= new XOPiece();
		    }
	    }
	}

   /**
	 * String representation of the board 
	 * showing the contents of each space 
	 */
	public String toString()
	{
		String printMe="";
	    for(int i=0;i<board.length;i++){//i=row
			for(int j=0;j<board.length;j++){//j=column
				printMe+= "["+board[i][j]+"] ";
		    }
			printMe+="\n";
	    }
		return printMe;
	}

	/**
	  * Method that prints out the board with
	  * the coordinates of each slot
	  * to show the users how to identify each slot
	  */
	public void printBoardCoordinates()
	{
		for (int i=0; i<board.length; i++) 
		{
			for (int j=0; j<board[i].length; j++)
			{
				System.out.print("["+i+","+j+"] ");
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	  * Sets a Token on the board with coordinates (i,j)
	  */
	public boolean setPiece(XOPiece.XO t, int i, int j)
	{
		if(board[i][j].checkBlank()){
			board[i][j]=new XOPiece(t);
			return true;
		}else{
			return false;
		}
		
	}
	private int compliment(int n){
		return board.length-n-1;
	}
	/**
	  * Gets an item on the board with coordinates (i,j)
	  */  
	public XOPiece getPiece(int i, int j)
	{
		 
		return board[i][j];
	}
	private boolean checkTL_BR(){//top left-bottem right
		boolean line = true;
		for(int i=0; i<(board.length-1);i++){
			if (!board[i][i].match(board[i+1][i+1].getXO())){
				line=false;
			}
		}
		if (line){
			return true;
		}else{
			return false;
		}
	}
		
	private boolean checkTR_BL(){
		boolean line = true;
		for(int i=0; i<(board.length-1);i++){
			if (!board[i][compliment(i)].match(board[i+1][compliment(i)-1].getXO())){
				line=false;
			}
		}
		if (line){
			return true;
		}else{
			return false;
		}
	}
	private boolean checkRow(){
		boolean win = false;
		boolean line;
		for(int r=0;r<(board.length);r++){
			line=true;
			for(int c=0; c<(board.length-1);c++){
				if (!board[r][c].match(board[r][c+1].getXO())){
					line=false;
				}
			}
			if (line){
				win=true;
			}
		}
		
		if (win){
			return true;
		}else{
			return false;
		}
	}
	private boolean checkColumn(){
		boolean win = false;
		boolean line;
		for(int c=0;c<(board.length);c++){
			line=true;
			for(int r=0; r<(board.length-1);r++){
				if (!board[r][c].match(board[r+1][c].getXO())){
					line=false;
				}
			}
			if (line){
				win=true;
			}
		}
		
		if (win){
			return true;
		}else{
			return false;
		}
	}

	public boolean checkWin(){
		if(checkTL_BR()||checkTR_BL()||checkRow()||checkColumn()){
			return true;
		}else{
			return false;
		}
	}
	public boolean checkDraw(){
		boolean draw = true;
		for(int c=0;c<(board.length);c++){
			for(int r=0; r<(board.length);r++){
				if (board[r][c].checkBlank()){
					draw=false;
				}
			}
		}
		return draw;
	}
}
