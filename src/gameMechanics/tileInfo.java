package gameMechanics;

import java.io.Serializable;

public class tileInfo implements Serializable{

	private int boardIndex; 
	private String tileType; 
	private int tilePrice; 
	private int rent;
	private boolean tileOwned;  
	
	
	// ================= constructor
	public tileInfo(int boardIndex, String tileType, int tilePrice, int rentAmt)
	{
		this.boardIndex = boardIndex; 
		this.tileType = tileType; 
		this.tilePrice = tilePrice; 
		rent = rentAmt; 
	}
	
	// =============== setters 
	public void tileBought() {tileOwned = true;}
	public void tileIsSold() {tileOwned = false; }
	
	// ========= getters
	public boolean isOwned() { return tileOwned;}
	
	public int getPrice() {return tilePrice; }
	public int getRent() {return rent; }
	public int tilePositionOnBoard() {return boardIndex; }

	public String getTileType() {return tileType; }
	
	// ================= overwrites for debugging and equality checks
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
