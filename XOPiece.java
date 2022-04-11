public class XOPiece
{
    
    public static enum XO {X, O}

    private XO myPiece;

    public XOPiece() 
    {
        myPiece=null;
    }

    public XOPiece(XO choice)
    {
        myPiece=choice;
    }

    public String toString()
    {
        String returnString = " ";
        if (myPiece==XO.X){
          returnString="-X-";
        }else if (myPiece==XO.O){
          returnString="-O-";
        }else {
          returnString="   ";
        }
        return returnString;
    }
    public XO getXO(){
      return myPiece;
    }
    public boolean match (XO piece)
    {
        if(myPiece==piece&&myPiece!=null){
			return true;
		}else{
			return false; 
		}
    }

	public boolean checkBlank(){
		if(myPiece==null){
			return true;
		}else{
			return false;
		}
	}
}