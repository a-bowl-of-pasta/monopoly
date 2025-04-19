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
	
	public gameState()
	{
		currentPlayerIndex = 0; 
		nextPlayerIndex = currentPlayerIndex +1; 
		numOfPlayers = 0; 
		playerList = new ArrayList<player>();
		totalTiles = 40; 

		

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
		currentPlayerIndex = (currentPlayerIndex +1) % numOfPlayers - 1; 
	}
	public void boughtProperty(tileInfo tileBought, player ownerPlayer)
	{
		propertiesOwned.put(tileBought, ownerPlayer); 
	}
	public void soldProperty(tileInfo tileSold, player soldPlayer)
	{
		propertiesOwned.remove(tileSold); 
	}
	


}

