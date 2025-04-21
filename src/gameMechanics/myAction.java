package gameMechanics;

import java.io.Serializable;

public class myAction implements Serializable
{
	private int playerID; 
	private String playerMove; 
	
	public myAction(int playerId,String playerMove)
	{
		playerID = playerId; 
		this.playerMove = playerMove; 
	}
	
	public int getPlayerID() {return playerID; }
	public String getPlayerMove() {return playerMove; }

	@Override
	public String toString() {
	    return "Action by Player " + playerID + ": " + playerMove;
	}
}
