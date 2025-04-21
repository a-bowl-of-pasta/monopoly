package gameMechanics;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Random;
import ocsf.server.ConnectionToClient; 

public class gameLogic implements Serializable{

	
	// ============= performs the action and changes gameState
	public void performGameAction(Object action, ConnectionToClient client, gameState currentState) {
	    if (!(action instanceof myAction)) return;

	    myAction move = (myAction) action;
	    
	    int playerID = move.getPlayerID();
	    
	    String playerMove = move.getPlayerMove();
	    player currentPlayer = currentState.currentPlayerObj();

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
		Random random = new Random(System.currentTimeMillis());
		
		int dice1 = random.nextInt(6) +1;
		int dice2 = random.nextInt(6) +1; 
		
		return dice1 + dice2; 
			
	}
	
	private void manageTile(player currentPlayer, gameState currentGameState)
	{
		
		 tileInfo tile = currentGameState.getTileAt(currentPlayer.getBoardPostition());
		 HashMap<tileInfo, player> propertiesOwned = currentGameState.propertiesOwnedHashMap(); 

		    if (tile.isOwned() && !propertiesOwned.get(tile).equals(currentPlayer)) {
		        int rent = tile.getRent();
		        currentPlayer.manipMoney(-rent);
		        currentGameState.propertiesOwned.get(tile).manipMoney(rent); // pay to owner
		        System.out.println("Paid rent of " + rent);
		    }
		
	}
	
	
	
	// ============ helper methods
	
	private void sellTile(player currentPlayer, gameState currentGameState)
	{
		
		tileInfo currentTile = currentGameState.getTileAt(currentPlayer.getBoardPostition());

		
	    if (currentGameState.propertiesOwned.containsKey(currentTile) &&
	        currentGameState.propertiesOwned.get(currentTile).equals(currentPlayer)) {
	        
	        currentPlayer.manipMoney(currentTile.getPrice()); 
	        currentGameState.soldProperty(currentTile, currentPlayer);
	        currentTile.tileIsSold(); 

	        System.out.println("Player " + currentPlayer.getUsername() + " sold tile at " + currentTile.tilePositionOnBoard());
	    }	
		
		
	}
	private void buyTile(player currentPlayer, gameState currentGameState)
	{
		 tileInfo currentTile = currentGameState.getTileAt(currentPlayer.getBoardPostition()); 
		    
		 if (!currentTile.isOwned() && currentPlayer.getMoney() >= currentTile.getPrice()) {
		 
			 currentPlayer.manipMoney(- currentTile.getPrice());
			 currentGameState.boughtProperty(currentTile, currentPlayer);
			 currentTile.tileBought();
			 
		    
		 }
			
	}
	// ================ constructor and toString / debugging
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
	gameLogic(){}
	
}




