package gameMechanics;

import java.io.Serializable;

public class myAction implements Serializable
{
	private int playerID; 
	private String playerMove; 
	
	myAction(int playerId,String playerMove)
	{
		playerID = playerId; 
		this.playerMove = playerMove; 
	}
	
	public int getPlayerID() {return playerID; }
	public String getPlayerMove() {return playerMove; }
	
}
