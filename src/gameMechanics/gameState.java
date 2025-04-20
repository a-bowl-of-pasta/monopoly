package gameMechanics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class gameState implements Serializable{
	
	private int currentPlayerIndex;
	private int nextPlayerIndex; 
	private int numOfPlayers; 
	private int totalTiles; 
	ArrayList<player> playerList; 
	HashMap<tileInfo, player>propertiesOwned;
	ArrayList<tileInfo> linearBoard; 
	
	public gameState()
	{
		currentPlayerIndex = 0; 
		nextPlayerIndex = currentPlayerIndex +1; 
		numOfPlayers = 0; 
		playerList = new ArrayList<player>();
		totalTiles = 40; 
		linearBoard = new ArrayList<tileInfo>(); 
		propertiesOwned = new HashMap<tileInfo, player>(); 

		

		/* loop through tile info csv
		 * add each tile in sequential order to the linearBoardMap
		 * each player starts at linearBoardMap[0]
		 * if it hits the last tile, loop back around 
		 */
		
		
		
	}
	// -------- adds a new player to the game state
	public void addPlayers(player addedPlayer)
	{
		playerList.add(addedPlayer);
		numOfPlayers++; 
	}
	public void nextPlayersTurn()
	{
		currentPlayerIndex = nextPlayerIndex;  
		nextPlayerIndex = (nextPlayerIndex +1) % numOfPlayers; 
	}
	public void boughtProperty(tileInfo tileBought, player ownerPlayer)
	{
		if(propertiesOwned.containsKey(tileBought) == false)
		{
			propertiesOwned.put(tileBought, ownerPlayer); 
		}
	}
	public void soldProperty(tileInfo tileSold, player soldPlayer)
	{
		if(propertiesOwned.containsKey(tileSold) && propertiesOwned.get(tileSold).equals(soldPlayer) )
		{
			propertiesOwned.remove(tileSold); 
		}
	}
	public void checkGameOver()
	{
		
		for (player p : playerList) {
	        
			if (p.getMoney() <= 0) {
	            
				// -------- display in the GUI
	        	System.out.println(p.getUsername() + " is out of the game!");
	            // -------
	        	
	            playerList.remove(p);
	            numOfPlayers--;
	            break;
	        }
	    }
		
		if(numOfPlayers <= 1)
		{
			// -------- display in GUI
			System.out.println("game is over"); 
			// -------
		}
	}
	// ================ getters 
	
	public int currentPlayerIndex() { return currentPlayerIndex;}
	public player currentPlayerObj() {return playerList.get(currentPlayerIndex); }
	public int playerCount() {return numOfPlayers;}
	public int getNextPlayer() {return nextPlayerIndex;}
	public player nextPlayerObj() {return playerList.get(nextPlayerIndex); }
	public int getTileCount() {return totalTiles; }
	public tileInfo getTileAt(int i) {return linearBoard.get(i); }
	public HashMap<tileInfo, player> propertiesOwnedHashMap(){return propertiesOwned; }

}

