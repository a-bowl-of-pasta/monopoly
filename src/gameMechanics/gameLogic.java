package gameMechanics;

import java.io.Serializable;
import java.util.Random;
import ocsf.server.ConnectionToClient; 

public class gameLogic implements Serializable{

	private static int[] dice; 
	
	// ============= performs the action and changes gameState
	public void performGameAction(Object action, ConnectionToClient client, gameState currentState)
	{
			
		
		int playerID = ((myAction) action).getPlayerID(); 
		String playerMove = ((myAction) action).getPlayerMove(); 
		
		if(playerMove == "ROLL")
		{
			rollDice(); 
			
		}else if (playerMove == "BUY_TILE")
		{
			
			
			
		}else if(playerMove == "SELL_TILE")
		{
			
			
			
		}else if(playerMove == "END_TURN")
		{
			
			
			
		}
		
		
	}

	// =========== basic game logic 

	public void rollDice()
	{
		Random random = new Random(System.currentTimeMillis());
		
		boolean firstNumGenerated = false;
		boolean secondNumGenerated = false;
		
		while(firstNumGenerated == false && secondNumGenerated == false)
		{
			if(firstNumGenerated != true)
			{
				
			}
			else if(secondNumGenerated != true)
			{
				
			}
				
		}
			
	}
	
	private void manageTile()
	{
		
	}
	
	
	
	// ============ helper methods
	
	private void sellTile()
	{
		
	}
	private void buyTile()
	{
		
	}
	private int diceRollLogic(Random rand)
	{
		int roll = rand.nextInt();
		return roll; 
	}
	// ================ constructor 
	gameLogic(){
		dice = new int[2];
		
	}
	
}




