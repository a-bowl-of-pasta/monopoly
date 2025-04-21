package gameMechanics;

import java.io.Serializable;

public class tileInfo implements Serializable{

	private int boardIndex; 
	private String tileType; 
	private int tilePrice; 
	private int rent;
	private boolean tileOwned;  
	
	
	
	public tileInfo(int boardIndex, String tileType, int tilePrice, int rentAmt)
	{
		this.boardIndex = boardIndex; 
		this.tileType = tileType; 
		this.tilePrice = tilePrice; 
		rent = rentAmt; 
	}
	
	public void tileBought() {tileOwned = true;}
	public boolean isOwned() { return tileOwned;}
	public void tileIsSold() {tileOwned = false; }
	public int getPrice() {return tilePrice; }
	public int getRent() {return rent; }
	public String getTileType() {return tileType; }
	public int tilePositionOnBoard() {return boardIndex; }
	
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    tileInfo tile = (tileInfo) obj;
	    return boardIndex == tile.boardIndex;
	}

	@Override
	public int hashCode() {
	    return Integer.hashCode(boardIndex);
	}

	@Override
	public String toString() {
	    return "Tile[" + boardIndex + "] " + tileType + 
	           " | Price: $" + tilePrice + " | Rent: $" + rent + 
	           " | Owned: " + tileOwned;
	}
}
