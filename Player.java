public class Player {
    private String playerName;
	private int wins;
	private XOPiece.XO playerPiece;

	public Player(){
		playerName=null;
		wins=0;
		playerPiece=null;
	}
	
	public Player(String name,XOPiece.XO piece){
		playerName= name;
		wins = 0;
		playerPiece= piece;
	}
	public String getName(){
		return playerName;
	}
	public XOPiece.XO getPiece(){
		return playerPiece;
	}
	public void win(){
		wins++;
	}
	public int getWins(){
		return wins;
	}
}
