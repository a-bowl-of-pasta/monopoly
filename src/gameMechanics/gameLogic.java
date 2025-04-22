package gameMechanics;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Random;
import ocsf.server.ConnectionToClient; 

public class gameLogic implements Serializable{

	
	// ============= performs the action and changes gameState
	public void performGameAction(Object action, ConnectionToClient client, gameState currentState) {
		
		// stops method if player action is not sent
	    if (!(action instanceof myAction)) return;

	    // finds player from action
	    myAction move = (myAction) action;
	    int playerID = move.getPlayerID();
	    
	    // extracts the exact move the player did "ROLL", "END_TURN"
	    String playerMove = move.getPlayerMove();
	    player currentPlayer = currentState.currentPlayerObj();

	    // handles decision making
	    switch (playerMove) {
	        case "ROLL":
	            int roll = rollDice();
	            currentPlayer.moveOnBoard(roll, currentState.getTileCount());
	            manageTile(currentPlayer, currentState);
	            System.out.println("Player " + playerID + " rolled " + roll);
	            break;

	        case "BUY_TILE":
	            buyTile(currentPlayer, currentState);
	            break;

	        case "SELL_TILE":
	            sellTile(currentPlayer, currentState);
	            break;

	        case "END_TURN":
	            currentState.nextPlayersTurn();
	            break;

	        default:
	            System.out.println("Unknown move: " + playerMove);
	    }

	    currentState.checkGameOver();
	}
	// =========== basic game logic 

	public int rollDice()
	{
		/* finds rand num 1 - 6 
		 * does that for both dice
		 * adds them together and returns
		 */
		Random random = new Random(System.currentTimeMillis());
		
		int dice1 = random.nextInt(6) +1;
		int dice2 = random.nextInt(6) +1; 
		
		return dice1 + dice2; 
			
	}
	
	private void manageTile(player currentPlayer, gameState currentGameState)
	{
		
		// grabs the tile at current player position and tile ownership map
		 tileInfo tile = currentGameState.getTileAt(currentPlayer.getBoardPostition());
		 HashMap<tileInfo, player> propertiesOwned = currentGameState.propertiesOwnedHashMap(); 

		 // if the tile has an owner and the current player is not the owner
		 if (tile.isOwned() && !propertiesOwned.get(tile).equals(currentPlayer)) 
		 { 
			 // get the rent, remove from current player, add to player that owns property, confirm
			 int rent = tile.getRent();		      
			 currentPlayer.manipMoney(-rent);
	         propertiesOwned.get(tile).manipMoney(rent); // pay to owner
	         System.out.println("Paid rent of " + rent);
	         
		   }
		
	}
	
	
	
	// ============ helper methods
	
	private void sellTile(player currentPlayer, gameState currentGameState)
	{
		// gets the current player tile
		tileInfo currentTile = currentGameState.getTileAt(currentPlayer.getBoardPostition());
		HashMap<tileInfo, player> propertiesOwned = currentGameState.propertiesOwnedHashMap(); 
		
		// if the current property is owned and the current player is the currenPlayer is the owner 
	    if (currentTile.isOwned() && propertiesOwned.get(currentTile).equals(currentPlayer)) {
	        
	    	// pay current player, remove from ownership map, set currentTile ownership to false
	        currentPlayer.manipMoney(currentTile.getPrice()); 
	        currentGameState.soldProperty(currentTile, currentPlayer);
	        currentTile.tileIsSold(); 

	        System.out.println("Player " + currentPlayer.getUsername() + " sold tile at " + currentTile.tilePositionOnBoard());
	    }	
		
		
	}
	private void buyTile(player currentPlayer, gameState currentGameState)
	{
		// get current tile
		 tileInfo currentTile = currentGameState.getTileAt(currentPlayer.getBoardPostition()); 
		 
		   
		 // if the current tile is not owned and the current player has enough money
		 if (!currentTile.isOwned() && currentPlayer.getMoney() >= currentTile.getPrice()) {
		 
			 // remove player money, update the ownership map, update current tile ownership
			 currentPlayer.manipMoney(- currentTile.getPrice());
			 currentGameState.boughtProperty(currentTile, currentPlayer);
			 currentTile.tileBought();
			 
		    
		 }
			
	}
	// ================ toString for debugging, logging, and cli 
	public String toStringGameState(Object action, ConnectionToClient client, gameState currentState)
	{
		return currentState.toString();
	}
	public String toStringAction(Object action)
	{
		if(action instanceof myAction)
		{
			return action.toString();
		}
		else
		{
			return "not a valid action"; 
		}
			
	}
	public String toStringPlayer(ConnectionToClient client, gameState currentState)
	{
		player currentPlay = currentState.currentPlayerObj();
		return currentPlay.toString();  
	}
	
	// ========== constructor
	gameLogic(){}
	
}




